package module.problem;

import util.db.DBConn;

import java.lang.management.ClassLoadingMXBean;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAO {

    private static ProblemDAO problemDAO = new ProblemDAO();

    static final String SQL_PROBLEM_FIND_BY_ID = "select * from problems where pid = ?";
    static final String SQL_PROBLEM_INSERT = "insert into problems values(Problems_SEQ.nextval, ?, ?, ?, ?, sysdate, sysdate, ?)";
    static final String SQL_PROBLEM_SELECT_ALL = "select * from problems";

    static private DBConn dbConn = DBConn.getInstance();

    public static ProblemDAO getInstance() {
        return problemDAO;
    }

    public ProblemVO save(ProblemVO problem) {
        int result = 0;

        try {
            PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_INSERT);
            ps.setString(1, problem.getTitle());
            ps.setString(2, problem.getAnswer());
            ps.setLong(3, problem.getLikeCount());
            ps.setLong(4, problem.getUnlikeCount());
            ps.setLong(5, problem.getTid());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1 ? problem : null;
    }

    public ProblemVO findById(Long pid) {
        ProblemVO problem = null;

        try {
            PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_FIND_BY_ID);
            ps.setLong(1, pid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                problem = new ProblemVO.Builder()
                                .pid(rs.getLong(1))
                                .title(rs.getString(2))
                                .answer(rs.getString(3))
                                .likeCount(rs.getLong(4))
                                .unlikeCount(rs.getLong(5))
                                .enrollDate(rs.getDate(6))
                                .updateDate(rs.getDate(7))
                                .tid(rs.getLong(8))
                                .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problem;
    }

    public List<ProblemVO> problemSelectAll() {
        List<ProblemVO> problemVOList = new ArrayList<>();

        try {
            PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_PROBLEM_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                problemVOList.add(new ProblemVO.Builder()
                        .pid(rs.getLong(1))
                        .title(rs.getString(2))
                        .answer(rs.getString(3))
                        .likeCount(rs.getLong(4))
                        .unlikeCount(rs.getLong(5))
                        .enrollDate(rs.getDate(6))
                        .updateDate(rs.getDate(7))
                        .tid(rs.getLong(8))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problemVOList;
    }

    public void delete() {

    }

    public void update() {

    }
}
