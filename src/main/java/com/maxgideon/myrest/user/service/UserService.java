package com.maxgideon.myrest.user.service;

import com.maxgideon.myrest.user.service.data.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUser(UserDto userDto);
    public UserDto getUserById(long id);
    public void saveUser(UserDto userDto);
    public void updateUser(UserDto userDto);
}