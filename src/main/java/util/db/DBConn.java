package util.db;

import util.io.FileIOUtil;

import java.sql.*;
import java.util.Properties;

public class DBConn {

    // 싱글톤
    private static DBConn dbConn = new DBConn();

    private String database;
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
        this.database = database;
        try {
            Properties properties = FileIOUtil.jdbcGetPropertise(path);
            connection = getInitConnection(
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
        closeConnection(connection);
    }

    public void loadDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getInitConnection(String driver, String url, String user, String password) throws Exception {
        loadDriver(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public void closeConnection(Connection connection) {
        if (connection == null) {
            return ;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void setDbUtil(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
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

    public DBUtil getDbUtil() {
        return dbUtil;
    }

    public String getDatabase() {
        return database;
    }
}
