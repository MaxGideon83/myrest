package com.maxgideon.myrest.office.dao;


import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.office.service.data.OfficeDto;

import java.util.List;

public interface OfficeDao {
    public List<Office> getAllOffice(OfficeDto officeDto);
    public Office getOfficeById(long id);
    public void saveOffice(OfficeDto officeDto);
    public void updateOffice(OfficeDto officeDto);
}
