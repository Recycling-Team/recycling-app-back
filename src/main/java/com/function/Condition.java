package com.function;

public class Condition {

    private int conditionId;
    private String condition;

    public Condition(int conditionId, String condition) {
        this.conditionId = conditionId;
        this.condition = condition;
    }

    public int getConditionId() {
        return conditionId;
    }

    public String getCondition() {
        return condition;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
