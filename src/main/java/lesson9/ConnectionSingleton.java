package lesson9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    public Connection connection;

    private static ConnectionSingleton instance = null;

    private ConnectionSingleton(String url) throws SQLException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.connection = DriverManager.getConnection(url);
    }

    public static ConnectionSingleton getInstance(String value) {
        if (instance == null) {
            try {
                instance = new ConnectionSingleton(value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}