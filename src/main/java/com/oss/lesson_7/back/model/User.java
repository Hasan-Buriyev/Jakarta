package com.oss.lesson_7.back.model;

import com.oss.lesson_7.back.enums.Gender;

import java.util.Date;

public class User {
    private long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Gender gender;
    private Date loginDate;

    public User(long id, String name, String username, String password, String email, Gender gender, Date loginDate) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.loginDate = loginDate;
    }

    public User(String name, String username, String password, String email, Gender gender) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
