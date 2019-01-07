package com.example.jwt.demo.repository;

import com.example.jwt.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {


    @Modifying
    @Query("update AppUser u set u.refesh_token = :refesh_token WHERE u.email= :email")
    @Transactional
    int updateRefreshToken(@Param("email") String email, @Param("refesh_token") String refreshToken);

    @Query("SELECT u FROM AppUser u WHERE u.email=?1")
    AppUser getUserByEmail(String email);

    @Query("SELECT u FROM AppUser u WHERE u.refesh_token=?1")
    AppUser findByRefreshToken(String refreshToken);

    @Query("SELECT u FROM AppUser u WHERE u.email=?1 ")
    AppUser validateUser(String email);

}
