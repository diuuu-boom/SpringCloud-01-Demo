drop database if exists springcloud01_app;
create database springcloud01_app character set utf8;
use springcloud01_app;
create table user_wx(
	userId bigint(11) primary key auto_increment not null,
    username varchar(25) ,
    `password` varchar(255),
    age int(10),
    gender int(1),
    hobby varchar(255),
    db_source varchar(25)
);

insert into user_wx(username,`password`,age,gender,hobby,db_source) values('小明','123456',18,1,'打篮球',database());
insert into user_wx(username,`password`,age,gender,hobby,db_source) values('小红','123456',19,0,'逛街',database());
insert into user_wx(username,`password`,age,gender,hobby,db_source) values('小莉','123456',17,0,'健身',database());
insert into user_wx(username,`password`,age,gender,hobby,db_source) values('小刚','123456',20,1,'踢足球',database());
insert into user_wx(username,`password`,age,gender,hobby,db_source) values('小强','123456',23,1,'看书',database());

select * from user_wx;
-- 
alter user 'root'@'localhost' identified with mysql_native_password by '123456';

flush privileges;

select * from mysql.user;
