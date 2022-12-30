package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {

    public static void gameProgression() {
        var gamer = Engine.greet();
        var questionsAndAnswers = new String[2][Engine.WIN_ROUNDS_COUNT];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            final int minProgLength = 5;
            final int maxProgLength = 10;
            final int maxStep = 5;
            final int maxStartNumber = 20;
            var startNumber = Utils.getRandom(1, maxStartNumber);
            var progLength = Utils.getRandom(minProgLength, maxProgLength);
            var step = Utils.getRandom(2, maxStep);
            var questionPosition = Utils.getRandom(0, progLength - 1);
            var progressionItems = getProgression(startNumber, step, progLength);

            questionsAndAnswers[1][i] = progressionItems[questionPosition];
            progressionItems[questionPosition] = "..";
            questionsAndAnswers[0][i] = String.join(" ", progressionItems);
        }

        System.out.println("What number is missing in the progression?");
        Engine.game(questionsAndAnswers, gamer);
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


