package com.maxgideon.myrest.user.dao;


import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.user.entity.references.Countries;
import com.maxgideon.myrest.user.entity.references.DocumentsType;
import com.maxgideon.myrest.user.service.data.UserDto;

import java.util.List;
/**
 * DAO для работы с User
 */
public interface UserDao {
    /**
     * Метод для получения списка пользователей
     * @param userDto объект класса UserDto
     * @return List<User> коллекция объектов User
     */
    public List<User> getAllUser(UserDto userDto);
    /**
     * Метод для получения объекта User по id
     * @param id переменная типа long, идентификатор пользователя в базе
     * @return User объект класса User
     */
    public User getUserById(long id);
    /**
     * Метод для сохранения объекта User в БД
     * @param userDto объект класса UserDto
     */
    public void saveUser(UserDto userDto);
    /**
     * Метод для обновления объекта User в БД
     * @param userDto объект класса UserDto
     */
    public void updateUser(UserDto userDto);
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
