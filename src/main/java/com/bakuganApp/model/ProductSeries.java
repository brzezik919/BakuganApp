package com.bakuganApp.model;

public enum ProductSeries {
    LEGACY ("Legacy"),
    BATTLE_PLANET ("Battle Planet"),
    REVELATIONS ("Revelations");

    private final String state;

    ProductSeries(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
