package com.cy.users.controllers;

import com.cy.users.dto.UserDto;
import com.cy.users.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController

public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable String id){
        UserDto userEntity = userService.getUserById(id);
        return userEntity;
    }

    @PostMapping("/user/newuser")
    public UserDto insertUser(@RequestBody UserDto userEntity) {
        userService.insert(userEntity);
        //log.debug("The method is ending");
        return userEntity;
    }
}
