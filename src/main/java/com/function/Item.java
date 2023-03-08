package com.function;

public class Item {
    private int item_id;
    private String item_name;
    private User user;

    public Item(int item_id, String item_name, User user) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.user = user;
        user.addItem(this);
    }

    public int getItemId() {
        return item_id;
    }

    public String getItemName() {
        return item_name;
    }

    public User getUser() {
        return user;
    }

    public void setItemName(String item_name) {
        this.item_name = item_name;
    }

    public void setUser(User user) {
        this.user = user;
    }
}