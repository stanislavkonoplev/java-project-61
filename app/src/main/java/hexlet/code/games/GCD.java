package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

    public static void gameGCD() {
        var gamer = Engine.greet();
        int winCount = 3;
        var data = new String[2][winCount];

        for (var i = 0; i < winCount; i++) {
            var firstNumber = Engine.random(1, 100);
            var secondNumber = Engine.random(1, 20);
            var degrees = factorization(firstNumber);
            for (var j = 3; j >= 0; j--) {
                if (j == 3 && degrees[j] != 0) {
                    secondNumber = secondNumber * 7;
                    break;
                }
                if (j == 2 && degrees[j] != 0) {
                    secondNumber = secondNumber * 5;
                    break;
                }
                if (j == 1 && degrees[j] != 0) {
                    secondNumber = secondNumber * 3;
                    break;
                }
                if (j == 0 && degrees[j] != 0) {
                    secondNumber = secondNumber * 2;
                    break;
                }
            }

            String question = firstNumber + " " + secondNumber;
            String correctAnswer = String.valueOf(findGCD(firstNumber, secondNumber));

            data[0][i] = question;
            data[1][i] = correctAnswer;
        }

        System.out.println("Find the greatest common divisor of given numbers.");
        Engine.game(data, gamer);
    }

    private static int[] factorization(int number) {
        var m = number;
        var multiplierDegrees = new int[4];
        var i = 0;
        var j = 0;
        var k = 0;
        var l = 0;

        while (i < 6) {
            if (m % 2 == 0) {
                m = m / 2;
                i++;
            } else {
                break;
            }
        }
        multiplierDegrees[0] = i;

        while (j < 4) {
            if (m % 3 == 0) {
                m = m / 3;
                j++;
            } else {
                break;
            }
        }
        multiplierDegrees[1] = j;

        while (k < 2) {
            if (m % 5 == 0) {
                m = m / 5;
                k++;
            } else {
                break;
            }
        }
        multiplierDegrees[2] = k;

        while (l < 2) {
            if (m % 7 == 0) {
                m = m / 7;
                l++;
            } else {
                break;
            }
        }
        multiplierDegrees[3] = l;

        return multiplierDegrees;
    }

    private static int findGCD(int firstNumber, int secondNumber) {
        int[] firstDegrees = factorization(firstNumber);
        int[] secondDegrees = factorization(secondNumber);
        int valueGCD = 1;

        for (var i = 0; i < 4; i++) {
            if (i == 0 && firstDegrees[i] != 0 && secondDegrees[i] != 0) {
                valueGCD = firstDegrees[i] < secondDegrees[i] ? valueGCD * (int) Math.pow(2, firstDegrees[i])
                        : valueGCD * (int) Math.pow(2, secondDegrees[i]);
            }
            if (i == 1 && firstDegrees[i] != 0 && secondDegrees[i] != 0) {
                valueGCD = firstDegrees[i] < secondDegrees[i] ? valueGCD * (int) Math.pow(3, firstDegrees[i])
                        : valueGCD * (int) Math.pow(3, secondDegrees[i]);
            }
            if (i == 2 && firstDegrees[i] != 0 && secondDegrees[i] != 0) {
                valueGCD = firstDegrees[i] < secondDegrees[i] ? valueGCD * (int) Math.pow(5, firstDegrees[i])
                        : valueGCD * (int) Math.pow(5, secondDegrees[i]);
            }
            if (i == 3 && firstDegrees[i] != 0 && secondDegrees[i] != 0) {
                valueGCD = firstDegrees[i] < secondDegrees[i] ? valueGCD * (int) Math.pow(7, firstDegrees[i])
                        : valueGCD * (int) Math.pow(7, secondDegrees[i]);
            }
        }

        return valueGCD;
    }
}
