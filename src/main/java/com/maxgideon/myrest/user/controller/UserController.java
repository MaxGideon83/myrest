package com.maxgideon.myrest.user.controller;

import com.maxgideon.myrest.user.service.UserService;
import com.maxgideon.myrest.user.service.data.UserDto;
import com.maxgideon.myrest.validation.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Validated({Marker.ListObject.class})
    @PostMapping("/list")
    public Object showAllUser(@RequestBody @Valid UserDto userDto){
        return userService.getAllUser(userDto);
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @Validated({Marker.SaveObject.class})
    @PostMapping("/save")
    public void saveUser(@RequestBody @Valid UserDto userDto){
        userService.saveUser(userDto);
    }

    @Validated({Marker.UpdateObject.class})
    @PostMapping("/update")
    public void updateUser(@RequestBody @Valid UserDto userDto){
        userService.updateUser(userDto);
    }

}
