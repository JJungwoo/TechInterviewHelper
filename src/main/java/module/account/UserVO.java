package module.account;

import java.sql.*;

public class UserVO {
    private Long id;
    private String userid;
    private String password;
    private String nickname;
    private String email;
    private Date enroll_date;
    private Date update_date;
    private Byte role;

    public UserVO() {

    }

    public static class Builder {

        // 필수 항목들
        private Long id;

        // 추가 항목들
        private String userid   = null;
        private String password = null;
        private String nickname = null;
        private String email    = null;
        private Date enroll_date= null;
        private Date update_date= null;
        private Byte role       = null;

        public Builder(Long id) {
            this.id = id;
        }

        public Builder setUserid(String userid) {
            this.userid = userid;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setEnroll_date(Date enroll_date) {
            this.enroll_date = enroll_date;
            return this;
        }

        public Builder setUpdate_date(Date update_date) {
            this.update_date = update_date;
            return this;
        }

        public Builder setRole(Byte role) {
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
        this.enroll_date = builder.enroll_date;
        this.update_date = builder.update_date;
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

    public Date getEnroll_date() {
        return enroll_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public Byte getRole() {
        return role;
    }
}
