package com.maxgideon.myrest.references.dao;

import com.maxgideon.myrest.references.entity.Countries;
import com.maxgideon.myrest.references.entity.DocumentsType;

import java.util.List;

public interface ReferencesDao {
    /**
     * Метод для получения списка типов документа
     * @return List<DocumentsType> коллекция объектов DocumentsType
     */
    public List<DocumentsType> getAllDocumentsType();
    /**
     * Метод для получения списка стран
     * @return List<Countries> коллекция объектов Countries
     */
    public List<Countries> getAllCountries();
}
