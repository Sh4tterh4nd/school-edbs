package ch.fhnw.edbs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDelete {
    public static void main(String[] args) {
        try (
                Connection conn = ConnectionProp.getJDBCConnection();
                Statement stmt = conn.createStatement();
        ) {
            String sqlDelete = "delete from books where id >= 3000 and id < 4000";
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
