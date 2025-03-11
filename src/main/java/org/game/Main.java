package org.game;

public class Main {
    public static void main(String[] args) {
        String secretCode = null;
        if (args.length == 2 && args[0].equals("-c")) {
            secretCode = args[1];
        }

        System.out.println("Will you find the secret code?");
        GameLoop gameLoop = new GameLoop(secretCode);
    }
}