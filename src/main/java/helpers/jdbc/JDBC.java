package helpers.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private final static String DB_DRIVER = "org.postgresql.Driver";
    private final static String DB_CONNECTION = "jdbc:postgresql://10.31.106.33:5432/unibalance";
    private final static String DB_USER = "tech_ubc_ms";
    private final static String DB_PASSWORD = "ws)%/1yj:_@bql]-";

    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
