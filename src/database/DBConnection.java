package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/tweets";
    private static String name = "root";
    private static String password = "root";

    public DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, name, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        boolean result = true;

        try {
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено.");
            } else {
                result = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public void closeConnection() {
        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
