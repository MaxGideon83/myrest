package com.maxgideon.myrest.references.service;

import com.maxgideon.myrest.references.dao.ReferencesDao;
import com.maxgideon.myrest.references.entity.Countries;
import com.maxgideon.myrest.references.entity.DocumentsType;
import com.maxgideon.myrest.references.service.data.CountriesDto;
import com.maxgideon.myrest.references.service.data.DocumentsTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReferencesServiceImpl implements ReferencesService{
    @Autowired
    ReferencesDao referencesDao;

    @Override
    public List<DocumentsTypeDto> showAllDocumentsType() {
        List<DocumentsTypeDto> ldtd = new ArrayList<>();
        List<DocumentsType> ldt = referencesDao.getAllDocumentsType();
        for (DocumentsType dt : ldt){
            ldtd.add(new DocumentsTypeDto(dt));
        }
        return ldtd;
    }

    @Override
    public List<CountriesDto> showAllCountries() {
        List<CountriesDto> lcd = new ArrayList<>();
        List<Countries> lc = referencesDao.getAllCountries();
        for (Countries c : lc){
            lcd.add(new CountriesDto(c));
        }
        return lcd;
    }
}
