package strategy;

public class PixPayment implements PaymentStrategy {
    private final String keyPix;

    public PixPayment(String keyPix){
        this.keyPix = keyPix;
    }

    @Override
    public void execute(double amount) {
        System.out.println(
                "PIX KEY: " + this.keyPix + " \n"
                        + "Amount: " + amount
        );
    }
}