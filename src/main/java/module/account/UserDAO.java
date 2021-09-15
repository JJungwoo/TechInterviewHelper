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
    static final String SQL_USER_INSERT = "";
    static final String SQL_USER_DELETE = "";
    static final String SQL_USER_UPDATE = "";

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
                user = new UserVO.Builder(rs.getLong(1))
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

    public UserVO save() {
        return null;
    }

    public void delete() {

    }

    public void update() {

    }
}
