package observer;
import model.Client;
import subject.Status;
import context.PaymentContext;

public class PaymentObserver implements Observer {
    private final PaymentContext paymentContext;

    public PaymentObserver(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    @Override
    public void update(Client client, Status orderState, double amount) {
        switch (orderState) {
            case CONFIRMED:
                System.out.println("Pagamento processado para: " + client.getName());
                System.out.println("Novo status: " + Status.CONFIRMED);
                this.paymentContext.execute(amount);
                break;

            case CANCELLED:
                System.out.println("Pagamento cancelado para: " + client.getName());
                System.out.println("Novo status: " + Status.CANCELLED);
                break;

            case PENDING:
                System.out.println("Pagamento pendente para: " + client.getName());
                System.out.println("Novo status: " + Status.PENDING);
                break;
        }
    }
}
