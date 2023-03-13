package com.function;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("item_id")
    private int item_id;

    @JsonProperty("item_name")
    private String item_name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("pickTime")
    private String pickTime;

    @JsonProperty("user")
    private int user;
    @JsonProperty("category")
    private int category;
    @JsonProperty("condition")
    private int condition;

    public Item() {
    }

    public Item(int ItemId, String ItemName, String Description, String PickTime, int User, int Category,
            int Condition) {
        item_id = ItemId;
        item_name = ItemName;
        user = User;
        description = Description;
        pickTime = PickTime;
        category = Category;
        condition = Condition;
    }

    public int getItem_id() {
        return this.item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return this.item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPickTime() {
        return this.pickTime;
    }

    public void setPickTime(String pickTime) {
        this.pickTime = pickTime;
    }

    public int getUser() {
        return this.user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCondition() {
        return this.condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

}