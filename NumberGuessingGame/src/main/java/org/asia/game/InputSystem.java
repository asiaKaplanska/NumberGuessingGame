package org.asia.game;

import java.util.Scanner;

public final class InputSystem {

    private static InputSystem instance;
    private Scanner scanner = new Scanner(System.in);
    private GameUI gameUI = new GameUI();

    private InputSystem() {
    }

    public static InputSystem getInstance() {

        if (instance == null) {
            instance = new InputSystem();
        }
        return instance;
    }

    public int getUserInput() {

        boolean flag;
        String userInputAsString;
        var userInputAsInteger = 0;

        do {
            userInputAsString = scanner.next();
            try {
                userInputAsInteger = Integer.parseInt(userInputAsString);
                flag = false;
            } catch (NumberFormatException nfe) {
                gameUI.printOnlyNumbersMessage();
                flag = true;
            }
        } while (flag);

       return userInputAsInteger;
    }


    public String getUserName() {

        return scanner.nextLine();
    }

}
