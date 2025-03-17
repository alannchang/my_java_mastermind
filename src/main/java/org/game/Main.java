package org.game;

import org.apache.commons.cli.*;
import org.apache.commons.cli.ParseException;

import static org.game.CodeValidator.isValidCode;
import static org.game.CodeValidator.isPositiveInteger;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        String secretCode = null;
        int attempts = 0;
        options.addOption("c", "code", true, "user specified code");
        options.addOption("t", "roundNumber", true, "user specified number of roundNumber");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("c")) {
                String userDefinedCode = cmd.getOptionValue("c");
                if (isValidCode(userDefinedCode)) {
                    secretCode = userDefinedCode;
                } else {
                    System.out.println("Invalid code, please try again.");
                    System.exit(0);
                }
            }

            if (cmd.hasOption("t")) {
                if (isPositiveInteger(cmd.getOptionValue("t"))) {
                    attempts = Integer.parseInt(cmd.getOptionValue("t"));
                } else {
                    System.out.println("Invalid number of attempts, please try again.");
                }
            }
        } catch (ParseException e){
            System.out.println("Error: " + e.getMessage());
            printHelp(options);
        }

        System.out.println("Will you find the secret code?");
        GameLoop gameLoop = new GameLoop(secretCode, attempts);
        System.exit(0);
    }

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("my_java_mastermind", options);
    }
}