package com.maxgideon.myrest.organization.service;

import com.maxgideon.myrest.organization.dao.OrganizationDao;
import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void updateOrganization(OrganizationDto organizationDto) {
        Organization organization = organizationDAO.getOrganizationById(organizationDto.getId());
        organizationUpdate(organizationDto,organization);

    }

    @Transactional
    @Override
    public void saveOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        organizationUpdate(organizationDto, organization);
        organizationDAO.saveOrganization(organization);
    }

    /**
     * Метод для обновления свойств объекта Organization свойствами объекта OrganizationDto
     * @param organizationDto объект класса OrganizationDto
     * @param organization  объект класса Organization
     */
    private void organizationUpdate(OrganizationDto organizationDto,Organization organization){
        organization.setName(organizationDto.getName());
        organization.setFullName(organizationDto.getFullName());
        organization.setInn(organizationDto.getInn());
        organization.setKpp(organizationDto.getKpp());
        organization.setAddress(organizationDto.getAddress());
        if(organizationDto.getPhone()!= null) {
            organization.setPhone(organizationDto.getPhone());
        }
        if(organizationDto.getIsActive() != null) {
            organization.setIsActive(organizationDto.getIsActive());
        }

    }
}
