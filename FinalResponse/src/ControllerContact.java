import java.awt.event.*;

public class ControllerContact {
    ModelContact model;
    ViewContact view;

    public ControllerContact(ModelContact model, ViewContact view) {
        this.model = model;
        this.view = view;

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.fName.getText();
                String path = view.dropdown.getSelectedItem().toString();
                double writing = Integer.parseInt(view.fWriting.getText());
                double coding = Integer.parseInt(view.fCoding.getText());
                double interview = Integer.parseInt(view.fInterview.getText());

                double score;
                if (path == "Android Dev") {
                    score = (writing * 0.2) + (coding * 0.5) + (interview * 0.3);
                } else {
                    score = (writing * 0.4) + (coding * 0.35) + (interview * 0.25);
                }

                String status;
                if (score >= 85) {
                    status = "Accepted";
                } else {
                    status = "Not Accepted";
                }

                model.insertData(name, path, writing, coding, interview, score, status);
                refreshTable();
            }
        });

        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.fName.getText();
                String path = view.dropdown.getSelectedItem().toString();
                int writing = Integer.parseInt(view.fWriting.getText());
                int coding = Integer.parseInt(view.fCoding.getText());
                int interview = Integer.parseInt(view.fInterview.getText());
                model.updateData(name, path, writing, coding, interview);
                refreshTable();
            }
        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.fName.getText();
                model.deleteData(name);
                refreshTable();
            }
        });

        view.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
            }
        });
    }

    public void refreshTable() {
        String data[][] = model.readData();
        view.tableModel.setRowCount(0);
        for (String[] row : data) {
            if (row[0] != null)
                view.tableModel.addRow(row);
        }
    }

    public void clearTable() {
        String data[][] = model.readData();
        view.tableModel.setRowCount(0);
        for (String[] row : data) {
            if (row[0] != null)
                view.tableModel.removeRow(0);;
        }
    }
}
