package org.game;

import java.util.Random;
import java.util.Scanner;

public class GameLoop {
    String secretCode = "";
    Random rand = new Random();
    int round = 0;

    public GameLoop(String userProvidedSecret){
        if (userProvidedSecret == null) {
            generateSecretCode();
        } else {
            secretCode = userProvidedSecret;
        }
        Scanner scn = new Scanner(System.in);

        while(round < 10){
            System.out.printf("---\nRound %d\n>", round);
            String playerGuess = scn.nextLine();
            if (playerGuess.equals(secretCode)) {
                break;
            }
            System.out.println("Well placed pieces: ");
            System.out.println("Misplaced pieces: ");
            round++;
        }
        if (round > 9) {
            System.out.printf("The secret code is %s\n", secretCode);
            System.out.println("You lose! Try again!");
        }

    }

    void generateSecretCode() {
        for (int i = 0; i < 4; i++) {
            int randomInt = rand.nextInt(9);
            secretCode += String.valueOf(randomInt);
        }
    }

}
