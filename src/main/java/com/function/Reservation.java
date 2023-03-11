package com.function;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Reservation {

    @JsonProperty("user_id")
    private int user_id;
    @JsonProperty("item_id")
    private int item_id;
    private String date;

    public Reservation() {
        
    }

    public Reservation(int userId, int itemId, String date) {
        user_id = userId;
        item_id = itemId;
        this.date = date;
    }

    public int getUserId() {
        return user_id;
    }

    public int getItemId() {
        return item_id;
    }

    public String getDate() {
        return date;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public void setItemId(int item_id) {
        this.item_id = item_id;
    }

    public void setDate(String date) {
        this.date = date;
    }
}