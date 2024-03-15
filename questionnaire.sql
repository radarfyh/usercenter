/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql
 Source Server Type    : MySQL
 Source Server Version : 50742
 Source Host           : localhost:3306
 Source Schema         : questionnaire

 Target Server Type    : MySQL
 Target Server Version : 50742
 File Encoding         : 65001

 Date: 15/03/2024 18:11:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_option
-- ----------------------------
DROP TABLE IF EXISTS `t_option`;
CREATE TABLE `t_option`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `question_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问题记录ID',
  `option_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项代码',
  `option_desc` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '选项描述',
  `audio_url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '音频资料链接',
  `video_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '视频资料链接',
  `picture_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片资料链接',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '问题选项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_option
-- ----------------------------
INSERT INTO `t_option` VALUES ('b2796882df9011ee8ff5ccdae0d178e3', '1001', 'A', '干部', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.273503', '2024-03-11 18:18:25.273503', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b279a74cdf9011ee8ff5ccdae0d178e3', '1001', 'B', '战士', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.277215', '2024-03-11 18:18:25.277215', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b279d800df9011ee8ff5ccdae0d178e3', '1001', 'C', '学员', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.278485', '2024-03-11 18:18:25.278485', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27a1591df9011ee8ff5ccdae0d178e3', '1001', 'D', '不是军人', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.280064', '2024-03-11 18:18:25.280064', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27a420edf9011ee8ff5ccdae0d178e3', '1002', 'A', '医疗技术水平，能不能治好病', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.281205', '2024-03-11 18:18:25.281205', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27a6e71df9011ee8ff5ccdae0d178e3', '1002', 'B', '服务态度', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.282344', '2024-03-11 18:18:25.282344', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27a9ab3df9011ee8ff5ccdae0d178e3', '1002', 'C', '住院环境', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.283477', '2024-03-11 18:18:25.283477', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27acdc2df9011ee8ff5ccdae0d178e3', '1002', 'D', '医疗设备', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.284781', '2024-03-11 18:18:25.284781', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27afb33df9011ee8ff5ccdae0d178e3', '1003', 'A', '很满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.285947', '2024-03-11 18:18:25.285947', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27b2be9df9011ee8ff5ccdae0d178e3', '1003', 'B', '满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.287189', '2024-03-11 18:18:25.287189', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27b5688df9011ee8ff5ccdae0d178e3', '1003', 'C', '一般', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.288281', '2024-03-11 18:18:25.288281', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27b84a0df9011ee8ff5ccdae0d178e3', '1003', 'D', '不满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.289457', '2024-03-11 18:18:25.289457', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27bf9f1df9011ee8ff5ccdae0d178e3', '1004', 'A', '清晰明确', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.292424', '2024-03-11 18:18:25.292424', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27c4ebddf9011ee8ff5ccdae0d178e3', '1004', 'B', '一般', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.294627', '2024-03-11 18:18:25.294627', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27c7f48df9011ee8ff5ccdae0d178e3', '1004', 'C', '不明确', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.295876', '2024-03-11 18:18:25.295876', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27cadb0df9011ee8ff5ccdae0d178e3', '1004', 'D', '没注意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.297066', '2024-03-11 18:18:25.297066', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27cdb10df9011ee8ff5ccdae0d178e3', '1005', 'A', '科室设置齐全，就诊方便', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.298229', '2024-03-11 18:18:25.298229', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27d079bdf9011ee8ff5ccdae0d178e3', '1005', 'B', '科室设置齐全，但服务质量一般', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.299370', '2024-03-11 18:18:25.299370', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27d3413df9011ee8ff5ccdae0d178e3', '1005', 'C', '科室过少，无法满足就诊需求', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.300511', '2024-03-11 18:18:25.300511', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27d62e2df9011ee8ff5ccdae0d178e3', '1005', 'D', '未关注或未涉及', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.301684', '2024-03-11 18:18:25.301684', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27d9140df9011ee8ff5ccdae0d178e3', '1006', 'A', '非常耐心细致', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.302891', '2024-03-11 18:18:25.302891', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27dbf20df9011ee8ff5ccdae0d178e3', '1006', 'B', '较为耐心细致', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.304061', '2024-03-11 18:18:25.304061', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27deb6fdf9011ee8ff5ccdae0d178e3', '1006', 'C', '一般', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.305205', '2024-03-11 18:18:25.305205', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27e53cadf9011ee8ff5ccdae0d178e3', '1006', 'D', '不耐心细致', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.307850', '2024-03-11 18:18:25.307850', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27e8fb2df9011ee8ff5ccdae0d178e3', '1006', 'E', '敷衍了事', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.309395', '2024-03-11 18:18:25.309395', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27ec03fdf9011ee8ff5ccdae0d178e3', '1007', 'A', '很满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.310649', '2024-03-11 18:18:25.310649', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27eeb07df9011ee8ff5ccdae0d178e3', '1007', 'B', '满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.311748', '2024-03-11 18:18:25.311748', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27f14c7df9011ee8ff5ccdae0d178e3', '1007', 'C', '一般', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.312816', '2024-03-11 18:18:25.312816', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27f3dcbdf9011ee8ff5ccdae0d178e3', '1007', 'D', '不满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.313868', '2024-03-11 18:18:25.313868', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27f694fdf9011ee8ff5ccdae0d178e3', '1007', 'E', '很不满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.314982', '2024-03-11 18:18:25.314982', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27f91b4df9011ee8ff5ccdae0d178e3', '1008', 'A', '是的，很满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.316015', '2024-03-11 18:18:25.316015', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27fbac8df9011ee8ff5ccdae0d178e3', '1008', 'B', '一般，感觉不明显', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.317066', '2024-03-11 18:18:25.317066', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b27fe75adf9011ee8ff5ccdae0d178e3', '1008', 'C', '很不满意，存在惜用现象', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.318206', '2024-03-11 18:18:25.318206', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b280139cdf9011ee8ff5ccdae0d178e3', '1009', 'A', '是', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.319341', '2024-03-11 18:18:25.319341', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2804533df9011ee8ff5ccdae0d178e3', '1009', 'B', '否', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.320588', '2024-03-11 18:18:25.320588', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2807e0adf9011ee8ff5ccdae0d178e3', '1010', 'A', '是', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.322054', '2024-03-11 18:18:25.322054', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b280abfddf9011ee8ff5ccdae0d178e3', '1010', 'B', '否', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.323236', '2024-03-11 18:18:25.323236', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b280dd72df9011ee8ff5ccdae0d178e3', '1011', 'A', '优先', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.324490', '2024-03-11 18:18:25.324490', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b28110d8df9011ee8ff5ccdae0d178e3', '1011', 'B', '优先政策落实不到位', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.325816', '2024-03-11 18:18:25.325816', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b281407ddf9011ee8ff5ccdae0d178e3', '1011', 'B', '没有优先', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.327038', '2024-03-11 18:18:25.327038', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2816d38df9011ee8ff5ccdae0d178e3', '2001', 'A', '干部', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.328186', '2024-03-11 18:18:25.328186', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b28198f5df9011ee8ff5ccdae0d178e3', '2001', 'B', '战士', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.329302', '2024-03-11 18:18:25.329302', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b281c68adf9011ee8ff5ccdae0d178e3', '2001', 'C', '学员', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.330472', '2024-03-11 18:18:25.330472', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b281f41ddf9011ee8ff5ccdae0d178e3', '2001', 'D', '不是军人', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.331638', '2024-03-11 18:18:25.331638', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2821fd9df9011ee8ff5ccdae0d178e3', '2002', 'A', '医疗技术水平，能不能治好病', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.332757', '2024-03-11 18:18:25.332757', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2824a16df9011ee8ff5ccdae0d178e3', '2002', 'B', '服务态度', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.333841', '2024-03-11 18:18:25.333841', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b28273c8df9011ee8ff5ccdae0d178e3', '2002', 'C', '住院环境', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.334908', '2024-03-11 18:18:25.334908', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b282a1addf9011ee8ff5ccdae0d178e3', '2002', 'D', '医疗设备', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.336077', '2024-03-11 18:18:25.336077', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2830321df9011ee8ff5ccdae0d178e3', '2003', 'A', '很满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.338563', '2024-03-11 18:18:25.338563', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2832fa6df9011ee8ff5ccdae0d178e3', '2003', 'B', '满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.339713', '2024-03-11 18:18:25.339713', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2836b32df9011ee8ff5ccdae0d178e3', '2003', 'C', '一般', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.341228', '2024-03-11 18:18:25.341228', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2839bd7df9011ee8ff5ccdae0d178e3', '2003', 'D', '不满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.342481', '2024-03-11 18:18:25.342481', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b283ca52df9011ee8ff5ccdae0d178e3', '2006', 'A', '很满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.343675', '2024-03-11 18:18:25.343675', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b283f935df9011ee8ff5ccdae0d178e3', '2006', 'B', '满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.344878', '2024-03-11 18:18:25.344878', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2842ac9df9011ee8ff5ccdae0d178e3', '2006', 'C', '一般', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.346147', '2024-03-11 18:18:25.346147', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2845661df9011ee8ff5ccdae0d178e3', '2006', 'D', '不满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.347262', '2024-03-11 18:18:25.347262', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b28482a1df9011ee8ff5ccdae0d178e3', '2006', 'E', '很不满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.348396', '2024-03-11 18:18:25.348396', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b284af18df9011ee8ff5ccdae0d178e3', '2010', 'A', '是', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.349534', '2024-03-11 18:18:25.349534', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b284dbb1df9011ee8ff5ccdae0d178e3', '2010', 'B', '否', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.350674', '2024-03-11 18:18:25.350674', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2850733df9011ee8ff5ccdae0d178e3', '2014', 'A', '是', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.351791', '2024-03-11 18:18:25.351791', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b28536d6df9011ee8ff5ccdae0d178e3', '2014', 'B', '否', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.353004', '2024-03-11 18:18:25.353004', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b28566cedf9011ee8ff5ccdae0d178e3', '2015', 'A', '是的，很满意', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.354233', '2024-03-11 18:18:25.354233', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b28594f6df9011ee8ff5ccdae0d178e3', '2015', 'B', '一般，感觉不明显', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.355418', '2024-03-11 18:18:25.355418', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b285c326df9011ee8ff5ccdae0d178e3', '2015', 'C', '很不满意，存在惜用现象', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.356598', '2024-03-11 18:18:25.356598', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b285ef71df9011ee8ff5ccdae0d178e3', '2016', 'A', '优先', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.357733', '2024-03-11 18:18:25.357733', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b286233bdf9011ee8ff5ccdae0d178e3', '2016', 'B', '优先政策落实不到位', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.359058', '2024-03-11 18:18:25.359058', 'admin', 'admin', b'1');
INSERT INTO `t_option` VALUES ('b2864dcbdf9011ee8ff5ccdae0d178e3', '2016', 'B', '没有优先', NULL, NULL, NULL, NULL, '2024-03-11 18:18:25.360150', '2024-03-11 18:18:25.360150', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for t_paper_composition
-- ----------------------------
DROP TABLE IF EXISTS `t_paper_composition`;
CREATE TABLE `t_paper_composition`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `questionnaire_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查单记录ID',
  `sort_code` int(11) NULL DEFAULT NULL COMMENT '问题排序代码（题号）',
  `score` int(11) NULL DEFAULT NULL COMMENT '分值',
  `question_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问题记录ID',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '调查单组卷' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `question_type_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题型代码',
  `question_desc` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题目描述（唯一）',
  `audio_url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '音频资料链接',
  `video_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '视频资料链接',
  `picture_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片资料链接',
  `reference_score` int(11) NULL DEFAULT NULL COMMENT '参考分值',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '问题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('1001', 'single-choice', '您的身份是什么？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.222425', '2024-03-11 18:18:25.222425', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1002', 'single-choice', '到医院看病，您最关心什么问题？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.225850', '2024-03-11 18:18:25.225850', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1003', 'single-choice', '您对医院的为军服务是否满意？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.226997', '2024-03-11 18:18:25.226997', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1004', 'single-choice', '您认为，门诊就医的引导及优先标识清晰明确吗？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.228772', '2024-03-11 18:18:25.228772', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1005', 'single-choice', '您认为门诊军人诊区为军人提供了挂号、就诊、检查、治疗、取药等“一站式”服务吗？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.230054', '2024-03-11 18:18:25.230054', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1006', 'single-choice', '您对医生询问病情和检查的耐心细致程度满意吗？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.231173', '2024-03-11 18:18:25.231173', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1007', 'single-choice', '在门诊诊断或治疗时，您对医务人员关注并保护您的隐私满意吗？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.232292', '2024-03-11 18:18:25.232292', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1008', 'single-choice', '您认为，就诊医院是否将优质资源首先用于为军服务？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.233420', '2024-03-11 18:18:25.233420', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1009', 'single-choice', '您在整个诊疗过程中，是否有医疗自费支出产生？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.234717', '2024-03-11 18:18:25.234717', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1010', 'single-choice', '您认为，就诊医院对军人投诉或反映的问题处置是否迅速得当？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.235910', '2024-03-11 18:18:25.235910', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1011', 'single-choice', '您在诊疗过程中是否体会到军人优先？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.237123', '2024-03-11 18:18:25.237123', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('1012', 'essay', '您对医院政策执行、提升医疗服务品质方面有何不满意的地方？以及其他意见和建议？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.238312', '2024-03-11 18:18:25.238312', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2001', 'single-choice', '您的身份是什么？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.239510', '2024-03-11 18:18:25.239510', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2002', 'single-choice', '到医院看病，您最关心什么问题？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.240639', '2024-03-11 18:18:25.240639', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2003', 'single-choice', '您对医院的为军服务是否满意？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.241799', '2024-03-11 18:18:25.241799', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2004', 'single-choice', '医生为您开具住院单后，医院是否在24小时内通知安排您住院？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.243121', '2024-03-11 18:18:25.243121', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2005', 'single-choice', '军人病房内有无收治地方病人的情况出现？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.244429', '2024-03-11 18:18:25.244429', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2006', 'single-choice', '在门诊诊断或治疗时，您对医务人员关注并保护您的隐私满意吗？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.245594', '2024-03-11 18:18:25.245594', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2007', 'single-choice', '您的住院医生（经管医生）是以下哪种情况？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.246772', '2024-03-11 18:18:25.246772', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2008', 'single-choice', '当需要会诊时，您的主管医生是否主动为您联系协调解决？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.247963', '2024-03-11 18:18:25.247963', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2009', 'single-choice', '住院期间，您对医护人员关于病情、手术、用药等沟通告知是否满意？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.249030', '2024-03-11 18:18:25.249030', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2010', 'single-choice', '您在整个诊疗过程中，是否有医疗自费支出产生？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.250170', '2024-03-11 18:18:25.250170', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2011', 'single-choice', '您认为医生为军服务的态度如何？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.251277', '2024-03-11 18:18:25.251277', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2012', 'single-choice', '您认为护士为军服务的态度如何？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.252414', '2024-03-11 18:18:25.252414', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2013', 'single-choice', '您认为医院的整体就诊流程是否顺畅？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.253527', '2024-03-11 18:18:25.253527', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2014', 'single-choice', '您认为，就诊医院对军人投诉或反映的问题处置是否迅速得当？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.254658', '2024-03-11 18:18:25.254658', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2015', 'single-choice', '您认为，就诊医院是否将优质资源首先用于为军服务？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.255762', '2024-03-11 18:18:25.255762', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2016', 'single-choice', '您在诊疗过程中是否体会到军人优先？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.256860', '2024-03-11 18:18:25.256860', 'admin', 'admin', b'1');
INSERT INTO `t_question` VALUES ('2017', 'essay', '您对医院政策执行、提升医疗服务品质方面有何不满意的地方？以及其他意见和建议？', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.258201', '2024-03-11 18:18:25.258201', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for t_question_log
-- ----------------------------
DROP TABLE IF EXISTS `t_question_log`;
CREATE TABLE `t_question_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `survey_log_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查单答题者信息记录ID',
  `sort_code` int(11) NULL DEFAULT NULL COMMENT '问题排序代码（题号）',
  `answer_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问题答案代码',
  `score` int(11) NULL DEFAULT NULL COMMENT '得分',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '答题日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_question_type
