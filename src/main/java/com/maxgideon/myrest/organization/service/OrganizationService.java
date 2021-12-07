package com.maxgideon.myrest.organization.service;


import com.maxgideon.myrest.organization.service.data.OrganizationDto;

import java.util.List;


public interface OrganizationService {

    public Object getAllOrganization(OrganizationDto organizationDto);

    public Object getOrganizationById(long id);

    public void updateOrganization(OrganizationDto organizationDto);

    public void saveOrganization(OrganizationDto organizationDto);

}
