package org.game;

import java.util.HashMap;
import java.util.Map;

public class CodeValidator {
    public static boolean isNumeric(String str){
        return str.matches("\\d+");
    }

    public static boolean isPositiveInteger(String str) {
        return str.matches("[1-9]\\d*");
    }

    public static boolean isValidCode(String code){
        return code.length() == 4 && isNumeric(code) && !code.contains("9");
    }

    public static int[] checkMatches(String secret, String guess) {
        if (secret.length() != guess.length()) {
            throw new IllegalArgumentException("Both strings must be of the same length.");
        }

        int wellPlacedPieces = 0;
        int misPlacedPieces = 0;
        Map<Character, Integer> secretFreq = new HashMap<>();
        Map<Character, Integer> guessFreq = new HashMap<>();

        // First pass: Count exact matches and collect frequencies of non-matching digits
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                wellPlacedPieces++;
            } else {
                secretFreq.put(secret.charAt(i), secretFreq.getOrDefault(secret.charAt(i), 0) + 1);
                guessFreq.put(guess.charAt(i), guessFreq.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }

        // Second pass: Count partial matches
        for (Map.Entry<Character, Integer> entry : guessFreq.entrySet()) {
            char digit = entry.getKey();
            if (secretFreq.containsKey(digit)) {
                misPlacedPieces += Math.min(secretFreq.get(digit), entry.getValue());
            }
        }

        return new int[]{wellPlacedPieces, misPlacedPieces};
    }
}
