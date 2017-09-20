package com.github.spb.tget.demo.test;

import com.github.spb.tget.demo.configuration.autowiring.GameManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class AutowireTest {

    private final String relativeFilePathToResources =
            "src\\main\\java\\com\\github\\spb\\tget\\demo\\configuration\\autowiring\\";

    @Test
    public void autowire_tableTennisContext_tableTennisGameShouldBeInitializedWithFieldService() {
        ApplicationContext context = new FileSystemXmlApplicationContext(relativeFilePathToResources
                + "tabletennis-context.xml");
        GameManager gameManager = (GameManager) context.getBean("gameManager");

        assertThat("Game manager should print Table Tennis information", gameManager.printGameInfo(),
                stringContainsInOrder(Arrays.asList(
                        new String[]{"Table Tennis", "Field service with wide space to play sport games"})));
    }
}
