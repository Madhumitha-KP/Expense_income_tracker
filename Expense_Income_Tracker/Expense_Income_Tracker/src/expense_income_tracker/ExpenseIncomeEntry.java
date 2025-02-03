package expense_income_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpenseIncomeEntry {
    
    private String date;
    private String description;
    private double amount;
    private String type;
    
    public ExpenseIncomeEntry(String date, String description, double amount, String type) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getType() {
        return type;
    }
    
    public void saveToDatabase() {
        try {
            // Provide the JDBC URL, username, and password for your MySQL server
            String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "";

            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");

            // Prepare the SQL statement
            String sql = "INSERT INTO expense_income (date, description, amount, type) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, this.date);
            statement.setString(2, this.description);
            statement.setDouble(3, this.amount);
            statement.setString(4, this.type);

            // Execute the statement
            statement.executeUpdate();

            // Close the resources
            statement.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

