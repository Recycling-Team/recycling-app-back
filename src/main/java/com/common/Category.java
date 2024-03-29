package com.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    @JsonProperty("category_id")
    private int category_id;
    private String category;

    public Category(int categoryId, String category) {
        this.category_id = categoryId;
        this.category = category;
    }

    public int getCategoryId() {
        return category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategoryId(int categoryId) {
        this.category_id = categoryId;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
