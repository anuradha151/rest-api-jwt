package com.example.jwt.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "Varchar(100) default 'Admin'")
    private String user_role = "Admin";
    @JsonIgnore
    private String refesh_token;

    public AppUser() {
    }

    public AppUser(String username, String email, String password, String user_role, String refesh_token) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setUser_role(user_role);
        this.setRefesh_token(refesh_token);
    }

    @Override
    public String toString() {
        return "AppUser{" +
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
