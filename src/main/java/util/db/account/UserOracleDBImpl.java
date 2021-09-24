package util.db.account;

import module.account.UserVO;
import util.db.DBConn;
import util.db.OracleDBImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserOracleDBImpl extends OracleDBImpl {

    static final String SQL_USER_FIND_BY_ID = "select * from users where userid = ?";
    static final String SQL_USER_INSERT = "insert into users values(Users_SEQ.nextval, ?, ?, ?, ?, sysdate, sysdate, ?)";
    static final String SQL_USER_SELECT_ALL = "select * from users";
    static final String SQL_USER_DELETE_BY_USERID = "delete from users where userid = ?";
    static final String SQL_USER_UPDATE_PASSWORD_BY_USERID = "update users set password = ? where userid = ?";

    static private DBConn dbConn = DBConn.getInstance();

    @Override
    public <T> PreparedStatement insert(T t) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_INSERT);
        UserVO user = (UserVO) t;
        ps.setString(1, user.getUserid());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getNickname());
        ps.setString(4, user.getEmail());
        ps.setByte(5, user.getRole());
        return ps;
    }

    @Override
    public PreparedStatement findById(String userid) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_FIND_BY_ID);
        ps.setString(1, userid);
        return ps;
    }

    @Override
    public PreparedStatement selectAll() throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_SELECT_ALL);
        return ps;
    }

    public PreparedStatement deleteByUserid(String userid) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_DELETE_BY_USERID);
        ps.setString(1, userid);
        return ps;
    }

    public PreparedStatement updatePasswordByUserid(String userid, String password) throws SQLException {
        PreparedStatement ps = dbConn.getConnection().prepareStatement(SQL_USER_UPDATE_PASSWORD_BY_USERID);
        ps.setString(1, password);
        ps.setString(2, userid);
        return ps;
    }
}
