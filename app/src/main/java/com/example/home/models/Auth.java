package com.example.home.models;

public class Auth {

    private String jwt;
    private User user;

    public Auth() {
        this.jwt = "";
        this.user = null;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public User getUser() {
        return user;
    }
}
