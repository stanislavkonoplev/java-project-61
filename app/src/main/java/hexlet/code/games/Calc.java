package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    public static void gameCalc() {
        var gamer = Engine.greet();
        String operator = "";
        String correctAnswer = "";
        int winCount = 3;
        var questionsAndAnswers = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var a = Engine.getRandom(1, 20);
            var b = Engine.getRandom(1, 20);
            var operatorNumber = Engine.getRandom(1, 3);
            switch (operatorNumber) {
                case 1 -> {
                    operator = "+";
                    correctAnswer = String.valueOf(a + b);
                }
                case 2 -> {
                    operator = "-";
                    correctAnswer = String.valueOf(a - b);
                }
                case 3 -> {
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
