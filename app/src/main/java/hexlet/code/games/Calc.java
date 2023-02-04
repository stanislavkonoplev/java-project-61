package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {

    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int MAX_NUMBER = 100;
    private static final String EXERCISE =  "What is the result of the expression?";

    public static void playCalc() {
        var operatorsCount = OPERATORS.length;
        var questionsAndAnswers = new String[Engine.WIN_ROUNDS_COUNT][2];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var firstNumber = Utils.getRandom(1, MAX_NUMBER);
            var secondNumber = Utils.getRandom(1, MAX_NUMBER);
            var operator = OPERATORS[Utils.getRandom(0, operatorsCount - 1)];

            String question = firstNumber + " " + operator + " " + secondNumber;

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = String.valueOf(calculate(firstNumber, secondNumber, operator));
        }

        Engine.game(questionsAndAnswers, EXERCISE);
    }

    private static int calculate(int number1, int number2, String operator) {
        return switch (operator) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            default -> throw new Error("Unknown operator: " + operator);
        };
    }
}

