package org.asia.game;

public class GameLoop {

    private GameState gameState;

    private GameUI gameUI = new GameUI();
    private InputSystem inputSystem = InputSystem.getInstance();
    private NumberGenerator numberGenerator = new NumberGenerator();
    private ScoreSystem scoreSystem = new ScoreSystem();



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
            var generatedNumber = numberGenerator.drawRandomNumber();
            gameUI.printDrawnNumber(generatedNumber);

            scoreSystem.addBasicScore(userInput, generatedNumber, gameState);
            scoreSystem.addBonusScore(gameState);
        }
    }

    public void playSummary() {

        gameUI.printCollectedPointsMessage(gameState.getUserScore());
    }
}
