package com.example.jwt.demo.service;

import org.springframework.http.ResponseEntity;

public interface AppUserService {
    public ResponseEntity<?> registerCmsUser(CmsUserDTO cmsUserDTO);

    public ResponseEntity<?> updateCmsUser(CmsUserDTO cmsUserDTO);

    public ResponseEntity<?> removeCmsUser(int user_id);

    public ResponseEntity<?> searchCmsUser(int user_id);

}
