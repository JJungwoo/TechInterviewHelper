package module.account;

import util.db.DBConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 데이터베이스의 Users 테이블 접근 객체
// -> 나중에 Repository 클래스를 따로 만들어서 기존적인 crud 메서드는 상속 받도록 리팩토링 필요
public class UserDAO {

    private static UserDAO userDAO = new UserDAO();

    static final String SQL_USER_FIND_BY_ID = "select * from users where userid = ?";
    static final String SQL_USER_INSERT = "insert into users values(Users_SEQ.nextval, ?, ?, ?, ?, sysdate, sysdate, ?)";
    static final String SQL_USER_DELETE_BY_USERID = "delete from users where userid = ?";
    static final String SQL_USER_UPDATE_PASSWORD_BY_USERID = "update users set password = ? where userid = ?";

    // jdbc 에서 데이터 처리하기 위한 DB Connection 객체 가져오기
    static private DBConn dbConn = DBConn.getInstance();

    // 싱글톤 -> 나중에 애노테이션으로 리팩토링 필요
    public static UserDAO getInstance() {
        return userDAO;
    }

    public UserVO findById(String userid) {
        UserVO user = null;

        dbConn.initDB("oracle", "src/main/resources/oracleDBinfo.propertise");

        try {
            PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_FIND_BY_ID);
            ps.setString(1, userid);
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

        dbConn.initDB("oracle", "src/main/resources/oracleDBinfo.propertise");

        try {
            PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_INSERT);
            ps.setString(1, user.getUserid());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNickname());
            ps.setString(4, user.getEmail());
            ps.setByte(5, user.getRole());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1 ? user : null;
    }

    public boolean deleteByUserid(String userid) {
        int result = 0;

        dbConn.initDB("oracle", "src/main/resources/oracleDBinfo.propertise");

        try {
            PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_DELETE_BY_USERID);
            ps.setString(1, userid);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1;
    }

    public boolean updatePasswordByUserid(String userid, String password) {
        int result = 0;

        dbConn.initDB("oracle", "src/main/resources/oracleDBinfo.propertise");

        try {
            PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_UPDATE_PASSWORD_BY_USERID);
            ps.setString(1, password);
            ps.setString(2, userid);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result >= 1;
    }
}
