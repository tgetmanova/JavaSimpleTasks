package com.github.spb.tget.demo;

import com.github.spb.tget.demo.service.GameService;

import java.util.Arrays;

public class TableTennis extends SportGame implements BallGame {

    private double ballSize;

    private GameService gameService;

    private TableTennis() {
    }

    public TableTennis(GameService gameService) {
        this.gameService = gameService;
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
        return String.format("Table Tennis: %s number of players, originated from %s, playing since %d",
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
        return 40;
    }
}
