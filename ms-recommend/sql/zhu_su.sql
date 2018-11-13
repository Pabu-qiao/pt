/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : putai

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-13 10:09:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zhu_su
-- ----------------------------
DROP TABLE IF EXISTS `zhu_su`;
CREATE TABLE `zhu_su` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `fang_an_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fang_an_id` (`fang_an_id`),
  CONSTRAINT `fang_an_id` FOREIGN KEY (`fang_an_id`) REFERENCES `fang_an` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhu_su
-- ----------------------------
INSERT INTO `zhu_su` VALUES ('1', '头疼', '1');
INSERT INTO `zhu_su` VALUES ('2', '闹热', '2');
INSERT INTO `zhu_su` VALUES ('3', '胸闷', '1');
