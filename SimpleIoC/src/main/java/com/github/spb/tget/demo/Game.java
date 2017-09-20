package com.github.spb.tget.demo;

import com.github.spb.tget.demo.service.GameService;

public abstract class Game {

    private int numberOfPlayers;
    private String originatingCountry;
    private int foundationYear;

    public String getOriginatingCountry() {
        return this.originatingCountry;
    }

    public int getFoundationYear() {
        return this.foundationYear;
    }

    protected int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    protected Game withOriginatingCountry(String originatingCountry){
        this.originatingCountry = originatingCountry;
        return this;
    }

    protected Game withFoundationYear(int foundationYear){
        this.foundationYear = foundationYear;
        return this;
    }

    protected Game withNumberOfPlayers(int numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        return this;
    }

    public abstract String play();
    public abstract String getAccessories();
    public abstract GameService getService();
    public abstract boolean isTimeRestricted();
}
