package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static String greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");

        return name;
    }

    public static int random() {
        int min = 1;
        int max = 100;
        int diff = max - min;
        Random seed = new Random();
        return seed.nextInt(diff + 1) + min;
    }

    public static void game(String[][] data, String name) {
        Scanner scanner = new Scanner(System.in);
        var winCount = 3;

        var i = 0;
        while (i < winCount) {
            System.out.println("Question: " + data[0][i]);
            String answer = scanner.next();
            System.out.println("You answer: " + answer);
            if (answer.equals(data[1][i])) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + data[1][i] + "'.\nLet's try again, " + name + "!");
                break;
            }
            if (i == winCount) {
                System.out.println("Congratulations, " + name + "!");
            }
        }

        scanner.close();
    }
}
