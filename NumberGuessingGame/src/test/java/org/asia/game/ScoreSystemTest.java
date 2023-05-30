package org.asia.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreSystemTest {

    ScoreSystem scoreSystem;
    @Mock
    GameState gameState;

    @BeforeEach
    public void initEach() {
        scoreSystem = new ScoreSystem();
        gameState = new GameState();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should correctly add basic points to user score [positive]")
    void addBasicScore() {

        //when
        scoreSystem.addBasicScore(1, 3, gameState);

        //then
        assertEquals(0, gameState.getUserScore());
    }

    @Test
    @DisplayName("Should correctly add bonus points to user score [positive]")
    void addBonusScore() {

        //when
        gameState.setWinnings(2);
        scoreSystem.addBonusScore(gameState);

        //then
        assertEquals(10, gameState.getUserScore());
    }
}