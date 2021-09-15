package module.account;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.db.DBConn;
import util.db.OracleDBImpl;
import util.io.FileIOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserDAOTest {

    static final String SQL_SELECT_ALL = "select * from users";
    static final String SQL_SELECT_BY_ID = "select * from departments where department_id = ?";
    static final String SQL_SELECT_BY_NAME = "select * from departments where department_name like ?";
    static final String SQL_SELECT_BY_LOC = "select * from departments where location_id = ?";
    static final String SQL_INSERT_USER = "insert into users (id, userid, password, nickname, email, enroll_date, update_date, role) " +
                                            "values (Users_SEQ.nextval, 'testuser', '1234', 'tester', 'testuser@gmail.com', sysdate, sysdate, 1)";

    private DBConn conn = null;
    private OracleDBImpl oracleDB = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Before
    public void initDB() {
        oracleDB = new OracleDBImpl();
        Properties properties = FileIOUtil.jdbcGetPropertise("src/main/resources/oracleDBinfo.propertise");

        try {
            Connection connection = oracleDB.getInitConnection(properties.getProperty("url"),
                                                            properties.getProperty("userid"),
                                                            properties.getProperty("password"));
            conn = new DBConn.Builder(connection).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeDB() {
        oracleDB.closeResultSet(resultSet);
        oracleDB.closeStatement(statement);
        oracleDB.closePrepareStatement(preparedStatement);
        oracleDB.closeConnection(conn.getConnection());
    }

    @Test
    public void createUser() {
        try {
            statement = conn.getConnection().createStatement();
            assertEquals(1, statement.executeUpdate(SQL_INSERT_USER));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectUsers() {
        try {
            statement = conn.getConnection().createStatement();
            assertEquals(1, statement.executeUpdate(SQL_INSERT_USER));

            preparedStatement = conn.getConnection().prepareStatement(SQL_SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            assertTrue(resultSet.next());
            assertEquals("testuser", resultSet.getString(2));
            assertEquals("tester", resultSet.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
