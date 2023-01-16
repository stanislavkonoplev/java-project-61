package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int WIN_ROUNDS_COUNT = 3;

    public static void game(String[][] questionsAndAnswers, String exercise) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");

        if (exercise.equals("greet")) {
            scanner.close();
            return;
        }

        System.out.println(exercise);

        var i = 0;
        while (i < WIN_ROUNDS_COUNT) {
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            String answer = scanner.next();
            System.out.println("You answer: " + answer);
            if (answer.equals(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1] + "'.\nLet's try again, " + playerName + "!");
                scanner.close();
                return;
            }
        }

        System.out.println("Congratulations, " + playerName + "!");
        scanner.close();
    }
}
