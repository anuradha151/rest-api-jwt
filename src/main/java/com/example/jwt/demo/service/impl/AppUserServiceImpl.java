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

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ResponseEntity<?> registerUser(AppUserDTO appUserDTO) {
        AppUser userByEmail = userRepository.getUserByEmail(appUserDTO.getEmail());
        if (userByEmail != null) {
            return new ResponseEntity<>("Existing user", HttpStatus.BAD_REQUEST);
        }
        try {
            AppUser appUser = dTOToEntity(appUserDTO);
            if (userRepository.save(appUser) != null) {
                return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Failed to save user", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user");
        }
    }

    @Override
    public ResponseEntity<?> updateUser(AppUserDTO appUserDTO) {
        try {
            Optional<AppUser> optional = userRepository.findById(appUserDTO.getUser_id());
            if (optional.isPresent()) {
                AppUser appUser = dTOToEntity(appUserDTO);
                appUser.setUser_id(optional.get().getUser_id());
                if (userRepository.save(appUser) != null) {
                    return new ResponseEntity<>("App user updated successfully", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("App user update failed", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            throw new RuntimeException("Update unsuccessful");
        }

    }

    @Override
    public ResponseEntity<?> removeUser(int user_id) {
        try {
            Optional<AppUser> optional = userRepository.findById(user_id);
            if (optional.isPresent()) {
                userRepository.deleteById(user_id);
                return new ResponseEntity<>("User successfully removed", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            throw new RuntimeException("Data removal unsuccessful");
        }
    }

    @Override
    public ResponseEntity<?> searchUser(int user_id) {
        try {
            Optional<AppUser> optional = userRepository.findById(user_id);
            if (optional.isPresent()) {
                AppUserDTO appUserDTO = entityToDTO(optional.get());
                return new ResponseEntity<>(appUserDTO, HttpStatus.OK);
            } else {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching data");
        }
    }

    private AppUser dTOToEntity(AppUserDTO appUserDTO) {
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserDTO.getUsername());
        appUser.setEmail(appUserDTO.getEmail());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserDTO.getPassword()));
        appUser.setUser_role(UserRole.ADMIN.toString());
        appUser.setRefesh_token(appUserDTO.getRefesh_token());
        return appUser;
    }

    private AppUserDTO entityToDTO(AppUser appUser) {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setUsername(appUser.getUsername());
        appUserDTO.setEmail(appUser.getEmail());
        appUserDTO.setUser_role(appUser.getUser_role());
        appUserDTO.setRefesh_token(appUser.getRefesh_token());
        return appUserDTO;
    }

}
