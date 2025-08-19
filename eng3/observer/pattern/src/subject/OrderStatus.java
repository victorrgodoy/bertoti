package subject;

import model.Client;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class OrderStatus {
    private OrderState orderState;
    private final Client client;
    private final List<Observer> observers = new ArrayList<>();

    public OrderStatus(Client client) {
        this.orderState = OrderState.PENDING;
        this.client = client;
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyObserver(){
        for (Observer ob : this.observers){
            ob.update(this.client, this.orderState);
        }
    }

    public void setStatus(OrderState orderState){
        this.orderState = orderState;
        this.notifyObserver();
    }
}
