package observer;

import model.Client;
import subject.OrderState;

public class WhatsAppNotification implements Observer{

    @Override
    public void update(Client client, OrderState orderState) {
        String notification = "NAME: " + client.getName() + "\n" +
                "WHATSAPP: " + client.getNumber()  + "\n" +
                "PRODUCT: " + orderState;
        System.out.println(notification);
    }
}
