package hexlet.code;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the game number and "
               + "press Enter.\n1 - Greet\n2 - Even\n0 - Exit\nYour choice: ");
        String choice = scanner.next();
        switch (choice) {
            case "1":;
            case "2":
                Even.isEven();
                break;
            case "0":
                scanner.close();
                break;
            default:
                break;
        }
    }
}
