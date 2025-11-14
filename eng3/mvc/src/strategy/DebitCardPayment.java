package strategy;

public class DebitCardPayment implements PaymentStrategy {
    private final String number;

    public DebitCardPayment(String number){
        this.number = number;
    }

    @Override
    public void execute(double amount) {
        System.out.println(
                "DEBIT CARD: " + this.number + " \n"
                        + "Amount: " + amount
        );
    }

}
