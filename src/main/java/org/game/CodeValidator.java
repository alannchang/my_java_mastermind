package org.game;

public class CodeValidator {
    public static boolean isNumeric(String str){
        return str.matches("\\d+");
    }

    public static boolean isPositiveInteger(String str) {
        return str.matches("[1-9]\\d*");
    }

    public static boolean isValidCode(String code){
        // check length and check if all;
        if (code.length() != 4 || !isNumeric(code) || code.contains("9")) {
            return false;
        }
        return true;
    }
}
