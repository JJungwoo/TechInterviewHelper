package util.db;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DBTest {

    DBConn dbConn = DBConn.getInstance();

    String driverClassName = "org.h2.Driver";
    String url = "jdbc:h2:mem:testdb//localhost:9092/default";
    String userid = "root";
    String password = "1234";

    @Test
    public void DBConnectionTest() {
        try (Connection connection = dbConn.getInitConnection(driverClassName, url, userid, password);) {
            assertTrue(connection != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DBCloseTest() {
        Connection connection = null;
        try {
            connection = dbConn.getInitConnection(driverClassName, url, userid, password);
            assertNotNull(connection);
            dbConn.closeConnection(connection);
            assertTrue(connection.isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
