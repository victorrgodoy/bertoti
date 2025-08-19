package service;

public class PixPayment extends Payment {
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
