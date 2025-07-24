package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    // --- MODIFICATION --- Added fields for job role and address
    JTextField nameField, usernameField, jobRoleField, addressField;
    JPasswordField passwordField;
    JButton createButton, backButton;

    Signup() {
        setTitle("Bank Management System - Admin Signup");
        setLayout(null);
        // Increased height to fit new fields
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // Title
        JLabel title = new JLabel("Admin Signup Page");
        title.setFont(new Font("Arial", Font.BOLD, 38));
        title.setBounds(200, 40, 450, 40);
        add(title);
        
        // Name 
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setBounds(150, 140, 150, 30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(300, 140, 300, 30);
        add(nameField);

        
        // Job Role
        JLabel jobRoleLabel = new JLabel("Job Role:");
        jobRoleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        jobRoleLabel.setBounds(150, 190, 150, 30);
        add(jobRoleLabel);
        jobRoleField = new JTextField();
        jobRoleField.setBounds(300, 190, 300, 30);
        add(jobRoleField);
        
        // Address 
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        addressLabel.setBounds(150, 240, 150, 30);
        add(addressLabel);
        addressField = new JTextField();
        addressField.setBounds(300, 240, 300, 30);
        add(addressField);
        

        // Username 
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLabel.setBounds(150, 290, 150, 30);
        add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setBounds(300, 290, 300, 30);
        add(usernameField);
        
        // Password 
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setBounds(150, 340, 150, 30);
        add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 340, 300, 30);
        add(passwordField);

        // CreateAcc Button 
        createButton = new JButton("CREATE ACCOUNT");
        createButton.setBounds(300, 420, 180, 30);
        createButton.setBackground(Color.WHITE);
        createButton.setForeground(Color.BLACK);
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.addActionListener(this);
        add(createButton);
        
        // Back Button 
        backButton = new JButton("BACK");
        backButton.setBounds(500, 420, 100, 30);
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.addActionListener(this);
        add(backButton);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == createButton) {
            String name = nameField.getText();
            String jobRole = jobRoleField.getText(); // Get text from new field
            String address = addressField.getText(); // Get text from new field
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            // --- MODIFICATION --- Updated query to match the full table structure
            String query = "INSERT INTO admin(admin_name, admin_job_role, admin_address, username, password) VALUES('" + name + "', '" + jobRole + "', '" + address + "', '" + username + "', '" + password + "')";
            
            try {
                // Input validation
                if (name.isEmpty() || jobRole.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields except Address are required.");
                    return;
                }

                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Admin Account Created Successfully!");
                
                setVisible(false);
                new Login().setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error: This username may already be taken.");
            }
            
        } else if (ae.getSource() == backButton) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}