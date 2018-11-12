/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : putai

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-12 11:21:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zheng_zhuang
-- ----------------------------
DROP TABLE IF EXISTS `zheng_zhuang`;
CREATE TABLE `zheng_zhuang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fen_lei` varchar(32) DEFAULT NULL,
  `zheng_zhuang` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zheng_zhuang
-- ----------------------------
INSERT INTO `zheng_zhuang` VALUES ('1', '睡眠质量调理', '入睡困难');
INSERT INTO `zheng_zhuang` VALUES ('2', '睡眠质量调理', '多梦');
INSERT INTO `zheng_zhuang` VALUES ('3', '睡眠质量调理', '易醒');
INSERT INTO `zheng_zhuang` VALUES ('4', '睡眠质量调理', '早醒');
INSERT INTO `zheng_zhuang` VALUES ('5', '睡眠质量调理', '醒后疲劳、精神差醒');
INSERT INTO `zheng_zhuang` VALUES ('6', '睡眠质量调理', '梦游');
INSERT INTO `zheng_zhuang` VALUES ('7', '睡眠质量调理', '失眠');
INSERT INTO `zheng_zhuang` VALUES ('8', '减重、出汗', '手臂');
INSERT INTO `zheng_zhuang` VALUES ('9', '减重、出汗', '腹部');
INSERT INTO `zheng_zhuang` VALUES ('10', '减重、出汗', '腰部');
INSERT INTO `zheng_zhuang` VALUES ('11', '减重、出汗', '背部');
INSERT INTO `zheng_zhuang` VALUES ('12', '减重、出汗', '大腿');
INSERT INTO `zheng_zhuang` VALUES ('13', '减重、出汗', '小腿');
INSERT INTO `zheng_zhuang` VALUES ('14', '减重、出汗', '面部');
INSERT INTO `zheng_zhuang` VALUES ('15', '肝胆调理', '食欲减退、厌油');
INSERT INTO `zheng_zhuang` VALUES ('16', '肝胆调理', '乏力、易疲、思睡');
INSERT INTO `zheng_zhuang` VALUES ('17', '肝胆调理', '皮肤、巩膜等黄染');
INSERT INTO `zheng_zhuang` VALUES ('18', '肝胆调理', '牙龈出血');
INSERT INTO `zheng_zhuang` VALUES ('19', '肝胆调理', '鼻出血');
INSERT INTO `zheng_zhuang` VALUES ('20', '肝胆调理', '口干');
INSERT INTO `zheng_zhuang` VALUES ('21', '肝胆调理', '大便干或溏');
INSERT INTO `zheng_zhuang` VALUES ('22', '肝胆调理', '头晕耳鸣');
INSERT INTO `zheng_zhuang` VALUES ('23', '肝胆调理', '面色萎黄');
INSERT INTO `zheng_zhuang` VALUES ('24', '肝胆调理', '胁肋疼痛');
INSERT INTO `zheng_zhuang` VALUES ('25', '肝胆调理', '月经量少');
INSERT INTO `zheng_zhuang` VALUES ('26', '肝胆调理', '体重减少');
INSERT INTO `zheng_zhuang` VALUES ('27', '肝肾亏虚调理', '头晕目眩');
INSERT INTO `zheng_zhuang` VALUES ('28', '肝肾亏虚调理', '耳鸣健忘');
INSERT INTO `zheng_zhuang` VALUES ('29', '肝肾亏虚调理', '失眠多梦');
INSERT INTO `zheng_zhuang` VALUES ('30', '肝肾亏虚调理', '咽干口燥');
INSERT INTO `zheng_zhuang` VALUES ('31', '肝肾亏虚调理', '腰膝酸软');
INSERT INTO `zheng_zhuang` VALUES ('32', '肝肾亏虚调理', '胁肋胀痛');
INSERT INTO `zheng_zhuang` VALUES ('33', '肝肾亏虚调理', '视物不清');
INSERT INTO `zheng_zhuang` VALUES ('34', '肝肾亏虚调理', '五心烦热');
INSERT INTO `zheng_zhuang` VALUES ('35', '肝肾亏虚调理', '掉发');
INSERT INTO `zheng_zhuang` VALUES ('36', '肝肾亏虚调理', '颧红盗汗');
INSERT INTO `zheng_zhuang` VALUES ('37', '肝肾亏虚调理', '男子遗精');
INSERT INTO `zheng_zhuang` VALUES ('38', '肝肾亏虚调理', '女子经少或闭经');
INSERT INTO `zheng_zhuang` VALUES ('39', '肝肾亏虚调理', '舌红少苔');
INSERT INTO `zheng_zhuang` VALUES ('40', '脾胃肠道调理', '饮食情况正常');
INSERT INTO `zheng_zhuang` VALUES ('41', '脾胃肠道调理', '素食');
INSERT INTO `zheng_zhuang` VALUES ('42', '脾胃肠道调理', '生冷');
INSERT INTO `zheng_zhuang` VALUES ('43', '脾胃肠道调理', '辛辣');
INSERT INTO `zheng_zhuang` VALUES ('44', '脾胃肠道调理', '油腻');
INSERT INTO `zheng_zhuang` VALUES ('45', '脾胃肠道调理', '便秘');
INSERT INTO `zheng_zhuang` VALUES ('46', '脾胃肠道调理', '胃痛');
INSERT INTO `zheng_zhuang` VALUES ('47', '脾胃肠道调理', '腹痛');
INSERT INTO `zheng_zhuang` VALUES ('48', '脾胃肠道调理', '泄泻');
INSERT INTO `zheng_zhuang` VALUES ('49', '脾胃肠道调理', '脘腹胀满');
INSERT INTO `zheng_zhuang` VALUES ('50', '脾胃肠道调理', '肢体困倦');
INSERT INTO `zheng_zhuang` VALUES ('51', '脾胃肠道调理', '尿少色黄');
INSERT INTO `zheng_zhuang` VALUES ('52', '脾胃肠道调理', '大便溏泄不爽');
INSERT INTO `zheng_zhuang` VALUES ('53', '脾胃肠道调理', '纳少厌食');
INSERT INTO `zheng_zhuang` VALUES ('54', '脾胃肠道调理', '恶心呕吐');
INSERT INTO `zheng_zhuang` VALUES ('55', '脾胃肠道调理', '面黄');
INSERT INTO `zheng_zhuang` VALUES ('56', '脾胃肠道调理', '皮肤发痒');
INSERT INTO `zheng_zhuang` VALUES ('57', '脾胃肠道调理', '身热起伏');
INSERT INTO `zheng_zhuang` VALUES ('58', '脾胃肠道调理', '汗出不解');
INSERT INTO `zheng_zhuang` VALUES ('59', '脾胃肠道调理', '舌红苔黄腻');
INSERT INTO `zheng_zhuang` VALUES ('60', '脾胃肠道调理', '呕吐');
INSERT INTO `zheng_zhuang` VALUES ('61', '脾胃肠道调理', '泄泻');
INSERT INTO `zheng_zhuang` VALUES ('62', '脾胃肠道调理', '水肿');
INSERT INTO `zheng_zhuang` VALUES ('63', '脾胃肠道调理', '便血');
INSERT INTO `zheng_zhuang` VALUES ('64', '脾胃肠道调理', '喜按');
INSERT INTO `zheng_zhuang` VALUES ('65', '脾胃肠道调理', '胀满');
INSERT INTO `zheng_zhuang` VALUES ('66', '脾胃肠道调理', '经闭');
INSERT INTO `zheng_zhuang` VALUES ('67', '脾胃肠道调理', '带下');
INSERT INTO `zheng_zhuang` VALUES ('68', '脾胃肠道调理', '四肢逆冷');
INSERT INTO `zheng_zhuang` VALUES ('69', '心肺调理', '呼吸困难');
INSERT INTO `zheng_zhuang` VALUES ('70', '心肺调理', '无力');
INSERT INTO `zheng_zhuang` VALUES ('71', '心肺调理', '嘴唇发绀');
INSERT INTO `zheng_zhuang` VALUES ('72', '心肺调理', '静脉怒张');
INSERT INTO `zheng_zhuang` VALUES ('73', '心肺调理', '水肿');
INSERT INTO `zheng_zhuang` VALUES ('74', '心肺调理', '咳嗽');
INSERT INTO `zheng_zhuang` VALUES ('75', '心肺调理', '咯血');
INSERT INTO `zheng_zhuang` VALUES ('76', '心肺调理', '心慌');
INSERT INTO `zheng_zhuang` VALUES ('77', '心肺调理', '气短');
INSERT INTO `zheng_zhuang` VALUES ('78', '心肺调理', '胸闷');
INSERT INTO `zheng_zhuang` VALUES ('79', '心肺调理', '头晕');
INSERT INTO `zheng_zhuang` VALUES ('80', '心肺调理', '晕厥');
INSERT INTO `zheng_zhuang` VALUES ('81', '心肺调理', '局部发紫');
INSERT INTO `zheng_zhuang` VALUES ('82', '心肺调理', '下肢水肿');
INSERT INTO `zheng_zhuang` VALUES ('83', '阳虚体质调理', '手脚冰凉');
INSERT INTO `zheng_zhuang` VALUES ('84', '阳虚体质调理', '膝盖发凉');
INSERT INTO `zheng_zhuang` VALUES ('85', '阳虚体质调理', '后背发凉');
INSERT INTO `zheng_zhuang` VALUES ('86', '阳虚体质调理', '胸腹发凉');
INSERT INTO `zheng_zhuang` VALUES ('87', '阳虚体质调理', '脚踝怕凉');
INSERT INTO `zheng_zhuang` VALUES ('88', '阳虚体质调理', '怕冷');
INSERT INTO `zheng_zhuang` VALUES ('89', '阳虚体质调理', '怕热');
INSERT INTO `zheng_zhuang` VALUES ('90', '阳虚体质调理', '上热下寒');
INSERT INTO `zheng_zhuang` VALUES ('91', '前列腺保养', '排尿困难');
INSERT INTO `zheng_zhuang` VALUES ('92', '前列腺保养', '尿不尽');
INSERT INTO `zheng_zhuang` VALUES ('93', '前列腺保养', '疼痛症状');
INSERT INTO `zheng_zhuang` VALUES ('94', '前列腺保养', '性功能障碍');
INSERT INTO `zheng_zhuang` VALUES ('95', '前列腺保养', '神经衰弱');
INSERT INTO `zheng_zhuang` VALUES ('96', '骨关节、肌肉、脊椎（疼痛）', '风湿');
INSERT INTO `zheng_zhuang` VALUES ('97', '骨关节、肌肉、脊椎（疼痛）', '类风湿');
INSERT INTO `zheng_zhuang` VALUES ('98', '骨关节、肌肉、脊椎（疼痛）', '肌肉酸痛');
INSERT INTO `zheng_zhuang` VALUES ('99', '骨关节、肌肉、脊椎（疼痛）', '肌肉胀痛');
INSERT INTO `zheng_zhuang` VALUES ('100', '骨关节、肌肉、脊椎（疼痛）', '颈椎');
INSERT INTO `zheng_zhuang` VALUES ('101', '骨关节、肌肉、脊椎（疼痛）', '胸椎');
INSERT INTO `zheng_zhuang` VALUES ('102', '骨关节、肌肉、脊椎（疼痛）', '腰椎');
INSERT INTO `zheng_zhuang` VALUES ('103', '骨关节、肌肉、脊椎（疼痛）', '肩关节');
INSERT INTO `zheng_zhuang` VALUES ('104', '骨关节、肌肉、脊椎（疼痛）', '肘关节');
INSERT INTO `zheng_zhuang` VALUES ('105', '骨关节、肌肉、脊椎（疼痛）', '腕关节');
INSERT INTO `zheng_zhuang` VALUES ('106', '骨关节、肌肉、脊椎（疼痛）', '指关节');
INSERT INTO `zheng_zhuang` VALUES ('107', '骨关节、肌肉、脊椎（疼痛）', '髋关节');
INSERT INTO `zheng_zhuang` VALUES ('108', '骨关节、肌肉、脊椎（疼痛）', '股骨');
INSERT INTO `zheng_zhuang` VALUES ('109', '骨关节、肌肉、脊椎（疼痛）', '膝关节');
INSERT INTO `zheng_zhuang` VALUES ('110', '骨关节、肌肉、脊椎（疼痛）', '踝关节');
INSERT INTO `zheng_zhuang` VALUES ('111', '骨关节、肌肉、脊椎（疼痛）', '脚趾关节');
INSERT INTO `zheng_zhuang` VALUES ('112', '骨关节、肌肉、脊椎（疼痛）', '类风湿性关节炎');
INSERT INTO `zheng_zhuang` VALUES ('113', '骨关节、肌肉、脊椎（疼痛）', '退行性关节病变');
INSERT INTO `zheng_zhuang` VALUES ('114', '暖宫保养', '痛经');
INSERT INTO `zheng_zhuang` VALUES ('115', '暖宫保养', '手脚冰凉');
INSERT INTO `zheng_zhuang` VALUES ('116', '暖宫保养', '白带多');
INSERT INTO `zheng_zhuang` VALUES ('117', '暖宫保养', '腹部发凉');
INSERT INTO `zheng_zhuang` VALUES ('118', '暖宫保养', '容易发胖');
INSERT INTO `zheng_zhuang` VALUES ('119', '暖宫保养', '体质虚弱');
INSERT INTO `zheng_zhuang` VALUES ('120', '暖宫保养', '湿重');
INSERT INTO `zheng_zhuang` VALUES ('121', '三高调理', '高血压');
INSERT INTO `zheng_zhuang` VALUES ('122', '三高调理', '高血脂');
INSERT INTO `zheng_zhuang` VALUES ('123', '三高调理', '高血糖');
INSERT INTO `zheng_zhuang` VALUES ('124', '痛风调理', '跖趾关节');
INSERT INTO `zheng_zhuang` VALUES ('125', '痛风调理', '足背');
INSERT INTO `zheng_zhuang` VALUES ('126', '痛风调理', '足跟');
INSERT INTO `zheng_zhuang` VALUES ('127', '痛风调理', '踝关节');
INSERT INTO `zheng_zhuang` VALUES ('128', '痛风调理', '膝关节');
INSERT INTO `zheng_zhuang` VALUES ('129', '痛风调理', '腕关节');
INSERT INTO `zheng_zhuang` VALUES ('130', '痛风调理', '肘关节');
INSERT INTO `zheng_zhuang` VALUES ('131', '痛风调理', '肩关节');
INSERT INTO `zheng_zhuang` VALUES ('132', '痛风调理', '髋关节');
INSERT INTO `zheng_zhuang` VALUES ('133', '痛风调理', '脊柱');
INSERT INTO `zheng_zhuang` VALUES ('134', '痛风调理', '颞颌关节');
INSERT INTO `zheng_zhuang` VALUES ('135', '祛湿驱寒调理', '头重');
INSERT INTO `zheng_zhuang` VALUES ('136', '祛湿驱寒调理', '身重');
INSERT INTO `zheng_zhuang` VALUES ('137', '祛湿驱寒调理', '倦怠乏力');
INSERT INTO `zheng_zhuang` VALUES ('138', '祛湿驱寒调理', '大便粘腻');
INSERT INTO `zheng_zhuang` VALUES ('139', '祛湿驱寒调理', '喜热饮');
INSERT INTO `zheng_zhuang` VALUES ('140', '祛湿驱寒调理', '怕冷');
INSERT INTO `zheng_zhuang` VALUES ('141', '祛湿驱寒调理', '头重');
INSERT INTO `zheng_zhuang` VALUES ('142', '祛湿驱寒调理', '身重');
INSERT INTO `zheng_zhuang` VALUES ('143', '祛湿驱寒调理', '口苦');
INSERT INTO `zheng_zhuang` VALUES ('144', '祛湿驱寒调理', '尿黄而短');
INSERT INTO `zheng_zhuang` VALUES ('145', '祛湿驱寒调理', '倦怠乏力');
INSERT INTO `zheng_zhuang` VALUES ('146', '祛湿驱寒调理', '大便粘腻');
INSERT INTO `zheng_zhuang` VALUES ('147', '祛湿驱寒调理', '口干');
INSERT INTO `zheng_zhuang` VALUES ('148', '祛湿驱寒调理', '上火');
INSERT INTO `zheng_zhuang` VALUES ('149', '祛湿驱寒调理', '关节红肿热痛');
INSERT INTO `zheng_zhuang` VALUES ('150', '亚健康调理', '疲乏无力');
INSERT INTO `zheng_zhuang` VALUES ('151', '亚健康调理', '肌肉及关节酸痛');
INSERT INTO `zheng_zhuang` VALUES ('152', '亚健康调理', '头昏头痛');
INSERT INTO `zheng_zhuang` VALUES ('153', '亚健康调理', '睡眠紊乱');
INSERT INTO `zheng_zhuang` VALUES ('154', '亚健康调理', '食欲不振');
INSERT INTO `zheng_zhuang` VALUES ('155', '亚健康调理', '便溏便秘');
INSERT INTO `zheng_zhuang` VALUES ('156', '亚健康调理', '性功能减退');
INSERT INTO `zheng_zhuang` VALUES ('157', '亚健康调理', '怕冷怕热');
INSERT INTO `zheng_zhuang` VALUES ('158', '亚健康调理', '易于感冒');
INSERT INTO `zheng_zhuang` VALUES ('159', '亚健康调理', '情绪低落');
INSERT INTO `zheng_zhuang` VALUES ('160', '亚健康调理', '心烦意乱');
INSERT INTO `zheng_zhuang` VALUES ('161', '亚健康调理', '焦躁不安');
INSERT INTO `zheng_zhuang` VALUES ('162', '亚健康调理', '急躁易怒');
INSERT INTO `zheng_zhuang` VALUES ('163', '亚健康调理', '记忆力下降');
INSERT INTO `zheng_zhuang` VALUES ('164', '亚健康调理', '注意力不能集中');
INSERT INTO `zheng_zhuang` VALUES ('165', '亚健康调理', '反应迟钝');
INSERT INTO `zheng_zhuang` VALUES ('166', '美容护理', '去黑头');
INSERT INTO `zheng_zhuang` VALUES ('167', '美容护理', '嫩肤');
INSERT INTO `zheng_zhuang` VALUES ('168', '美容护理', '去死皮');
INSERT INTO `zheng_zhuang` VALUES ('169', '美容护理', '收缩毛孔');
