package org.game;

import static org.game.CodeValidator.isValidCode;

public class Main {
    public static void main(String[] args) {
        String secretCode = null;
        if (args.length == 2 && args[0].equals("-c")) {
            if (isValidCode(args[1])) {
                secretCode = args[1];
            } else {
                System.err.println("Invalid code, please input a 4 digit code.");
                System.exit(1);
            }
        }

        System.out.println("Will you find the secret code?");
        GameLoop gameLoop = new GameLoop(secretCode);
        System.exit(0);
    }
}