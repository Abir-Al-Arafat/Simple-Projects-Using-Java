public class Calculator {
    // fields
    private int principal;
    private float annualInterest;
    private byte years;

    // constructor
    public Calculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
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
}
