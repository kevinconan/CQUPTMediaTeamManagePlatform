/*
Navicat MySQL Data Transfer

Source Server         : kevin
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : team

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2013-05-29 12:24:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `meeting`
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `MEETING_TIME` varchar(15) NOT NULL COMMENT '记录时间',
  `MEETING_ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `MEETING_NAME` varchar(50) NOT NULL COMMENT '会议名称',
  `MEETING_CONTENT` varchar(5000) DEFAULT NULL COMMENT '会议内容',
  `MEETING_RECPEO` varchar(15) DEFAULT NULL COMMENT '会议记录人',
  `MEETING_PEONUM` int(5) NOT NULL COMMENT '参会人数',
  PRIMARY KEY (`MEETING_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meeting
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` int(10) NOT NULL DEFAULT '0' COMMENT '编号',
  `USER_PASSWORD` varchar(40) DEFAULT NULL COMMENT '密码',
  `USER_PERMISSION` int(1) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
