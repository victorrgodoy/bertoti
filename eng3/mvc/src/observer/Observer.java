package observer;

import model.Client;
import subject.Status;

public interface Observer{
    void update(Client client, Status orderState, double amount);
}
