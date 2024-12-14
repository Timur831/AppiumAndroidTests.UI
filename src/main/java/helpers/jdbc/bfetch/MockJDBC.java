package helpers.jdbc.bfetch;

import helpers.jdbc.JDBC;

import java.sql.*;

public class MockJDBC {
    public static void insertMockTable(String mockKey, String mockValue, String method) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String insertTableSQL = "INSERT INTO bfetch.mock "
                + "(mock_key, mock_value, created_date, method) " + "VALUES"
                + " ('" + mockKey + "', '" + mockValue + "', '" + timestamp + "', '" + method + "')";

        try {
            dbConnection = JDBC.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(insertTableSQL);
            System.out.println("Добавлен мок '" + method + "' в таблицу \"bfetch.mock\" для ctn " + mockKey);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void clearMockTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String clearTableSQL = "DELETE FROM bfetch.mock ";

        try {
            dbConnection = JDBC.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(clearTableSQL);
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void deleteFromMockTable(String mockKey, String method) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String clearTableSQL = "DELETE FROM bfetch.mock WHERE mock_key = '" + mockKey + "' AND method = '" + method + "'";

        try {
            dbConnection = JDBC.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(clearTableSQL);
            System.out.println("Удален мок '" + method + "' из таблицы \"bfetch.mock\" для ctn " + mockKey);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void getMockTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String getTableSQL = "SELECT * FROM bfetch.mock";
        try {
            dbConnection = JDBC.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            ResultSet resultSet = statement.executeQuery(getTableSQL);

            resultSet.next();

            System.out.println(resultSet.getString("mock_key"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
