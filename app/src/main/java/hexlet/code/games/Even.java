package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    public static void isEven() {
        var gamer = Engine.greet();
        int winCount = 3;
        var data = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var question = Engine.random();
            String correctAnswer = question % 2 == 0 ? "yes" : "no";
            data[0][i] = Integer.toString(question);
            data[1][i] = correctAnswer;
        }

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.game(data, gamer);
    }
}


