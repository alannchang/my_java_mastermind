package org.game;

public class CodeValidator {
    private static boolean isNumeric(String str){
        return str.matches("\\d+");
    }

    public static boolean isValidCode(String code){
        // check length and check if all;
        if (code.length() != 4 || !isNumeric(code)) {
            return false;
        }
        return true;
    }
}
