package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");
        scanner.close();
    }
}
