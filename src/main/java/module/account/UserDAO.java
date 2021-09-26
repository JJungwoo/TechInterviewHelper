package module.account;

import util.db.DBConn;
import util.db.DBUtil;
import util.db.account.UserH2DBImpl;
import util.db.account.UserOracleDBImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 데이터베이스의 Users 테이블 접근 객체
// -> 나중에 Repository 클래스를 따로 만들어서 기존적인 crud 메서드는 상속 받도록 리팩토링 필요
public class UserDAO {

    private static UserDAO userDAO = new UserDAO();
    private static DBUtil dbUtil;

    // jdbc 에서 데이터 처리하기 위한 DB Connection 객체 가져오기
    static private DBConn dbConn = DBConn.getInstance();

    // 싱글톤 -> 나중에 애노테이션으로 리팩토링 필요
    public static UserDAO getInstance() {
        String database = dbConn.getDatabase();
        if (database.equals("oracle")) {
//            dbConn.setDbUtil(new UserOracleDBImpl());
            dbUtil = new UserOracleDBImpl();
        } else if (database.equals("h2")) {
//            dbConn.setDbUtil(new UserH2DBImpl());
            dbUtil = new UserOracleDBImpl();
        }
        return userDAO;
    }

    public UserVO findById(String userid) {
        UserVO user = null;

        try {
            PreparedStatement ps = dbUtil.findById(userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserVO.Builder()
                        .id(rs.getLong(1))
                        .userid(rs.getString(2))
                        .password(rs.getString(3))
                        .nickname(rs.getString(4))
                        .email(rs.getString(5))
                        .enrollDate(rs.getDate(6))
                        .updateDate(rs.getDate(7))
                        .role(rs.getByte(8))
                        .build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public UserVO save(UserVO user) {
        int result = 0;

        try {
            PreparedStatement ps = dbUtil.insert(user);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1 ? user : null;
    }

    public boolean deleteByUserid(String userid) {
        int result = 0;

        try {
            PreparedStatement ps = null;
            if (dbUtil instanceof UserOracleDBImpl) {
                ps = ((UserOracleDBImpl) dbUtil).deleteByUserid(userid);
            } else if (dbUtil instanceof  UserH2DBImpl) {
                ps = ((UserH2DBImpl) dbUtil).deleteByUserid(userid);
            }

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1;
    }

    public boolean updatePasswordByUserid(String userid, String password) {
        int result = 0;

        try {
            PreparedStatement ps = null;
            if (dbUtil instanceof UserOracleDBImpl) {
                ps = ((UserOracleDBImpl) dbUtil).updatePasswordByUserid(userid, password);
            } else if (dbUtil instanceof  UserH2DBImpl) {
                ps = ((UserH2DBImpl) dbUtil).updatePasswordByUserid(userid, password);
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1;
    }
}
