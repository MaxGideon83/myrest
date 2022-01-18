package com.maxgideon.myrest.office.dao;

import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.office.service.data.OfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class OfficeDaoImpl implements OfficeDao{
    @Autowired
    EntityManager em;

    @Override
    public List<Office> getAllOffice(OfficeDto officeDto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = cb.createQuery(Office.class);
        Root<Office> officeRoot = criteriaQuery.from(Office.class);
        Predicate criteria = cb.conjunction();
        Predicate p = cb.equal(officeRoot.get("org"), officeDto.getOrgId());
        criteria = cb.and(criteria,p);
        if(officeDto.getName()!= null){
            Predicate pr = cb.equal(officeRoot.get("name"), officeDto.getName());
            criteria = cb.and(criteria,pr);
        }
        if(officeDto.getPhone() != null){
            Predicate pr = cb.equal(officeRoot.get("phone"), officeDto.getPhone());
            criteria = cb.and(criteria,pr);
        }
        if(officeDto.getIsActive() != null){
            Predicate pr = cb.equal(officeRoot.get("isActive"), officeDto.getIsActive());
            criteria = cb.and(criteria,pr);
        }
        criteriaQuery.where(criteria);
        List<Office> allOffice = em.createQuery(criteriaQuery).getResultList();
        if(allOffice.isEmpty()){
            throw new NoResultException("Офисов с такими параметрами не найдено");
        }
        return allOffice;
    }

    @Override
    public Office getOfficeById(long id) {
        Office office = em.find(Office.class, id);
        if(office == null){
            throw new NoResultException("Офиса с таким id не найдено");
        }
        return office;
    }

    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }

}
