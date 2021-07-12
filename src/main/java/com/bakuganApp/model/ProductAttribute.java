package com.bakuganApp.model;

public enum ProductAttribute {
    FIRE ("Fire"),
    WATER ("Water"),
    EARTH ("Earth"),
    WIND ("Wind"),
    LIGHT ("Light"),
    DARK ("Dark"),
    NONE ("None"),
    DOUBLE ("Double");

    private final String state;

    ProductAttribute(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
