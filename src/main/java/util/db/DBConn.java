package util.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {

    private String url;
    private String userid;
    private String password;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public static class Builder {

        // 필수 항목들
        private Connection connection;

        // 추가 항목들
        private String url;
        private String userid;
        private String password;
        private Statement statement;
        private ResultSet resultSet;

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
    }
}
