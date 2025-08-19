public class Main {
    public static void main(String[] args) {
        Client client = new Client("John", "john@gmail.com", "12 1234-1234");
        OrderStatus orderStatus = new OrderStatus(client, new EmailNotification(), new WhatsappNotification());
        orderStatus.update("PEDIDO ENVIADO");
        System.out.println("--");
        orderStatus.update("PEDIDO ENTREGUE");
    }
}