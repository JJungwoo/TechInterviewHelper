-- users 테이블 생성

drop table if exists users;
drop SEQUENCE if exists Users_SEQ;

CREATE TABLE users
(
    id             number(10)    NOT NULL,
    userid         VARCHAR(45)     NOT NULL,
    password       VARCHAR(45)     NOT NULL,
    nickname       VARCHAR(45)     NOT NULL,
    email          VARCHAR(45)     NOT NULL,
    enroll_date    DATE            NOT NULL,
    update_date    DATE            NOT NULL,
    role           number(2)      NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY (id)
);

CREATE SEQUENCE Users_SEQ
MINVALUE 1
START WITH 1
INCREMENT BY 1;

-- problems 테이블 생성

drop table if exists Problems;
drop SEQUENCE if exists Problems_SEQ;

CREATE TABLE Problems
(
    pid             NUMBER(10, 0)    NOT NULL,
    title           VARCHAR2(100)    NULL,
    answer          CLOB             NULL,
    like_count      NUMBER(10, 0)    NULL,
    unlike_count    NUMBER(10, 0)    NULL,
    enroll_date     DATE             NOT NULL,
    update_date     DATE             NOT NULL,
    tid             NUMBER(10, 0)    NULL,
    CONSTRAINT PK_Problem PRIMARY KEY (pid)
);

CREATE SEQUENCE Problems_SEQ
MINVALUE 1
START WITH 1
INCREMENT BY 1;
