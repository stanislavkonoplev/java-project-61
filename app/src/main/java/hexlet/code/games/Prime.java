package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    public static void gamePrime() {
        var gamer = Engine.greet();
        final int maxNumber = 100;
        var questionsAndAnswers = new String[2][Engine.WIN_ROUNDS_COUNT];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var question = Utils.getRandom(1, maxNumber);
            String correctAnswer = isPrime(question) ? "yes" : "no";

            questionsAndAnswers[0][i] = String.valueOf(question);
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Engine.game(questionsAndAnswers, gamer);
    }

    private static boolean isPrime(int number) {

        for (var delimiter = 2; delimiter <= number / 2; delimiter++) {
            if (number % delimiter == 0) {
                return false;
            }
        }

        return true;
    }
}


