package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static void gameEven() {
        var gamer = Engine.greet();
        int winCount = 3;
        var questionsAndAnswers = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var question = Engine.getRandom(1, 100);
            String correctAnswer = question % 2 == 0 ? "yes" : "no";

            questionsAndAnswers[0][i] = String.valueOf(question);
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.game(questionsAndAnswers, gamer);
    }
}


