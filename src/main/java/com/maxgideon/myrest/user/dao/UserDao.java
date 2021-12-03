package com.maxgideon.myrest.user.dao;

import com.maxgideon.myrest.user.entity.User;
import com.maxgideon.myrest.user.service.data.UserDto;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser(UserDto userDto);
    public User getUserById(long id);
    public void saveUser(UserDto userDto);
    public void updateUser(UserDto userDto);
}
