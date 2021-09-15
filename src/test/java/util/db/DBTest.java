package util.db;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;

public class DBTest {

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String userid = "hr";
    String password = "hr";

    @Test
    public void DBConnectionTest() {
        OracleDBImpl oracleDB = new OracleDBImpl();
        try (Connection connection = oracleDB.getConnection(url, userid, password);) {
            assertTrue(connection != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DBCloseTest() {
        OracleDBImpl oracleDB = new OracleDBImpl();
        try (Connection connection = oracleDB.getConnection(url, userid, password);) {
            assertTrue(connection != null);
            oracleDB.closeConnection(connection);
            assertTrue(connection == null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
