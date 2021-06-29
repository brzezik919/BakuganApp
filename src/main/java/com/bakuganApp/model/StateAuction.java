package com.bakuganApp.model;

public enum StateAuction {
    ONGOING ("Ongoing"),
    PENDING ("Pending"),
    ACCEPTED ("Accepted"),
    CANCELED ("Canceled");

    private final String state;

    StateAuction(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
