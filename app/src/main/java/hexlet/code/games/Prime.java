package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.ArrayUtils;

public class Prime {

    public static void gamePrime() {
        var gamer = Engine.greet();
        var winRoundsCount = Engine.getWinRoundsCount();
        var questionsAndAnswers = new String[2][winRoundsCount];

        String listOfPrimeNumbers = "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101";
        var primeNumbers = Engine.getNumbers(listOfPrimeNumbers);
        var numbersCount = primeNumbers.length;

        for (var i = 0; i < winRoundsCount; i++) {
            var questionPosition = Engine.getRandom(1, numbersCount);
            var question = primeNumbers[questionPosition - 1];
            String correctAnswer = ArrayUtils.contains(primeNumbers, question) ? "yes" : "no";

            questionsAndAnswers[0][i] = String.valueOf(question);
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Engine.game(questionsAndAnswers, gamer);
    }
}


