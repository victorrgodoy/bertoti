import service.CreditCardPayment;
import service.DebitCardPayment;
import service.Payment;
import service.PixPayment;

public class Main {
    public static void main(String[] args) {

        Payment creditCard = new CreditCardPayment("1234.1234.1234.1234");
        Payment pix = new PixPayment("pix@gmail.com");
        Payment debitCard = new DebitCardPayment("4444.4444.4444.4444");

        creditCard.execute(200);
        pix.execute(100);
        debitCard.execute(300);

    }
}
