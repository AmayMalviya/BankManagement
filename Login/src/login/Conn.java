package login;
import java.sql.*;
public class Conn {

    // Connection and Statement objects
    Connection c;
    Statement s;

    public Conn() {
        try {
            // 1. Register the JDBC driver (optional for modern JDBC)
            // Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Create a connection
            // The connection URL string: jdbc:mysql://hostname:port/databaseName
            String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
            String username = "root"; // Your MySQL username
            String password = "**********"; // Your MySQL password

            c = DriverManager.getConnection(url, username, password);
            
            // 3. Create a statement
            s = c.createStatement();
            
        } catch (Exception e) {
            // Print the exception details if connection fails
            System.out.println(e);
        }
    }
}
