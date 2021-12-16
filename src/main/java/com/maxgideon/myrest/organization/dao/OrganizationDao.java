package com.maxgideon.myrest.organization.dao;

import com.maxgideon.myrest.organization.entity.Organization;
import com.maxgideon.myrest.organization.service.data.OrganizationDto;

import java.util.List;
/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Метод для получения списка офисов
     * @param organizationDto объект класса OrganizationDto
     * @return List<Organization> коллекция объектов Organization
     */
    public List<Organization> getAllOrganizations(OrganizationDto organizationDto);
    /**
     * Метод для получения объекта Organization по id
     * @param id переменная типа long, идентификатор организации в базе
     * @return Organization объект класса Organization
     */
    public Organization getOrganizationById(long id);
    /**
     * Метод для сохранения объекта Organization в БД
     * @param organizationDto объект класса OrganizationDto
     */
    public void saveOrganization(OrganizationDto organizationDto);
    /**
     * Метод для обновления объекта Organization в БД
     * @param organizationDto объект класса OrganizationDto
     */
    public void updateOrganization(OrganizationDto organizationDto);

}
