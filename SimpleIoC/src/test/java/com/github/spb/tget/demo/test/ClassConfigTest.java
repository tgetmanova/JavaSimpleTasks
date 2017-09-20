package com.github.spb.tget.demo.test;

import com.github.spb.tget.demo.Game;
import com.github.spb.tget.demo.Sonic;
import com.github.spb.tget.demo.configuration.class_config.GameContext;
import org.hamcrest.CoreMatchers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;

public class ClassConfigTest {

    @Test
    public void classConfig_sonicContext_sonicGameShouldBeInitializedWithRoomService() {
        ApplicationContext context = new AnnotationConfigApplicationContext(GameContext.class);
        Game game = (Game) context.getBean("sonicGame");

        assertThat("Bean should be of type Sonic", game instanceof Sonic);
        assertThat("play() method should display Sonic information", game.play(),
                containsString("Sonic: 1 number of players, originated from Japan, playing since 1991"));
        assertThat("Incorrect Room service equipment", game.getService().getEquipment(),
                containsInAnyOrder("Chair", "Food"));
        assertThat("Incorrect Room service description", game.getService().getName(),
                CoreMatchers.containsString("Room service for comfortable virtual gaming"));
    }
}
