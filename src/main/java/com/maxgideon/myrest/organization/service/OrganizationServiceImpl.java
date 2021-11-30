package com.maxgideon.myrest.organization.service;

import com.maxgideon.myrest.organization.dao.OrganizationDAO;
import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    OrganizationDAO organizationDAO;

    @Override
    public List<OrganizationData> getAllOrganization(OrganizationData organizationData) {

        List<Organization>list =  organizationDAO.getAllOrganizations(organizationData);
        List<OrganizationData> dl = new ArrayList<>();
        for(Organization org : list){
            dl.add(new OrganizationData(org.getId(),org.getName(),org.getIsActive()));
        }
        return dl;
    }

    @Override
    public OrganizationData getOrganizationById(long id) {
        Organization organization = organizationDAO.getOrganizationById(id);
        OrganizationData organizationData = new OrganizationData(organization);

        return organizationData;
    }

    @Override
    public void updateOrganization(OrganizationData organizationData) {
        organizationDAO.updateOrganization(organizationData);
    }

    @Override
    public void saveOrganization(OrganizationData organizationData) {
        organizationDAO.saveOrganization(organizationData);
    }
}
