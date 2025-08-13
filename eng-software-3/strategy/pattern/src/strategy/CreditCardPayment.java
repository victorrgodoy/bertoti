package strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String number;

    public CreditCardPayment(String number){
        this.number = number;
    }

    @Override
    public void execute(double amount) {
        System.out.println(
                "CREDIT CARD: " + this.number + " \n"
                + "Amount: " + amount
        );
    }
}
