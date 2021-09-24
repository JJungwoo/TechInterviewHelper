package util.db;

import module.problem.ProblemVO;

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

    public abstract PreparedStatement insert(ProblemVO problem) throws SQLException;

    public abstract PreparedStatement findById(Long pid) throws SQLException;

    public abstract PreparedStatement problemSelectAll() throws SQLException;
}
