// class to take input

import java.util.Scanner;

public class Console {

    // object of scanner class for input
    private static Scanner input = new Scanner(System.in);

    // method overloading
    public static double readNumber(String prompt) {
        System.out.print(prompt + ": ");
        return input.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {

        // declaring variable to keep input
        Double value;

        // validating the input
        while (true) {
            System.out.print(prompt + ": ");
            value = input.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Insert a value between " + min + " and " + max);
        }
        return value;
    }
}
