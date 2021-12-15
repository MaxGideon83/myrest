package com.maxgideon.myrest.user.dao;

import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.user.entity.Documents;
import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.user.entity.references.Countries;
import com.maxgideon.myrest.user.entity.references.DocumentsType;
import com.maxgideon.myrest.user.service.data.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;



@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager em;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    public List<User> getAllUser(UserDto userDto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        Join<User, Documents> documents = userRoot.join("documents");
        Join<Documents, DocumentsType> documentsType = documents.join("docType");
        Join<User, Countries> countriesJoin = userRoot.join("countries");
        Predicate criteria = cb.conjunction();
        Predicate p = cb.equal(userRoot.get("office"), userDto.getOfficeId());
        criteria = cb.and(criteria, p);
        if (userDto.getFirstName() != null) {
            Predicate pr = cb.equal(userRoot.get("firstName"), userDto.getFirstName());
            criteria = cb.and(criteria, pr);
        }
        if (userDto.getSecondName() != null) {
            Predicate pr = cb.equal(userRoot.get("secondName"), userDto.getSecondName());
            criteria = cb.and(criteria, pr);
        }
        if (userDto.getMiddleName() != null) {
            Predicate pr = cb.equal(userRoot.get("middleName"), userDto.getMiddleName());
            criteria = cb.and(criteria, pr);
        }
        if (userDto.getPosition() != null) {
            Predicate pr = cb.equal(userRoot.get("position"), userDto.getPosition());
            criteria = cb.and(criteria, pr);
        }
        if (userDto.getDocCode() != null) {
            Predicate pr = cb.equal(documentsType.get("docCode"), userDto.getDocCode());
            criteria = cb.and(criteria, pr);
        }

        if (userDto.getCitizenshipCode() != null) {
            Predicate pr = cb.equal(countriesJoin.get("citizenshipCode"), userDto.getCitizenshipCode());
            criteria = cb.and(criteria, pr);
        }

        cq.where(criteria);
        List<User> allUser = em.createQuery(cq).getResultList();
        if(allUser.isEmpty()){
            throw new NoResultException("Пользователей с такими параметрами не найдено");
        }
        return allUser;

    };

    public User getUserById(long id) {
        User user = checkUser(id);
        return user;
    };


    @Transactional
    public void saveUser(UserDto userDto) {
        User user = new User();
        userDto.userUpdate(user);
        Documents documents = null;
        Countries countries = null;
        if (userDto.getDocCode() != null || userDto.getDocName() != null) {
               documents = addDocumentType(userDto,documents);
        }
        if (userDto.getDocDate() != null || userDto.getDocNumber() != null) {
            if (documents != null) {
                documents.setDocDate(userDto.getDocDate());
                documents.setDocNumber(userDto.getDocNumber());
            }else {
                documents = new Documents();
                documents.setDocDate(userDto.getDocDate());
                documents.setDocNumber(userDto.getDocNumber());
            }
        }
        if (userDto.getCitizenshipCode() != null) {
                countries = addCountries(userDto);
                user.setCountries(countries);
        }
        if(documents != null){
            user.setDocuments(documents);
        }
        Office office = checkOffice(userDto);
        user.setOffice(office);
        em.persist(user);
    };

    @Transactional
    public void updateUser(UserDto userDto){
        User user = checkUser(userDto.getId());
        userDto.userUpdate(user);
        Documents documents = user.getDocuments();
        if(userDto.getOfficeId() != null){
            Office office = checkOffice(userDto);
            user.setOffice(office);
        }
        if(userDto.getDocNumber() != null){
            if(documents != null){
                documents.setDocNumber(userDto.getDocNumber());
            }else{
                documents = new Documents();
                documents.setDocNumber(userDto.getDocNumber());
                user.setDocuments(documents);
            }
        }
        if(userDto.getDocDate() != null){
            if(documents != null){
                documents.setDocDate(userDto.getDocDate());
            }else{
                documents = new Documents();
                documents.setDocDate(userDto.getDocDate());
                user.setDocuments(documents);
            }
        }
        if(userDto.getCitizenshipCode() != null){
            Countries countries = addCountries(userDto);
            user.setCountries(countries);
        }
        if(userDto.getDocName() != null){
            documents = addDocumentType(userDto, documents);
            user.setDocuments(documents);
        }
    };

    @Override
    public List<DocumentsType> getAllDocumentsType() {
        Query query = em.createQuery("from DocumentsType");
        List<DocumentsType> docList = query.getResultList();
        return docList;
    }

    @Override
    public List<Countries> getAllCountries() {
        Query query = em.createQuery("from Countries");
        List<Countries> contList = query.getResultList();
        return contList;
    }

    private Documents addDocumentType(UserDto userDto, Documents documents){
        DocumentsType documentsType = null;
        TypedQuery<DocumentsType> query = em.createQuery(
                "SELECT d FROM DocumentsType d WHERE d.docCode = :docCode OR d.docName = :docName", DocumentsType.class);
        try {
            documentsType = query.setParameter("docCode", userDto.getDocCode())
                    .setParameter("docName", userDto.getDocName())
                    .getSingleResult();
        }catch(NoResultException nre){
            LOGGER.info(nre.getMessage());
            throw new NoResultException("Тип документа с таким docCode и/или docName не найден ");
        }
        if(documents != null){
            documents.setDocType(documentsType);
        }else {
            documents = new Documents();
            documents.setDocType(documentsType);
        }
        return documents;
    }
    private Countries addCountries(UserDto userDto){
        Countries countries = null;
        TypedQuery<Countries> query = em.createQuery(
                "SELECT d FROM Countries d WHERE d.citizenshipCode = :citizenshipCode", Countries.class);
        try {
            countries = query.setParameter("citizenshipCode", userDto.getCitizenshipCode()).getSingleResult();
        }catch(NoResultException nre) {
            LOGGER.info(nre.getMessage());
            throw new NoResultException("Страна с таким citizenshipCode не найдена");
        }
        return countries;
    }

    private Office checkOffice(UserDto userDto){
        Office office = em.find(Office.class, userDto.getOfficeId());
        if(office == null) {
            throw new NoResultException("Офиса с таким officeId не существует");
        }
        return office;
    }
    private User checkUser(Long id){
        User user = em.find(User.class, id);
        if(user==null){
            throw new NoResultException("Пользователя с такими id не найдено");
        }
        return user;
    }
}
