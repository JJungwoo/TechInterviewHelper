package util.db;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DBTest {

    String driverClassName = "org.h2.Driver";
    String url = "jdbc:h2:mem:testdb//localhost:9092/default";
    String userid = "root";
    String password = "1234";

    @Test
    public void DBConnectionTest() {
        OracleDBImpl oracleDB = new OracleDBImpl();
        try (Connection connection = oracleDB.getInitConnection(driverClassName, url, userid, password);) {
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
            connection = oracleDB.getInitConnection(driverClassName, url, userid, password);
            assertNotNull(connection);
            oracleDB.closeConnection(connection);
            assertTrue(connection.isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
