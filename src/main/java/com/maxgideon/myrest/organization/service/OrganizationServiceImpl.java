package com.maxgideon.myrest.organization.service;

import com.maxgideon.myrest.organization.dao.OrganizationDAO;
import com.maxgideon.myrest.organization.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    OrganizationDAO organizationDAO;

    @Override
    public List<Organization> getAllOrganization() {
        return organizationDAO.getAllOrganizations();
    }
}
