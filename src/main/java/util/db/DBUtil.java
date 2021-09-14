package util.db;

import java.sql.*;

public abstract class DBUtil {
    static final String ORACLE_DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
    static final String H2_DRIVER_CLASS_NAME = null;

    void closeConnection(Connection connection) {
        if (connection == null) {
            return ;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement(Statement statement) {
        if (statement == null) {
            return ;
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeResultSet(ResultSet resultSet) {
        if (resultSet == null) {
            return ;
        }

        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    abstract void loadDriver() throws Exception;

    public Connection getConnection(String url, String user, String password) throws Exception {
        loadDriver();
        return DriverManager.getConnection(url, user, password);
    }
}
