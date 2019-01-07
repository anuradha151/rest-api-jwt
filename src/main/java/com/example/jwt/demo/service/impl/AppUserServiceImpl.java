package com.example.jwt.demo.service.impl;

import com.example.jwt.demo.dto.AppUserDTO;
import com.example.jwt.demo.model.AppUser;
import com.example.jwt.demo.model.enums.UserRole;
import com.example.jwt.demo.repository.UserRepository;
import com.example.jwt.demo.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ResponseEntity<?> registerCmsUser(AppUserDTO appUserDTO) {
        AppUser userByEmail = userRepository.getUserByEmail(appUserDTO.getEmail());
        if (userByEmail != null) {
            return new ResponseEntity<>("Existing user", HttpStatus.BAD_REQUEST);
        }
        try {

            AppUser appUser = new AppUser();
            appUser.setUsername(appUserDTO.getUsername());
            appUser.setEmail(appUserDTO.getEmail());
            appUser.setPassword(bCryptPasswordEncoder.encode(appUserDTO.getPassword()));
            appUser.setUser_role(UserRole.ADMIN.toString());
            appUser.setRefesh_token(appUserDTO.getRefesh_token());

            if (userRepository.save(appUser) != null) {
                return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to save user", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed TO Save Admin... Operation Unsuccessful");
        }
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