-- ----------------------------
DROP TABLE IF EXISTS `t_question_type`;
CREATE TABLE `t_question_type`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题型代码（唯一）',
  `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '题型名称',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '题型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_question_type
-- ----------------------------
INSERT INTO `t_question_type` VALUES ('b26e65a8df9011ee8ff5ccdae0d178e3', 'decision', '判断题', NULL, '2024-03-11 18:18:25.201392', '2024-03-11 18:18:25.201392', 'admin', 'admin', b'1');
INSERT INTO `t_question_type` VALUES ('b26e9695df9011ee8ff5ccdae0d178e3', 'single-choice', '单选题', NULL, '2024-03-11 18:18:25.204711', '2024-03-11 18:18:25.204711', 'admin', 'admin', b'1');
INSERT INTO `t_question_type` VALUES ('b26eca81df9011ee8ff5ccdae0d178e3', 'multiple-choice', '多选题', NULL, '2024-03-11 18:18:25.206045', '2024-03-11 18:18:25.206045', 'admin', 'admin', b'1');
INSERT INTO `t_question_type` VALUES ('b26f0b61df9011ee8ff5ccdae0d178e3', 'essay', '简答题', NULL, '2024-03-11 18:18:25.207715', '2024-03-11 18:18:25.207715', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for t_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire`;
CREATE TABLE `t_questionnaire`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `type_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查表类型代码',
  `name` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查表名称（唯一）',
  `introduction` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '介绍',
  `qr_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '二维码链接',
  `total_score` int(11) NULL DEFAULT NULL COMMENT '总分',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '调查表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_questionnaire
