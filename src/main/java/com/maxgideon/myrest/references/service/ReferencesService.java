package com.maxgideon.myrest.references.service;

import com.maxgideon.myrest.references.service.data.CountriesDto;
import com.maxgideon.myrest.references.service.data.DocumentsTypeDto;

import java.util.List;

public interface ReferencesService {
    /**
     * Метод для получения списка типов документа
     * @return List<DocumentsTypeDto> коллекция объектов DocumentsTypeDto
     */
    public List<DocumentsTypeDto> showAllDocumentsType();
    /**
     * Метод для получения списка стран
     * @return List<CountriesDto> коллекция объектов CountriesDto
     */
    public List<CountriesDto> showAllCountries();
}
