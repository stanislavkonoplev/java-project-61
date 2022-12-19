package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    public static void gameGCD() {
        var gamer = Engine.greet();
        final int winCount = 3;
        final int maxRandomNumber = 10;
        final int maxRandomNumber2 = 3;
        var questionsAndAnswers = new String[2][winCount];
        String listOfPrimeMultipliers = "2 3 5 7 11";
        var primeMultipliers = Engine.getNumbers(listOfPrimeMultipliers);

        for (var i = 0; i < winCount; i++) {
            var firstNumber = Engine.getRandom(1, maxRandomNumber)
                    * primeMultipliers[Engine.getRandom(0, maxRandomNumber2)] * 2;
            var secondNumber = Engine.getRandom(1, maxRandomNumber)
                    * primeMultipliers[Engine.getRandom(0, maxRandomNumber2)] * 2;

            String question = firstNumber + " " + secondNumber;
            String correctAnswer = String.valueOf(getGCD(firstNumber, secondNumber, primeMultipliers));

            questionsAndAnswers[0][i] = question;
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Find the greatest common divisor of given numbers.");
        Engine.game(questionsAndAnswers, gamer);
    }

    private static int[] factorize(int number, int[] primeMultipliers) {
        var primeMultipliersCount = primeMultipliers.length;
        var multipliersDegrees = new int[primeMultipliersCount];

        for (var i = 0; i < primeMultipliersCount; i++) {
            var data = getNextNumAndMultiplierDegree(number, primeMultipliers[i]);
            number = data[0];
            multipliersDegrees[i] = data[1];
        }

        return multipliersDegrees;
    }

    private static int[] getNextNumAndMultiplierDegree(int number, int primeMultiplier) {
        final var maxDegreeOfPrimeMultiplier = 6;
        var nextNumAndMultiplierDegree = new int[2];

        var i = 0;
        while (i < maxDegreeOfPrimeMultiplier) {
            if (number % primeMultiplier == 0) {
                number = number / primeMultiplier;
                i++;
            } else {
                break;
            }
        }

        nextNumAndMultiplierDegree[0] = number;
        nextNumAndMultiplierDegree[1] = i;
        return nextNumAndMultiplierDegree;
    }

    private static int getGCD(int firstNumber, int secondNumber, int[] primeMultipliers) {
        var firstDegrees = factorize(firstNumber, primeMultipliers);
        var secondDegrees = factorize(secondNumber, primeMultipliers);
        int valueGCD = 1;
        var primeMultipliersCount = primeMultipliers.length;

        for (var i = 0; i < primeMultipliersCount; i++) {
            valueGCD = firstDegrees[i] < secondDegrees[i]
                    ? valueGCD * (int) Math.pow(primeMultipliers[i], firstDegrees[i])
                    : valueGCD * (int) Math.pow(primeMultipliers[i], secondDegrees[i]);
        }

        return valueGCD;
    }
}
