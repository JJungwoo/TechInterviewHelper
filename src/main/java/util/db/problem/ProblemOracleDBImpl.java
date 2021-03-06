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
    static final String SQL_USERLIKE_INSERT = "insert into userlike values(USERLIKE_SEQ.NEXTVAL, ?, ?, sysdate, 'like')";
    static final String SQL_USERLIKE_PROBLEM_FIND_BY_USERID = "select * from problems where pid in " +
                                            "(select problemid from users u join userlike ul on u.id = ul.userid where u.userid like ?)";

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

    public PreparedStatement userLikeInsert(Long userId, Long problemId) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USERLIKE_INSERT);
        ps.setLong(1, userId);
        ps.setLong(2, problemId);
        return ps;
    }

    public PreparedStatement selectUserLikeProblemAll(String userId) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USERLIKE_PROBLEM_FIND_BY_USERID);
        ps.setString(1, userId);
        return ps;
    }
}
