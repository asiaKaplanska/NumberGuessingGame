package org.asia.game;

public class GameUI {

    private static final String INSERT_USER_INPUT = ", enter the number of eggs >>> ";
    private static final String GAME_DESCRIPTION = """
            
            Welcome to the game!
            
            Here are the rules:
            The game generates a random number of eggs laid by the hen (from 1 to %s) that you have to guess.
            You get points if you correctly guess the number of eggs laid (5 points for each correct answer).
            In addition, 2 wins in a row give you an additional 10 points, 3 wins in a row give you 100 points
            and 4 correct answers give you 1000 extra points!
            
            Good luck :)
            """.formatted(Config.MAX_VALUE_DRAWING);
    private static final String INSERT_USER_NAME = "What's Your name? ";
    private static final String DRAWN_NUMBER = "The hen has laid %s eggs this round";
    private static final String POINTS = "Congratulations %s, you have scored %s points in this game!";
    private static final String GREETING_USER =
            "Hello %s! Guess how many eggs the hen has laid?";
    private static final String ROUND = "Round ";


    public void printInsertInputMessage() {

        System.out.print(INSERT_USER_INPUT);
    }

    public void printGameDescriptionMessage() {

        System.out.println(GAME_DESCRIPTION);
    }

    public void printInsertUserNameMessage() {

        System.out.println(INSERT_USER_NAME);
    }

    public void printDrawnNumber(int number) {

        System.out.println(DRAWN_NUMBER.formatted(number));
    }

    public void printCollectedPointsMessage(String userName, int points) {

        System.out.print(POINTS.formatted(userName, points));
    }

    public void printDottedLine() {

        System.out.println("* ".repeat(50));
    }

    public void printEmptyRow() {

        System.out.println();
    }

    public void printGreetingUserMessage(GameState gameState) {

        System.out.println(GREETING_USER.formatted(gameState.getUserName()));
    }

    public void printRoundMessage(int round) {

        System.out.print(ROUND + round);
    }

}
