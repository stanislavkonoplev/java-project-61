package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    public static void gameCalc() {
        var gamer = Engine.greet();
        String operator = "";
        String correctAnswer = "";
        int winCount = 3;
        var data = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var a = Engine.random(1, 20);
            var b = Engine.random(1, 20);
            var operatorNumber = Engine.random(1, 3);
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

            data[0][i] = question;
            data[1][i] = correctAnswer;
        }

        System.out.println("What is the result of the expression?");
        Engine.game(data, gamer);
    }
}
