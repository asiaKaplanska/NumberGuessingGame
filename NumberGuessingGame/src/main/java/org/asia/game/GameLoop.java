package org.asia.game;

public class GameLoop {

    private GameUI gameUI = new GameUI();
    private InputSystem inputSystem;
    private NumberGenerator numberGenerator;
    private int userScore = Config.STARTING_SCORE;


    public void playIntro() {

        gameUI.printGameDescriptionMessage();
        gameUI.printInsertUserNameMessage();
        inputSystem.getUserName();
    }

    public void playGame() {

        for (int i = 0; i < Config.GAMES_ITERATION; i++) {
            gameUI.printInsertInputMessage();
            var userInput = inputSystem.getUserInput();
            gameUI.printDrawnNumber();
            var generatedNumber = numberGenerator.drawRandomNumber();

        }
    }
}
