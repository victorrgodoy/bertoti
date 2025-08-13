public class PaymentProcessor {

    public void execute(double amount, String method){
        switch (method){
            case "pix":
                System.out.println("Pagamento R$ " + amount + " via PIX");
                break;
            case "boleto":
                System.out.println("Pagamento R$ " + amount + " via BOLETO");
                break;
            case "credito":
                System.out.println("Pagamento R$ " + amount + " via CREDITO");
                break;
            case "debito":
                System.out.println("Pagamento R$ " + amount + " via DEBITO");
                break;
            default:
                System.out.println("Método de pagamento não suportado!");

        }
    }
}
