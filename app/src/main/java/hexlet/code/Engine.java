package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static final int WIN_ROUNDS_COUNT = 3;

    public static String greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");

        return playerName;
    }

    public static int getRandom(int min, int max) {
        int diff = max - min;
        Random seed = new Random();
        return seed.nextInt(diff + 1) + min;
    }

    public static void game(String[][] questionsAndAnswers, String playerName) {
        Scanner scanner = new Scanner(System.in);

        var i = 0;
        while (i < WIN_ROUNDS_COUNT) {
            System.out.println("Question: " + questionsAndAnswers[0][i]);
            String answer = scanner.next();
            System.out.println("You answer: " + answer);
            if (answer.equals(questionsAndAnswers[1][i])) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[1][i] + "'.\nLet's try again, " + playerName + "!");
                scanner.close();
                return;
            }
        }

        System.out.println("Congratulations, " + playerName + "!");
        scanner.close();
    }
}
