package com.example.jwt.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AppUserDTO {
    private int user_id;
    @NotNull
    @Size(min = 2, message = "Username should be has more than 2 characters")
    @Pattern(regexp = "^([A-Za-z0-9_\\s])*$", message = "Please input valid username")
    private String username;
    @NotNull(message = "Email required. Please provide an email")
//    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",message = "Please Input Valid Email To Continue")
    @Email(message = "Please input valid email address")
    private String email;
    @NotNull(message = "No password provided. Password must be provided.")
    @Size(min = 5, message = "Password should have 6 characters at least")
    private String password;
    private String user_role;
    @JsonIgnore
    private String refesh_token;

    public AppUserDTO() {
    }

    public AppUserDTO(int user_id, @NotNull @Size(min = 2, message = "Username should be has more than 2 characters") @Pattern(regexp = "^([A-Za-z0-9_\\s])*$", message = "Please input valid username") String username, @NotNull(message = "Email required. Please provide an email") @Email(message = "Please input valid email address") String email, @NotNull(message = "No password provided. Password must be provided.") @Size(min = 5, message = "Password should have 6 characters at least") String password, String user_role, String refesh_token) {
        this.setUser_id(user_id);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setUser_role(user_role);
        this.setRefesh_token(refesh_token);
    }

    @Override
    public String toString() {
        return "AppUserDTO{" +
                "user_id=" + getUser_id() +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", user_role='" + getUser_role() + '\'' +
                ", refesh_token='" + getRefesh_token() + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getRefesh_token() {
        return refesh_token;
    }

    public void setRefesh_token(String refesh_token) {
        this.refesh_token = refesh_token;
    }
}

