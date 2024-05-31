import java.sql.*;

public class ModelContact {
    String DBurl = "jdbc:mysql://localhost:3306/recruit_db";
    String DBusername = "root";
    String DBpassword = "";
    Connection conn;
    Statement statement;

    public ModelContact() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }

    public void insertData(String name, String path, double writing, double coding, double interview, double score, String status) {
        try {
            String query = "INSERT INTO recruitment(name, path, writing, coding, interview, score, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, path);
            pstmt.setDouble(3, writing);
            pstmt.setDouble(4, coding);
            pstmt.setDouble(5, interview);
            pstmt.setDouble(6, score);
            pstmt.setString(7, status);
            pstmt.executeUpdate();
            System.out.println("Input Success");
        } catch(Exception ex) {
            System.out.println("Input Failed: " + ex.getMessage());
        }
    }

    public String[][] readData() {
        String data[][] = new String[10][7];
        try {
            String query = "SELECT * FROM recruitment";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int totalData = 0;
            while(resultSet.next()) {
                data[totalData][0] = resultSet.getString("name");
                data[totalData][1] = resultSet.getString("path");
                data[totalData][2] = resultSet.getString("writing");
                data[totalData][3] = resultSet.getString("coding");
                data[totalData][4] = resultSet.getString("interview");
                data[totalData][5] = resultSet.getString("score");
                data[totalData][6] = resultSet.getString("status");
                totalData++;
            }
        } catch(SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return data;
    }

    public void updateData(String name, String path, int writing, int coding, int interview) {
        try {
            String query = "UPDATE recruitment SET name=?, path=?, writing=?, coding=?, interview=? WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, path);
            pstmt.setInt(3, writing);
            pstmt.setInt(4, coding);
            pstmt.setInt(5, interview);
            pstmt.setString(6, name);
            pstmt.executeUpdate();
            System.out.println("Update Success");
        } catch(Exception ex) {
            System.out.println("Update Failed: " + ex.getMessage());
        }
    }

    public void deleteData(String name) {
        try {
            String query = "DELETE FROM recruitment WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Delete Success");
        } catch(Exception ex) {
            System.out.println("Delete Failed: " + ex.getMessage());
        }
    }
}
