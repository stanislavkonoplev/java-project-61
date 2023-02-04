package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    private static final int MAX_NUMBER = 100;
    private static final String EXERCISE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void playPrime() {
        var questionsAndAnswers = new String[Engine.WIN_ROUNDS_COUNT][2];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var question = Utils.getRandom(1, MAX_NUMBER);
            String correctAnswer = isPrime(question) ? "yes" : "no";

            questionsAndAnswers[i][0] = String.valueOf(question);
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.game(questionsAndAnswers, EXERCISE);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (var delimiter = 2; delimiter <= number / 2; delimiter++) {
            if (number % delimiter == 0) {
                return false;
            }
        }

        return true;
    }
}


