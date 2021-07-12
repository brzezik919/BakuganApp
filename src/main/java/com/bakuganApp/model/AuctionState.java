package com.bakuganApp.model;

public enum AuctionState {

    ONGOING ("ongoing"),
    PENDING ("pending"),
    SHIPMENT ("shipment"),
    ENDED("ended"),
    CANCELED ("canceled");

    private final String state;

    AuctionState(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
