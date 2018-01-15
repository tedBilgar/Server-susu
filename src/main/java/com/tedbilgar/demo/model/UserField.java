package com.tedbilgar.demo.model;

public enum UserField {
    USER_NAME("username");

    UserField(String field) {
        this.field = field;
    }

    private final String field;

    public String getField() {
        return field;
    }
}
