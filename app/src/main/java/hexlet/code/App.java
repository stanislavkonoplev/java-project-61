package hexlet.code;

import hexlet.code.games.*;
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

        switch (choice) {
            case "1" -> Engine.greet();
            case "2" -> Even.gameEven();
            case "3" -> Calc.gameCalc();
            case "4" -> GCD.gameGCD();
            case "5" -> Progression.gameProgression();
            case "6" -> Prime.gamePrime();
            case "0" -> scanner.close();
            default -> {
            }
        }

    }
}
