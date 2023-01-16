package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {

    private static final int MIN_PROG_LENGTH = 5;
    private static final int MAX_PROG_LENGTH = 10;
    private static final int MAX_STEP = 5;
    private static final int MAX_START_NUMBER = 20;
    private static final String EXERCISE = "What number is missing in the progression?";

    public static void gameProgression() {
        var questionsAndAnswers = new String[Engine.WIN_ROUNDS_COUNT][2];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var startNumber = Utils.getRandom(1, MAX_START_NUMBER);
            var progLength = Utils.getRandom(MIN_PROG_LENGTH, MAX_PROG_LENGTH);
            var step = Utils.getRandom(2, MAX_STEP);
            var questionPosition = Utils.getRandom(0, progLength - 1);
            var progressionItems = getProgression(startNumber, step, progLength);

            questionsAndAnswers[i][1] = progressionItems[questionPosition];
            progressionItems[questionPosition] = "..";
            questionsAndAnswers[i][0] = String.join(" ", progressionItems);
        }

        Engine.game(questionsAndAnswers, EXERCISE);
    }

    private static String[] getProgression(int startNumber, int step, int progLength) {
        var progressionItems = new String[progLength];

        for (var j = 0; j < progLength; j++) {
            progressionItems[j] = String.valueOf(startNumber);
            startNumber = startNumber + step;
        }

        return progressionItems;
    }
}


