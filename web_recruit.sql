/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : web_recruit

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 14/07/2020 13:12:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `categoryName_UNIQUE`(`category_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'Java', 'Java工程师');
INSERT INTO `category` VALUES (2, 'C++', 'C++工程师');
INSERT INTO `category` VALUES (3, 'Python', 'Python工程师');
INSERT INTO `category` VALUES (4, 'PHP', 'PHP工程师');
INSERT INTO `category` VALUES (5, '.NET', '.NET工程师');
INSERT INTO `category` VALUES (6, '大数据', '大数据开发');
INSERT INTO `category` VALUES (7, '人工智能', '人工智能研究');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `company_description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `company_address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`company_id`) USING BTREE,
  UNIQUE INDEX `company_name`(`company_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (1, '阿里巴巴', '附属于四川师范大学，工作条件优良，员工体验佳。', '四川省成都市龙泉驿');
INSERT INTO `company` VALUES (2, '拼多多', '年轻人的购物网站', '四川省成都市龙泉驿');
INSERT INTO `company` VALUES (3, '百度', '致力于搜索引擎以及人工智能', '四川省成都市龙泉驿');
INSERT INTO `company` VALUES (4, '爱奇艺', '知名的视频网站', '四川省成都市龙泉驿');
INSERT INTO `company` VALUES (5, '嘀嘀出行', '随时随地，去你心之所向', '四川省成都市龙泉驿');
INSERT INTO `company` VALUES (6, 'bilibili', '年轻世代高度聚集的文化社区和视频平台', '四川省成都市龙泉驿');

-- ----------------------------
-- Table structure for favor
-- ----------------------------
DROP TABLE IF EXISTS `favor`;
CREATE TABLE `favor`  (
  `favor_id` int(11) NOT NULL AUTO_INCREMENT,
  `favor_position_id` int(11) NOT NULL,
  `favor_resume_id` int(11) NOT NULL,
  `favor_state` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`favor_id`) USING BTREE,
  UNIQUE INDEX `favor_unique`(`favor_position_id`, `favor_resume_id`) USING BTREE,
  INDEX `fk_resume`(`favor_resume_id`) USING BTREE,
  CONSTRAINT `fk_position` FOREIGN KEY (`favor_position_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_resume` FOREIGN KEY (`favor_resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favor
-- ----------------------------
INSERT INTO `favor` VALUES (1, 1, 1, -1);
INSERT INTO `favor` VALUES (2, 2, 1, 0);
INSERT INTO `favor` VALUES (3, 6, 1, 1);

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr`  (
  `hr_id` int(11) NOT NULL AUTO_INCREMENT,
  `hr_account` int(11) NOT NULL,
  `hr_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `hr_company_id` int(11) NOT NULL,
  `hr_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `hr_gender` int(11) NOT NULL,
  `hr_mobile` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `hr_entry_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`hr_id`) USING BTREE,
  UNIQUE INDEX `hr_account`(`hr_account`) USING BTREE,
  INDEX `fk_company_id`(`hr_company_id`) USING BTREE,
  CONSTRAINT `fk_company_id` FOREIGN KEY (`hr_company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES (1, 123456, '123456', 1, '王五', 1, '15273948231', '2017-10-10');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `position_id` int(11) NOT NULL AUTO_INCREMENT,
  `position_category_id` int(11) NOT NULL,
  `position_company_id` int(11) NOT NULL,
  `position_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `position_quantity` int(11) NOT NULL,
  `position_description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `position_salary_down` int(11) NOT NULL,
  `position_salary_up` int(11) NOT NULL,
  `position_city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `position_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`position_id`) USING BTREE,
  INDEX `fk_company_id_2`(`position_company_id`) USING BTREE,
  CONSTRAINT `fk_company_id_2` FOREIGN KEY (`position_company_id`) REFERENCES `company` (`company_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, 1, 1, 'Java工程师', 12, 'java工程师，习惯996', 12000, 20000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (2, 1, 2, 'Java工程师', 20, 'java工程师，习惯996', 20000, 24000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (3, 1, 3, 'Java工程师', 10, 'java工程师，习惯996', 22000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (4, 1, 5, 'Java工程师', 7, 'java工程师，习惯996', 11000, 20000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (5, 1, 6, 'Java工程师', 9, 'java工程师，习惯996', 20000, 30000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (6, 2, 1, 'C++工程师', 30, 'C++工程师，习惯996', 20000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (7, 2, 2, 'C++工程师', 18, 'C++工程师，习惯996', 20000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (8, 2, 4, 'C++工程师', 25, 'C++工程师，习惯996', 20000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (9, 4, 4, 'PHP工程师', 22, 'PHP工程师，习惯996', 20000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (10, 4, 6, 'PHP工程师', 30, 'PHP工程师，习惯996', 18000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (11, 3, 1, 'python工程师', 40, 'python工程师，习惯996', 18000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (12, 3, 3, 'python工程师', 5, 'python工程师，习惯996', 18000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (13, 3, 5, 'python工程师', 10, 'python工程师，习惯996', 18000, 25000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (14, 7, 2, '人工智能研发', 15, '人工智能研发，习惯996', 16000, 24000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (15, 7, 5, '人工智能研发', 20, '人工智能研发，习惯996', 17000, 23000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (16, 6, 2, '大数据开发', 26, '大数据开发，习惯996', 18000, 20000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (17, 6, 4, '大数据开发', 18, '大数据开发，习惯996', 18000, 20000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (18, 5, 1, '.NET工程师', 11, '.NET工程师，习惯996', 16000, 23000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (19, 5, 4, '.NET工程师', 7, '.NET工程师，习惯996', 20000, 27000, '成都市', '四川师范大学成龙校区成龙大道1819号');
INSERT INTO `position` VALUES (20, 4, 1, 'PHP工程师', 12, '精通PHP，习惯996', 18000, 24000, '成都市', '四川师范大学');

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `resume_id` int(11) NOT NULL AUTO_INCREMENT,
  `resume_user_id` int(11) NOT NULL,
  `resume_content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `resume_work_desire` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `resume_work_experience` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`resume_id`) USING BTREE,
  UNIQUE INDEX `resume_user_id`(`resume_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES (1, 1, '吃苦耐劳，有强烈的敬业精神和团队协作精神，能够承受一定的压力，能迅速的适应各 环境，并融合其中同时对编程具有浓厚的兴趣。\r\n有积极进取的工作精神和实际动手能力，对新知识、新技术有着强烈的求知欲与良好的接受能力。', '1、java程序开发岗位，主要负责：代码编写、数据库操作、sql语句优化、wsdl技术调用接口、生成接口等。\r\n\r\n2、本身掌握的前端技术加上工作期间积累的html5和css3知识，会同时负责前端的实现。\r\n\r\n3、git项目管理，包括：远程git仓库项目的创建与删除等、gitolite中项目操作权限的设置等。\r\n\r\n4、研究并使用大数据相关的技术用于解决海量日志的分析，将数据存储到hadoop平台，然后将分析结果导入到Oracle数据库，通过Spring框架将结果进行展示。', '我最希望得到的是一种学习，能让我学到工作的技能。虽然我已经在学校学习了快16年,但只是学习到了知识，在学校里，没有机会接触到真正的社会，没有掌握一项工作技能，所以我最希望获得一项工作的技能，能够成为某一个行业领域的专业人士。');
INSERT INTO `resume` VALUES (2, 2, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_birth` date NULL DEFAULT NULL,
  `user_gender` int(11) NULL DEFAULT NULL,
  `user_graduation` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_edu_degree` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_position_id` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_account`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123456', '123456', '李四', '2000-02-02', 0, '四川师范大学', '本科', 0);
INSERT INTO `user` VALUES (2, '1234', '1234', '1234', '1900-01-01', 1, '1234', '本科', 0);

SET FOREIGN_KEY_CHECKS = 1;
