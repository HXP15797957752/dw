/*
Navicat MySQL Data Transfer

Source Server         : jdbc
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : dw

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-04-13 22:39:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `database_info`
-- ----------------------------
DROP TABLE IF EXISTS `database_info`;
CREATE TABLE `database_info` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `database_description` varchar(64) NOT NULL,
  `ip` varchar(64) NOT NULL,
  `port` int(32) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `ctime` date NOT NULL,
  `mtime` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of database_info
-- ----------------------------
INSERT INTO `database_info` VALUES ('1', '这是数据库信息描述', '10.13.69.32', '8080', 'admin', '325682', '2020-04-01', '2020-04-01');
INSERT INTO `database_info` VALUES ('2', '这是数据库信息描述', '10.13.69.32', '8080', 'zhan', '85724', '2020-04-01', '2020-04-01');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(128) NOT NULL,
  `owner` varchar(64) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `mtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------

-- ----------------------------
-- Table structure for `dispatcher_project`
-- ----------------------------
DROP TABLE IF EXISTS `dispatcher_project`;
CREATE TABLE `dispatcher_project` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(128) NOT NULL,
  `username` varchar(64) NOT NULL,
  `job_name` varchar(64) NOT NULL,
  `main_jar` varchar(64) NOT NULL,
  `dependency_jar` varchar(64) DEFAULT NULL,
  `main_class` varchar(64) NOT NULL,
  `job_parameter` varchar(64) DEFAULT NULL,
  `finished_notify` int(8) DEFAULT NULL COMMENT '0 通知 1 不通知',
  `ctime` date DEFAULT NULL,
  `mtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dispatcher_project
-- ----------------------------
INSERT INTO `dispatcher_project` VALUES ('1', '', 'hxp', 'job1', 'xxxx.jar', 'xxx1.jar', 'com.java.main', 'opts : -jvm', '0', '2020-04-02', '2020-04-02');
INSERT INTO `dispatcher_project` VALUES ('2', '', 'hxp', 'job1', 'xxxx.jar', 'xxx1.jar', 'com.java.main', 'opts : -jvm', '0', '2020-04-02', '2020-04-02');
INSERT INTO `dispatcher_project` VALUES ('3', '', 'hxp', 'job3', 'huangxiap.jar', '', 'com.hxp.main.class', '', '0', '2020-04-02', '2020-04-02');
INSERT INTO `dispatcher_project` VALUES ('4', '', 'hxp', 'job3', 'huangxiap.jar', '', 'com.hxp.main.class', '', '0', '2020-04-02', '2020-04-02');
INSERT INTO `dispatcher_project` VALUES ('5', '', 'hxp', 'job3', 'huangxiap.jar', '', 'com.hxp.main.class', '', '0', '2020-04-02', '2020-04-02');

-- ----------------------------
-- Table structure for `integration_task`
-- ----------------------------
DROP TABLE IF EXISTS `integration_task`;
CREATE TABLE `integration_task` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `task_name` varchar(128) NOT NULL,
  `data_source_description` varchar(128) NOT NULL,
  `department_name` varchar(128) NOT NULL,
  `project_name` varchar(128) NOT NULL,
  `serve_name` varchar(128) NOT NULL,
  `ip` varchar(64) NOT NULL,
  `port` int(16) NOT NULL,
  `database_name` varchar(64) NOT NULL,
  `database_table_name` varchar(64) NOT NULL,
  `has_sub_table` int(2) NOT NULL,
  `is_create_hive_table` int(2) NOT NULL,
  `sync_strategy` varchar(64) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `mtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integration_task
-- ----------------------------

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(128) NOT NULL,
  `username` varchar(64) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `mtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', 'file', 'hxp', '2020-04-13 16:59:04', '2020-04-13 16:59:04');
INSERT INTO `resource` VALUES ('2', '江西农业大学毕业论文-黄小平-v1.0.doc', 'hxp', '2020-04-13 17:02:07', '2020-04-13 17:02:07');
INSERT INTO `resource` VALUES ('3', '', 'hxp', '2020-04-13 17:07:21', '2020-04-13 17:07:21');
INSERT INTO `resource` VALUES ('4', '江西农业大学毕业论文-黄小平 -v2.1.doc', 'hxp', '2020-04-13 17:07:50', '2020-04-13 17:07:50');

-- ----------------------------
-- Table structure for `sql_history`
-- ----------------------------
DROP TABLE IF EXISTS `sql_history`;
CREATE TABLE `sql_history` (
  `id` tinyint(64) NOT NULL AUTO_INCREMENT,
  `sql_context` varchar(128) NOT NULL,
  `username` varchar(64) NOT NULL,
  `status` int(8) DEFAULT NULL,
  `ctime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `mtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sql_history
-- ----------------------------
INSERT INTO `sql_history` VALUES ('1', 'select * from sql_history', 'hxp', '0', '2020-04-07 20:20:37', '2020-04-07 20:20:43');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(64) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `status` int(8) DEFAULT '0' COMMENT '离职状态 -> 0: 在职, 1: 离职, -1: 未知',
  `email` varchar(64) DEFAULT NULL,
  `department_id` int(64) DEFAULT NULL,
  `ctime` varchar(255) NOT NULL,
  `mtime` date NOT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'hxp', 'hxp', '123', '0', 'hxp@qq.com', '2', '2020-04-01', '2020-04-01');
INSERT INTO `user` VALUES ('2', 'huangxiaoping', 'hxp', '123', '0', 'hxp@qq.com', '2', '23:36:48', '2020-04-01');
INSERT INTO `user` VALUES ('3', 'zhan', '平子', '123', null, 'admin@qq.com', null, '01:53:35', '2020-04-02');
