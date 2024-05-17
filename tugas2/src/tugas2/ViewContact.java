package tugas2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class ViewContact extends JFrame {
    private JFrame window;
    private JTextField fNim, fName, fAge;
    private JButton btnAdd, btnRefresh;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;

    public ViewContact() {
        window = new JFrame("Student Input");
        fNim = new JTextField();
        fName = new JTextField();
        fAge = new JTextField();
        btnAdd = new JButton("ADD");
        btnRefresh = new JButton("REFRESH");

        window.setLayout(null);
        window.setSize(500, 400);
        window.setVisible(true);
        window.setLocationRelativeTo(null);

        window.add(new JLabel("NIM")).setBounds(5, 35, 120, 20);
        window.add(fNim).setBounds(150, 35, 120, 20);
        window.add(new JLabel("NAME")).setBounds(5, 60, 120, 20);
        window.add(fName).setBounds(150, 60, 120, 20);
        window.add(new JLabel("AGE")).setBounds(5, 85, 120, 20);
        window.add(fAge).setBounds(150, 85, 120, 20);
        window.add(btnAdd).setBounds(300, 35, 90, 20);
        window.add(btnRefresh).setBounds(300, 60, 90, 20);

        String[] columnNames = {"ID", "NIM", "Name", "Age"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        window.add(scrollPane).setBounds(20, 120, 450, 200);
    }

    public JTextField getFNim() {
        return fNim;
    }

    public JTextField getFName() {
        return fName;
    }

    public JTextField getFAge() {
        return fAge;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnRefresh() {
        return btnRefresh;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
