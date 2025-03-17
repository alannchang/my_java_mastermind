package org.game;

import java.util.Random;
import java.util.Scanner;

import static org.game.CodeValidator.isValidCode;

public class GameLoop {
    String secretCode = "";
    Random rand = new Random();
    int roundNumber = 0;
    int maxAttempts = 10;
    int wellPlacedPieces;
    int misplacedPieces;

    public GameLoop(String userProvidedSecret, int userDefinedAttempts){
        if (userProvidedSecret == null) {
            generateSecretCode();
        } else {
            secretCode = userProvidedSecret;
        }

        if (userDefinedAttempts != 0) {
            maxAttempts = userDefinedAttempts;
        }

        Scanner scan = new Scanner(System.in);

        while(roundNumber < maxAttempts){
            System.out.printf("---\nRound %d\n>", roundNumber);
            String playerGuess = scan.nextLine();
            if (!isValidCode(playerGuess)) {
                System.out.println("Wrong input! Try again!");
                continue;
            }
            if (playerGuess.equals(secretCode)) {
                break;
            }
            System.out.printf("Well placed pieces: %d\n", wellPlacedPieces);
            System.out.printf("Misplaced pieces: %d\n", misplacedPieces);
            roundNumber++;
        }

        if (roundNumber >= maxAttempts) {
            System.out.printf("The secret code is %s\n", secretCode);
            System.out.println("You lose! Try again!");
        } else {
            System.out.println("Congrats! You did it!");
        }
    }

    void generateSecretCode() {
        for (int i = 0; i < 4; i++) {
            int randomInt = rand.nextInt(8);
            secretCode += String.valueOf(randomInt);
        }
    }

}
