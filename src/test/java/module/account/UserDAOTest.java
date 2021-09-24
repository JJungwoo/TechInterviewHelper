package module.account;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.db.DBConn;
import util.db.DBUtil;
import util.db.H2DBImpl;
import util.db.OracleDBImpl;
import util.db.problem.ProblemH2DBImpl;
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
    static final String SQL_INSERT_USER = "insert into users (id, userid, password, nickname, email, enroll_date, update_date, role) " +
                                            "values (Users_SEQ.nextval, 'testuser', '1234', 'tester', 'testuser@gmail.com', sysdate, sysdate, 1)";

    static final String H2_SQL_INSERT_USER = "insert into users " +
            "values (NULL, 'testuser', '1234', 'tester', 'testuser@gmail.com', '2021-09-23', '2021-09-23', 1)";

    static final String H2_SQL_CREATE_USER = "CREATE TABLE Users\n" +
            "(\n" +
            "    `id`           NUMBER(10, 0)    NOT NULL    AUTO_INCREMENT COMMENT 'id',\n" +
            "    `userid`       VARCHAR(45)      NOT NULL    COMMENT 'userId',\n" +
            "    `password`     VARCHAR(45)      NOT NULL    COMMENT 'password',\n" +
            "    `nickname`     VARCHAR(45)      NOT NULL    COMMENT 'nickname',\n" +
            "    `email`        VARCHAR(45)      NOT NULL    COMMENT 'email',\n" +
            "    `enroll_date`  DATE             NOT NULL    COMMENT 'enroll_date',\n" +
            "    `update_date`  DATE             NOT NULL    COMMENT 'update_date',\n" +
            "    `role`         NUMBER(2, 0)     NOT NULL    COMMENT 'role',\n" +
            "    CONSTRAINT PK_User PRIMARY KEY (id)\n" +
            ")";

    private DBConn conn = DBConn.getInstance();
    private DBUtil dbUtil = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private final static String oraclePath = "src/main/resources/oracleDBinfo.propertise";
    private final static String h2Path = "src/main/resources/h2DBinfo.propertise";

    // 테스트용 DB 또는 트랜잭션 속성을 통해 테스트 데이터 끝나면 모두 삭제 기능 필요
    // 테스트 할 때마다 테스트용 디비에 테이블 만들고 테스트 끝내거나 테스트한 데이터 전부 삭제하도록 트랜잭션 특성 필요.
    // 트랜잭션 속성은 commit 메서드로로 나중에 리팩토링 가능할 듯.
    @Before
    public void initDB() {
        DBConn dbConn = new DBConn();
        Properties properties = FileIOUtil.jdbcGetPropertise(h2Path);

        try {
            conn.setConnection(dbConn.getInitConnection(
                    properties.getProperty("driver-class-name"),
                    properties.getProperty("url"),
                    properties.getProperty("userid"), properties.getProperty("password")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeDB() {
        dbUtil.closeResultSet(resultSet);
        dbUtil.closeStatement(statement);
        dbUtil.closePrepareStatement(preparedStatement);
        conn.closeConnection(conn.getConnection());
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
            // 현재 user 테이블에 데이터가 없음을 전제하에 테스트 진행
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

    @Test
    public void selectUsersH2DBTest() {
        try {
            // 현재 user 테이블에 데이터가 없음을 전제하에 테스트 진행
            statement = conn.getConnection().createStatement();
            statement.executeUpdate(H2_SQL_CREATE_USER);
            assertEquals(1, statement.executeUpdate(H2_SQL_INSERT_USER));

            preparedStatement = conn.getConnection().prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            assertTrue(resultSet.next());
            assertEquals("testuser", resultSet.getString(2));
            assertEquals("tester", resultSet.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
