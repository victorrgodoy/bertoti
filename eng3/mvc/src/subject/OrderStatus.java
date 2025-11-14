package subject;

import model.Client;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class OrderStatus {
    private Status status;
    private final double amount;
    private final Client client;
    private final List<Observer> observers = new ArrayList<>();

    public OrderStatus(Client client, double amount) {
        this.status = Status.PENDING;
        this.client = client;
        this.amount = amount;
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer ob : this.observers){
            ob.update(this.client, this.status, this.amount);
        }
    }

    public void setOrderStatus(Status status){
        this.status = status;
        this.notifyObservers();
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    public Status getOrderStatus(){
        return  this.status;
    }
}
