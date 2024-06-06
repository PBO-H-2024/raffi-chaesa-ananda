import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame {
    ModelEvent model;
    JLabel lUsername = new JLabel("Username");
    JTextField fUsername = new JTextField();
    JLabel lPassword = new JLabel("Password");
    JPasswordField fPassword = new JPasswordField();
    JButton btnLogin = new JButton("Login");
    JButton btnBack = new JButton("Back");

    public LoginPage(ModelEvent model) {
        this.model = model;
        setTitle("Admin Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(lUsername);
        add(fUsername);
        add(lPassword);
        add(fPassword);
        add(btnLogin);
        add(btnBack);

        lUsername.setBounds(20, 20, 100, 20);
        fUsername.setBounds(120, 20, 150, 20);
        lPassword.setBounds(20, 50, 100, 20);
        fPassword.setBounds(120, 50, 150, 20);
        btnLogin.setBounds(120, 90, 70, 30);
        btnBack.setBounds(200, 90, 70, 30);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fUsername.getText();
                String password = new String(fPassword.getPassword());

                if (isValidAdmin(username, password)) {
                    new AdminPage(model);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LandingPage(model);
                dispose();
            }
        });

        setVisible(true);
    }

    private boolean isValidAdmin(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concert_db", "root", "");
            String query = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
