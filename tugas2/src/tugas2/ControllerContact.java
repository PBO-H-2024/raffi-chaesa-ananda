package tugas2;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControllerContact {
    private ViewContact view;
    private ModelContact model;

    public ControllerContact(ViewContact view, ModelContact model) {
        this.view = view;
        this.model = model;
        
        this.view.getBtnAdd().addActionListener(e -> addData());
        this.view.getBtnRefresh().addActionListener(e -> refreshData());
    }

    private void addData() {
        int nim = Integer.parseInt(view.getFNim().getText());
        String name = view.getFName().getText();
        int age = Integer.parseInt(view.getFAge().getText());

        model.insertData(nim, name, age);
        refreshData();
    }

    private void refreshData() {
        String[][] data = model.readData();
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0); // clear existing data
        for (String[] row : data) {
            tableModel.addRow(row);
        }
    }
}
