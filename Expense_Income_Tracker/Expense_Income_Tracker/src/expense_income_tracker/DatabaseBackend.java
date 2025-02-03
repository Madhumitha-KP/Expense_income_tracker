/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package expense_income_tracker;

/**
 *
 * @author MADHUMITHA
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBackend {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb" ;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public DatabaseBackend() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Iammadhu*9");
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ExpenseIncomeEntry> getAllEntries() {
        List<ExpenseIncomeEntry> entries = new ArrayList<>();
        String query = "SELECT * FROM expenses_and_incomes";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                String type = resultSet.getString("type");
                ExpenseIncomeEntry entry = new ExpenseIncomeEntry(date, description, amount, type);
                entries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }

    // Other methods

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
