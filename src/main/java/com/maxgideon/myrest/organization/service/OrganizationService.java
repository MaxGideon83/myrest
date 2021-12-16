package com.maxgideon.myrest.organization.service;


import com.maxgideon.myrest.organization.service.data.OrganizationDto;

import java.util.List;

/**
 * Service для работы с OrganizationDto
 */
public interface OrganizationService {
    /**
     * Метод для преобразования списка объектов Organization в список объектов OrganizationDto
     * @param organizationDto объект класса OrganizationDto
     * @return List<OrganizationDto> коллекция объектов OrganizationDto
     */
    public List<OrganizationDto> getAllOrganization(OrganizationDto organizationDto);
    /**
     * Метод для преобразования объекта Organization полученного по id в объект OrganizationDto
     * @param id переменная типа long, идентификатор организации в базе
     * @return OrganizationDto объект класса OrganizationDto
     */
    public OrganizationDto getOrganizationById(long id);
    /**
     * Метод для сохранения объекта Organization в БД
     * @param organizationDto объект класса OrganizationDto
     */
    public void updateOrganization(OrganizationDto organizationDto);
    /**
     * Метод для обновления объекта Organization в БД
     * @param organizationDto объект класса OrganizationDto
     */
    public void saveOrganization(OrganizationDto organizationDto);

}
