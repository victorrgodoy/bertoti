package controller;

import factory.ConnectionFactory;
import factory.OutputStyles;
import service.DataBaseService;
import service.LMStudioService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ChatGUI {
    private JFrame jFrame;
    private final ConnectionFactory connectionFactory;
    private final DataBaseService dataBaseService;
    private JTextField input;
    private JEditorPane output;
    private String conversationHistory = "";
    private int processingCounter = 0;
    private final Timer timer;

    public ChatGUI(DataBaseService dataBaseService, ConnectionFactory connectionFactory) {
        this.dataBaseService = dataBaseService;
        this.connectionFactory = connectionFactory;
        SwingUtilities.invokeLater(this::configureGUI);
        timer = new Timer(500, e -> updateProcessingText());
    }

    public void configureGUI() {
        jFrame = new JFrame();
        jFrame.setSize(600, 500);
        jFrame.setTitle("ChatBot");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        Container contentPane = jFrame.getContentPane();
        contentPane.setBackground(Color.white);
        contentPane.setLayout(null);

        conversationHistory += "<b>Bot:</b> Olá, eu sou o SQL bot, faça uma pergunta:<br><br>";

        Border roundedBorder = createRoundedBorder();

        input = new JTextField();
        input.setText("Faça uma pergunta...");
        input.setBounds(40, 400, 410, 40);
        input.setBackground(new Color(255, 255, 255, 255));
        input.setForeground(new Color(0, 0, 0, 128));
        input.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), roundedBorder));
        input.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("Faça uma pergunta...")) {
                    input.setText("");
                }
            }
        });

        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        output = new JEditorPane();
        HTMLEditorKit editor = new HTMLEditorKit();
        new OutputStyles().ApplyStyles(editor);
        output.setContentType("text/html");
        output.setEditable(false);
        output.setEditorKit(editor);
        output.setForeground(new Color(0, 0, 0, 102));
        output.setText("<html>" + conversationHistory + "</html>");
        output.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), roundedBorder));

        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setBounds(40, 55, 525, 330);
        scrollPane.setBorder(null);

        JButton buttonSent = new JButton();
        buttonSent.setText("ENVIAR");
        buttonSent.setBounds(470, 400, 90, 36);
        buttonSent.setFont(new Font("Arial", Font.BOLD, 12));
        buttonSent.addActionListener(e -> sendMessage());

        JLabel nameDB = new JLabel();
        nameDB.setBounds(44, 15, 500, 35);
        nameDB.setFont(new Font("Arial", Font.BOLD, 14));
        nameDB.setForeground(new Color(0, 0, 0, 179));
        jFrame.add(nameDB);

        JLabel imageOnlineDB = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src/main/resources/static/img/online.png");

        Image image = imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        imageOnlineDB.setIcon(imageIcon);
        imageOnlineDB.setBounds(160, 21, 25, 25);
        jFrame.add(imageOnlineDB);

        jFrame.add(input);
        jFrame.add(scrollPane);
        jFrame.add(buttonSent);
        dataBaseService.dataSchema(connectionFactory);
        jFrame.setVisible(true);
    }

    private void sendMessage() {
        String userQuestion = input.getText();

        input.setText("");

        this.conversationHistory += "<b>You:</b> " + userQuestion + "<br><br>";
        timer.start();

        new Thread(() -> {
            try {
                String response = LMStudioService.resultSQL(LMStudioService.sendLMStudioQuery(userQuestion, dataBaseService), new ConnectionFactory());
                conversationHistory += "<b>Bot:</b> " + response + "<br><br>";
                timer.stop();

                output.setText("<html>" + conversationHistory + "</html>");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).start();
    }

    private Border createRoundedBorder() {
        return new CompoundBorder(new RoundedBorder(10), BorderFactory.createEmptyBorder(0, 5, 0, 5));
    }

    static class RoundedBorder implements Border {
        private final int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius, this.radius, this.radius, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    private void updateProcessingText() {
        String[] processingTexts = { "Processando<b>.<b>", "Processando<b>..<b>", "Processando<b>...<b>" };
        output.setText(conversationHistory + "<b>Bot: </b>" + processingTexts[processingCounter]);
        processingCounter = (processingCounter + 1) % processingTexts.length;
    }
}
