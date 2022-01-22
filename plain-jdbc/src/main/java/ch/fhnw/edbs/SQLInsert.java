package ch.fhnw.edbs;

import java.sql.*;

public class SQLInsert {
    public static void main(String[] args) {
        try (
                Connection conn = ConnectionProp.getJDBCConnection();
                Statement stmt = conn.createStatement();
        ) {


//            String sqlInsert = "insert into books values (3001, 'Gone Fishing', 'Kumar', 11.11, 11)";
//            int countInserted = stmt.executeUpdate(sqlInsert);
//            System.out.println(countInserted + " records inserted.\n");
//



            Book book = new Book();
            book.setId(4500L);
            book.setAuthor("Goethe");
            book.setPrice(25);
            book.setTitle("Faust");
            book.setQty(10);
            insertBook(book);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertBook(Book book) {
        try {
            Connection conn = ConnectionProp.getJDBCConnection();
            Statement stmt = conn.createStatement();

            String sqlInsert = "insert into books values ("
                    + book.getId() + ", '"
                    + book.getTitle() + "', '"
                    + book.getAuthor() + "', " + book.getPrice() + ", "
                    + book.getQty() + ")";
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
