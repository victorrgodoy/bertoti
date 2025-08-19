package observer;

import model.Client;
import subject.OrderState;

public interface Observer{
    void update(Client client, OrderState orderState);
}
