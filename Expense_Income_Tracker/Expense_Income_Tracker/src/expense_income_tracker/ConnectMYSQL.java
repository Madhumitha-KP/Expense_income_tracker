
package expense_income_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMYSQL {

    public static Connection connect() {
        Connection connection = null;
        try {
            // Provide the JDBC URL, username, and password for your MySQL server
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "Iammadhu*9";

            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Iammadhu*9");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = connect();
        if (connection != null) {
            System.out.println("Connected to the database!");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
