package hexlet.code;

import java.util.Scanner;

public class Greet {

    public static String userName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");

        return name;
    }
}
