package ch.fhnw.edbs;

import java.sql.*;

public class JDBCSelect {
    public static void main(String[] args) {
        try (
                Connection connection = ConnectionProp.getJDBCConnection();
                Statement statement = connection.createStatement();
        ) {

//            String selectString = "select title, price, qty from books where id = 1001";
            String selectString = "select title, price, qty from books";
            ResultSet resultSet = ((Statement) statement).executeQuery(selectString);

            int rowCount = 0;
            while(resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                int    qty   = resultSet.getInt("qty");
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

}
