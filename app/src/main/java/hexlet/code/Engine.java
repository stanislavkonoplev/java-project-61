package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

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

    public static int[] getNumbers(String listOfNumbers) {
        String[] numbersString = listOfNumbers.split(" ");
        var numbersCount = numbersString.length;
        var numbers = new int[numbersCount];

        for (var j = 0; j < numbersCount; j++) {
            numbers[j] = Integer.parseInt(numbersString[j]);
        }

        return numbers;
    }

    public static void game(String[][] questionsAndAnswers, String playerName) {
        Scanner scanner = new Scanner(System.in);
        final int winCount = 3;

        var i = 0;
        while (i < winCount) {
            System.out.println("Question: " + questionsAndAnswers[0][i]);
            String answer = scanner.next();
            System.out.println("You answer: " + answer);
            if (answer.equals(questionsAndAnswers[1][i])) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[1][i] + "'.\nLet's try again, " + playerName + "!");
                break;
            }
            if (i == winCount) {
                System.out.println("Congratulations, " + playerName + "!");
            }
        }

        scanner.close();
    }
}
