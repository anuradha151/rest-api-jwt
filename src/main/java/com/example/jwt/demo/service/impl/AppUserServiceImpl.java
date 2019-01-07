package com.example.jwt.demo.service.impl;

import com.example.jwt.demo.dto.AppUserDTO;
import com.example.jwt.demo.service.AppUserService;
import org.springframework.http.ResponseEntity;

public class AppUserServiceImpl implements AppUserService {



    @Override
    public ResponseEntity<?> registerCmsUser(AppUserDTO appUserDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateCmsUser(AppUserDTO appUserDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> removeCmsUser(int user_id) {
        return null;
    }

    @Override
    public ResponseEntity<?> searchCmsUser(int user_id) {
        return null;
    }
}
