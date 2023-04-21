package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection dbConnect() throws SQLException {
        // Database coonection value
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "password";

        // Database open conection
        // Try and catch in case connection does not work
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}
