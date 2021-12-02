package com.maxgideon.myrest.organization.dao;

import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationDto;

import java.util.List;

public interface OrganizationDao {

    public List<Organization> getAllOrganizations(OrganizationDto organizationDto);

    public Organization getOrganizationById(long id);

    public void saveOrganization(OrganizationDto organizationDto);

    public void updateOrganization(OrganizationDto organizationDto);

}
