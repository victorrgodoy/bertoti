package view;

import model.Client;
import subject.Status;

public class OrderView {

    public void showNewOrder(Client client, Status status, double amount) {
        System.out.println("=== PEDIDO CRIADO ===");
        System.out.println("Cliente: " + client.getName());
        System.out.println("Status: " + status);
        System.out.println("Valor: R$ " + amount);
        System.out.println("===".repeat(10));
    }
}