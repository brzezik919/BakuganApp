package com.bakuganApp.model;

public enum Attribute {
    FIRE ("Fire"),
    WATER ("Water"),
    EARTH ("Earth"),
    WIND ("Wind"),
    LIGHT ("Light"),
    DARK ("Dark"),
    NONE ("None"),
    DOUBLE ("Double");

    private final String state;

    Attribute(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
