package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    public static void gameGCD() {
        var gamer = Engine.greet();
        final int maxNumber = 100;
        var questionsAndAnswers = new String[2][Engine.WIN_ROUNDS_COUNT];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var firstNumber = Utils.getRandom(1, maxNumber);
            var secondNumber = Utils.getRandom(1, maxNumber);

            String question = firstNumber + " " + secondNumber;
            String correctAnswer = String.valueOf(getGCD(firstNumber, secondNumber));

            questionsAndAnswers[0][i] = question;
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Find the greatest common divisor of given numbers.");
        Engine.game(questionsAndAnswers, gamer);
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
