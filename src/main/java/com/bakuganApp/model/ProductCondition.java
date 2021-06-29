package com.bakuganApp.model;

public enum ProductCondition {
    BROKEN ("Broken"),
    USED ("Used"),
    MINT ("Mint");

    private final String state;

    ProductCondition(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
