package com.maxgideon.myrest.user.dao;
import com.maxgideon.myrest.user.entity.Documents;
import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.references.entity.Countries;
import com.maxgideon.myrest.references.entity.DocumentsType;
import com.maxgideon.myrest.user.service.data.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import java.util.List;



@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager em;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
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
            throw new NoResultException("?????????????????????????? ?? ???????????? ?????????????????????? ???? ??????????????");
        }
        return allUser;

    };

    @Override
    public User getUserById(long id) {
        User user = em.find(User.class, id);
        if(user==null){
            throw new NoResultException("???????????????????????? ?? ???????????? id ???? ??????????????");
        }
        return user;
    };


    @Override
    public void saveUser(User user) {
       em.persist(user);
    };


    @Override
    public DocumentsType getDocumentsTypeByCodeOrName(String code, String name){
        DocumentsType documentsType = null;
        TypedQuery<DocumentsType> query = em.createQuery(
                "SELECT d FROM DocumentsType d WHERE d.docCode = :docCode OR d.docName = :docName", DocumentsType.class);
        try {
            documentsType = query.setParameter("docCode", code)
                    .setParameter("docName", name)
                    .getSingleResult();
        }catch(NoResultException nre){
            LOGGER.info(nre.getMessage());
            throw new NoResultException("?????? ?????????????????? ?? ?????????? docCode ??/?????? docName ???? ???????????? ");
        }
        return documentsType;
    }


    @Override
    public Countries getCountriesByCitizenshipCode(String citizenshipCode){
        Countries countries = null;
        TypedQuery<Countries> query = em.createQuery(
                "SELECT d FROM Countries d WHERE d.citizenshipCode = :citizenshipCode", Countries.class);
        try {
            countries = query.setParameter("citizenshipCode", citizenshipCode).getSingleResult();
        }catch(NoResultException nre) {
            LOGGER.info(nre.getMessage());
            throw new NoResultException("???????????? ?? ?????????? citizenshipCode ???? ??????????????");
        }
        return countries;
    }


}
