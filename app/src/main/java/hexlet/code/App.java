package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit
                Your choice:\s""");
        String choice = scanner.next();
        switch (choice) {
            case "1" -> Engine.greet();
            case "2" -> Even.isEven();
            case "3" -> Calc.calculate();
            case "0" -> scanner.close();
            default -> {
            }
        }
    }
}
