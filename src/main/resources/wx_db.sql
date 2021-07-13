/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云数据库
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Schema         : wx_db

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 13/07/2021 14:09:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `subscribe` int(3) NOT NULL,
  `openid` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` int(3) NOT NULL,
  `language` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `city` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `province` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `country` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `headimgurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `subscribe_time` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `groupid` int(3) NULL DEFAULT NULL,
  `tagid_list` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `subscribe_scene` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jwc_user
-- ----------------------------
DROP TABLE IF EXISTS `jwc_user`;
CREATE TABLE `jwc_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `creat_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for receive_data
-- ----------------------------
DROP TABLE IF EXISTS `receive_data`;
CREATE TABLE `receive_data`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `msg` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `service` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `service_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `data` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `creat_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
