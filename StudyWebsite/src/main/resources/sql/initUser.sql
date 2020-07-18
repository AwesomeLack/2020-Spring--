CREATE DATABASE IF NOT EXISTS `springboot`;
USE `springboot`;
CREATE TABLE `study_user` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `name` varchar(10) DEFAULT NULL COMMENT '名字',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `department` varchar(20) DEFAULT NULL COMMENT '学院',
  `stu_id` int(10) DEFAULT NULL COMMENT '学号',
  `gender` int(2) DEFAULT NULL COMMENT '性别女0男1',
  CONSTRAINT gender CHECK (gender in(0,1)),
  `grade` varchar(10) DEFAULT NULL COMMENT '年级',
  `major` varchar(50) DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

# INSERT INTO study_user(
#                        `username`,`password`,`name`,`phone`,`department`,`stu_id`,`gender`,`grade`,`major`)
#                        VALUES (
#                                 'lack','lack123','卢臻玄','15217896768','计算机科学学院','41712239',1,'2017级','软件工程'
#                               );