package com.maxgideon.myrest.organization.dao;

import com.maxgideon.myrest.organization.entity.Organization;


import java.util.List;
/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {
    /**
     * Метод для получения списка офисов
     * @param organization объект класса OrganizationDto
     * @return List<Organization> коллекция объектов Organization
     */
    public List<Organization> getAllOrganizations(Organization organization);
    /**
     * Метод для получения объекта Organization по id
     * @param id переменная типа long, идентификатор организации в базе
     * @return Organization объект класса Organization
     */
    public Organization getOrganizationById(long id);
    /**
     * Метод для сохранения объекта Organization в БД
     * @param organization объект класса OrganizationDto
     */
    public void saveOrganization(Organization organization);

}
