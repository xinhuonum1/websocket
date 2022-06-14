/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : sakila

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 10/08/2020 15:35:07
*/
DROP TABLE IF EXISTS staff;
CREATE TABLE staff  (
  id int AUTO_INCREMENT,
  username varchar(16) NOT NULL,
  password varchar(32) NOT NULL,
  PRIMARY KEY (id)
) ;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO staff VALUES (1, 'Mike', '81dc9bdb52d04dc20036dbd8313ed055');
INSERT INTO staff VALUES (2, 'Jon', '1234');
INSERT INTO staff VALUES (3, 'TOM', '1234');