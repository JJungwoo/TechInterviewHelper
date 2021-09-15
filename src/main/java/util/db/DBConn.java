package util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {

    private String url;
    private String userid;
    private String password;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public DBConn() {

    }

    public static class Builder {

        // 필수 항목들
        private Connection connection;

        // 추가 항목들
        private String url                          = null;
        private String userid                       = null;
        private String password                     = null;
        private Statement statement                 = null;
        private ResultSet resultSet                 = null;
        private PreparedStatement preparedStatement = null;

        public Builder(Connection connection) {
            this.connection = connection;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setUserid(String userid) {
            this.userid = userid;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setStatement(Statement statement) {
            this.statement = statement;
            return this;
        }

        public Builder setPreparedStatement(PreparedStatement preparedStatement) {
            this.preparedStatement = preparedStatement;
            return this;
        }

        public Builder setResultSet(ResultSet resultSet) {
            this.resultSet = resultSet;
            return this;
        }

        public DBConn build() {
            return new DBConn(this);
        }
    }

    public DBConn(Builder builder) {
        this.url = builder.url;
        this.userid = builder.userid;
        this.password = builder.password;
        this.connection = builder.connection;
        this.statement = builder.statement;
        this.resultSet = builder.resultSet;
        this.preparedStatement = builder.preparedStatement;
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
