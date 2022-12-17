package hexlet.code.games;

import hexlet.code.Engine;
import java.util.StringJoiner;

public class Progression {

    public static void gameProgression() {
        var gamer = Engine.greet();
        int winCount = 3;
        var data = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var length  = Engine.random(5, 10);
            var position = Engine.random(1, length);
            var step = Engine.random(2, 5);
            var startNumber = Engine.random(1, 20);
            var correctAnswer = startNumber;
            var progressionItems = new StringJoiner(" ");

            for (var j = 1; j <= length; j++) {
                if (j == position) {
                    progressionItems.add("..");
                    correctAnswer = startNumber;
                } else {
                    progressionItems.add(String.valueOf(startNumber));
                }
                startNumber = startNumber + step;
            }

            data[0][i] = String.valueOf(progressionItems);
            data[1][i] = String.valueOf(correctAnswer);
        }

        System.out.println("What number is missing in the progression?");
        Engine.game(data, gamer);
    }
}


