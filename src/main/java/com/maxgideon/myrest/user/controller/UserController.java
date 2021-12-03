package com.maxgideon.myrest.user.controller;

import com.maxgideon.myrest.user.service.UserService;
import com.maxgideon.myrest.user.service.data.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/list")
    public List<UserDto> showAllUser(@RequestBody UserDto userDto){
        return userService.getAllUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }
    @PostMapping("/update")
    public void updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
    }

}
