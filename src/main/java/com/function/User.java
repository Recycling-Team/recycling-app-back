package com.function;


public class User {

    private int user_id;
    private String username;


    public User(String username) {
        this.username = username;
    }

    public int getUserId() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}