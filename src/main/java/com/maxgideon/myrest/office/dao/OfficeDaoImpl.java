package com.maxgideon.myrest.office.dao;

import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.office.service.data.OfficeDto;
import com.maxgideon.myrest.organization.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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
        return allOffice;
    }

    @Override
    public Office getOfficeById(long id) {
        Office office = em.find(Office.class, id);
        return office;
    }

    @Override
    public void saveOffice(OfficeDto officeDto) {
        Office office = new Office();
        office.officeUpdate(officeDto);
        Organization organization = em.find(Organization.class, officeDto.getOrgId());
        if(organization != null) {
            office.setOrg(organization);
        }else{
            throw new NoResultException();
        }
        em.persist(office);
    }

    @Override
    public void updateOffice(OfficeDto officeDto) {
        Office office = em.find(Office.class, officeDto.getId());
        office.officeUpdate(officeDto);
    }
}
