package com.maxgideon.myrest.user.service;

import com.maxgideon.myrest.user.dao.UserDao;
import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.user.entity.references.Countries;
import com.maxgideon.myrest.user.entity.references.DocumentsType;
import com.maxgideon.myrest.user.service.data.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    public List<UserDto> getAllUser(UserDto userDto){
        List<User> list = userDao.getAllUser(userDto);
        List<UserDto> listDto = new ArrayList<>();
        for(User us: list){
            listDto.add(new UserDto(us.getId(),us.getFirstName(),us.getSecondName(),us.getMiddleName(),us.getPosition()));
        }
        return listDto;
    };
    public UserDto getUserById(long id){
          User user = userDao.getUserById(id);
          UserDto userDto = new UserDto(user);
          return userDto;
    };
    public void saveUser(UserDto userDto){
        userDao.saveUser(userDto);

    };
    public void updateUser(UserDto userDto){
        userDao.updateUser(userDto);
    };

    @Override
    public List<DocumentsType> showAllDocumentsType() {
        return userDao.getAllDocumentsType();
    }

    @Override
    public List<Countries> showAllCountries() {
        return userDao.getAllCountries();
    }
}
