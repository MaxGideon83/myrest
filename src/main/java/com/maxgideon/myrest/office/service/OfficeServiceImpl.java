package com.maxgideon.myrest.office.service;

import com.maxgideon.myrest.office.dao.OfficeDao;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.office.service.data.OfficeDto;
import com.maxgideon.myrest.organization.dao.OrganizationDao;
import com.maxgideon.myrest.organization.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    OfficeDao officeDao;

    @Autowired
    OrganizationDao organizationDao;

    @Override
    public List<OfficeDto> getAllOffice(OfficeDto officeDto) {
        Office office = new Office();
        officeUpdate(officeDto,office);
        Organization organization = organizationDao.getOrganizationById(officeDto.getOrgId());
        office.setOrg(organization);
        List<Office> list = officeDao.getAllOffice(office);
        List<OfficeDto> listDto = new ArrayList<>();
        for(Office of: list){
            listDto.add(new OfficeDto(of.getId(),of.getName(),of.getIsActive()));
        }
        return listDto;
    }

    @Override
    public OfficeDto getOfficeById(long id) {
        Office office = officeDao.getOfficeById(id);
        OfficeDto officeDto = new OfficeDto(office);
        return officeDto;
    }

    @Transactional
    @Override
    public void saveOffice(OfficeDto officeDto) {
        Office office = new Office();
        officeUpdate(officeDto,office);
        Organization organization = organizationDao.getOrganizationById(officeDto.getOrgId());
        office.setOrg(organization);
        officeDao.saveOffice(office);
    }

    @Transactional
    @Override
    public void updateOffice(OfficeDto officeDto) {
        Office office = officeDao.getOfficeById(officeDto.getId());
        officeUpdate(officeDto,office);
    }

    /**
     * Метод для обновления свойств объекта Office свойствами объекта OfficeDto
     * @param office объект класса Office
     * @param officeDto объект класса OfficeDto
     */
    private void officeUpdate(OfficeDto officeDto, Office office){
        office.setName(officeDto.getName());
        office.setAddress(officeDto.getAddress());
        if(officeDto.getPhone() != null) {
            office.setPhone(officeDto.getPhone());
        }
        if(officeDto.getIsActive() != null) {
            office.setIsActive(officeDto.getIsActive());
        }
    }
}
