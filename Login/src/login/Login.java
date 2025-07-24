package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, signupButton;

    Login() {
        setTitle("Bank Management System - Admin Login");
        setLayout(null);
        setSize(800, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("Admin Login");
        title.setFont(new Font("Arial", Font.BOLD, 38));
        title.setBounds(290, 40, 400, 40);
        add(title);

        JLabel usernameLabel = new JLabel("User ID:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        usernameLabel.setBounds(150, 150, 150, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(300, 150, 230, 30);
        usernameField.setFont(new Font("Arial", Font.BOLD, 14));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 24));
        passwordLabel.setBounds(150, 220, 150, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(300, 220, 230, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField);

        
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(300, 300, 100, 30);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.addActionListener(this);
        add(loginButton);

        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(430, 300, 100, 30);
        signupButton.setBackground(Color.WHITE);
        signupButton.setForeground(Color.BLACK);
        signupButton.setFont(new Font("Arial", Font.BOLD, 14));
        signupButton.addActionListener(this);
        add(signupButton);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter User ID and Password");
                return; 
            }
            
            String query = "SELECT * FROM admin WHERE username = '" + username + "' AND password = '" + password + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    
                    setVisible(false);
                    //new AdminDashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect User ID or Password");
                }
                rs.close(); 
                c.s.close(); 
                c.c.close(); 
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signupButton) {
            setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}