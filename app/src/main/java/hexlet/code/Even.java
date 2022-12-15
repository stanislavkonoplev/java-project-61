package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {

    public static void isEven() {
        Scanner scanner = new Scanner(System.in);
        var name = Greet.userName();

        int min = 1;
        int max = 100;
        int diff = max - min;
        Random random = new Random();

        final var winCount = 3;
        var i = 1;
        while (i <= winCount) {
            var number = random.nextInt(diff + 1) + min;
            System.out.print("Answer 'yes' if the number is even, "
                    + "otherwise answer 'no'.\nQuestion: " + number + "\n");
            String answer = scanner.next();
            String oppositeAnswer = answer.equals("yes") ? "no" : "yes";
            System.out.println("You answer: " + answer);
            if ((number % 2 == 0 && answer.equals("yes"))
                    || (number % 2 != 0 && answer.equals("no"))) {
                System.out.println("Correct!");
                i++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + oppositeAnswer + "'.\nLet's try again, " + name + "!");
                break;
            }
        }

        if (i > winCount) {
            System.out.println("Congratulations, " + name + "!");
        }
        scanner.close();
    }
}


