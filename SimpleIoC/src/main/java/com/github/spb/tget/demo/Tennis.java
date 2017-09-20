package com.github.spb.tget.demo;

import com.github.spb.tget.demo.service.GameService;

import java.util.Arrays;

public class Tennis extends SportGame implements BallGame {

    private double ballSize;

    private GameService gameService;

    private Tennis() {
    }

    public Tennis(GameService gameService) {
        this.gameService = gameService;
    }

    public static Tennis create() {
        return (Tennis) new Tennis()
                .withNumberOfPlayers(2)
                .withOriginatingCountry("USA")
                .withFoundationYear(1860);
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public int getNumberOfPlayers() {
        return 2;
    }

    public boolean isTimeRestricted() {
        return false;
    }

    public String play() {
        return String.format("Tennis: %s number of players, originated from %s, playing since %d",
                this.getNumberOfPlayers(), this.getOriginatingCountry(), this.getFoundationYear());
    }

    @Override
    public GameService getService() {
        return this.gameService;
    }

    @Override
    public String getAccessories() {
        return Arrays.toString(gameService.getEquipment().toArray());
    }

    public double ballSize() {
        return 68.5;
    }
}
