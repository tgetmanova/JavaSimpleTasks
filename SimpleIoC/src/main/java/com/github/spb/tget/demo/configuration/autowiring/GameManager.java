package com.github.spb.tget.demo.configuration.autowiring;

import com.github.spb.tget.demo.Game;
import com.github.spb.tget.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;

public class GameManager {

    @Autowired
    private GameService gameService;

    @Autowired
    private Game game;

    public String printGameInfo(){
        return game.play() + gameService.getName();
    }
}
