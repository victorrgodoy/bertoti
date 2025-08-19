public class OrderStatus {
    private final Client client;
    private String status;
    private final EmailNotification emailNotification;
    private final WhatsappNotification whatsappNotification;

    //ligação forte, acoplamento
    public OrderStatus(Client client, EmailNotification emailNotification, WhatsappNotification whatsappNotification) {
        this.client = client;
        this.status = "";
        this.emailNotification = emailNotification;
        this.whatsappNotification = whatsappNotification;
    }

    public void update(String status){
        this.status = status.toUpperCase();
        this.emailNotification.sentNotification(this.client.getEmail(), status);
        this.whatsappNotification.sentNotification(this.client.getNumber(), status);
    }
}
