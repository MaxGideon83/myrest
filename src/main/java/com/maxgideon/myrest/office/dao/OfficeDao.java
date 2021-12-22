package com.maxgideon.myrest.office.dao;


import com.maxgideon.myrest.office.entity.Office;
import com.maxgideon.myrest.office.service.data.OfficeDto;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {
    /**
     * Метод для получения списка офисов
     * @param office объект класса OfficeDto
     * @return List<Office> коллекция объектов Office
     */
    public List<Office> getAllOffice(Office office);

    /**
     * Метод для получения объекта Office по id
     * @param id переменная типа long, идентификатор офиса в базе
     * @return Office объект класса Office
     */
    public Office getOfficeById(long id);

    /**
     * Метод для сохранения объекта Office в БД
     * @param office объект класса OfficeDto
     */
    public void saveOffice(Office office);

}
