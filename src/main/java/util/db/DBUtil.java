package util.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DBUtil {
    static final String ORACLE_DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
    static final String H2_DRIVER_CLASS_NAME = null;

    void closeConnection(Connection connection);
    void closeStatement(Statement statement);
    void closeResultSet(ResultSet resultSet);

    void loadDriver() throws Exception;
    Connection getConnection(String url, String user, String password) throws Exception;
}
