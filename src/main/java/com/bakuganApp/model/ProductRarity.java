package com.bakuganApp.model;

public enum ProductRarity {

    BAKU_CORE ("Baku Core"),
    BATTLE_DAMAGED ("Battle Damaged"),
    BAKU_CRYSTAL ("Baku Crystal"),
    BAKU_FROST ("Baku Frost"),
    BAKU_LYTE ("Baku Lyte"),
    BAKU_FLIP ("Baku Flip"),
    BAKU_SOLAR ("Baku Solar"),
    BAKU_NEON ("Baku Neon"),
    BAKU_STEEL ("Baku Steel"),
    BAKU_MUTATIONS ("Baku Mutations"),
    EVIL_TWIN ("Evil Twin"),
    BAKU_GOLD ("Baku Gold"),
    BAKU_BRONZE("Baku Bronze"),
    B_ONE ("B1"),
    BAKU_STEALTH ("Baku Stealth"),
    CRIMSON_PEARL ("Crimson&Pearl"),
    BAKU_METALIC("Baku Metalic"),
    BAKU_BLAZE ("Blue Blaze"),
    COLLECTOR ("Collector"),
    NORMAL ("Normal"),
    DIAMOND ("Diamond"),
    CORE ("Core"),
    CRYSTAL ("Crystal"),
    FROST ("Frost"),
    SPIRIT ("Spirit"),
    NEGATIVE ("Negative"),
    SOLAR ("Solar"),
    TOXIC ("Toxic"),
    MECHA ("Mecha"),
    DOUBLE_ATTRIBUTE ("Double Attribute"),
    GOLD ("Gold"),
    BRONZE ("Bronze"),
    AZURE_WAVE ("Azure Wave"),
    CRIMSON_CORE ("Crimson Core");

    private final String state;

    ProductRarity(String value){
        state = value;
    }

    public String toString(){
        return this.state;
    }
}
