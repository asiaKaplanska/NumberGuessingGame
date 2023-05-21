package org.asia.game;

import java.time.LocalDateTime;

public class GameResult {

    private final String playerName;
    private final int playerScore;
    private final LocalDateTime dateOfGame;

    public GameResult(String playerName, int playerScore, LocalDateTime dateOfGame) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.dateOfGame = dateOfGame;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public LocalDateTime getDateOfGame() {
        return dateOfGame;
    }
}
