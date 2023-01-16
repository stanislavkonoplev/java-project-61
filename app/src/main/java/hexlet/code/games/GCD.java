package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    private static final int MAX_NUMBER = 100;
    private static final String EXERCISE =  "Find the greatest common divisor of given numbers.";

    public static void gameGCD() {
        var questionsAndAnswers = new String[Engine.WIN_ROUNDS_COUNT][2];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var firstNumber = Utils.getRandom(1, MAX_NUMBER);
            var secondNumber = Utils.getRandom(1, MAX_NUMBER);

            String question = firstNumber + " " + secondNumber;
            String correctAnswer = String.valueOf(getGCD(firstNumber, secondNumber));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.game(questionsAndAnswers, EXERCISE);
    }

    private static int getGCD(int firstNumber, int secondNumber) {

        while (firstNumber != 0 && secondNumber != 0) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber % secondNumber;
            } else {
                secondNumber = secondNumber % firstNumber;
            }
        }

        return firstNumber + secondNumber;
    }
}
