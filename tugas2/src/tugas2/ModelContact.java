package tugas2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelContact {
    String DBurl = "jdbc:mysql://localhost/student_db";
    String DBusername = "root";
    String DBpassword = "";
    
    Connection conn;
    Statement statement;
    
    public ModelContact(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }
    
    void insertData(int nim, String name, int age){
        try{
            String query = "INSERT INTO `student`(`nim`,`name`,`age`) VALUES ('" + nim + "','" + name + "','" + age + "')";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Input Success");
        }catch(Exception ex){
            System.out.println("Input Failed " + ex.getMessage());
        }
    }
    
    String[][] readData(){
        String data[][] = new String[10][4]; 
        try{
            int totalData = 0;
            String query = "SELECT * FROM student";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("nim");
                data[totalData][2] = resultSet.getString("name");
                data[totalData][3] = resultSet.getString("age");
                totalData++;
            }
            statement.close();
        }catch(SQLException e){
            System.out.println("SQL Error" + e.getMessage());
        }finally{
            return data;
        }
    }
    
    void updateData(int id, int nim, String name, int age){
        try{
            String query = "UPDATE `student` SET nim= '" + nim+ "',"
                    + " name= '" + name+ "',"
                    + " age= '" + age+ "' WHERE id = '" + id + "'";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Update Success");
        }catch(Exception ex){
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }
    
    void deleteData(int id){
        try{
            String query = "DELETE FROM `student` WHERE id='" + id + "'";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Delete Success");
        }catch(Exception ex){
            System.out.println("Delete Failed : " + ex.getMessage());
        }
    }
}
