package com.maxgideon.myrest.user.dao;

import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.user.entity.Documents;
import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.user.entity.references.Countries;
import com.maxgideon.myrest.user.entity.references.DocumentsType;
import com.maxgideon.myrest.user.service.data.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager em;

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
        return allUser;

    };

    public User getUserById(long id) {
        User user = em.find(User.class, id);
        return user;

    };

    public void saveUser(UserDto userDto) {
        User user = new User();
        user.userUpdate(userDto);
        Documents documents = null;
        DocumentsType documentsType = null;
        Countries countries = null;
        if (userDto.getDocCode() != null || userDto.getDocName() != null) {


                TypedQuery<DocumentsType> query = em.createQuery(
                        "SELECT d FROM DocumentsType d WHERE d.docCode = :docCode OR d.docName = :docName", DocumentsType.class);
                documentsType = query.setParameter("docCode", userDto.getDocCode())
                        .setParameter("docName", userDto.getDocName())
                        .getSingleResult();
                documents = new Documents();
                documents.setDocType(documentsType);

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

                TypedQuery<Countries> query = em.createQuery(
                        "SELECT d FROM Countries d WHERE d.citizenshipCode = :citizenshipCode", Countries.class);
                countries = query.setParameter("citizenshipCode", userDto.getCitizenshipCode()).getSingleResult();
                user.setCountries(countries);
        }

        if(documents != null){
            user.setDocuments(documents);
        }

        Office office = em.find(Office.class, userDto.getOfficeId());
        if(office != null) {
            user.setOffice(office);
        }else{
            throw new NoResultException();
        }
        em.persist(user);

    };




    public void updateUser(UserDto userDto){

        User user = em.find(User.class, userDto.getId());
        user.userUpdate(userDto);
        Documents documents = user.getDocuments();


        if(userDto.getOfficeId() != 0){
            Office office = em.find(Office.class, userDto.getOfficeId());
            if(office != null) {
                user.setOffice(office);
            }else{
                throw new NoResultException();
            }
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
            TypedQuery<Countries> query = em.createQuery(
                    "SELECT d FROM Countries d WHERE d.citizenshipCode = :citizenshipCode", Countries.class);
            Countries countries = query.setParameter("citizenshipCode", userDto.getCitizenshipCode()).getSingleResult();
            user.setCountries(countries);
        }
        if(userDto.getDocName() != null){
            TypedQuery<DocumentsType> query = em.createQuery(
                    "SELECT d FROM DocumentsType d WHERE d.docName = :docName", DocumentsType.class);
            DocumentsType documentsType = query.setParameter("docName", userDto.getDocName()).getSingleResult();
            if (documents != null) {
                documents.setDocType(documentsType);
            }else{
                documents = new Documents();
                documents.setDocType(documentsType);
                user.setDocuments(documents);
            }

        }


    };

}