-- ----------------------------
INSERT INTO `t_questionnaire` VALUES ('b26b5e69df9011ee8ff5ccdae0d178e3', 'patient-army', '八一骨科医院为军服务门诊满意度调查', '八一骨科医院为军服务门诊满意度调查', NULL, 500, NULL, '2024-03-11 18:18:25.181509', '2024-03-11 18:18:25.181509', 'admin', 'admin', b'1');
INSERT INTO `t_questionnaire` VALUES ('b26b99afdf9011ee8ff5ccdae0d178e3', 'patient-army', '上海411医院为军服务门诊满意度调查', '上海411医院为军服务门诊满意度调查', NULL, 500, NULL, '2024-03-11 18:18:25.185120', '2024-03-11 18:18:25.185120', 'admin', 'admin', b'1');
INSERT INTO `t_questionnaire` VALUES ('b26bc83cdf9011ee8ff5ccdae0d178e3', 'patient-army', '淮安医院为军服务门诊满意度调查', '淮安医院为军服务门诊满意度调查', NULL, 500, NULL, '2024-03-11 18:18:25.186335', '2024-03-11 18:18:25.186335', 'admin', 'admin', b'1');
INSERT INTO `t_questionnaire` VALUES ('b26bf5a3df9011ee8ff5ccdae0d178e3', 'patient-army', '镇江医院为军服务门诊满意度调查', '镇江医院为军服务门诊满意度调查', NULL, 500, NULL, '2024-03-11 18:18:25.187497', '2024-03-11 18:18:25.187497', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for t_questionnaire_type
-- ----------------------------
DROP TABLE IF EXISTS `t_questionnaire_type`;
CREATE TABLE `t_questionnaire_type`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类型代码（唯一）',
  `name` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '类型名称',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '调查表类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_questionnaire_type
-- ----------------------------
INSERT INTO `t_questionnaire_type` VALUES ('b2681f1fdf9011ee8ff5ccdae0d178e3', 'hospital', '为民服务住院满意度调查', NULL, '2024-03-11 18:18:25.148523', '2024-03-11 18:18:25.148523', 'admin', 'admin', b'1');
INSERT INTO `t_questionnaire_type` VALUES ('b2686234df9011ee8ff5ccdae0d178e3', 'patient', '为民服务门诊满意度调查', NULL, '2024-03-11 18:18:25.164018', '2024-03-11 18:18:25.164018', 'admin', 'admin', b'1');
INSERT INTO `t_questionnaire_type` VALUES ('b2689bc8df9011ee8ff5ccdae0d178e3', 'hospital-army', '为军服务住院满意度调查', NULL, '2024-03-11 18:18:25.165500', '2024-03-11 18:18:25.165500', 'admin', 'admin', b'1');
INSERT INTO `t_questionnaire_type` VALUES ('b268e508df9011ee8ff5ccdae0d178e3', 'patient-army', '为军服务门诊满意度调查', NULL, '2024-03-11 18:18:25.167399', '2024-03-11 18:18:25.167399', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for t_standard_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_standard_answer`;
CREATE TABLE `t_standard_answer`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `question_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '问题记录ID',
  `answer_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '答案代码',
  `answer_desc` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '答案描述',
  `audio_url` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '音频资料链接',
  `video_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '视频资料链接',
  `picture_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片资料链接',
  `score` int(11) NULL DEFAULT NULL COMMENT '分值',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '问题标准答案' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_standard_answer
-- ----------------------------
INSERT INTO `t_standard_answer` VALUES ('b288b7cedf9011ee8ff5ccdae0d178e3', '1001', 'A', '干部', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.374020', '2024-03-11 18:18:25.374020', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b288f563df9011ee8ff5ccdae0d178e3', '1001', 'B', '战士', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.377525', '2024-03-11 18:18:25.377525', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28923fddf9011ee8ff5ccdae0d178e3', '1001', 'C', '学员', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.378728', '2024-03-11 18:18:25.378728', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28960eedf9011ee8ff5ccdae0d178e3', '1001', 'D', '不是军人', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.380299', '2024-03-11 18:18:25.380299', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b2898b1edf9011ee8ff5ccdae0d178e3', '1002', 'A', '医疗技术水平，能不能治好病', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.381374', '2024-03-11 18:18:25.381374', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b289b920df9011ee8ff5ccdae0d178e3', '1002', 'B', '服务态度', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.382554', '2024-03-11 18:18:25.382554', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b289eacedf9011ee8ff5ccdae0d178e3', '1002', 'C', '住院环境', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.383796', '2024-03-11 18:18:25.383796', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28a1b2bdf9011ee8ff5ccdae0d178e3', '1002', 'D', '医疗设备', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.385064', '2024-03-11 18:18:25.385064', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28a46f1df9011ee8ff5ccdae0d178e3', '1003', 'A', '很满意', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.386189', '2024-03-11 18:18:25.386189', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28a722ddf9011ee8ff5ccdae0d178e3', '1003', 'B', '满意', NULL, NULL, NULL, 40, NULL, '2024-03-11 18:18:25.387296', '2024-03-11 18:18:25.387296', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28a9decdf9011ee8ff5ccdae0d178e3', '1003', 'C', '一般', NULL, NULL, NULL, 30, NULL, '2024-03-11 18:18:25.388416', '2024-03-11 18:18:25.388416', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28acc1cdf9011ee8ff5ccdae0d178e3', '1003', 'D', '不满意', NULL, NULL, NULL, 20, NULL, '2024-03-11 18:18:25.389592', '2024-03-11 18:18:25.389592', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28afed4df9011ee8ff5ccdae0d178e3', '1004', 'A', '清晰明确', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.390886', '2024-03-11 18:18:25.390886', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28b389bdf9011ee8ff5ccdae0d178e3', '1004', 'B', '一般', NULL, NULL, NULL, 30, NULL, '2024-03-11 18:18:25.392353', '2024-03-11 18:18:25.392353', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28b6905df9011ee8ff5ccdae0d178e3', '1004', 'C', '不明确', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.393615', '2024-03-11 18:18:25.393615', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28b93f8df9011ee8ff5ccdae0d178e3', '1004', 'D', '没注意', NULL, NULL, NULL, 25, NULL, '2024-03-11 18:18:25.394716', '2024-03-11 18:18:25.394716', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28bbff2df9011ee8ff5ccdae0d178e3', '1005', 'A', '科室设置齐全，就诊方便', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.395840', '2024-03-11 18:18:25.395840', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28beaeadf9011ee8ff5ccdae0d178e3', '1005', 'B', '科室设置齐全，但服务质量一般', NULL, NULL, NULL, 30, NULL, '2024-03-11 18:18:25.396939', '2024-03-11 18:18:25.396939', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28c38f4df9011ee8ff5ccdae0d178e3', '1005', 'C', '科室过少，无法满足就诊需求', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.398933', '2024-03-11 18:18:25.398933', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28c689adf9011ee8ff5ccdae0d178e3', '1005', 'D', '未关注或未涉及', NULL, NULL, NULL, 25, NULL, '2024-03-11 18:18:25.400143', '2024-03-11 18:18:25.400143', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28ca3d5df9011ee8ff5ccdae0d178e3', '1006', 'A', '非常耐心细致', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.401639', '2024-03-11 18:18:25.401639', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28cd723df9011ee8ff5ccdae0d178e3', '1006', 'B', '较为耐心细致', NULL, NULL, NULL, 40, NULL, '2024-03-11 18:18:25.402980', '2024-03-11 18:18:25.402980', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28d076adf9011ee8ff5ccdae0d178e3', '1006', 'C', '一般', NULL, NULL, NULL, 30, NULL, '2024-03-11 18:18:25.404218', '2024-03-11 18:18:25.404218', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28d3aa3df9011ee8ff5ccdae0d178e3', '1006', 'D', '不耐心细致', NULL, NULL, NULL, 20, NULL, '2024-03-11 18:18:25.405531', '2024-03-11 18:18:25.405531', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28d6818df9011ee8ff5ccdae0d178e3', '1006', 'E', '敷衍了事', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.406698', '2024-03-11 18:18:25.406698', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28d9b51df9011ee8ff5ccdae0d178e3', '1007', 'A', '很满意', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.407979', '2024-03-11 18:18:25.407979', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28dd76bdf9011ee8ff5ccdae0d178e3', '1007', 'B', '满意', NULL, NULL, NULL, 40, NULL, '2024-03-11 18:18:25.409526', '2024-03-11 18:18:25.409526', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28e0a8bdf9011ee8ff5ccdae0d178e3', '1007', 'C', '一般', NULL, NULL, NULL, 30, NULL, '2024-03-11 18:18:25.410852', '2024-03-11 18:18:25.410852', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28e38f9df9011ee8ff5ccdae0d178e3', '1007', 'D', '不满意', NULL, NULL, NULL, 20, NULL, '2024-03-11 18:18:25.412044', '2024-03-11 18:18:25.412044', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28e67f1df9011ee8ff5ccdae0d178e3', '1007', 'E', '很不满意', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.413236', '2024-03-11 18:18:25.413236', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28e9462df9011ee8ff5ccdae0d178e3', '1008', 'A', '是的，很满意', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.414387', '2024-03-11 18:18:25.414387', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28ebf96df9011ee8ff5ccdae0d178e3', '1008', 'B', '一般，感觉不明显', NULL, NULL, NULL, 30, NULL, '2024-03-11 18:18:25.415493', '2024-03-11 18:18:25.415493', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28ef74edf9011ee8ff5ccdae0d178e3', '1008', 'C', '很不满意，存在惜用现象', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.416892', '2024-03-11 18:18:25.416892', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28f26dddf9011ee8ff5ccdae0d178e3', '1009', 'A', '是', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.418131', '2024-03-11 18:18:25.418131', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28f50f1df9011ee8ff5ccdae0d178e3', '1009', 'B', '否', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.419207', '2024-03-11 18:18:25.419207', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28f7adbdf9011ee8ff5ccdae0d178e3', '1010', 'A', '是', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.420288', '2024-03-11 18:18:25.420288', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28fad71df9011ee8ff5ccdae0d178e3', '1010', 'B', '否', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.421579', '2024-03-11 18:18:25.421579', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b28fd9cfdf9011ee8ff5ccdae0d178e3', '1011', 'A', '优先', NULL, NULL, NULL, 50, NULL, '2024-03-11 18:18:25.422715', '2024-03-11 18:18:25.422715', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b2900627df9011ee8ff5ccdae0d178e3', '1011', 'B', '优先政策落实不到位', NULL, NULL, NULL, 30, NULL, '2024-03-11 18:18:25.423850', '2024-03-11 18:18:25.423850', 'admin', 'admin', b'1');
INSERT INTO `t_standard_answer` VALUES ('b2903caadf9011ee8ff5ccdae0d178e3', '1011', 'B', '没有优先', NULL, NULL, NULL, 10, NULL, '2024-03-11 18:18:25.425228', '2024-03-11 18:18:25.425228', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for t_survey_log
-- ----------------------------
DROP TABLE IF EXISTS `t_survey_log`;
CREATE TABLE `t_survey_log`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '记录ID',
  `questionnaire_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调查单记录ID',
  `obj_hospital` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '被调查对象所属医院',
  `obj_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '被调查对象唯一ID（医院就诊卡ID，医保卡ID等）',
  `obj_phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '被调查对象电话号码',
  `obj_idcard_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '被调查对象身份证号码',
  `obj_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '被调查对象姓名',
  `obj_wechat` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '被调查对象微信号',
  `score` int(11) NULL DEFAULT NULL COMMENT '总得分',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '答题者信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `branch_id` bigint(20) NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int(11) NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'AT transaction mode undo table' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
