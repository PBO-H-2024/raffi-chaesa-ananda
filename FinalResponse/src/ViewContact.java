import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class ViewContact extends JFrame {
    JLabel lName = new JLabel("Name");
    JTextField fName = new JTextField();
    JLabel lPath = new JLabel("Path");
    String[] options = { "Android Dev", "Website Dev" };
    JComboBox<String> dropdown = new JComboBox<>(options);
    JLabel lWriting = new JLabel("Writing");
    JTextField fWriting = new JTextField();
    JLabel lCoding = new JLabel("Coding");
    JTextField fCoding = new JTextField();
    JLabel lInterview = new JLabel("Interview");
    JTextField fInterview = new JTextField();

    JButton btnAdd = new JButton("Add");
    JButton btnUpdate = new JButton("Update");
    JLabel disclaimer1 = new JLabel("(match the name to one of the names on the table)");
    JButton btnDelete = new JButton("Delete");
    JLabel disclaimer2 = new JLabel("(match the name to one of the names on the table)");
    JButton btnClear = new JButton("Clear");
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    Object columnName[] = { "Name", "Path", "Writing", "Coding", "Interview", "Score", "Status" };

    public ViewContact() {
        setTitle("PT. OOP");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(lName);
        add(fName);
        add(lPath);
        add(dropdown);
        add(lWriting);
        add(fWriting);
        add(lCoding);
        add(fCoding);
        add(lInterview);
        add(fInterview);
        add(btnAdd);
        add(btnUpdate);
        add(disclaimer1);
        add(btnDelete);
        add(disclaimer2);
        add(btnClear);

        lName.setBounds(20, 20, 100, 20);
        fName.setBounds(120, 20, 150, 20);
        lPath.setBounds(20, 50, 100, 20);
        dropdown.setBounds(120, 50, 150, 20);
        lWriting.setBounds(20, 80, 100, 20);
        fWriting.setBounds(120, 80, 150, 20);
        lCoding.setBounds(20, 110, 100, 20);
        fCoding.setBounds(120, 110, 150, 20);
        lInterview.setBounds(20, 140, 100, 20);
        fInterview.setBounds(120, 140, 150, 20);
        btnAdd.setBounds(280, 20, 80, 30);
        btnUpdate.setBounds(280, 60, 80, 30);
        disclaimer1.setBounds(370, 60, 400, 30);
        btnDelete.setBounds(280, 100, 80, 30);
        disclaimer2.setBounds(370, 100, 400, 30);
        btnClear.setBounds(280, 140, 80, 30);

        tableModel = new DefaultTableModel(columnName, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        scrollPane.setBounds(20, 180, 540, 180);

        setVisible(true);
    }
}
