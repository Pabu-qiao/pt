/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : putai

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-13 10:09:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fang_an
-- ----------------------------
DROP TABLE IF EXISTS `fang_an`;
CREATE TABLE `fang_an` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `jia_ge` decimal(10,0) DEFAULT NULL,
  `shi_chang` int(11) DEFAULT NULL,
  `re_du` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fang_an
-- ----------------------------
INSERT INTO `fang_an` VALUES ('1', '肩颈痛调理', '298', null, null);
INSERT INTO `fang_an` VALUES ('2', '腰椎疼痛调理', '498', null, null);
INSERT INTO `fang_an` VALUES ('3', '女子胞宫调理', '498', null, null);
INSERT INTO `fang_an` VALUES ('4', '生命能量补济', '698', null, null);
INSERT INTO `fang_an` VALUES ('5', '好睡深眠', '598', null, null);
INSERT INTO `fang_an` VALUES ('6', '焕颜活肤', '398', null, null);
INSERT INTO `fang_an` VALUES ('7', '风湿调理', '6980', null, null);
INSERT INTO `fang_an` VALUES ('8', '静脉曲张调理', '3980', null, null);
INSERT INTO `fang_an` VALUES ('9', '皮肤问题调理', '1980', null, null);
