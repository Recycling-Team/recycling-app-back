package com.function;


public class Reservation {

    private int userId;
    private int itemId;
    private String date;

    public Reservation(int userId, int itemId, String date) {
        this.userId = userId;
        this.itemId = itemId;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getDate() {
        return date;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setDate(String date) {
        this.date = date;
    }
}