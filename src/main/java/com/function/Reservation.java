package com.function;


public class Reservation {

    private int user_id;
    private int item_id;
    private String date;

    public Reservation(int userId, int itemId, String date) {
        this.user_id = userId;
        this.item_id = itemId;
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

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public void setItemId(int itemId) {
        this.item_id = itemId;
    }

    public void setDate(String date) {
        this.date = date;
    }
}