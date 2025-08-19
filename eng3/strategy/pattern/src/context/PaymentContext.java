package service;

import strategy.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void execute(double amount){
        if (paymentStrategy == null){
            throw new IllegalArgumentException("Incorrect type method");
        }

        this.paymentStrategy.execute(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
