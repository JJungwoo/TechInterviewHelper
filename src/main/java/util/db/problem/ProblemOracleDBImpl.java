package util.db.problem;

import module.problem.ProblemVO;
import util.db.DBConn;
import util.db.OracleDBImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProblemOracleDBImpl extends OracleDBImpl {

    static final String SQL_PROBLEM_FIND_BY_ID = "select * from problems where pid = ?";
    static final String SQL_PROBLEM_INSERT = "insert into problems values(Problems_SEQ.nextval, ?, ?, ?, ?, sysdate, sysdate, ?)";
    static final String SQL_PROBLEM_SELECT_ALL = "select * from problems";

    static private DBConn dbConn = DBConn.getInstance();

    @Override
    public PreparedStatement insert(ProblemVO problem) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_INSERT);
        ps.setString(1, problem.getTitle());
        ps.setString(2, problem.getAnswer());
        ps.setLong(3, problem.getLikeCount());
        ps.setLong(4, problem.getUnlikeCount());
        ps.setLong(5, problem.getTid());
        return ps;
    }

    @Override
    public PreparedStatement findById(Long pid) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_FIND_BY_ID);
        ps.setLong(1, pid);
        return ps;
    }

    @Override
    public PreparedStatement problemSelectAll() throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_SELECT_ALL);
        return ps;
    }
}
