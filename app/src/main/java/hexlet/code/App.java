package hexlet.code;

import hexlet.code.games.Progression;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""");

        String choice = scanner.next();

        final String greet = "1";
        final String even = "2";
        final String calc = "3";
        final String gcd = "4";
        final String prog = "5";
        final String prime = "6";
        final String exit = "0";

        switch (choice) {
            case greet -> Cli.greet();
            case even -> Even.gameEven();
            case calc -> Calc.gameCalc();
            case gcd -> GCD.gameGCD();
            case prog -> Progression.gameProgression();
            case prime -> Prime.gamePrime();
            case exit -> scanner.close();
            default -> throw new Error("Unknown command: " + choice);
        }

    }
}
