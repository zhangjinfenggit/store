/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2017-05-26 18:39:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `seller`
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sid` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `khm` varchar(20) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `connecter` varchar(20) DEFAULT NULL,
  `contel` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `wsite` varchar(30) DEFAULT NULL,
  `account` varchar(25) DEFAULT NULL,
  `description` text,
  `postCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('1', '张三', '李四', '河南', '王五', '18838928206', '121-45-656-789', '1412619418@qq.com', 'www.baidu.com', '1457456464564674', '很好', '466231');
