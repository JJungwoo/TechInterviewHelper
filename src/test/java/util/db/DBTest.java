package util.db;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DBTest {

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String userid = "hr";
    String password = "hr";

    @Test
    public void DBConnectionTest() {
        OracleDBImpl oracleDB = new OracleDBImpl();
        try (Connection connection = oracleDB.getInitConnection(url, userid, password);) {
            assertTrue(connection != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DBCloseTest() {
        OracleDBImpl oracleDB = new OracleDBImpl();
        Connection connection = null;
        try {
            connection = oracleDB.getInitConnection(url, userid, password);
            assertNotNull(connection);
            oracleDB.closeConnection(connection);
            assertTrue(connection.isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
