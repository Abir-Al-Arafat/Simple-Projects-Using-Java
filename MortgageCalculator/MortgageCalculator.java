// make a mortgage calculator which takes three inputs principal, annual interest rate and period (in years) and prints the monthly payment the user has to give

import java.text.NumberFormat;

public class MortgageCalculator {
    public static void main(String[] args) {

        // getting principal amount
        int principal = (int) Console.readNumber("Principal", 1000, 1_000_000);

        // getting annual interest rate
        float annualInterest = (float) Console.readNumber("Annual Interest rate", 1, 30);

        // getting the number of years
        byte years = (byte) Console.readNumber("Years", 1, 30);

        // System.out.println(Math.pow(2, 3));
        Calculator calculate = new Calculator(principal, annualInterest, years);
        double mortgage = calculate.calculateMortgage();

        // getting currency instance
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // string representation of the result in a currency format
        String result = currency.format(mortgage);

        System.out.println("Mortgage: " + result);

        // for loop to print the amount that is left to pay
        for (short month = 1; month <= years * 12; month++) {
            // returning the amount left to pay after every payment
            double balance = MortgageReport.calculateBalance(principal, annualInterest, years, month);

            // printing the amount left to pay
            System.out.print("Payment left after month " + month + ": ");
            System.out.println(currency.format(balance));
        }

    }
}