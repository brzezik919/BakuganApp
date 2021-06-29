package com.bakuganApp.model;

public enum ProductRegion {
    JAPAN ("Japan"),
    OTHER ("Other");

    private final String state;

    ProductRegion(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
