package hexlet.code.games;

import hexlet.code.Engine;
import java.util.StringJoiner;

public class Progression {

    public static void gameProgression() {
        var gamer = Engine.greet();
        final int winRoundsCount = 3;
        final int minProgLength = 5;
        final int maxProgLength = 10;
        final int maxStep = 5;
        final int maxStartNumber = 20;
        var questionsAndAnswers = new String[2][winRoundsCount];

        for (var i = 0; i < winRoundsCount; i++) {
            var progLength  = Engine.getRandom(minProgLength, maxProgLength);
            var questionPosition = Engine.getRandom(1, progLength);
            var step = Engine.getRandom(2, maxStep);
            var startNumber = Engine.getRandom(1, maxStartNumber);
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


