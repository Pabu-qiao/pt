/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : putai

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-12 11:21:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fu_wu
-- ----------------------------
DROP TABLE IF EXISTS `fu_wu`;
CREATE TABLE `fu_wu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ying_wen_ming` varchar(32) DEFAULT NULL,
  `zhong_wen_ming` varchar(32) DEFAULT NULL,
  `shi_chang` int(11) DEFAULT NULL,
  `re_du` int(11) DEFAULT NULL,
  `jia_ge` decimal(12,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fu_wu
-- ----------------------------
INSERT INTO `fu_wu` VALUES ('1', 'blood-lipid', '朴泰血脂调理仪', '1', '1', '200');
INSERT INTO `fu_wu` VALUES ('2', 'chinese-yew', '朴泰红豆杉酵素浴', '2', '2', '300');
INSERT INTO `fu_wu` VALUES ('3', 'energy-balance', '朴泰多功能能量调理仪', '3', '3', '100');
INSERT INTO `fu_wu` VALUES ('4', 'foot-bath-barre', '朴泰远红外碳晶足浴桶', '4', '4', '500');
INSERT INTO `fu_wu` VALUES ('5', 'infra-red', '朴泰悬灸仪', '5', '5', '20');
INSERT INTO `fu_wu` VALUES ('6', 'manual', '手法调理', '6', '6', '310');
INSERT INTO `fu_wu` VALUES ('7', 'moxibustion', '朴泰无烟三节豪华艾灸舱', '7', '7', '120');
INSERT INTO `fu_wu` VALUES ('8', 'space-capsule', '朴泰远红外线3D艾灸舱', '8', '8', '210');
INSERT INTO `fu_wu` VALUES ('9', 'three-dimensional', '朴泰三维立体共振调理仪', '9', '9', '110');
INSERT INTO `fu_wu` VALUES ('10', 'little_bubble', '小气泡', '10', '10', '300');
