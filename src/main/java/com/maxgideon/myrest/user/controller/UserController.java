package com.maxgideon.myrest.user.controller;

import com.maxgideon.myrest.exception.ResponseResult;
import com.maxgideon.myrest.user.service.UserService;
import com.maxgideon.myrest.user.service.data.UserDto;
import com.maxgideon.myrest.validation.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
@RequestMapping("api")
public class UserController {

    @Autowired
    UserService userService;

    @Validated({Marker.ListObject.class})
    @PostMapping("/user/list")
    public Object showAllUser(@RequestBody @Valid UserDto userDto){
        return userService.getAllUser(userDto);
    }

    @GetMapping("/user/{id}")
    public Object getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @Validated({Marker.SaveObject.class})
    @PostMapping("/user/save")
    public ResponseEntity<ResponseResult> saveUser(@RequestBody @Valid UserDto userDto){
        userService.saveUser(userDto);
        return new ResponseEntity<>(new ResponseResult("success"), HttpStatus.OK);
    }

    @Validated({Marker.UpdateObject.class})
    @PostMapping("/user/update")
    public ResponseEntity<ResponseResult> updateUser(@RequestBody @Valid UserDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity<>(new ResponseResult("success"), HttpStatus.OK);
    }

    @PostMapping("/docs")
    public Object showAllDocumentsType(){
        return userService.showAllDocumentsType();
    }

    @PostMapping("/countries")
    public Object showAllCountries(){
        return userService.showAllCountries();
    }

}
