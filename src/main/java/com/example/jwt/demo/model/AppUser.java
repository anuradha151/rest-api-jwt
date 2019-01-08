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
    private String user_name;
    @Column(nullable = false)
    private String user_email;
    @Column(nullable = false)
    private String user_password;
    @Column(columnDefinition = "Varchar(100) default 'Admin'")
    private String user_role = "Admin";
    @JsonIgnore
    private String refresh_token;

    public AppUser() {
    }

    public AppUser(String user_name, String user_email, String user_password, String user_role, String refresh_token) {
        this.setUser_name(user_name);
        this.setUser_email(user_email);
        this.setUser_password(user_password);
        this.setUser_role(user_role);
        this.setRefresh_token(refresh_token);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_role='" + user_role + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
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
