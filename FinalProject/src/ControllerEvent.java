import java.awt.event.*;

public class ControllerEvent {
    ModelEvent model;
    AdminPage view;

    public ControllerEvent(ModelEvent model, AdminPage view) {
        this.model = model;
        this.view = view;

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.fName.getText();
                String date = view.fDate.getText();
                String venue = view.fVenue.getText();
                int ticket_price = Integer.parseInt(view.fticket_price.getText());
                String artist_artist_lineup = view.fartist_artist_lineup.getText();

                model.insertEvent(name, date, venue, ticket_price, artist_artist_lineup);
                refreshTable();
            }
        });

        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.fName.getText();
                String date = view.fDate.getText();
                String venue = view.fVenue.getText();
                double ticket_price = Double.parseDouble(view.fticket_price.getText());
                String artist_artist_lineup = view.fartist_artist_lineup.getText();

                model.updateEvent(name, date, venue, ticket_price, artist_artist_lineup);
                refreshTable();
            }
        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.fName.getText();
                model.deleteEvent(name);
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
        String data[][] = model.readEvents();
        view.tableModel.setRowCount(0);
        for (String[] row : data) {
            if (row[0] != null)
                view.tableModel.addRow(row);
        }
    }

    public void clearTable() {
        String data[][] = model.readEvents();
        view.tableModel.setRowCount(0);
        for (String[] row : data) {
            if (row[0] != null)
                view.tableModel.removeRow(0);
            ;
        }
    }
}
