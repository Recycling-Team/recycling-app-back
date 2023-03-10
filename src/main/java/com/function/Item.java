package com.function;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
  
    @JsonProperty("item_id")
    private int item_id;

    @JsonProperty("item_name")
    private String item_name;
    
    private String description;

    private String pickTime;
    
    @JsonProperty("User")
    private int user;

    private String username;

    private int category;

    private int condition;

    public Item() {
    }

    public Item(int ItemId, String ItemName, int User) {
        ItemId = item_id;
        ItemName = item_name;
        User = user;
    }

    public int getItemName() {
        return item_id;
    }

    public String getItemId() {
        return item_name;
    }

    public int getUser() {
        return user;
    }

    public void setItemId(int itemId) {
        this.item_id = itemId;
    }

    public void setItemName(String itemName) {
        this.item_name = itemName;
    }

    public void setUser(int user) {
        this.user = user;
    }
    

}