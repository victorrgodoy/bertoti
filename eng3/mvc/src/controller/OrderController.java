package controller;

import model.Client;
import observer.PaymentObserver;
import subject.OrderStatus;
import subject.Status;
import strategy.PaymentStrategy;
import context.PaymentContext;
import view.OrderView;

public class OrderController {
    private final OrderStatus orderStatus;
    private final OrderView view;

    public OrderController(Client client, double amount, PaymentStrategy paymentStrategy) {
        this.orderStatus = new OrderStatus(client, amount);
        this.view = new OrderView();
        PaymentContext paymentContext = new PaymentContext(paymentStrategy);

        PaymentObserver paymentObserver = new PaymentObserver(paymentContext);
        this.orderStatus.addObserver(paymentObserver);
    }

    public void createOrder(Status status) {
        view.showNewOrder(
                orderStatus.getClient(),
                orderStatus.getOrderStatus(),
                orderStatus.getAmount()
        );

        this.orderStatus.setOrderStatus(status);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}