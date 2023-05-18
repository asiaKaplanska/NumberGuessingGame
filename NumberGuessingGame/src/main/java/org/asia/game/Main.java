package org.asia.game;

public class Main {

    public static void main(String[] args) {

        GameLoop gameLoop = new GameLoop();
        gameLoop.playIntro();
        gameLoop.playGame();
        gameLoop.playSummary();
    }
}
