package com.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class Item {

    @JsonProperty("item_id")
    private int item_id;

    @JsonProperty("item_name")
    private String item_name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("pick_time")
    private String pick_time;

    @JsonProperty("message")
    private String message;

    @JsonProperty("pickup_status")
    private String pickup_status;

    @JsonProperty("listing_date")
    public String listing_date;

    @JsonProperty("available")
    private String available;

    @JsonProperty("user")
    private int user;

    @JsonProperty("category")
    private int category;

    @JsonProperty("condition")
    private int condition;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
    
    @JsonProperty("visible")
    private boolean visible;

    public Item() {
    }

    public Item(int item_id, String item_name, String description, String pick_time, String message,
            String pickup_status, String listing_date, String available, int user, int category, int condition, boolean visible) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.description = description;
        this.pick_time = pick_time;
        this.message = message;
        this.pickup_status = pickup_status;
        this.listing_date = listing_date;
        this.available = available;
        this.user = user;
        this.category = category;
        this.condition = condition;
        this.visible = visible;
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

    public String getPick_time() {
        return this.pick_time;
    }

    public void setPick_time(String pick_time) {
        this.pick_time = pick_time;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPickup_status() {
        return this.pickup_status;
    }

    public void setPickup_status(String pickup_status) {
        this.pickup_status = pickup_status;
    }

    public String getListing_date() {
        return this.listing_date;
    }

    public void setListing_date(String listing_date) {
        this.listing_date = listing_date;
    }

    public String getAvailable() {
        return this.available;
    }

    public void setAvailable(String available) {
        this.available = available;
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

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "{" +
                " item_id='" + getItem_id() + "'" +
                ", item_name='" + getItem_name() + "'" +
                ", description='" + getDescription() + "'" +
                ", pick_time='" + getPick_time() + "'" +
                ", message='" + getMessage() + "'" +
                ", pickup_status='" + getPickup_status() + "'" +
                ", listing_date='" + getListing_date() + "'" +
                ", available='" + getAvailable() + "'" +
                ", user='" + getUser() + "'" +
                ", category='" + getCategory() + "'" +
                ", condition='" + getCondition() + "'" +
                ", visible='" + getVisible() + "'" +
                "}";
    }

}