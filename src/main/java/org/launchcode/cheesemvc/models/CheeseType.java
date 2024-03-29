package org.launchcode.cheesemvc.models;

public enum CheeseType {

    HARD ("Hard"),
    SOFT ("Soft"),
    FAKE ("Faux");

    private final String name;

    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
