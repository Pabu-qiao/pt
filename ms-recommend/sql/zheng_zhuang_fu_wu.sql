/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : putai

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-12 11:22:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zheng_zhuang_fu_wu
-- ----------------------------
DROP TABLE IF EXISTS `zheng_zhuang_fu_wu`;
CREATE TABLE `zheng_zhuang_fu_wu` (
  `zheng_zhuang_id` int(11) NOT NULL,
  `fu_wu_id` int(11) NOT NULL,
  PRIMARY KEY (`zheng_zhuang_id`,`fu_wu_id`),
  KEY `machine_id` (`fu_wu_id`),
  CONSTRAINT `machine_id` FOREIGN KEY (`fu_wu_id`) REFERENCES `fu_wu` (`id`),
  CONSTRAINT `symptom_id` FOREIGN KEY (`zheng_zhuang_id`) REFERENCES `zheng_zhuang` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zheng_zhuang_fu_wu
-- ----------------------------
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('121', '1');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('122', '1');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('123', '1');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('1', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('2', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('3', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('4', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('5', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('6', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('7', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('8', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('9', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('10', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('11', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('12', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('13', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('14', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('15', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('16', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('17', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('18', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('19', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('20', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('21', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('22', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('23', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('24', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('25', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('26', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('27', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('28', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('29', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('30', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('31', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('32', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('33', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('34', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('35', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('36', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('37', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('38', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('39', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('40', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('41', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('42', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('43', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('44', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('45', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('46', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('47', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('48', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('49', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('50', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('51', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('52', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('53', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('54', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('55', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('56', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('57', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('58', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('59', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('60', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('61', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('62', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('63', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('64', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('65', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('66', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('67', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('68', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('69', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('70', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('71', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('72', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('73', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('74', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('75', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('76', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('77', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('78', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('79', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('80', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('81', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('82', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('83', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('84', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('85', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('86', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('87', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('88', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('89', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('90', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('96', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('97', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('98', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('99', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('100', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('101', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('102', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('103', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('104', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('105', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('106', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('107', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('108', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('109', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('110', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('111', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('112', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('113', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('121', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('122', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('123', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('124', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('125', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('126', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('127', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('128', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('129', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('130', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('131', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('132', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('133', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('134', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('135', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('136', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('137', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('138', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('139', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('140', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('141', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('142', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('143', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('144', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('145', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('146', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('147', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('148', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('149', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('150', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('151', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('152', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('153', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('154', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('155', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('156', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('157', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('158', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('159', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('160', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('161', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('162', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('163', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('164', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('165', '2');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('1', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('2', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('3', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('4', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('5', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('6', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('7', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('121', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('122', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('123', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('124', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('125', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('126', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('127', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('128', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('129', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('130', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('131', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('132', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('133', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('134', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('150', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('151', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('152', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('153', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('154', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('155', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('156', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('157', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('158', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('159', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('160', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('161', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('162', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('163', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('164', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('165', '3');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('15', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('16', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('17', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('18', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('19', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('20', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('21', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('22', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('23', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('24', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('25', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('26', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('27', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('28', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('29', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('30', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('31', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('32', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('33', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('34', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('35', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('36', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('37', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('38', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('39', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('40', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('41', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('42', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('43', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('44', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('45', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('46', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('47', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('48', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('49', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('50', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('51', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('52', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('53', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('54', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('55', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('56', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('57', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('58', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('59', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('60', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('61', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('62', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('63', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('64', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('65', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('66', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('67', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('68', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('69', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('70', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('71', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('72', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('73', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('74', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('75', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('76', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('77', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('78', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('79', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('80', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('81', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('82', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('83', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('84', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('85', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('86', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('87', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('88', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('89', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('90', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('114', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('115', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('116', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('117', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('118', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('119', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('120', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('150', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('151', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('152', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('153', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('154', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('155', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('156', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('157', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('158', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('159', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('160', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('161', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('162', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('163', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('164', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('165', '4');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('114', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('115', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('116', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('117', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('118', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('119', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('120', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('150', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('151', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('152', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('153', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('154', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('155', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('156', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('157', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('158', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('159', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('160', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('161', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('162', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('163', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('164', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('165', '5');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('1', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('2', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('3', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('4', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('5', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('6', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('7', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('15', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('16', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('17', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('18', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('19', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('20', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('21', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('22', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('23', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('24', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('25', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('26', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('27', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('28', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('29', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('30', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('31', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('32', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('33', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('34', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('35', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('36', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('37', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('38', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('39', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('40', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('41', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('42', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('43', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('44', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('45', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('46', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('47', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('48', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('49', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('50', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('51', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('52', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('53', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('54', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('55', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('56', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('57', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('58', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('59', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('60', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('61', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('62', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('63', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('64', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('65', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('66', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('67', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('68', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('69', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('70', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('71', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('72', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('73', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('74', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('75', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('76', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('77', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('78', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('79', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('80', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('81', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('82', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('83', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('84', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('85', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('86', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('87', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('88', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('89', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('90', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('91', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('92', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('93', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('94', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('95', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('96', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('97', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('98', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('99', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('100', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('101', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('102', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('103', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('104', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('105', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('106', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('107', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('108', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('109', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('110', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('111', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('112', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('113', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('114', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('115', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('116', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('117', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('118', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('119', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('120', '6');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('1', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('2', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('3', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('4', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('5', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('6', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('7', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('15', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('16', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('17', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('18', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('19', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('20', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('21', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('22', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('23', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('24', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('25', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('26', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('114', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('115', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('116', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('117', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('118', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('119', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('120', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('135', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('136', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('137', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('138', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('139', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('140', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('141', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('142', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('143', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('144', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('145', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('146', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('147', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('148', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('149', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('150', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('151', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('152', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('153', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('154', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('155', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('156', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('157', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('158', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('159', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('160', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('161', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('162', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('163', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('164', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('165', '7');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('15', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('16', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('17', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('18', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('19', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('20', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('21', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('22', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('23', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('24', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('25', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('26', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('96', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('97', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('98', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('99', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('100', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('101', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('102', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('103', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('104', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('105', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('106', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('107', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('108', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('109', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('110', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('111', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('112', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('113', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('114', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('115', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('116', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('117', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('118', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('119', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('120', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('135', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('136', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('137', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('138', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('139', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('140', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('141', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('142', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('143', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('144', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('145', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('146', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('147', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('148', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('149', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('150', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('151', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('152', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('153', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('154', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('155', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('156', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('157', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('158', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('159', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('160', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('161', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('162', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('163', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('164', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('165', '8');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('1', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('2', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('3', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('4', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('5', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('6', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('7', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('8', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('9', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('10', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('11', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('12', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('13', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('14', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('15', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('16', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('17', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('18', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('19', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('20', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('21', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('22', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('23', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('24', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('25', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('26', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('27', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('28', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('29', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('30', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('31', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('32', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('33', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('34', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('35', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('36', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('37', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('38', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('39', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('40', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('41', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('42', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('43', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('44', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('45', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('46', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('47', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('48', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('49', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('50', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('51', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('52', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('53', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('54', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('55', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('56', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('57', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('58', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('59', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('60', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('61', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('62', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('63', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('64', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('65', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('66', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('67', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('68', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('69', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('70', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('71', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('72', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('73', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('74', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('75', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('76', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('77', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('78', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('79', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('80', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('81', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('82', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('83', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('84', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('85', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('86', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('87', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('88', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('89', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('90', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('91', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('92', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('93', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('94', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('95', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('96', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('97', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('98', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('99', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('100', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('101', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('102', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('103', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('104', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('105', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('106', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('107', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('108', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('109', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('110', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('111', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('112', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('113', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('121', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('122', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('123', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('124', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('125', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('126', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('127', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('128', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('129', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('130', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('131', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('132', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('133', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('134', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('135', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('136', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('137', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('138', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('139', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('140', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('141', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('142', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('143', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('144', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('145', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('146', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('147', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('148', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('149', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('150', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('151', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('152', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('153', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('154', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('155', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('156', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('157', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('158', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('159', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('160', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('161', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('162', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('163', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('164', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('165', '9');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('166', '10');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('167', '10');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('168', '10');
INSERT INTO `zheng_zhuang_fu_wu` VALUES ('169', '10');
