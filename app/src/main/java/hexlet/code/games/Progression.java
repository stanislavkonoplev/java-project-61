package hexlet.code.games;

import hexlet.code.Engine;
import java.util.StringJoiner;

public class Progression {

    public static void gameProgression() {
        var gamer = Engine.greet();
        final int winCount = 3;
        final int minRandomLength = 5;
        final int maxRandomLength = 10;
        final int maxRandomStep = 5;
        final int maxRandomStartNumber = 20;
        var questionsAndAnswers = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var progLength  = Engine.getRandom(minRandomLength, maxRandomLength);
            var questionPosition = Engine.getRandom(1, progLength);
            var step = Engine.getRandom(2, maxRandomStep);
            var startNumber = Engine.getRandom(1, maxRandomStartNumber);
            var correctAnswer = startNumber;
            var progressionItems = new StringJoiner(" ");

            for (var j = 1; j <= progLength; j++) {
                if (j == questionPosition) {
                    progressionItems.add("..");
                    correctAnswer = startNumber;
                } else {
                    progressionItems.add(String.valueOf(startNumber));
                }
                startNumber = startNumber + step;
            }

            questionsAndAnswers[0][i] = String.valueOf(progressionItems);
            questionsAndAnswers[1][i] = String.valueOf(correctAnswer);
        }

        System.out.println("What number is missing in the progression?");
        Engine.game(questionsAndAnswers, gamer);
    }
}


