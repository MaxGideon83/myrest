package com.maxgideon.myrest.user.service;

import com.maxgideon.myrest.user.entity.references.Countries;
import com.maxgideon.myrest.user.entity.references.DocumentsType;
import com.maxgideon.myrest.user.service.data.UserDto;

import java.util.List;
/**
 * Service для работы с UserDto
 */
public interface UserService {
    /**
     * Метод для преобразования списка объектов User в список объектов UserDto
     * @param userDto объект класса UserDto
     * @return List<UserDto> коллекция объектов UserDto
     */
    public List<UserDto> getAllUser(UserDto userDto);
    /**
     * Метод для преобразования объекта User полученного по id в объект UserDto
     * @param id переменная типа long, идентификатор пользователя в базе
     * @return UserDto объект класса UserDto
     */
    public UserDto getUserById(long id);
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
    public List<DocumentsType> showAllDocumentsType();
    /**
     * Метод для получения списка стран
     * @return List<Countries> коллекция объектов Countries
     */
    public List<Countries> showAllCountries();
}
