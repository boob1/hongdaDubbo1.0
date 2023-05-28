package com.hongda.controller;

import com.hongda.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author liuyibo
 * @Date 2023/5/27 11:34
 **/
@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user")
    public String getUser(){
        return userService.getUser();
    }
}


