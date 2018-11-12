/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : putai

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-12 11:21:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for health_question
-- ----------------------------
DROP TABLE IF EXISTS `health_question`;
CREATE TABLE `health_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `single` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否单选',
  `code` varchar(32) NOT NULL COMMENT '问题分类编码',
  `category` varchar(32) DEFAULT NULL COMMENT '问题分类名称',
  `origin` enum('CUSTOMER','SYSTEM') DEFAULT 'SYSTEM' COMMENT '问题来源',
  `items` text COMMENT '问题的子选项',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of health_question
-- ----------------------------
INSERT INTO `health_question` VALUES ('1', '', 'Shape', '体型', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"肥胖\"},{\"code\":\"02\",\"desc\":\"中等\"},{\"code\":\"03\",\"desc\":\"偏瘦\"}]');
INSERT INTO `health_question` VALUES ('2', '', 'BloodSugar', '血糖', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"正常\"},{\"code\":\"02\",\"desc\":\"不正常\"},{\"code\":\"03\",\"desc\":\"未知\"}]');
INSERT INTO `health_question` VALUES ('3', '', 'BloodPressure', '血压', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"正常\"},{\"code\":\"02\",\"desc\":\"不正常\"},{\"code\":\"03\",\"desc\":\"未知\"}]');
INSERT INTO `health_question` VALUES ('4', '', 'BloodFat', '血脂', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"正常\"},{\"code\":\"02\",\"desc\":\"不正常\"},{\"code\":\"03\",\"desc\":\"未知\"}]');
INSERT INTO `health_question` VALUES ('5', '', 'Exercise', '锻炼情况', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"经常锻炼\"},{\"code\":\"02\",\"desc\":\"偶尔锻炼\"},{\"code\":\"03\",\"desc\":\"很少锻炼\"}]');
INSERT INTO `health_question` VALUES ('6', '', 'Smoke', '是否吸烟', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"吸烟\"},{\"code\":\"02\",\"desc\":\"不吸烟\"}]');
INSERT INTO `health_question` VALUES ('7', '', 'Drink', '是否喝酒', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"喝酒\"},{\"code\":\"02\",\"desc\":\"不喝酒\"}]');
INSERT INTO `health_question` VALUES ('8', '\0', 'Anamnesis', '既往病史', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"高血压\"},{\"code\":\"02\",\"desc\":\"高血脂\"},{\"code\":\"03\",\"desc\":\"糖尿病\"},{\"code\":\"04\",\"desc\":\"冠心病\"},{\"code\":\"05\",\"desc\":\"支气管\"},{\"code\":\"06\",\"desc\":\"皮肤疾病\"},{\"code\":\"07\",\"desc\":\"遗传性疾病\"},{\"code\":\"08\",\"desc\":\"其它\"}]');
INSERT INTO `health_question` VALUES ('9', '\0', 'Allergies', '过敏史', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"食物\"},{\"code\":\"02\",\"desc\":\"药物\"},{\"code\":\"03\",\"desc\":\"花粉\"},{\"code\":\"04\",\"desc\":\"其它\"}]');
INSERT INTO `health_question` VALUES ('10', '', 'Mental', '精神状态', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"优\"},{\"code\":\"02\",\"desc\":\"良\"},{\"code\":\"03\",\"desc\":\"中\"},{\"code\":\"04\",\"desc\":\"差\"}]');
INSERT INTO `health_question` VALUES ('11', '\0', 'Surgery', '手术史', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"心脏支架\"},{\"code\":\"02\",\"desc\":\"体内钢板钢钉\"},{\"code\":\"03\",\"desc\":\"外科缝合术\"},{\"code\":\"04\",\"desc\":\"其它\"}]');
INSERT INTO `health_question` VALUES ('12', '\0', 'Taboo', '禁忌事项', 'SYSTEM', '[{\"code\":\"01\",\"desc\":\"心脏支架\"},{\"code\":\"02\",\"desc\":\"体内钢板钢钉\"},{\"code\":\"03\",\"desc\":\"外科缝合术\"},{\"code\":\"04\",\"desc\":\"妊娠期、生理期\"},{\"code\":\"05\",\"desc\":\"开放性软组织损伤\"},{\"code\":\"06\",\"desc\":\"精神障碍\"},{\"code\":\"07\",\"desc\":\"皮肤病变\"},{\"code\":\"08\",\"desc\":\"急性化脓性炎症\"},{\"code\":\"09\",\"desc\":\"结核等传染性疾病\"},{\"code\":\"10\",\"desc\":\"有出血倾向疾病\"},{\"code\":\"11\",\"desc\":\"危重心、肝、肾、肺等内脏疾病和恶性肿瘤\"},{\"code\":\"12\",\"desc\":\"血栓性静脉炎\"},{\"code\":\"13\",\"desc\":\"极度衰弱、饥饿以及醉酒后\"},{\"code\":\"14\",\"desc\":\"局部金属异物\"},{\"code\":\"15\",\"desc\":\"医生认为不适宜应用的疾病以及对电流不能耐受者\"}]');
INSERT INTO `health_question` VALUES ('13', '\0', 'Sleep', '睡眠质量', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"入睡困难\"},{\"code\":\"02\",\"desc\":\"多梦\"},{\"code\":\"03\",\"desc\":\"易醒\"},{\"code\":\"04\",\"desc\":\"早醒\"},{\"code\":\"05\",\"desc\":\"醒后疲劳、精神差醒\"},{\"code\":\"06\",\"desc\":\"梦游\"},{\"code\":\"07\",\"desc\":\"失眠\"}]');
INSERT INTO `health_question` VALUES ('14', '\0', 'Weight', '减重', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"手臂\"},{\"code\":\"02\",\"desc\":\"腹部\"},{\"code\":\"03\",\"desc\":\"腰部\"},{\"code\":\"04\",\"desc\":\"背部\"},{\"code\":\"05\",\"desc\":\"大腿\"},{\"code\":\"06\",\"desc\":\"小腿\"},{\"code\":\"07\",\"desc\":\"面部\"}]');
INSERT INTO `health_question` VALUES ('15', '\0', 'Liver', '肝胆功能', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"食欲减退、厌油\"},{\"code\":\"02\",\"desc\":\"乏力、易疲、嗜睡\"},{\"code\":\"03\",\"desc\":\"皮肤、巩膜等黄染\"},{\"code\":\"04\",\"desc\":\"牙龈出血\"},{\"code\":\"05\",\"desc\":\"鼻出血\"},{\"code\":\"06\",\"desc\":\"口干\"},{\"code\":\"07\",\"desc\":\"大便干或溏\"},{\"code\":\"08\",\"desc\":\"头晕耳鸣\"},{\"code\":\"09\",\"desc\":\"面色萎黄\"},{\"code\":\"10\",\"desc\":\"肋骨疼痛\"},{\"code\":\"11\",\"desc\":\"月经量少\"},{\"code\":\"12\",\"desc\":\"体重减少\"}]');
INSERT INTO `health_question` VALUES ('16', '\0', 'Kidney', '肝肾亏虚', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"头晕目眩\"},{\"code\":\"02\",\"desc\":\"耳鸣健忘\"},{\"code\":\"03\",\"desc\":\"失眠多梦\"},{\"code\":\"04\",\"desc\":\"咽干口燥\"},{\"code\":\"05\",\"desc\":\"腰膝酸软\"},{\"code\":\"06\",\"desc\":\"肋骨胀痛\"},{\"code\":\"07\",\"desc\":\"视物不清\"},{\"code\":\"08\",\"desc\":\"五心烦热\"},{\"code\":\"09\",\"desc\":\"掉发\"},{\"code\":\"10\",\"desc\":\"颧红盗汗\"},{\"code\":\"11\",\"desc\":\"男子遗精\"},{\"code\":\"12\",\"desc\":\"女子经少或闭经\"},{\"code\":\"13\",\"desc\":\"舌红少苔\"}]');
INSERT INTO `health_question` VALUES ('17', '\0', 'Spleen', '脾胃肠道', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"饮食正常\"},{\"code\":\"02\",\"desc\":\"饮食素食\"},{\"code\":\"03\",\"desc\":\"饮食生冷\"},{\"code\":\"04\",\"desc\":\"饮食辛辣\"},{\"code\":\"05\",\"desc\":\"饮食油腻\"},{\"code\":\"06\",\"desc\":\"便秘\"},{\"code\":\"07\",\"desc\":\"胃痛\"},{\"code\":\"08\",\"desc\":\"腹痛\"},{\"code\":\"09\",\"desc\":\"泄泻\"},{\"code\":\"10\",\"desc\":\"脘腹胀满\"},{\"code\":\"11\",\"desc\":\"肢体困倦\"},{\"code\":\"12\",\"desc\":\"尿少色黄\"},{\"code\":\"13\",\"desc\":\"大便溏泄不爽\"},{\"code\":\"14\",\"desc\":\"纳少厌食\"},{\"code\":\"15\",\"desc\":\"恶心呕吐\"},{\"code\":\"16\",\"desc\":\"面黄\"},{\"code\":\"17\",\"desc\":\"皮肤发痒\"},{\"code\":\"18\",\"desc\":\"身热起伏\"},{\"code\":\"19\",\"desc\":\"汗出不解\"},{\"code\":\"20\",\"desc\":\"舌红苔黄腻\"},{\"code\":\"21\",\"desc\":\"呕吐\"},{\"code\":\"22\",\"desc\":\"水肿\"},{\"code\":\"23\",\"desc\":\"便血\"},{\"code\":\"24\",\"desc\":\"喜按\"},{\"code\":\"25\",\"desc\":\"胀满\"},{\"code\":\"26\",\"desc\":\"经闭\"},{\"code\":\"27\",\"desc\":\"带下\"},{\"code\":\"28\",\"desc\":\"四肢逆冷\"}]');
INSERT INTO `health_question` VALUES ('18', '\0', 'Heart', '心肺', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"呼吸困难\"},{\"code\":\"02\",\"desc\":\"无力\"},{\"code\":\"03\",\"desc\":\"嘴唇发绀\"},{\"code\":\"04\",\"desc\":\"静脉怒张\"},{\"code\":\"05\",\"desc\":\"水肿\"},{\"code\":\"06\",\"desc\":\"咳嗽\"},{\"code\":\"07\",\"desc\":\"咯血\"},{\"code\":\"08\",\"desc\":\"心慌\"},{\"code\":\"09\",\"desc\":\"气短\"},{\"code\":\"10\",\"desc\":\"胸闷\"},{\"code\":\"11\",\"desc\":\"头晕\"},{\"code\":\"12\",\"desc\":\"晕厥\"},{\"code\":\"13\",\"desc\":\"局部发紫\"},{\"code\":\"14\",\"desc\":\"下肢水肿\"}]');
INSERT INTO `health_question` VALUES ('19', '\0', 'Weak', '阳虚体弱', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"手脚冰凉\"},{\"code\":\"02\",\"desc\":\"膝盖发凉\"},{\"code\":\"03\",\"desc\":\"后背发凉\"},{\"code\":\"04\",\"desc\":\"胸腹发凉\"},{\"code\":\"05\",\"desc\":\"脚踝怕凉\"},{\"code\":\"06\",\"desc\":\"怕冷\"},{\"code\":\"07\",\"desc\":\"怕热\"},{\"code\":\"08\",\"desc\":\"上热下寒\"}]');
INSERT INTO `health_question` VALUES ('20', '\0', 'Prostate', '前列腺保养', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"排尿困难\"},{\"code\":\"02\",\"desc\":\"尿不尽\"},{\"code\":\"03\",\"desc\":\"疼痛症状\"},{\"code\":\"04\",\"desc\":\"性功能障碍\"},{\"code\":\"05\",\"desc\":\"神经衰弱\"}]');
INSERT INTO `health_question` VALUES ('21', '\0', 'Muscle', '骨关节、肌肉、脊椎（疼痛）', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"风湿\"},{\"code\":\"02\",\"desc\":\"类风湿\"},{\"code\":\"03\",\"desc\":\"肌肉酸痛\"},{\"code\":\"04\",\"desc\":\"肌肉胀痛\"},{\"code\":\"05\",\"desc\":\"颈椎\"},{\"code\":\"06\",\"desc\":\"胸椎\"},{\"code\":\"07\",\"desc\":\"腰椎\"},{\"code\":\"08\",\"desc\":\"肩关节\"},{\"code\":\"09\",\"desc\":\"肘关节\"},{\"code\":\"10\",\"desc\":\"腕关节\"},{\"code\":\"11\",\"desc\":\"指关节\"},{\"code\":\"12\",\"desc\":\"髋关节\"},{\"code\":\"13\",\"desc\":\"股骨\"},{\"code\":\"14\",\"desc\":\"膝关节\"},{\"code\":\"15\",\"desc\":\"踝关节\"},{\"code\":\"16\",\"desc\":\"脚趾关节\"},{\"code\":\"17\",\"desc\":\"类风湿性关节炎\"},{\"code\":\"18\",\"desc\":\"退行性关节病变\"}]');
INSERT INTO `health_question` VALUES ('22', '\0', 'Uterus', '暖宫保养', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"量多\"},{\"code\":\"02\",\"desc\":\"量少\"},{\"code\":\"03\",\"desc\":\"量正常\"},{\"code\":\"04\",\"desc\":\"经期正常\"},{\"code\":\"05\",\"desc\":\"经期提前\"},{\"code\":\"06\",\"desc\":\"经期推后\"},{\"code\":\"07\",\"desc\":\"经期不定期\"},{\"code\":\"08\",\"desc\":\"颜色正常\"},{\"code\":\"00\",\"desc\":\"颜色偏淡\"},{\"code\":\"10\",\"desc\":\"颜色鲜红\"},{\"code\":\"11\",\"desc\":\"颜色暗红\"},{\"code\":\"12\",\"desc\":\"有血块\"},{\"code\":\"13\",\"desc\":\"无痛经\"},{\"code\":\"14\",\"desc\":\"轻度痛经\"},{\"code\":\"15\",\"desc\":\"中度痛经\"},{\"code\":\"16\",\"desc\":\"重度痛经\"},{\"code\":\"17\",\"desc\":\"手脚冰凉\"},{\"code\":\"18\",\"desc\":\"白带多\"},{\"code\":\"19\",\"desc\":\"腹部发凉\"},{\"code\":\"20\",\"desc\":\"容易发胖\"},{\"code\":\"21\",\"desc\":\"体质虚弱\"},{\"code\":\"22\",\"desc\":\"湿重\"}]');
INSERT INTO `health_question` VALUES ('23', '\0', 'ThreeHigh', '三高', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"高血压\"},{\"code\":\"02\",\"desc\":\"高血脂\"},{\"code\":\"03\",\"desc\":\"高血糖\"}]');
INSERT INTO `health_question` VALUES ('24', '\0', 'Gout', '痛风调理', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"跖趾关节\"},{\"code\":\"02\",\"desc\":\"足背\"},{\"code\":\"03\",\"desc\":\"足跟\"},{\"code\":\"04\",\"desc\":\"踝关节\"},{\"code\":\"05\",\"desc\":\"膝关节\"},{\"code\":\"06\",\"desc\":\"腕关节\"},{\"code\":\"07\",\"desc\":\"肘关节\"},{\"code\":\"08\",\"desc\":\"肩关节\"},{\"code\":\"09\",\"desc\":\"髋关节\"},{\"code\":\"10\",\"desc\":\"脊柱\"},{\"code\":\"11\",\"desc\":\"颞颌关节\"}]');
INSERT INTO `health_question` VALUES ('25', '\0', 'Cool', '祛湿驱寒', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"头重\"},{\"code\":\"02\",\"desc\":\"身重\"},{\"code\":\"03\",\"desc\":\"倦怠乏力\"},{\"code\":\"04\",\"desc\":\"大便粘腻\"},{\"code\":\"05\",\"desc\":\"喜热饮\"},{\"code\":\"06\",\"desc\":\"怕冷\"},{\"code\":\"07\",\"desc\":\"口苦\"},{\"code\":\"08\",\"desc\":\"尿黄而短\"},{\"code\":\"09\",\"desc\":\"口干\"},{\"code\":\"10\",\"desc\":\"上火\"},{\"code\":\"11\",\"desc\":\"关节红肿热痛干\"}]');
INSERT INTO `health_question` VALUES ('26', '\0', 'Subhealthy', '亚健康体质', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"疲乏无力\"},{\"code\":\"02\",\"desc\":\"肌肉及关节酸痛\"},{\"code\":\"03\",\"desc\":\"头昏头痛\"},{\"code\":\"04\",\"desc\":\"睡眠紊乱\"},{\"code\":\"05\",\"desc\":\"食欲不振\"},{\"code\":\"06\",\"desc\":\"便溏便秘\"},{\"code\":\"07\",\"desc\":\"性功能减退\"},{\"code\":\"08\",\"desc\":\"怕冷怕热\"},{\"code\":\"09\",\"desc\":\"易于感冒\"},{\"code\":\"10\",\"desc\":\"情绪低落\"},{\"code\":\"11\",\"desc\":\"心烦意乱\"},{\"code\":\"12\",\"desc\":\"焦躁不安\"},{\"code\":\"13\",\"desc\":\"急躁易怒\"},{\"code\":\"14\",\"desc\":\"记忆力下降\"},{\"code\":\"15\",\"desc\":\"注意力不能集中\"},{\"code\":\"16\",\"desc\":\"反应迟钝\"}]');
INSERT INTO `health_question` VALUES ('27', '\0', 'Cosmetology', '美容', 'CUSTOMER', '[{\"code\":\"01\",\"desc\":\"去黑头\"},{\"code\":\"02\",\"desc\":\"嫩肤\"},{\"code\":\"03\",\"desc\":\"去死皮\"},{\"code\":\"04\",\"desc\":\"收缩毛孔\"}]');
