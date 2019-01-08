package com.example.jwt.demo.repository;

import com.example.jwt.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {


    @Modifying
    @Query("update AppUser u set u.refresh_token = :refresh_token WHERE u.user_email= :user_email")
    @Transactional
    int updateRefreshToken(@Param("user_email") String user_email, @Param("refresh_token") String refreshToken);

    @Query("SELECT u FROM AppUser u WHERE u.user_email=?1")
    Optional<AppUser> getUserByEmail(String user_email);

    @Query("SELECT u FROM AppUser u WHERE u.refresh_token=?1")
    Optional<AppUser> findByRefreshToken(String refresh_token);

    @Query("SELECT u FROM AppUser u WHERE u.user_email=?1 ")
    Optional<AppUser> validateUser(String user_email);

}
