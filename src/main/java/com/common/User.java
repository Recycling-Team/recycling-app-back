package com.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("user_id")
    private int user_id;
    private String username;


    public User() {
    }

    public User(int user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }
    
    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}