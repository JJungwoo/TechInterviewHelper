package util.db;

import java.sql.*;

public abstract class DBUtil {

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

    public void closePrepareStatement(PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            return ;
        }

        try {
            preparedStatement.close();
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

    public abstract <T> PreparedStatement insert(T t) throws SQLException;

    public abstract PreparedStatement findById(String id) throws SQLException;

    public abstract PreparedStatement selectAll() throws SQLException;
}
