package com.maxgideon.myrest.office.service;

import com.maxgideon.myrest.office.dao.OfficeDao;
import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.office.service.data.OfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    OfficeDao officeDao;

    @Override
    public List<OfficeDto> getAllOffice(OfficeDto officeDto) {
        List<Office> list = officeDao.getAllOffice(officeDto);
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

    @Override
    public void saveOffice(OfficeDto officeDto) {
        officeDao.saveOffice(officeDto);
    }

    @Override
    public void updateOffice(OfficeDto officeDto) {
        officeDao.updateOffice(officeDto);
    }
}
