package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {

    public static void calculate() {
        var gamer = Engine.greet();
        String operator = "";
        String correctAnswer = "";
        int winCount = 3;
        var data = new String[2][winCount];
        int min = 1;
        int max = 3;
        int diff = max - min;
        Random seed = new Random();

        for (var i = 0; i < winCount; i++) {
            var a = Engine.random();
            var b = Engine.random();
            var operatorNumber = seed.nextInt(diff + 1) + min;
            switch (operatorNumber) {
                case 1 -> {
                    operator = "+";
                    correctAnswer = Integer.toString(a + b);
                }
                case 2 -> {
                    operator = "-";
                    correctAnswer = Integer.toString(a - b);
                }
                case 3 -> {
                    operator = "*";
                    correctAnswer = Integer.toString(a * b);
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
