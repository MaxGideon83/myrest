package com.maxgideon.myrest.organization.service;

import com.maxgideon.myrest.organization.dao.OrganizationDao;
import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    OrganizationDao organizationDAO;

    @Override
    public List<OrganizationDto> getAllOrganization(OrganizationDto organizationDto) {

        List<Organization>list =  organizationDAO.getAllOrganizations(organizationDto);
        List<OrganizationDto> dl = new ArrayList<>();
        for(Organization org : list){
            dl.add(new OrganizationDto(org.getId(),org.getName(),org.getIsActive()));
        }
        return dl;
    }

    @Override
    public OrganizationDto getOrganizationById(long id) {
        Organization organization = organizationDAO.getOrganizationById(id);
        OrganizationDto organizationDto = new OrganizationDto(organization);
        return  organizationDto;

    }

    @Override
    public void updateOrganization(OrganizationDto organizationDto) {
        organizationDAO.updateOrganization(organizationDto);
    }

    @Override
    public void saveOrganization(OrganizationDto organizationDto) {
        organizationDAO.saveOrganization(organizationDto);
    }
}
