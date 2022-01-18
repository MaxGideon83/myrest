package com.maxgideon.myrest.references.controller;

import com.maxgideon.myrest.references.service.ReferencesService;
import com.maxgideon.myrest.references.service.data.CountriesDto;
import com.maxgideon.myrest.references.service.data.DocumentsTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("api")
public class ReferencesController {
    @Autowired
    ReferencesService referencesService;

    @PostMapping("/docs")
    public List<DocumentsTypeDto> showAllDocumentsType(){
        return referencesService.showAllDocumentsType();
    }

    @PostMapping("/countries")
    public List<CountriesDto> showAllCountries(){
        return referencesService.showAllCountries();
    }
}
