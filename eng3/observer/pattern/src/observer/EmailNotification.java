package observer;

import model.Client;
import subject.OrderState;

public class EmailNotification implements Observer{

    @Override
    public void update(Client client, OrderState orderState) {
        String notification = "NAME: " + client.getName() + "\n" +
                "EMAIL: " + client.getEmail()  + "\n" +
                "PRODUCT: " + orderState + "\n";
        System.out.println(notification);
    }
}
