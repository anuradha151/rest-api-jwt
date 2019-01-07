package com.example.jwt.demo.controller;

import com.example.jwt.demo.service.AppUserService;

public class UserController {

    private final AppUserService appUserService;


    public UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

}
