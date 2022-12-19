package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    public static void gameCalc() {
        var gamer = Engine.greet();
        String operator = "";
        String correctAnswer = "";
        final int winRoundsCount = 3;
        final int maxNumber = 20;
        final int operatorsCount = 3;
        var questionsAndAnswers = new String[2][winRoundsCount];

        for (var i = 0; i < winRoundsCount; i++) {
            var a = Engine.getRandom(1, maxNumber);
            var b = Engine.getRandom(1, maxNumber);
            var operatorNumber = Engine.getRandom(1, operatorsCount);
            switch (operatorNumber) {
                case 1 -> {
                    operator = "+";
                    correctAnswer = String.valueOf(a + b);
                }
                case 2 -> {
                    operator = "-";
                    correctAnswer = String.valueOf(a - b);
                }
                case operatorsCount -> {
                    operator = "*";
                    correctAnswer = String.valueOf(a * b);
                }
                default -> {
                }
            }

            String question = a + " " + operator + " " + b;

            questionsAndAnswers[0][i] = question;
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("What is the result of the expression?");
        Engine.game(questionsAndAnswers, gamer);
    }
}
