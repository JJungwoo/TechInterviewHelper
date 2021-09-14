package util.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DBImpl implements DBUtil {

    @Override
    public void closeConnection(Connection connection) {
        if (connection == null) {
            return ;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
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

    @Override
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

    @Override
    public void loadDriver() throws Exception {
        try {
            Class.forName(H2_DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            throw new Exception("Unable to register driver class", e);
        }
    }

    @Override
    public Connection getConnection(String url, String user, String password) {
        return null;
    }
}
