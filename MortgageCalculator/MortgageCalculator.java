// make a mortgage calculator which takes three inputs principal, annual interest rate and period (in years) and prints the monthly payment the user has to give

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        // object of scanner class for input
        Scanner input = new Scanner(System.in);

        System.out.print("Principal: ");
        // taking input from user
        float principal = input.nextFloat();

        // validating principal amount
        while (principal < 1000 || principal > 1000000) {
            System.out.println("Enter a number between 1,000 and 1,000,000");
            System.out.print("Principal: ");
            principal = input.nextFloat();
        }

        // using nextLine method to read further inputs
        input.nextLine();

        System.out.print("Annual Interest Rate(%): ");
        // taking input from user
        float interestRate = input.nextFloat();

        // validating interestRate amount
        while (interestRate < 1 || interestRate >= 30) {
            System.out.println("Enter a value between 1 to 30");
            System.out.print("Annual Interest Rate(%): ");
            interestRate = input.nextFloat();
        }

        // monthly interest
        // dividing by 100 because input is given in percentage
        interestRate = (interestRate / 100) / 12;

        System.out.print("Period (Years): ");
        // taking input from user
        int period = input.nextInt();

        // validating interestRate amount
        while (period < 1 || period > 30) {
            System.out.println("Enter a value between 1 to 30");
            System.out.print("Period (Years): ");
            interestRate = input.nextFloat();
        }

        // finding the number of times the amount is given to pay debt
        period = period * 12;

        // System.out.println(Math.pow(2, 3));

        // mortgage formula:
        // M = p*r*(1+r)^n / (a+r)^n - 1

        // p*r*(1+r)^n
        float mortgage = principal * interestRate * (float) Math.pow((1 + interestRate), period);

        // (a+r)^n - 1
        mortgage = mortgage / ((float) Math.pow((1 + interestRate), period) - 1);

        // getting currency instance
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // string representation of the result in a currency format
        String result = currency.format(mortgage);

        System.out.println("Mortgage: " + result);
    }
}
