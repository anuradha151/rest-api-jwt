package com.example.jwt.demo.controller;

import com.example.jwt.demo.dto.AppUserDTO;
import com.example.jwt.demo.exception.CustomException;
import com.example.jwt.demo.exception.CustomValidateException;
import com.example.jwt.demo.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app_user")
@CrossOrigin
public class UserController {

    private final AppUserService appUserService;
    private final CustomValidateException customValidateException;
    private String validateError;


    public UserController(AppUserService appUserService, CustomValidateException customValidateException) {
        this.appUserService = appUserService;
        this.customValidateException = customValidateException;
    }

    @PostMapping("/save")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody AppUserDTO appUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            validateError = customValidateException.validationException(bindingResult);
            throw new CustomException(validateError);
        }
        return appUserService.registerUser(appUserDTO);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody AppUserDTO cmsUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            validateError = customValidateException.validationException(bindingResult);
            throw new CustomException(validateError);
        }
        return appUserService.updateUser(cmsUserDTO);
    }

    @DeleteMapping("/delete/{user_id:.+}")
    public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
        return appUserService.removeUser(user_id);
    }

    @GetMapping("/search/{user_id:.+}")
    public ResponseEntity<?> searchUser(@PathVariable int user_id) {
        return appUserService.searchUser(user_id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUserDTO appUserDTO) {
        return cmsLoginService.loginUser(appUserDTO);
    }

    @PostMapping("/getAccessToken")
    public ResponseEntity<?> getaccesstoken(@RequestBody AuthToken token) throws Exception {
        return cmsLoginService.getRefreshToken(token.getRefresh_token());
    }

}
