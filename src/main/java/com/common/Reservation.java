package com.common;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {

    @JsonProperty("user_id")
    private int user_id;

    @JsonProperty("item_id")
    private int item_id;

    private String date;

    private String notification;

    public Reservation() {

    }


    public Reservation(int user_id, int item_id, String date, String notification) {
        this.user_id = user_id;
        this.item_id = item_id;
        this.date = date;
        this.notification = notification;
    }
    

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getItem_id() {
        return this.item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotification() {
        return this.notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
    
}