import model.Client;
import strategy.CreditCardPayment;
import controller.OrderController;
import subject.Status;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("John", "john@email.com", "11-98888-8888");
        double amount = 150.00;

        CreditCardPayment creditCard = new CreditCardPayment("5555-6666-7777-8888");

        OrderController controller = new OrderController(client, amount, creditCard);

        controller.createOrder(Status.CANCELLED);

    }
}