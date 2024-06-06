import java.sql.*;

public class ModelEvent {
    String DBurl = "jdbc:mysql://localhost:3306/concert_db";
    String DBusername = "root";
    String DBpassword = "";
    Connection conn;

    public ModelEvent() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }

    public void insertEvent(String name, String date, String venue, int ticket_price, String artist_lineup) {
        try {
            String query = "INSERT INTO events(name, date, venue, ticket_price, artist_lineup) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, date);
            pstmt.setString(3, venue);
            pstmt.setInt(4, ticket_price);
            pstmt.setString(5, artist_lineup);
            pstmt.executeUpdate();
            System.out.println("Event Inserted");
        } catch (SQLException e) {
            System.out.println("Insert Failed: " + e.getMessage());
        }
    }

    public String[][] readEvents() {
        String data[][] = new String[10][5];
        try {
            String query = "SELECT * FROM events";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int rowCount = 0;
            while (resultSet.next()) {
                data[rowCount][0] = resultSet.getString("name");
                data[rowCount][1] = resultSet.getString("date");
                data[rowCount][2] = resultSet.getString("venue");
                data[rowCount][3] = String.valueOf(resultSet.getDouble("ticket_price"));
                data[rowCount][4] = resultSet.getString("artist_lineup");
                rowCount++;
            }
        } catch (SQLException e) {
            System.out.println("Read Failed: " + e.getMessage());
        }
        return data;
    }

    public void updateEvent(String name, String date, String venue, double ticket_price, String artist_lineup) {
        try {
            String query = "UPDATE events SET date=?, venue=?, ticket_price=?, artist_lineup=? WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, venue);
            pstmt.setDouble(3, ticket_price);
            pstmt.setString(4, artist_lineup);
            pstmt.setString(5, name);
            pstmt.executeUpdate();
            System.out.println("Event Updated");
        } catch (SQLException e) {
            System.out.println("Update Failed: " + e.getMessage());
        }
    }

    public void deleteEvent(String name) {
        try {
            String query = "DELETE FROM events WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Event Deleted");
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getMessage());
        }
    }

    public void insertPurchase(String eventName, String userName, String email, int tickets, double totalPrice) {
        try {
            String query = "INSERT INTO purchases(event_name, user_name, email, tickets, total_price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, eventName);
            pstmt.setString(2, userName);
            pstmt.setString(3, email);
            pstmt.setInt(4, tickets);
            pstmt.setDouble(5, totalPrice);
            pstmt.executeUpdate();
            System.out.println("Purchase Recorded");
        } catch (SQLException e) {
            System.out.println("Purchase Failed: " + e.getMessage());
        }
    }

    public String[][] readPurchases() {
        String data[][] = new String[10][6];
        try {
            String query = "SELECT * FROM purchases";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int rowCount = 0;
            while (resultSet.next()) {
                data[rowCount][0] = resultSet.getString("event_name");
                data[rowCount][1] = resultSet.getString("user_name");
                data[rowCount][2] = resultSet.getString("email");
                data[rowCount][3] = String.valueOf(resultSet.getInt("tickets"));
                data[rowCount][4] = String.valueOf(resultSet.getDouble("total_price"));
                rowCount++;
            }
        } catch (SQLException e) {
            System.out.println("Read Failed: " + e.getMessage());
        }
        return data;
    }
}
