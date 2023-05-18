package org.asia.game;

public class GameLoop {

    private GameState gameState;

    private GameUI gameUI = new GameUI();
    private InputSystem inputSystem;
    private NumberGenerator numberGenerator;
    private ScoreSystem scoreSystem;



    public void playIntro() {

        gameState = new GameState();
        gameUI.printGameDescriptionMessage();
        gameUI.printInsertUserNameMessage();
        gameState.setUserName(inputSystem.getUserName());
    }

    public void playGame() {

        for (int i = 0; i < Config.GAMES_ITERATION; i++) {

            gameUI.printInsertInputMessage();
            var userInput = inputSystem.getUserInput();
            gameUI.printDrawnNumber();
            var generatedNumber = numberGenerator.drawRandomNumber();

            scoreSystem.addBasicScore(userInput, generatedNumber, gameState);
            scoreSystem.addBonusScore(gameState);
        }
    }
}
