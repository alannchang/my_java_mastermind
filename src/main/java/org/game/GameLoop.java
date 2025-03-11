package org.game;

import java.util.Random;

public class GameLoop {
    int[] secretCode = new int[4];
    Random rand = new Random();

    public GameLoop(String userProvidedSecret){
        if (userProvidedSecret == null) {
            generateSecretCode();
        } else {
            for (int i = 0; i < secretCode.length; i++){
                secretCode[i] = Character.getNumericValue(userProvidedSecret.charAt(i));
            }
        }
        System.out.println("The secret code is ");
        for (int i = 0; i < secretCode.length; i++) {
            System.out.print(secretCode[i]);
        }
    }

    void generateSecretCode() {
        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = rand.nextInt(9);
        }
    }

}
