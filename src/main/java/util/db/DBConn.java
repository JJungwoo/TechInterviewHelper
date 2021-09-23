package util.db;

import util.io.FileIOUtil;

import java.sql.*;
import java.util.Properties;

public class DBConn {

    // 싱글톤
    private static DBConn dbConn = new DBConn();

    private String url;
    private String userid;
    private String password;

    private DBUtil dbUtil;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public static DBConn getInstance() {
        return dbConn;
    }

    // 요청되는 DB에 따라 connection 변경
    public boolean initDB(String database, String path) {
        if (database.equals("oracle")) {
            dbUtil = new OracleDBImpl();
        } else if (database.equals("h2")) {
            dbUtil = new H2DBImpl();
        } else {
            return false;
        }

        try {
            Properties properties = FileIOUtil.jdbcGetPropertise(path);
            connection = dbUtil.getInitConnection(
                    properties.getProperty("driver-class-name"),
                    properties.getProperty("url"),
                    properties.getProperty("userid"), properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void closeDB() {
        dbUtil.closeResultSet(resultSet);
        dbUtil.closeStatement(statement);
        dbUtil.closePrepareStatement(preparedStatement);
        dbUtil.closeConnection(connection);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public String getUrl() {
        return url;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
}
