/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-06-02 09:50:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `principal` varchar(255) NOT NULL COMMENT '负责人',
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '收银部门', '小陈', '认真，负责');
INSERT INTO `dept` VALUES ('2', '销售部', '老王', '沉稳');
INSERT INTO `dept` VALUES ('3', '开发部', '峰哥', '耐心专研');
INSERT INTO `dept` VALUES ('4', '安保部', '晨晨', '聪明，能干');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(3) DEFAULT NULL,
  `dept` varchar(11) NOT NULL,
  `duty` varchar(255) DEFAULT NULL COMMENT '职务',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `fax` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '李四', '19', '男', '销售部', '销售员', '1541212313', 'as11d5a4', '河南', '1414556qq@.com', '13154646414');
INSERT INTO `emp` VALUES ('2', '李思思', '18', '女', '销售部', '总经理', '4672356', '134ds424', '河南', '1454qq.com', '14564616165');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `company` varchar(255) NOT NULL,
  `effectiveDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `instore`
-- ----------------------------
DROP TABLE IF EXISTS `instore`;
CREATE TABLE `instore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` varchar(255) NOT NULL,
  `did` int(11) NOT NULL,
  `wareName` varchar(255) NOT NULL,
  `joinTime` varchar(255) NOT NULL,
  `weight` double NOT NULL,
  `remark` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of instore
-- ----------------------------
INSERT INTO `instore` VALUES ('1', '4546461564', '1', '方便面', '2017-09-20', '16', '不好吃');
INSERT INTO `instore` VALUES ('2', '4a779d1cc88fea05f31b', '3', '火腿肠', '2017-11-01', '10', '好吃');
INSERT INTO `instore` VALUES ('3', '49e8b8afc1e1d4160b3b', '1', '橘子', '2017-7-01', '100', '好吃');
INSERT INTO `instore` VALUES ('4', '4187acef0b3f404e37aa', '1', '苹果', '2017-7-01', '19', '');
INSERT INTO `instore` VALUES ('5', '4d76b6f094abf2821a22', '1', '黄瓜', '2017-7-01', '50', '好吃');
INSERT INTO `instore` VALUES ('6', '4cbd9e0aee70ddb34128', '1', '香蕉', '2017-06-01', '80', '特好吃');
INSERT INTO `instore` VALUES ('7', '4164829a8ca992519e8e', '1', '芒果', '2017-06-01', '200', '不好吃');

-- ----------------------------
-- Table structure for `outstore`
-- ----------------------------
DROP TABLE IF EXISTS `outstore`;
CREATE TABLE `outstore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) NOT NULL,
  `wareName` varchar(255) NOT NULL,
  `outTime` varchar(255) NOT NULL,
  `weight` double NOT NULL,
  `remark` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outstore
-- ----------------------------
INSERT INTO `outstore` VALUES ('4', '1', '火腿肠', '2017-3-01', '20', '好吃');
INSERT INTO `outstore` VALUES ('5', '4', '方便面', '2017-3-01', '12.6', '好吃');
INSERT INTO `outstore` VALUES ('6', '1', '牙刷', '2017-6-01', '60', '...');
INSERT INTO `outstore` VALUES ('7', '1', '毛巾', '2017-6-01', '85', '.。。');
INSERT INTO `outstore` VALUES ('8', '1', '羽毛球', '2017-5-31', '10', '好玩');
INSERT INTO `outstore` VALUES ('9', '1', '足球', '2017-5-31', '100', '.。。');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `khm` varchar(255) NOT NULL,
  `orderNum` varchar(255) NOT NULL,
  `pushDate` date DEFAULT NULL,
  `productName` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `count` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('7', '张三', '4d0083b1500fbc9109e1', '2017-06-01', '方便面', '10000', '10000', '1');
INSERT INTO `purchase` VALUES ('8', '李四', '4af5bec5257ecd7582a8', '2017-06-01', '火腿肠', '100', '100', '0');

-- ----------------------------
-- Table structure for `seller`
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sid` int(20) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('1', '玲珑科技', '玲珑科技', '郑州', '张三', '464646465', '466757', '15454564qq@.com', 'www.baidu.com', '46545646456', '人不错', '466231');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` tinyint(3) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '001');
