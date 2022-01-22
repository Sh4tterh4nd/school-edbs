package ch.fhnw.edbs;

import java.sql.*;

public class JDBCUpdate {

    public static void main(String[] args) {
        try (
                Connection conn = ConnectionProp.getJDBCConnection();

                Statement stmt = conn.createStatement();
        ) {
            String strUpdate = "update books set price = price*1.8, qty = qty+1 where id = 3001";
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected.\n");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
