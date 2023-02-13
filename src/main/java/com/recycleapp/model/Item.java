package com.recycleapp.model;

public class Item {

    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public String getItem() {
        return name;
    }

    public void setItem(String name) {
        this.name = name;
    }
}
