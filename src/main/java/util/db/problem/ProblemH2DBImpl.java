package util.db.problem;

import module.problem.ProblemVO;
import util.db.DBConn;
import util.db.H2DBImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProblemH2DBImpl extends H2DBImpl {

    static final String SQL_PROBLEM_FIND_BY_ID = "select * from problems where pid = ?";
    static final String SQL_PROBLEM_INSERT = "insert into problems values(NULL, ?, ?, ?, ?, sysdate, sysdate, ?)";
    static final String SQL_PROBLEM_SELECT_ALL = "select * from problems";

    static private DBConn dbConn = DBConn.getInstance();

    @Override
    public <T> PreparedStatement insert(T t) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_INSERT);
        ProblemVO problem = (ProblemVO) t;
        ps.setString(1, problem.getTitle());
        ps.setString(2, problem.getAnswer());
        ps.setLong(3, problem.getLikeCount());
        ps.setLong(4, problem.getUnlikeCount());
        ps.setLong(5, problem.getTid());
        return ps;
    }

    @Override
    public PreparedStatement findById(String id) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_FIND_BY_ID);
        ps.setLong(1, Long.parseLong(id));
        return ps;
    }

    @Override
    public PreparedStatement selectAll() throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_SELECT_ALL);
        return ps;
    }
}
