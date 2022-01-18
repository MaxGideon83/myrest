package com.maxgideon.myrest.user.dao;


import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.references.entity.Countries;
import com.maxgideon.myrest.references.entity.DocumentsType;
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
     * @param user объект класса User
     */
    public void saveUser(User user);

    /**
     * Метод для получения типа документа по его коду и\или имени
     * @param code код типа документа
     * @param name имя типа документа
     * @return
     */
    public DocumentsType getDocumentsTypeByCodeOrName(String code, String name);

    /**
     * Метод для получения Страны по ее коду
     * @param citizenshipCode код страны
     * @return
     */
    public Countries getCountriesByCitizenshipCode(String citizenshipCode);
}
