package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static void gameEven() {
        var gamer = Engine.greet();
        final int maxNumber = 100;
        var questionsAndAnswers = new String[2][Engine.WIN_ROUNDS_COUNT];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var question = Engine.getRandom(1, maxNumber);
            String correctAnswer = question % 2 == 0 ? "yes" : "no";

            questionsAndAnswers[0][i] = String.valueOf(question);
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.game(questionsAndAnswers, gamer);
    }
}


