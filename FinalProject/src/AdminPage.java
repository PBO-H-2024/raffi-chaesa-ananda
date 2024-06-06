import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class AdminPage extends JFrame {
    ModelEvent model;
    JLabel lName = new JLabel("Event Name");
    JTextField fName = new JTextField();
    JLabel lDate = new JLabel("Date");
    JTextField fDate = new JTextField();
    JLabel lVenue = new JLabel("Venue");
    JTextField fVenue = new JTextField();
    JLabel lticket_price = new JLabel("Ticket Price");
    JTextField fticket_price = new JTextField();
    JLabel lartist_artist_lineup = new JLabel("Artist Line-up");
    JTextField fartist_artist_lineup = new JTextField();
    JButton btnAdd = new JButton("Add");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    JButton btnBack = new JButton("Back");
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    JLabel lPurchaseTitle = new JLabel("Purchases");
    JTable purchaseTable;
    DefaultTableModel purchaseTableModel;
    JScrollPane purchaseScrollPane;

    Object columnName[] = { "Name", "Date", "Venue", "Ticket Price", "Artist Line-up" };
    Object purchaseColumnName[] = { "Event Name", "User Name", "Email", "Tickets", "Total Price" };

    public AdminPage(ModelEvent model) {
        this.model = model;
        setTitle("Music Concert Event Management - Admin Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(lName);
        add(fName);
        add(lDate);
        add(fDate);
        add(lVenue);
        add(fVenue);
        add(lticket_price);
        add(fticket_price);
        add(lartist_artist_lineup);
        add(fartist_artist_lineup);
        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);
        add(btnBack);

        lName.setBounds(20, 20, 100, 20);
        fName.setBounds(130, 20, 150, 20);
        lDate.setBounds(20, 50, 100, 20);
        fDate.setBounds(130, 50, 150, 20);
        lVenue.setBounds(20, 80, 100, 20);
        fVenue.setBounds(130, 80, 150, 20);
        lticket_price.setBounds(20, 110, 100, 20);
        fticket_price.setBounds(130, 110, 150, 20);
        lartist_artist_lineup.setBounds(20, 140, 100, 20);
        fartist_artist_lineup.setBounds(130, 140, 150, 20);

        btnAdd.setBounds(300, 20, 80, 30);
        btnUpdate.setBounds(300, 60, 80, 30);
        btnDelete.setBounds(300, 100, 80, 30);
        btnClear.setBounds(300, 140, 80, 30);
        btnBack.setBounds(300, 180, 80, 30);

        tableModel = new DefaultTableModel(columnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        scrollPane.setBounds(20, 220, 740, 200);

        lPurchaseTitle.setBounds(400, 20, 100, 20);

        purchaseTableModel = new DefaultTableModel(purchaseColumnName, 0);
        purchaseTable = new JTable(purchaseTableModel);
        purchaseScrollPane = new JScrollPane(purchaseTable);
        purchaseScrollPane.setBounds(400, 40, 350, 150);

        add(lPurchaseTitle);
        add(purchaseScrollPane);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fName.getText();
                String date = fDate.getText();
                String venue = fVenue.getText();
                int ticket_price = Integer.parseInt(fticket_price.getText());
                String artist_artist_lineup = fartist_artist_lineup.getText();

                model.insertEvent(name, date, venue, ticket_price, artist_artist_lineup);
                refreshTable();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fName.getText();
                String date = fDate.getText();
                String venue = fVenue.getText();
                double ticket_price = Double.parseDouble(fticket_price.getText());
                String artist_artist_lineup = fartist_artist_lineup.getText();

                model.updateEvent(name, date, venue, ticket_price, artist_artist_lineup);
                refreshTable();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fName.getText();
                model.deleteEvent(name);
                refreshTable();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LandingPage(model);
                dispose();
            }
        });

        refreshTable();
        refreshPurchaseTable();
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

    public void refreshPurchaseTable() {
        String purchasedata[][] = model.readPurchases();
        purchaseTableModel.setRowCount(0);
        for (String[] row : purchasedata) {
            if (row[0] != null) {
                purchaseTableModel.addRow(row);
            }
        }
    }

    public void clearTable() {
        tableModel.setRowCount(0);
    }
}
