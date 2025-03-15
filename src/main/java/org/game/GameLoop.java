package org.game;

import java.util.Random;
import java.util.Scanner;

import static org.game.CodeValidator.isValidCode;

public class GameLoop {
    String secretCode = "";
    Random rand = new Random();
    int round = 0;
    int wellPlacedPieces;
    int misplacedPieces;

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
            if (!isValidCode(playerGuess)) {
                System.out.println("Wrong input! Try again!");
                continue;
            }
            if (playerGuess.equals(secretCode)) {
                break;
            }
            System.out.printf("Well placed pieces: %d\n", wellPlacedPieces);
            System.out.printf("Misplaced pieces: %d\n", misplacedPieces);
            round++;
        }

        if (round > 9) {
            System.out.printf("The secret code is %s\n", secretCode);
            System.out.println("You lose! Try again!");
        } else {
            System.out.println("Congrats! You did it!");
        }



    }

    void generateSecretCode() {
        for (int i = 0; i < 4; i++) {
            int randomInt = rand.nextInt(9);
            secretCode += String.valueOf(randomInt);
        }
    }

}
