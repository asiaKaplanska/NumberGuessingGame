package org.asia.game;

import java.util.Scanner;

public final class InputSystem {

    private static InputSystem instance;
    private Scanner s = new Scanner(System.in);

    private InputSystem() {
    }

    public static InputSystem getInstance() {

        if (instance == null) {
            instance = new InputSystem();
        }
        return instance;
    }

    public int getUserInput() {

        return Integer.parseInt(s.nextLine());
    }

    // ToDo: walidacja inputu, (w przyszłości rezszerzenie metody o podanie np imienia >>>> metoda generyczna???
}
