package com.maxgideon.myrest.organization.dao;

import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationData;
import org.hibernate.Session;
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
public class OrganizationDAOImpl implements OrganizationDAO{

    @Autowired
    private EntityManager em;

    @Override
    public List<Organization> getAllOrganizations(OrganizationData organizationData) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = cb.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        Predicate criteria = cb.conjunction();
        Predicate p = cb.equal(organizationRoot.get("name"),organizationData.getName());
        criteria = cb.and(criteria,p);
        if(organizationData.getInn()!= null){
            Predicate pr = cb.equal(organizationRoot.get("inn"),organizationData.getInn());
            criteria = cb.and(criteria,pr);
        }
        if(organizationData.getIsActive() != null){
            Predicate pr = cb.equal(organizationRoot.get("isActive"),organizationData.getIsActive());
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
    public void saveOrganization(OrganizationData organizationData) {
        Organization organization = new Organization();
        organization.organizationUpdate(organizationData);
        em.persist(organization);
    }

    @Override
    public void updateOrganization(OrganizationData organizationData) {
        Organization organization = em.find(Organization.class, organizationData.getId());
        organization.organizationUpdate(organizationData);
    }
}
