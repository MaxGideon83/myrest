package com.maxgideon.myrest.organization.dao;

import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class OrganizationDaoImpl implements OrganizationDao {

    @Autowired
    private EntityManager em;

    @Override
    public List<Organization> getAllOrganizations(OrganizationDto organizationDto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = cb.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        Predicate criteria = cb.conjunction();
        Predicate p = cb.equal(organizationRoot.get("name"), organizationDto.getName());
        criteria = cb.and(criteria,p);
        if(organizationDto.getInn()!= null){
            Predicate pr = cb.equal(organizationRoot.get("inn"), organizationDto.getInn());
            criteria = cb.and(criteria,pr);
        }
        if(organizationDto.getIsActive() != null){
            Predicate pr = cb.equal(organizationRoot.get("isActive"), organizationDto.getIsActive());
            criteria = cb.and(criteria,pr);
        }
        criteriaQuery.where(criteria);
        List<Organization> allOrganization = em.createQuery(criteriaQuery).getResultList();
        return allOrganization;
    }

    @Override
    public Organization getOrganizationById(long id) {
        Organization organization = em.find(Organization.class, id);
        return organization;
    }

    @Override
    public void saveOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        organization.organizationUpdate(organizationDto);
        em.persist(organization);
    }

    @Override
    public void updateOrganization(OrganizationDto organizationDto) {
        Organization organization = em.find(Organization.class, organizationDto.getId());
        organization.organizationUpdate(organizationDto);
    }
}
