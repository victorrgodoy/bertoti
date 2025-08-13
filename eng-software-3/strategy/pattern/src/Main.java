import service.PaymentContext;
import strategy.CreditCardPayment;
import strategy.DebitCardPayment;
import strategy.PixPayment;

public class Main {
    public static void main(String[] args) {

        CreditCardPayment creditCardPayment = new CreditCardPayment("1234.1234.1234.1234");
        DebitCardPayment debitCardPayment = new DebitCardPayment("4444.4444.4444.4444");
        PixPayment pixPayment = new PixPayment("pix@gmail.com");

        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.execute(200.20);

        paymentContext.setPaymentStrategy(debitCardPayment);
        paymentContext.execute(300);

        paymentContext.setPaymentStrategy(pixPayment);
        paymentContext.execute(400);

    }
}