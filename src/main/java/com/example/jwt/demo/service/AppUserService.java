package com.example.jwt.demo.service;

import com.example.jwt.demo.dto.AppUserDTO;
import org.springframework.http.ResponseEntity;

public interface AppUserService {
    ResponseEntity<?> registerUser(AppUserDTO appUserDTO);

    ResponseEntity<?> updateUser(AppUserDTO appUserDTO);

    ResponseEntity<?> removeUser(int user_id);

    ResponseEntity<?> searchUser(int user_id);

}
