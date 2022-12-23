package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    public static void gameCalc() {
        var gamer = Engine.greet();
        String operator = "";
        final int maxNumber = 100;
        final int operatorsCount = 3;
        var winRoundsCount = Engine.getWinRoundsCount();
        var questionsAndAnswers = new String[2][winRoundsCount];

        for (var i = 0; i < winRoundsCount; i++) {
            var firstNumber = Engine.getRandom(1, maxNumber);
            var secondNumber = Engine.getRandom(1, maxNumber);

            var operatorNumber = Engine.getRandom(1, operatorsCount);
            if (operatorNumber == 1) {
                operator = "+";
            }
            if (operatorNumber == 2) {
                operator = "-";
            }
            if (operatorNumber == operatorsCount) {
                operator = "*";
            }

            String question = firstNumber + " " + operator + " " + secondNumber;

            questionsAndAnswers[0][i] = question;
            questionsAndAnswers[1][i] = String.valueOf(calculate(firstNumber, secondNumber, operator));
        }

        System.out.println("What is the result of the expression?");
        Engine.game(questionsAndAnswers, gamer);
    }

    private static int calculate(int number1, int number2, String operator) {

        if (operator.equals("+")) {
            number1 = number1 + number2;
        }
        if (operator.equals("-")) {
            number1 = number1 - number2;
        }
        if (operator.equals("*")) {
            number1 = number1 * number2;
        }

        return number1;
    }
}

