package com.example.jwt.demo.service;

import com.example.jwt.demo.dto.AppUserDTO;
import org.springframework.http.ResponseEntity;

public interface AppUserService {
    ResponseEntity<?> registerCmsUser(AppUserDTO appUserDTO);

    ResponseEntity<?> updateCmsUser(AppUserDTO appUserDTO);

    ResponseEntity<?> removeCmsUser(int user_id);

    ResponseEntity<?> searchCmsUser(int user_id);

}
