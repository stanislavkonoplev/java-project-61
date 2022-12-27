package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    public static void gameCalc() {
        var gamer = Engine.greet();
        final int maxNumber = 100;
        final int operatorsCount = 3;
        final int summarizeNumber = 1;
        final int substractionNumber = 2;
        final int multiplyNumber = 3;
        var questionsAndAnswers = new String[2][Engine.WIN_ROUNDS_COUNT];

        for (var i = 0; i < Engine.WIN_ROUNDS_COUNT; i++) {
            var firstNumber = Engine.getRandom(1, maxNumber);
            var secondNumber = Engine.getRandom(1, maxNumber);
            var operatorNumber = Engine.getRandom(1, operatorsCount);

            var operator = switch (operatorNumber) {
                case summarizeNumber -> "+";
                case substractionNumber -> "-";
                case multiplyNumber -> "*";
                default -> "";
            };

            String question = firstNumber + " " + operator + " " + secondNumber;

            questionsAndAnswers[0][i] = question;
            questionsAndAnswers[1][i] = String.valueOf(calculate(firstNumber, secondNumber, operator));
        }

        System.out.println("What is the result of the expression?");
        Engine.game(questionsAndAnswers, gamer);
    }

    private static int calculate(int number1, int number2, String operator) {

        number1 = switch (operator) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            default -> number1;
        };

        return number1;
    }
}

