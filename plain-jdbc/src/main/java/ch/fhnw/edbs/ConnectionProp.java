package ch.fhnw.edbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProp {

    public static Connection getJDBCConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.0.30:3307/edbs?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "user", "password");
        return conn;
    }
}
