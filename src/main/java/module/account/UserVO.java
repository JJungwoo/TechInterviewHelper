package module.account;

import java.sql.*;

public class UserVO {
    private Long id;
    private String userid;
    private String password;
    private String nickname;
    private String email;
    private Date enrollDate;
    private Date updateDate;
    private Byte role;

    public static class Builder {

        private Long id = 0L; // auto increment (oracle은 seq)
        private String userid   = null;
        private String password = null;
        private String nickname = null;
        private String email    = null;
        private Date enrollDate = null;
        private Date updateDate = null;
        private Byte role       = null;

        public Builder() {

        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userid(String userid) {
            this.userid = userid;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder enrollDate(Date enrollDate) {
            this.enrollDate = enrollDate;
            return this;
        }

        public Builder updateDate(Date updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Builder role(Byte role) {
            this.role = role;
            return this;
        }

        public UserVO build() {
            return new UserVO(this);
        }
    }

    public UserVO(Builder builder) {
        this.id = builder.id;
        this.userid = builder.userid;
        this.password = builder.password;
        this.nickname = builder.nickname;
        this.email = builder.email;
        this.enrollDate = builder.enrollDate;
        this.updateDate = builder.updateDate;
        this.role = builder.role;
    }

    public Long getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Byte getRole() {
        return role;
    }
}
