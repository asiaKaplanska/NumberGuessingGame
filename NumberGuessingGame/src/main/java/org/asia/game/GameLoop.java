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
        gameUI.printDottedLine();
        gameUI.printEmptyRow();
        gameUI.printInsertUserNameMessage();
        gameState.setUserName(inputSystem.getUserName());
        gameUI.printGreetingUserMessage(gameState);
    }

    public void playGame() {

        for (int i = 0; i < Config.GAMES_ITERATION; i++) {

            gameUI.printRoundMessage(i + 1);
            gameUI.printInsertInputMessage();
            var userInput = inputSystem.getUserInput();
            var generatedNumber = numberGenerator.drawRandomNumber();
            gameUI.printDrawnNumber(generatedNumber);
            gameUI.printEmptyRow();

            scoreSystem.addBasicScore(userInput, generatedNumber, gameState);
            scoreSystem.addBonusScore(gameState);
        }

        gameUI.printDottedLine();
    }

    public void playSummary() {

        gameUI.printEmptyRow();
        gameUI.printCollectedPointsMessage(gameState.getUserName(), gameState.getUserScore());
    }
}
