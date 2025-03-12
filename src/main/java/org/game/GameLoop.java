package org.game;

import java.util.Random;
import java.util.Scanner;

public class GameLoop {
    int[] secretCode = new int[4];
    Random rand = new Random();
    int round = 0;

    public GameLoop(String userProvidedSecret){
        if (userProvidedSecret == null) {
            generateSecretCode();
        } else {
            for (int i = 0; i < secretCode.length; i++){
                secretCode[i] = Character.getNumericValue(userProvidedSecret.charAt(i));
            }
        }
        Scanner scn = new Scanner(System.in);

        while(round < 10){
            System.out.printf("---\nRound %d\n>", round);
            String playerGuess = scn.nextLine();
            System.out.println("Well placed pieces: ");
            System.out.println("Misplaced pieces: ");
            round++;
        }
        if (round > 9) {
            System.out.println("The secret code is ");
            for (int j : secretCode) {
                System.out.print(j);
            }
            System.out.print("\nYou lose! Try again!\n");
        }

    }

    void generateSecretCode() {
        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = rand.nextInt(9);
        }
    }

}
