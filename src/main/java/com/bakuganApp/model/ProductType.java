package com.bakuganApp.model;

public enum ProductType {
    MODEL ("Model"),
    SEALED ("Sealed"),
    CARD("Card"),
    ACCESSORIES ("Accessories");

    private final String state;

    ProductType(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
