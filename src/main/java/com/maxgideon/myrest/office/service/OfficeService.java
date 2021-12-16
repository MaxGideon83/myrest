package com.maxgideon.myrest.office.service;


import com.maxgideon.myrest.office.service.data.OfficeDto;

import java.util.List;

/**
 * Service для работы с OfficeDto
 */
public interface OfficeService {
    /**
     * Метод для преобразования списка объектов Office в список объектов OfficeDto
     * @param officeDto объект класса OfficeDto
     * @return List<OfficeDto> коллекция объектов OfficeDto
     */
    public List<OfficeDto> getAllOffice(OfficeDto officeDto);
    /**
     * Метод для преобразования объекта Office полученного по id в объект OfficeDto
     * @param id переменная типа long, идентификатор офиса в базе
     * @return OfficeDto объект класса OfficeDto
     */
    public OfficeDto getOfficeById(long id);
    /**
     * Метод для сохранения объекта Office в БД
     * @param officeDto объект класса OfficeDto
     */
    public void saveOffice(OfficeDto officeDto);
    /**
     * Метод для обновления объекта Office в БД
     * @param officeDto объект класса OfficeDto
     */
    public void updateOffice(OfficeDto officeDto);
}

