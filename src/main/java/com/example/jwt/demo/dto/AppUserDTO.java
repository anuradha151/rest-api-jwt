package com.example.jwt.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * created by Anuradha Ranasinghe
 */
public class AppUserDTO {
    private int user_id;
    @NotNull
    @Size(min = 2, message = "Username should be has more than 2 characters")
    @Pattern(regexp = "^([A-Za-z0-9_\\s])*$", message = "Please input valid username")
    private String user_name;
    @NotNull(message = "Email required. Please provide an email")
//    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",message = "Please Input Valid Email To Continue")
    @Email(message = "Please input valid email address")
    private String user_email;
    @NotNull(message = "No password provided. Password must be provided.")
    @Size(min = 5, message = "Password should have 6 characters at least")
    private String user_password;
    private String user_role;
    @JsonIgnore
    private String refresh_token;

    public AppUserDTO() {
    }

    public AppUserDTO(int user_id, @NotNull @Size(min = 2, message = "Username should be has more than 2 characters") @Pattern(regexp = "^([A-Za-z0-9_\\s])*$", message = "Please input valid username") String user_name, @NotNull(message = "Email required. Please provide an email") @Email(message = "Please input valid email address") String user_email, @NotNull(message = "No password provided. Password must be provided.") @Size(min = 5, message = "Password should have 6 characters at least") String user_password, String user_role, String refresh_token) {
        this.setUser_id(user_id);
        this.setUser_name(user_name);
        this.setUser_email(user_email);
        this.setUser_password(user_password);
        this.setUser_role(user_role);
        this.setRefresh_token(refresh_token);
    }

    @Override
    public String toString() {
        return "AppUserDTO{" +
                "user_id=" + getUser_id() +
                ", user_name='" + getUser_name() + '\'' +
                ", user_email='" + getUser_email() + '\'' +
                ", user_password='" + getUser_password() + '\'' +
                ", user_role='" + getUser_role() + '\'' +
                ", refresh_token='" + getRefresh_token() + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}

