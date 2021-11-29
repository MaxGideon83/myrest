package com.maxgideon.myrest.organization.dao;

import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationData;

import java.util.List;

public interface OrganizationDAO {

    public List<Organization> getAllOrganizations(OrganizationData organizationData);

    public Organization getOrganizationById(long id);
//
//    public void saveOrganization(Organization organization);
//
//    public void updateOrganization(Organization organization);
}
