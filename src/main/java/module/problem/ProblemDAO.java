package module.problem;

import util.db.DBConn;
import util.db.DBUtil;
import util.db.OracleDBImpl;
import util.db.problem.ProblemH2DBImpl;
import util.db.problem.ProblemOracleDBImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAO {

    private static ProblemDAO problemDAO = new ProblemDAO();

    private static DBConn dbConn = DBConn.getInstance();
    private static DBUtil dbUtil;

    public static ProblemDAO getInstance() {
        String database = dbConn.getDatabase();
        if (database.equals("oracle")) {
//            dbConn.setDbUtil(new ProblemOracleDBImpl());
            dbUtil = new ProblemOracleDBImpl();
        } else if (database.equals("h2")) {
//            dbConn.setDbUtil(new ProblemH2DBImpl());
            dbUtil = new ProblemH2DBImpl();
        }
        return problemDAO;
    }

    public ProblemVO save(ProblemVO problem) {
        int result = 0;

        try {
            PreparedStatement ps = dbUtil.insert(problem);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1 ? problem : null;
    }

    public ProblemVO findById(String pid) {
        ProblemVO problem = null;

        try {
            PreparedStatement ps = dbUtil.findById(pid);
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
            PreparedStatement ps = dbUtil.selectAll();
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

    public Long saveLikeProblem(Long userId, Long problemId) {
        int result = 0;

        try {
            PreparedStatement ps = ((ProblemOracleDBImpl) dbUtil).userLikeInsert(userId, problemId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1 ? problemId : null;
    }

    public void delete() {

    }

    public void update() {

    }
}
