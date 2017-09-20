package com.github.spb.tget.demo;

import com.github.spb.tget.demo.service.GameService;

import java.util.Arrays;

public class Sonic extends ComputerGame {

    private GameService gameService;

    public Sonic() {
        create();
    }

    public Sonic(GameService gameService) {
        this();
        this.gameService = gameService;
    }

    public Sonic create() {
        return (Sonic)this
                .withNumberOfPlayers(getNumberOfPlayers())
                .withOriginatingCountry("Japan")
                .withFoundationYear(1991);
    }

    public GameService getGameService() {
        return this.gameService;
    }

    @Override
    public String getAccessories(){
        return Arrays.toString(this.gameService.getEquipment().toArray());
    }

    @Override
    public GameService getService() {
        return this.gameService;
    }

    @Override
    public String play() {
        return String.format("Sonic: %s number of players, originated from %s, playing since %d",
                this.getNumberOfPlayers(), this.getOriginatingCountry(), this.getFoundationYear());
    }

    @Override
    public int getNumberOfPlayers(){
        return 1;
    }


    @Override
    public boolean isTimeRestricted() {
        return true;
    }
}
