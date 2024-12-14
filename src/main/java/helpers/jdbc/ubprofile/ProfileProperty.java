package helpers.jdbc.ubprofile;

import helpers.jdbc.JDBC;

import java.sql.*;

public class ProfileProperty {
    public static void updateUBOffer(String ctnKey, Boolean ubOfferFlag) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String updateUBOfferSQL = "UPDATE ubprofile.profile_property "
                + "SET uboffer = " + ubOfferFlag + " WHERE ctn = " + "'" + ctnKey + "'";

        try {
            dbConnection = JDBC.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(updateUBOfferSQL);
            System.out.println("Данные в колонке \"uboffer\" обновлены в таблице \"ubprofile.profile_property\" для ctn " + ctnKey);
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

    public static Boolean getUBOffer(String ctnKey) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String getUBOfferSQL = "SELECT uboffer FROM ubprofile.profile_property" +
                " WHERE ctn = " + "'" + ctnKey + "'";
        try {
            dbConnection = JDBC.getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            ResultSet resultSet = statement.executeQuery(getUBOfferSQL);

            resultSet.next();

            return resultSet.getBoolean("uboffer");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
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
