import model.Client;
import observer.EmailNotification;
import observer.WhatsAppNotification;
import subject.OrderState;
import subject.OrderStatus;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("John", "john@gmail.com", "12 1234-1234");

        EmailNotification emailNotification = new EmailNotification();
        WhatsAppNotification whatsAppNotification = new WhatsAppNotification();

        OrderStatus orderStatus = new OrderStatus(client);
        orderStatus.addObserver(emailNotification);
        orderStatus.addObserver(whatsAppNotification);
        orderStatus.notifyObserver();
        System.out.println("--");
        orderStatus.setStatus(OrderState.PAID);
        System.out.println("--");
        orderStatus.setStatus(OrderState.DELIVERED);
    }
}