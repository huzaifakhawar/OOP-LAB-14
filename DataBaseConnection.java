package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    private Connection connection;
    private Statement statement;

    public DataBaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx_db", "root", "Huzaifa123@#");
            statement = connection.createStatement();
            System.out.println("Database connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}