package util.db;

import module.problem.ProblemVO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class H2DBImpl extends DBUtil {

    public abstract PreparedStatement insert(ProblemVO problem) throws SQLException;

    public abstract PreparedStatement findById(Long pid) throws SQLException;

    public abstract PreparedStatement problemSelectAll() throws SQLException;
}
