import controller.ChatGUI;
import factory.ConnectionFactory;
import service.DataBaseService;

public class Main {
    public static void main(String[] args) {

        new ChatGUI(new DataBaseService(), new ConnectionFactory());

    }
}
