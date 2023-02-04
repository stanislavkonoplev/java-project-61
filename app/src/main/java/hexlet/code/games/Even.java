package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    private static final int MAX_NUMBER = 100;
    private static final String EXERCISE =  "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void playEven() {
        var questionsAndAnswers = new String[Engine.WIN_ROUNDS_COUNT][2];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var question = Utils.getRandom(1, MAX_NUMBER);
            String correctAnswer = isEven(question) ? "yes" : "no";

            questionsAndAnswers[i][0] = String.valueOf(question);
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.game(questionsAndAnswers, EXERCISE);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}


