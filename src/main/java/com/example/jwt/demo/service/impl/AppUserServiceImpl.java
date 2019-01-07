package com.example.jwt.demo.service.impl;

import com.example.jwt.demo.dto.AppUserDTO;
import com.example.jwt.demo.repository.UserRepository;
import com.example.jwt.demo.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final UserRepository userRepository;

    public AppUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
