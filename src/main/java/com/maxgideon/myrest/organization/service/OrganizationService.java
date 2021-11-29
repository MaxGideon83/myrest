package com.maxgideon.myrest.organization.service;


import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationData;

import java.util.List;


public interface OrganizationService {

    public List<OrganizationData> getAllOrganization(OrganizationData organizationData);

    public OrganizationData getOrganizationById(long id);

    public void updateOrganization();

    public void saveOrganization();

}
