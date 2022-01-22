package ch.fhnw.edbs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCreateTable {


    public static void main(String[] args) {

        try (
                Connection conn = ConnectionProp.getJDBCConnection();

                Statement statement = conn.createStatement();
        ) {
            String updateString = "CREATE TABLE books (id  INT NOT NULL AUTO_INCREMENT, " +
                    "title VARCHAR(255), " +
                    "author VARCHAR(255), " +
                    "price FLOAT , " +
                    "qty INT, " +
                    "PRIMARY KEY(id))";
            statement.execute(updateString);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
