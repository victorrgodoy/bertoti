public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.execute(220.20, "pix");
        paymentProcessor.execute(320.20, "boleto");
        paymentProcessor.execute(420.20, "credito");
        paymentProcessor.execute(520.20, "debito");

    }
}