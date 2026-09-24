package br.com.pelissaro.librarySystem.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3307/library_system";
        String username = "root";
        String password = "admin1406";
        return DriverManager.getConnection(url, username, password);
    }
}
