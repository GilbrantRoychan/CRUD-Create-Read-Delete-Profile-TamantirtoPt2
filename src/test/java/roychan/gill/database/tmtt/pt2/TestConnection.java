package roychan.gill.database.tmtt.pt2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import roychan.gill.database.tmtt.pt2.utill.HikariConnection;

import java.sql.*;

public class TestConnection {

    @Test
    void testConnecToDb() {
        try(
                Connection connection = HikariConnection.getDataSource().getConnection();
                ) {
            if (connection != null){
                System.out.println("Success ConnectToDatabse");
            }

        }catch (SQLException e){
            Assertions.fail(e);
        }
    }

    @Test
    void tetGetInformationOfTables() {
        try(
                Connection connection= HikariConnection.getDataSource().getConnection();
                Statement statement = connection.createStatement();
        ) {
            final String QUERY_SQL = "SELECT * FROM Profile";
            ResultSet result = statement.executeQuery(QUERY_SQL);

            ResultSetMetaData getInfoForTables = result.getMetaData();

            for (int x = 1; x<= getInfoForTables.getColumnCount(); x++){
                System.out.println("table name: " + getInfoForTables.getColumnName(x));
                System.out.println("type in java.sql: " + getInfoForTables.getColumnType(x));
                System.out.println("Type: " + getInfoForTables.getColumnTypeName(x));

                System.out.println();
            }

        }catch (SQLException e){
            Assertions.fail(e);
        }
    }
}
