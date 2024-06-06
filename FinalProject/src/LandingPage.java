import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class LandingPage extends JFrame {
    ModelEvent model;
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JButton btnAdmin = new JButton("Admin Page");
    JButton btnPurchase = new JButton("Order Ticket");

    Object columnName[] = { "Name", "Date", "Venue", "Ticket Price", "Artist Line-up" };

    public LandingPage(ModelEvent model) {
        this.model = model;
        setTitle("Music Concert Event Management - Landing Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        tableModel = new DefaultTableModel(columnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        scrollPane.setBounds(20, 20, 740, 300);

        add(btnAdmin);
        btnAdmin.setBounds(20, 340, 150, 30);

        add(btnPurchase);
        btnPurchase.setBounds(180, 340, 150, 30);

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage(model);
                dispose();
            }
        });

        btnPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String eventName = tableModel.getValueAt(selectedRow, 0).toString();
                    double ticket_price = Double.parseDouble(tableModel.getValueAt(selectedRow, 3).toString());
                    new DetailPage(model, eventName, ticket_price);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an event to purchase tickets.");
                }
            }
        });

        refreshTable();
        setVisible(true);
    }

    public void refreshTable() {
        String data[][] = model.readEvents();
        tableModel.setRowCount(0);
        for (String[] row : data) {
            if (row[0] != null) {
                tableModel.addRow(row);
            }
        }
    }
}
