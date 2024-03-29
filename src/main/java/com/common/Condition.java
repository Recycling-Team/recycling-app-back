package com.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Condition {

    
    @JsonProperty("category_id")
    private int condition_id;
    private String condition;

    public Condition(int conditionId, String condition) {
        this.condition_id = conditionId;
        this.condition = condition;
    }

    public int getConditionId() {
        return condition_id;
    }

    public String getCondition() {
        return condition;
    }

    public void setConditionId(int conditionId) {
        this.condition_id = conditionId;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
