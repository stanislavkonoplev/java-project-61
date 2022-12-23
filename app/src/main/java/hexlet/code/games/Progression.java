package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;


public class Progression {

    public static void gameProgression() {
        var gamer = Engine.greet();
        var winRoundsCount = Engine.getWinRoundsCount();
        var questionsAndAnswers = new String[2][winRoundsCount];


        for (var i = 0; i < winRoundsCount; i++) {
            var progressionItems = getProgression();
            var progLength = progressionItems.length;
            var questionPosition = Engine.getRandom(1, progLength);

            var questionProgression = Arrays.copyOf(progressionItems, questionPosition);
            questionProgression = ArrayUtils.add(questionProgression, "..");
            var questionProgEnd = Arrays.copyOfRange(progressionItems, questionPosition + 1, progLength);
            questionProgression = ArrayUtils.addAll(questionProgression, questionProgEnd);
            var question = String.join(" ", questionProgression);

            questionsAndAnswers[0][i] = question;
            questionsAndAnswers[1][i] = progressionItems[questionPosition];
        }

        System.out.println("What number is missing in the progression?");
        Engine.game(questionsAndAnswers, gamer);
    }

    private static String[] getProgression() {
        final int minProgLength = 5;
        final int maxProgLength = 10;
        final int maxStep = 5;
        final int maxStartNumber = 20;
        var startNumber = Engine.getRandom(1, maxStartNumber);
        var progLength  = Engine.getRandom(minProgLength, maxProgLength);
        var step = Engine.getRandom(2, maxStep);
        var progressionItems = new String[progLength];

        for (var j = 0; j < progLength; j++) {
            progressionItems[j] = String.valueOf(startNumber);
            startNumber = startNumber + step;
        }

        return progressionItems;
    }
}


