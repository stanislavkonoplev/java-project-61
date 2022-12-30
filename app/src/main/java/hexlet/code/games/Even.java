package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    public static void gameEven() {
        var gamer = Engine.greet();
        final int maxNumber = 100;
        var questionsAndAnswers = new String[2][Engine.WIN_ROUNDS_COUNT];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var question = Utils.getRandom(1, maxNumber);
            String correctAnswer = isEven(question) ? "yes" : "no";

            questionsAndAnswers[0][i] = String.valueOf(question);
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.game(questionsAndAnswers, gamer);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}


