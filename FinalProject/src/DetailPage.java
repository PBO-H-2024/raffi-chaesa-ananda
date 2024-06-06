import javax.swing.*;
import java.awt.event.*;

public class DetailPage extends JFrame {
    ModelEvent model;
    JLabel lEventName = new JLabel("Event: ");
    JLabel lEventValue = new JLabel();
    JLabel lName = new JLabel("Name");
    JTextField fName = new JTextField();
    JLabel lEmail = new JLabel("Email");
    JTextField fEmail = new JTextField();
    JLabel lTickets = new JLabel("Tickets");
    JTextField fTickets = new JTextField();
    JLabel lTotalPrice = new JLabel("Total Price: ");
    JLabel lPriceValue = new JLabel();
    JButton btnPurchase = new JButton("Order");
    JButton btnBack = new JButton("Back");
    double ticket_price;

    public DetailPage(ModelEvent model, String eventName, double ticket_price) {
        this.model = model;
        this.ticket_price = ticket_price;

        setTitle("Order Ticket");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lEventValue.setText(eventName);

        add(lEventName);
        add(lEventValue);
        add(lName);
        add(fName);
        add(lEmail);
        add(fEmail);
        add(lTickets);
        add(fTickets);
        add(lTotalPrice);
        add(lPriceValue);
        add(btnPurchase);
        add(btnBack);

        lEventName.setBounds(20, 20, 100, 20);
        lEventValue.setBounds(120, 20, 250, 20);
        lName.setBounds(20, 50, 100, 20);
        fName.setBounds(120, 50, 150, 20);
        lEmail.setBounds(20, 80, 100, 20);
        fEmail.setBounds(120, 80, 150, 20);
        lTickets.setBounds(20, 110, 100, 20);
        fTickets.setBounds(120, 110, 150, 20);
        lTotalPrice.setBounds(20, 140, 100, 20);
        lPriceValue.setBounds(120, 140, 150, 20);
        btnPurchase.setBounds(20, 170, 100, 30);
        btnBack.setBounds(130, 170, 100, 30);

        fTickets.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int tickets = Integer.parseInt(fTickets.getText());
                    lPriceValue.setText(String.valueOf(tickets * ticket_price));
                } catch (NumberFormatException ex) {
                    lPriceValue.setText("");
                }
            }
        });

        btnPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = fName.getText();
                String email = fEmail.getText();
                int tickets = Integer.parseInt(fTickets.getText());
                double totalPrice = tickets * ticket_price;

                model.insertPurchase(eventName, userName, email, tickets, totalPrice);
                JOptionPane.showMessageDialog(null, "Order successful for " + userName + ", kindly check your email to finish the purchase");
                new LandingPage(model);
                dispose();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LandingPage(model);
                dispose();
            }
        });

        setVisible(true);
    }
}
