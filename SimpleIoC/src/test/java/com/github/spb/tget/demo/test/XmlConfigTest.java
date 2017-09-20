package com.github.spb.tget.demo.test;

import com.github.spb.tget.demo.Game;
import com.github.spb.tget.demo.Sonic;
import com.github.spb.tget.demo.Tennis;
import org.hamcrest.CoreMatchers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;

public class XmlConfigTest {

    private final String relativeFilePathToResources =
            "src\\main\\java\\com\\github\\spb\\tget\\demo\\configuration\\xml_config\\";

    @Test
    public void xmlConfig_sonicContext_sonicGameShouldBeInitializedWithRoomService() {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                relativeFilePathToResources + "sonic-context.xml");
        Game game = (Game) context.getBean("sonicGame");

        assertThat("Bean should be of type Sonic", game instanceof Sonic);
        assertThat("play() method should display Sonic information", game.play(),
                containsString("Sonic: 1 number of players, originated from Japan, playing since 1991"));
        assertThat("Incorrect Room service equipment", game.getService().getEquipment(),
                containsInAnyOrder("Chair", "Food"));
        assertThat("Incorrect Room service description", game.getService().getName(),
                CoreMatchers.containsString("Room service for comfortable virtual gaming"));
    }

    @Test
    public void xmlConfig_tennisContext_tennisGameShouldBeInitializedWithFieldService() {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                relativeFilePathToResources + "tennis-context.xml");
        Game game = (Game) context.getBean("tennisGame");

        assertThat("Bean should be of type Tennis", game instanceof Tennis);
        assertThat("play() method should display Tennis information", game.play(),
                containsString("Tennis: 2 number of players, originated from USA, playing since 1860"));
        assertThat("Incorrect Field service equipment", game.getService().getEquipment(),
                containsInAnyOrder("Court", "Net"));
    }
}
