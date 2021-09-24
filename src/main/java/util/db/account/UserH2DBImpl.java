package util.db.account;

import module.problem.ProblemVO;
import util.db.H2DBImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserH2DBImpl extends H2DBImpl {

    @Override
    public PreparedStatement insert(ProblemVO problem) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement findById(Long pid) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement problemSelectAll() throws SQLException {
        return null;
    }
}
