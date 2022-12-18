package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    public static void gameGCD() {
        var gamer = Engine.greet();
        int winCount = 3;
        var questionsAndAnswers = new String[2][winCount];
        String listOfPrimeMultipliers = "2 3 5 7";
        var primeMultipliers = Engine.getNumbers(listOfPrimeMultipliers);

        for (var i = 0; i < winCount; i++) {
            var firstNumber = Engine.getRandom(1, 10) * primeMultipliers[Engine.getRandom(0, 3)] * 2;
            var secondNumber = Engine.getRandom(1, 10) * primeMultipliers[Engine.getRandom(0, 3)] * 2;

            String question = firstNumber + " " + secondNumber;
            String correctAnswer = String.valueOf(getGCD(firstNumber, secondNumber));

            questionsAndAnswers[0][i] = question;
            questionsAndAnswers[1][i] = correctAnswer;
        }

        System.out.println("Find the greatest common divisor of given numbers.");
        Engine.game(questionsAndAnswers, gamer);
    }

    private static int[] factorize(int number) {
        var enoughPrimeMultipliersCount = 4;
        var multipliersDegrees = new int[enoughPrimeMultipliersCount];

        String listOfPrimeMultipliers = "2 3 5 7";
        var primeMultipliers = Engine.getNumbers(listOfPrimeMultipliers);

        for (var i = 0; i < enoughPrimeMultipliersCount; i++) {
            var data = getNextNumAndMultiplierDegree(number, primeMultipliers[i]);
            number = data[0];
            multipliersDegrees[i] = data[1];
        }

        return multipliersDegrees;
    }

    private static int[] getNextNumAndMultiplierDegree(int number, int primeMultiplier) {
        var maxDegreeOfPrimeMultiplier = 6;
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

    private static int getGCD(int firstNumber, int secondNumber) {
        var firstDegrees = factorize(firstNumber);
        var secondDegrees = factorize(secondNumber);
        String listOfPrimeMultipliers = "2 3 5 7";
        var primeMultipliers = Engine.getNumbers(listOfPrimeMultipliers);
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
