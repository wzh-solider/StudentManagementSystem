-- 创建学生表
create table t_student
(
    id    int primary key auto_increment,
    name  varchar(255) default '',
    age   int,
    sex   char check (sex in ('男', '女')),
    grade varchar(255) default ''
)engine=INNODB default charset=utf8

-- 创建用户表
create table t_user
(
    id       int primary key auto_increment,
    username varchar(255) default '',
    email    varchar(255) default '',
    password varchar(255) default ''
)engine=INNODB default charset=utf8