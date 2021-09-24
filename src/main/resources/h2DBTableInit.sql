-- 유저 테이블 생성

CREATE TABLE Users
(
    `id`           NUMBER(10, 0)    NOT NULL    AUTO_INCREMENT COMMENT 'id',
    `userid`       VARCHAR(45)      NOT NULL    COMMENT 'userId',
    `password`     VARCHAR(45)      NOT NULL    COMMENT 'password',
    `nickname`     VARCHAR(45)      NOT NULL    COMMENT 'nickname',
    `email`        VARCHAR(45)      NOT NULL    COMMENT 'email',
    `enroll_date`  DATE             NOT NULL    COMMENT 'enroll_date',
    `update_date`  DATE             NOT NULL    COMMENT 'update_date',
    `role`         NUMBER(2, 0)     NOT NULL    COMMENT 'role',
    CONSTRAINT PK_User PRIMARY KEY (id)
);

-- 문제 테이블 생성

CREATE TABLE Problem
(
    `pid`           NUMBER(10, 0)    NOT NULL    AUTO_INCREMENT COMMENT 'problem id',
    `title`         TEXT             NULL        COMMENT 'title',
    `answer`        TEXT             NULL        COMMENT 'answer',
    `like_count`    NUMBER(10, 0)    NULL        COMMENT 'like_count',
    `unlike_count`  NUMBER(10, 0)    NULL        COMMENT 'unlike_count',
    `enroll_date`   DATE             NOT NULL    COMMENT 'enroll_date',
    `update_date`   DATE             NOT NULL    COMMENT 'update_date',
    `tid`           NUMBER(10, 0)    NULL        COMMENT 'tag id',
    CONSTRAINT PK_Problem PRIMARY KEY (pid)
);

ALTER TABLE Problem
    ADD CONSTRAINT FK_Problem_tid_ProblemTag_tid FOREIGN KEY (tid)
        REFERENCES ProblemTag (tid) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE Problem
    ADD CONSTRAINT FK_Problem_pid_ProblemToPackage_pid FOREIGN KEY (pid)
        REFERENCES ProblemToPackage (pid) ON DELETE RESTRICT ON UPDATE RESTRICT;