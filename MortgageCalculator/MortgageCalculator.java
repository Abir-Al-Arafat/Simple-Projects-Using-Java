// make a mortgage calculator which takes three inputs principal, annual interest rate and period (in years) and prints the monthly payment the user has to give

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {

        // getting principal amount
        int principal = (int) readNumber("Principal", 1000, 1_000_000);

        // getting annual interest rate
        float annualInterest = (float) readNumber("Annual Interest rate", 1, 30);

        // getting the number of years
        byte years = (byte) readNumber("Years", 1, 30);

        // System.out.println(Math.pow(2, 3));

        double mortgage = calculateMortgage(principal, annualInterest, years);

        // getting currency instance
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // string representation of the result in a currency format
        String result = currency.format(mortgage);

        System.out.println("Mortgage: " + result);

        // for loop to print the amount that is left to pay
        for (short month = 1; month <= years * 12; month++) {
            // returning the amount left to pay after the payment
            double balance = calculateBalance(principal, annualInterest, years, month);

            // printing the amount left to pay
            System.out.print("Payment left after month " + month + ": ");
            System.out.println(currency.format(balance));
        }

    }

    // gives balance after a specific month
    public static double calculateBalance(int principal, float annualInterest, byte years, short number0fPaymentsMade) {
        // monthly interest
        // dividing by 100 because input is given in percentage
        float monthlyInterest = (annualInterest / 100) / 12;

        // finding the number of times the amount is given to pay debt
        float numberOfPayments = (short) (years * 12);

        // formula:
        // B = L[(1+c)^n - (1+c)^p] / [(1+c)^n - 1]
        // L = loan/principle
        // c = monthly interest
        // n = number of payments
        // p = payment made/paid

        // L[(1+c)^n - (1+c)^p]
        double paymentLeft = (double) (principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                        - Math.pow(1 + monthlyInterest, number0fPaymentsMade)));

        // [(1+c)^n - 1]
        paymentLeft = paymentLeft / (Math.pow((1 + monthlyInterest),
                numberOfPayments) - 1);

        return paymentLeft;
    }

    public static double calculateMortgage(float principal, float annualInterest, byte years) {
        // monthly interest
        // dividing by 100 because input is given in percentage
        float monthlyInterest = (annualInterest / 100) / 12;

        // finding the number of times the amount is given to pay debt
        short numberOfPayments = (short) (years * 12);

        // mortgage formula:
        // M = p*r*(1+r)^n / (a+r)^n - 1

        // p*r*(1+r)^n
        double mortgage = principal * monthlyInterest * (float) Math.pow((1 + monthlyInterest), numberOfPayments);

        // (a+r)^n - 1
        mortgage = mortgage / ((float) Math.pow((1 + monthlyInterest), numberOfPayments) - 1);

        return mortgage;
    }

    public static double readNumber(String prompt, double min, double max) {
        // object of scanner class for input
        Scanner input = new Scanner(System.in);

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
