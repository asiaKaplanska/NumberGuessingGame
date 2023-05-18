package org.asia.game;

public class GameUI {

    private static final String INSERT_USER_INPUT = "Place to insert Your input >>> ";
    private static final String GAME_DESCRIPTION = """
            Welcome to the game!
            Here are the rules:
            The game generates a random number between 1 and %s that you have to guess. 
            They will get points if they guess correctly (5 points for each correct answer). 
            In addition, 2 wins in a row give you an additional 10 points, 3 wins in a row give you 100 points 
            and 4 correct answers give you 1000 extra points!
            Good luck :)
            """.formatted(Config.MAX_VALUE_DRAWING);
    private static final String INSERT_USER_NAME = "What's Your name?";
    private static final String DRAWN_NUMBER = "The number drawn is ... >>> ";
    private static final String POINTS = "Collected points >>>";

    public void printInsertInputMessage() {

        System.out.println(INSERT_USER_INPUT);
    }

    public void printGameDescriptionMessage() {

        System.out.println(GAME_DESCRIPTION);
    }

    public void printInsertUserNameMessage() {

        System.out.println(INSERT_USER_NAME);
    }

    public void printDrawnNumber(int number) {

        System.out.println(DRAWN_NUMBER + number);
    }

    public void printCollectedPointsMessage(int points) {

        System.out.println(POINTS + points);
    }
}
