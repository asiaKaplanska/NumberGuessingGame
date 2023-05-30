package org.asia.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

class ScoreSystemTest {

    ScoreSystem scoreSystem;
    @Mock
    GameState gameState;

    @BeforeEach
    public void initEach() {
        scoreSystem = new ScoreSystem();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should correctly set number of winnings to 0 after drawing wrong number [negative]")
    void addBasicScore_negative() {

        //when
        scoreSystem.addBasicScore(1, 2, gameState);

        //then
        //score system should set winnings on game state to 0
        Mockito.verify(gameState).setWinnings(0);
        Mockito.verify(gameState, Mockito.never()).addToUserScore(Config.BASIC_WIN_POINTS);
    }

    @Test
    @DisplayName("Should correctly add basic points to user score after drawing correct number [positive]")
    void addBasicScore_positive() {

        //when
        scoreSystem.addBasicScore(1, 1, gameState);

        //then
        //score system should add to score basic win points and increase winnings
        Mockito.verify(gameState).addToUserScore(Config.BASIC_WIN_POINTS);
        Mockito.verify(gameState).increaseWinnings();
    }

    @Test
    @DisplayName("Should correctly add double wins bonus points to user score [positive]")
    void addBonusScore_doubleWins() {

        //when
        //set mock state to winnings == 2
        Mockito.when(gameState.getWinnings()).thenReturn(2);
        scoreSystem.addBonusScore(gameState);

        //then
        Mockito.verify(gameState).addToUserScore(Config.TWO_WINS_BONUS);
    }

    @Test
    @DisplayName("Should correctly add triple wins bonus points to user score [positive]")
    void addBonusScore_tripleWins() {

        //when
        //set mock state to winnings == 3
        Mockito.when(gameState.getWinnings()).thenReturn(3);
        scoreSystem.addBonusScore(gameState);

        //then
        Mockito.verify(gameState).addToUserScore(Config.THREE_WINS_BONUS);
    }

    @Test
    @DisplayName("Should correctly add quadruple wins bonus points to user score [positive]")
    void addBonusScore_quadrupleWins() {

        //when
        //set mock state to winnings == 4
        Mockito.when(gameState.getWinnings()).thenReturn(4);
        scoreSystem.addBonusScore(gameState);

        //then
        Mockito.verify(gameState).addToUserScore(Config.FOUR_WINS_BONUS);
    }

    @Test
    @DisplayName("Should correctly add no wins bonus points to user score after no winnings [negative]")
    void addBonusScore_negative() {

        //when
        //set mock state to winnings == 0
        Mockito.when(gameState.getWinnings()).thenReturn(0);
        scoreSystem.addBonusScore(gameState);

        //then
        Mockito.verify(gameState, Mockito.never()).addToUserScore(any(Integer.class));
    }
}