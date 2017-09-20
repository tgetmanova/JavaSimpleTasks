package com.github.spb.tget.demo.configuration.class_config;

import com.github.spb.tget.demo.Game;
import com.github.spb.tget.demo.Sonic;
import com.github.spb.tget.demo.service.GameService;
import com.github.spb.tget.demo.service.RoomService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameContext {

    @Bean(name = "sonicGame")
    public Game getSonicGame() {
        return new Sonic(getGameService());
    }

    @Bean(name = "gameServiceBean")
    public GameService getGameService() {
        RoomService service = new RoomService();
        service.setPrettyName("Room service for comfortable virtual gaming");
        return service;
    }
}
