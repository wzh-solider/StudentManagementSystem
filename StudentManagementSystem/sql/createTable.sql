-- 创建学生表
CREATE TABLE t_student
(
    id    INT PRIMARY KEY auto_increment,
    NAME  VARCHAR(255) DEFAULT '',
    age   INT,
    sex   CHAR CHECK (
        sex IN ('男', '女')),
    grade VARCHAR(255) DEFAULT ''
) ENGINE = INNODB DEFAULT charset = utf8

-- 创建用户表
CREATE TABLE t_user
(
    id       INT PRIMARY KEY auto_increment,
    username VARCHAR(255) DEFAULT '',
    email    VARCHAR(255) DEFAULT '',
    PASSWORD VARCHAR(255) DEFAULT ''
) ENGINE = INNODB DEFAULT charset = utf8