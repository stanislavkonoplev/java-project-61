package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    public static void gameCalc() {
        var gamer = Engine.greet();
        String operator = "";
        String correctAnswer = "";
        final int winCount = 3;
        final int maxRandomNumber = 20;
        final int maxRandomNumber2 = 3;
        var questionsAndAnswers = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var a = Engine.getRandom(1, maxRandomNumber);
            var b = Engine.getRandom(1, maxRandomNumber);
            var operatorNumber = Engine.getRandom(1, maxRandomNumber2);
            switch (operatorNumber) {
                case 1 -> {
                    operator = "+";
                    correctAnswer = String.valueOf(a + b);
                }
                case 2 -> {
                    operator = "-";
                    correctAnswer = String.valueOf(a - b);
                }
                case maxRandomNumber2 -> {
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
