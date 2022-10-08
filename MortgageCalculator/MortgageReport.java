// class to give balance after a specific month

public class MortgageReport {
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
}
