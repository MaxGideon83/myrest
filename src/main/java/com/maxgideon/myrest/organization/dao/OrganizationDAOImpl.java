package com.maxgideon.myrest.organization.dao;

import com.maxgideon.myrest.organization.entity.Organization;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO{

    @Autowired
    private EntityManager em;

    @Override
    public List<Organization> getAllOrganizations() {
        Session session = em.unwrap(Session.class);
        Query<Organization> query = session.createQuery("from Organization", Organization.class);
        List<Organization> allOrganization = query.getResultList();
        return allOrganization;
    }
}
