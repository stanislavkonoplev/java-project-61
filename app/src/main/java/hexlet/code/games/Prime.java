package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.ArrayUtils;

public class Prime {

    public static void gamePrime() {
        var gamer = Engine.greet();
        int winCount = 3;
        var data = new String[2][winCount];

        String listOfPrimeNumbers = "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101";
        String[] primeNumbersString = listOfPrimeNumbers.split(" ");
        var length = primeNumbersString.length;
        var primeNumbers = new int[length];

        for (var j = 0; j < length; j++) {
            primeNumbers[j] = Integer.parseInt(primeNumbersString[j]);
        }

        for (var i = 0; i < winCount; i++) {
            var position = Engine.random(1, length);
            var question = primeNumbers[position - 1];
            String correctAnswer = ArrayUtils.contains(primeNumbers, question) ? "yes" : "no";

            data[0][i] = String.valueOf(question);
            data[1][i] = correctAnswer;
        }

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Engine.game(data, gamer);
    }
}


