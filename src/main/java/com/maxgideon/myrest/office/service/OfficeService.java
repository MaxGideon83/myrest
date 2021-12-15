package com.maxgideon.myrest.office.service;


import com.maxgideon.myrest.office.service.data.OfficeDto;

import java.util.List;

public interface OfficeService {
    public List<OfficeDto> getAllOffice(OfficeDto officeDto);
    public OfficeDto getOfficeById(long id);
    public void saveOffice(OfficeDto officeDto);
    public void updateOffice(OfficeDto officeDto);
}

