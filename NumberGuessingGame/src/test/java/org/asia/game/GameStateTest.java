package org.asia.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStateTest {

    GameState gameState = new GameState();

    @Test
    @DisplayName("Should correctly add user score [positive]")
    void addToUserScore() throws NoSuchFieldException, IllegalAccessException {

        //setup
        //set initial user score to 10
        Field userScore = gameState.getClass().getDeclaredField("userScore");
        userScore.setAccessible(true);
        userScore.set(gameState, 10);

        //when
        //add additional 10 points to score
        gameState.addToUserScore(10);

        //then
        //expected: 10 (initial) + 10 (additional) -> 20 points as result
        assertEquals(20, userScore.getInt(gameState));
    }
}