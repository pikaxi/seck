/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : seckill

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-18 18:07:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for seckill
-- ----------------------------
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE `seckill` (
  `seck_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '秒杀开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT ' 秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seck_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- ----------------------------
-- Records of seckill
-- ----------------------------
INSERT INTO `seckill` VALUES ('1000', '1000元秒杀iwatch', '10', '2019-01-19 00:00:00', '2019-01-19 00:01:00', '2019-01-18 10:49:22');
INSERT INTO `seckill` VALUES ('1001', '20元秒杀手环', '10', '2019-01-19 01:00:00', '2019-01-19 02:00:00', '2019-01-18 10:49:22');
INSERT INTO `seckill` VALUES ('1002', '9.9元秒杀床单4件套', '20', '2019-01-19 00:00:00', '2019-01-19 01:00:00', '2019-01-18 10:49:22');
INSERT INTO `seckill` VALUES ('1003', '1元秒杀鸡蛋（4个）', '30', '2019-01-19 00:00:00', '2019-01-19 01:00:00', '2019-01-18 10:49:22');
