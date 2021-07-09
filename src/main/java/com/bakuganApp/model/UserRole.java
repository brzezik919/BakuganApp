package com.bakuganApp.model;

public enum UserRole {
    USER_ROLE ("user"),
    ADMIN_ROLE ("admin");

    private final String state;

    UserRole(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
