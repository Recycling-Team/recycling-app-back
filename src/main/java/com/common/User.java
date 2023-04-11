package com.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("user_id")
    private int user_id;
    private String username;

    private String last_login;


    public User() {
    }


    public User(int user_id, String username, String last_login) {
        this.user_id = user_id;
        this.username = username;
        this.last_login = last_login;
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

    public String getLast_login() {
        return this.last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    @Override
    public String toString() {
        return "{" +
            " user_id='" + getUser_id() + "'" +
            ", username='" + getUsername() + "'" +
            ", last_login='" + getLast_login() + "'" +
            "}";
    }

}