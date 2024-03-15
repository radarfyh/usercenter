/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql
 Source Server Type    : MySQL
 Source Server Version : 50742
 Source Host           : localhost:3306
 Source Schema         : user_center

 Target Server Type    : MySQL
 Target Server Version : 50742
 File Encoding         : 65001

 Date: 15/03/2024 18:11:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('MetanetClusteredScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('MetanetClusteredScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('MetanetClusteredScheduler', 'LAPTOP-S47RJNDF1710381781815', 1710389204397, 7500);
INSERT INTO `qrtz_scheduler_state` VALUES ('MetanetClusteredScheduler', 'LAPTOP-S47RJNDF1710381819438', 1710389205514, 7500);

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(190) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_acls
-- ----------------------------
DROP TABLE IF EXISTS `uc_acls`;
CREATE TABLE `uc_acls`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色ID',
  `resource_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '资源ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '访问控制列表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_acls
-- ----------------------------
INSERT INTO `uc_acls` VALUES ('224', '4', '1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('225', '4', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('226', '4', '9', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('227', '4', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('228', '4', '13', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('229', '4', '4', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('230', '4', '17', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('231', '4', '5', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('232', '4', '21', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('233', '4', '6', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('234', '4', '7', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('235', '4', '31', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('236', '4', '8', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('237', '4', '25', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('238', '4', '26', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('239', '4', '27', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('240', '4', '28', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('241', '4', '29', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('242', '4', '30', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('243', '4', '35', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('388', '2', '1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('389', '2', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('390', '2', '9', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('391', '2', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('392', '2', '13', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('393', '2', '17', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('394', '2', '5', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('395', '2', '21', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('396', '2', '7', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('397', '2', '31', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('398', '2', '8', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('399', '2', '6', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('400', '2', '35', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('401', '2', '28', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('402', '2', '29', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('403', '2', '30', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('404', '3', '1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('405', '3', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('406', '3', '9', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('407', '3', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('408', '3', '13', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('409', '3', '8', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('410', '3', '6', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('411', '3', '28', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('412', '3', '29', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('413', '3', '30', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('431', '8', '1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('432', '8', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('433', '8', '9', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('434', '8', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('435', '8', '13', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('436', '8', '4', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('437', '8', '17', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('438', '8', '5', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('439', '8', '21', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('440', '8', '7', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('441', '8', '31', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('442', '8', '8', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('443', '8', '6', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_acls` VALUES ('444', '8', '35', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for uc_apps
-- ----------------------------
DROP TABLE IF EXISTS `uc_apps`;
CREATE TABLE `uc_apps`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '应用id',
  `channel_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '渠道id',
  `app_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '应用名称',
  `package_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '包名',
  `auth_type` enum('MAC','SN','MACSN') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'MACSN' COMMENT '认证方式',
  `app_type` enum('0','1') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '0' COMMENT '应用类型-0 APP，1 固件',
  `instruction` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '应用说明',
  `enable_sn` bit(1) NOT NULL DEFAULT b'1' COMMENT '启动激活码激活',
  `app_key` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_secret` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '应用' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_appstore
-- ----------------------------
DROP TABLE IF EXISTS `uc_appstore`;
CREATE TABLE `uc_appstore`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '应用商店id',
  `channel_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '渠道id',
  `app_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '应用名称',
  `package_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '包名',
  `call_class` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '调用类名',
  `file_size` decimal(19, 2) NOT NULL DEFAULT 0.00 COMMENT '文件大小(b)字节',
  `version_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '版本名',
  `version_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '版本号',
  `url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件地址',
  `md5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5值',
  `icon` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图标',
  `instruction` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '应用说明',
  `app_scope` enum('0','1') CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '应用范围-0所有/1指定',
  `download_number` int(11) NULL DEFAULT NULL COMMENT '下载次数',
  `phase_tag` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '阶段标签(0幼儿,1小学,2中学,3高中,100综合)',
  `release_time` date NULL DEFAULT NULL COMMENT '发布时间',
  `content_type` enum('EDU','AMUSEMENT') CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容类型',
  `developer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '开发商',
  `images` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '应用截图',
  `enable` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否启用',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '应用商店' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_area_dept
-- ----------------------------
DROP TABLE IF EXISTS `uc_area_dept`;
CREATE TABLE `uc_area_dept`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `area_id` bigint(20) NULL DEFAULT NULL COMMENT '区域ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '机构ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '区域机构关系表，备用' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_areas
-- ----------------------------
DROP TABLE IF EXISTS `uc_areas`;
CREATE TABLE `uc_areas`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '代号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '区域名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级区域ID，一级区域为0',
  `acreage` bigint(20) NULL DEFAULT NULL COMMENT '面积，单位：平方公里',
  `population` bigint(20) NULL DEFAULT NULL COMMENT '人口，单位：万人',
  `households` bigint(20) NULL DEFAULT NULL COMMENT '户数',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  `order_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `k_sort`(`sort`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '区域管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_areas
-- ----------------------------
INSERT INTO `uc_areas` VALUES ('1', 'sh', '上海', 0, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_areas` VALUES ('2', 'mh', '闵行区', 1, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_areas` VALUES ('3', 'zz', '紫竹科技园', 2, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);

-- ----------------------------
-- Table structure for uc_browses
-- ----------------------------
DROP TABLE IF EXISTS `uc_browses`;
CREATE TABLE `uc_browses`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '浏览id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `resource_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '资源id',
  `content_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容id',
  `ratio` double(3, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '播放占比%',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `k_user_id`(`user_id`) USING BTREE,
  INDEX `k_resource_id`(`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '浏览' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_certifications
-- ----------------------------
DROP TABLE IF EXISTS `uc_certifications`;
CREATE TABLE `uc_certifications`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `mode` int(11) NULL DEFAULT 0 COMMENT '认证方式 0短信 1银行 2人脸识别 3公有云实名认证服务 4身份证查验 5护照查验',
  `certfied_real_name` int(11) NULL DEFAULT 0 COMMENT '是否已通过实名认证 0未通过 1通过',
  `organization_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '实名认证机构',
  `certfied_result` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '实名认证机构返回的认证结果',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '身份证姓名',
  `id_card_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '身份证号码',
  `passport_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '护照号码',
  `driving_license_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '驾照号码',
  `url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '认证资料链接',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  `id_card_mumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户认证表，不含密码认证' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_collections
-- ----------------------------
DROP TABLE IF EXISTS `uc_collections`;
CREATE TABLE `uc_collections`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '收藏id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `resource_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '资源id',
  `content_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `k_user_id`(`user_id`) USING BTREE,
  INDEX `k_resource_id`(`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_departments
-- ----------------------------
DROP TABLE IF EXISTS `uc_departments`;
CREATE TABLE `uc_departments`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '代号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '机构名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
  `department_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT 'department' COMMENT '类型，company公司，department部门，office-room科室，group小组，other其他',
  `principal` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '负责人',
  `department_level` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '级别',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话',
  `fax` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '传真',
  `postcode` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮编',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  `order_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_code`(`code`) USING BTREE,
  INDEX `k_sort`(`sort`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '机构管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_departments
-- ----------------------------
INSERT INTO `uc_departments` VALUES ('17', 'yjt', '第一集团', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('18', 'ejt', '第二集团', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('19', 'sjt', '第三集团', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('21', 'sh', '上海分公司', 18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('22', 'bj', '北京分公司', 17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('23', 'gz', '广州分公司', 18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('25', 'rj', '软件研发部', 22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('26', 'yj', '硬件研发部', 21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('27', 'yw', '交付运维部', 23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('29', 'yx', '营销部', 22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('30', 'sc', '市场部', 23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('33', 'xt', '系统组', 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('34', 'kf', '开发组', 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);
INSERT INTO `uc_departments` VALUES ('35', 'cs', '测试组', 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', NULL);

-- ----------------------------
-- Table structure for uc_diaries
-- ----------------------------
DROP TABLE IF EXISTS `uc_diaries`;
CREATE TABLE `uc_diaries`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '日记id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `content` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '日记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_dictionaries
-- ----------------------------
DROP TABLE IF EXISTS `uc_dictionaries`;
CREATE TABLE `uc_dictionaries`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '数据值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标签名',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '类型',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '描述',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `k_sort`(`sort`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_dictionaries
-- ----------------------------
INSERT INTO `uc_dictionaries` VALUES ('3', 'male', '男', 'sex', '性别', 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_dictionaries` VALUES ('4', 'female', '女', 'sex', '性别', 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for uc_family_members
-- ----------------------------
DROP TABLE IF EXISTS `uc_family_members`;
CREATE TABLE `uc_family_members`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '标识',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '成员id，关联users表',
  `master_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '家主id，关联users表',
  `relation_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '关系名称',
  `education` int(11) NULL DEFAULT NULL COMMENT '教育阶段-0幼儿园/1小学/2中学',
  `grade` int(11) NULL DEFAULT NULL COMMENT '年级-1/2/3/4/5/6/7/8/9/10/11/12',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '家庭成员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_logs
-- ----------------------------
DROP TABLE IF EXISTS `uc_logs`;
CREATE TABLE `uc_logs`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求参数',
  `execute_time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'IP地址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '系统日志,不允许修改删除' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_prizes
-- ----------------------------
DROP TABLE IF EXISTS `uc_prizes`;
CREATE TABLE `uc_prizes`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品id',
  `channel_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '渠道id',
  `prize_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `prize_img` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品图片',
  `score` decimal(9, 2) UNSIGNED NOT NULL COMMENT '积分',
  `inventory` double(9, 0) UNSIGNED NOT NULL DEFAULT 1 COMMENT '库存',
  `prize_status` enum('UP','DOWN') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'DOWN' COMMENT '商品状态-UP:上架/DOWN:下架',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_resources
-- ----------------------------
DROP TABLE IF EXISTS `uc_resources`;
CREATE TABLE `uc_resources`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '资源名称',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '父资源ID，一级资源为NULL或者空串',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '资源URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址), 4.表记录，使用rec:{tablename}/{id}，其中多个tablename使用逗号分隔，多个id使用逗号分隔',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  `resource_type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录/元数据   1：菜单   2：按钮 3：信息项/数据记录',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图标',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE,
  INDEX `k_sort`(`sort`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '资源管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_resources
-- ----------------------------
INSERT INTO `uc_resources` VALUES ('1', '系统管理', NULL, NULL, NULL, 0, 'el-icon-setting', 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('10', '新增用户', '2', NULL, 'sys:user:add', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('11', '修改用户', '2', NULL, 'sys:user:edit', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('12', '删除用户', '2', NULL, 'sys:user:delete', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('13', '查看部门', '3', NULL, 'sys:dept:view', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('14', '新增部门', '3', NULL, 'sys:dept:add', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('15', '修改部门', '3', NULL, 'sys:dept:edit', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('16', '删除部门', '3', NULL, 'sys:dept:delete', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('17', '查看角色', '4', NULL, 'sys:role:view', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('18', '新增角色', '4', NULL, 'sys:role:add', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('19', '修改角色', '4', NULL, 'sys:role:edit', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('2', '用户管理', '1', '/sys/user', NULL, 1, 'el-icon-service', 1, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('20', '删除角色', '4', NULL, 'sys:role:delete', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('21', '查看菜单', '5', NULL, 'sys:menu:view', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('22', '新增菜单', '5', NULL, 'sys:menu:add', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('23', '修改菜单', '5', NULL, 'sys:menu:edit', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('24', '删除菜单', '5', NULL, 'sys:menu:delete', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('3', '机构管理', '1', '/sys/dept', NULL, 1, 'el-icon-news', 2, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('31', '查看字典', '7', NULL, 'sys:dict:view', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('32', '新增字典', '7', NULL, 'sys:dict:add', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('33', '修改字典', '7', NULL, 'sys:dict:edit', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('34', '删除字典', '7', NULL, 'sys:dict:delete', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('4', '角色管理', '1', '/sys/role', NULL, 1, 'el-icon-view', 4, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('5', '资源管理', '1', '/sys/menu', NULL, 1, 'el-icon-menu', 5, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('7', '字典管理', '1', '/sys/dict', NULL, 1, 'el-icon-edit-outline', 7, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('8', '系统日志', '1', '/sys/log', 'sys:log:view', 1, 'el-icon-info', 8, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_resources` VALUES ('9', '查看用户', '2', NULL, 'sys:user:view', 2, NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for uc_rewards
-- ----------------------------
DROP TABLE IF EXISTS `uc_rewards`;
CREATE TABLE `uc_rewards`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '奖励id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `resource_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '资源id',
  `content_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容id',
  `reward_number` double(3, 0) UNSIGNED NOT NULL COMMENT '奖励数量',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_resource_id`(`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '星星奖励记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `uc_role_dept`;
CREATE TABLE `uc_role_dept`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色ID',
  `dept_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '机构ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色机构关系表，备用' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_roles
-- ----------------------------
DROP TABLE IF EXISTS `uc_roles`;
CREATE TABLE `uc_roles`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色代号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '角色名称',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '父ID，一级为空',
  `role_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '职责/类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_code`(`code`) USING BTREE,
  INDEX `k_sort`(`sort`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_roles
-- ----------------------------
INSERT INTO `uc_roles` VALUES ('1', 'admin', '超级管理员', '0', NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_roles` VALUES ('2', 'dev', '开发人员', '0', NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_roles` VALUES ('3', 'test', '测试人员', '0', NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_roles` VALUES ('4', 'project', '项目经理', '0', NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_roles` VALUES ('8', 'mng', '部门经理', '0', NULL, 0, NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for uc_score_detail
-- ----------------------------
DROP TABLE IF EXISTS `uc_score_detail`;
CREATE TABLE `uc_score_detail`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户积分明细id',
  `user_score_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户积分id',
  `change_value` decimal(9, 2) NOT NULL COMMENT '交易值',
  `after_value` decimal(9, 2) UNSIGNED NOT NULL COMMENT '交易后的值',
  `change_type` enum('EDU','EXCHANGE') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '交易类型-EDU:学习/EXCHANGE:兑换',
  `join_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '关联业务id, 现解释为appID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户积分明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_score_exchanges
-- ----------------------------
DROP TABLE IF EXISTS `uc_score_exchanges`;
CREATE TABLE `uc_score_exchanges`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户积分兑换id',
  `order_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `channel_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '渠道id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `prize_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品id',
  `prize_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `prize_img` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品图片',
  `score` decimal(9, 2) UNSIGNED NOT NULL COMMENT '积分',
  `logistics_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '物流id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_order_number`(`order_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户积分兑换记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_sec_config
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_config`;
CREATE TABLE `uc_sec_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_config
-- ----------------------------
INSERT INTO `uc_sec_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2024-03-13 19:02:13', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `uc_sec_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2024-03-13 19:02:13', '', NULL, '初始化密码 123456');
INSERT INTO `uc_sec_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2024-03-13 19:02:13', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `uc_sec_config` VALUES (4, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2024-03-13 19:02:13', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for uc_sec_dept
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_dept`;
CREATE TABLE `uc_sec_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_dept
-- ----------------------------
INSERT INTO `uc_sec_dept` VALUES (100, 0, '0', 'TESTU科技', 0, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);
INSERT INTO `uc_sec_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL);

-- ----------------------------
-- Table structure for uc_sec_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_dict_data`;
CREATE TABLE `uc_sec_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_dict_data
-- ----------------------------
INSERT INTO `uc_sec_dict_data` VALUES (1, 1, '男', '0', 'uc_sec_user_sex', '', '', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '性别男');
INSERT INTO `uc_sec_dict_data` VALUES (2, 2, '女', '1', 'uc_sec_user_sex', '', '', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '性别女');
INSERT INTO `uc_sec_dict_data` VALUES (3, 3, '未知', '2', 'uc_sec_user_sex', '', '', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '性别未知');
INSERT INTO `uc_sec_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '显示菜单');
INSERT INTO `uc_sec_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '隐藏菜单');
INSERT INTO `uc_sec_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '正常状态');
INSERT INTO `uc_sec_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '停用状态');
INSERT INTO `uc_sec_dict_data` VALUES (8, 1, '正常', '0', 'uc_sec_job_status', '', 'primary', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '正常状态');
INSERT INTO `uc_sec_dict_data` VALUES (9, 2, '暂停', '1', 'uc_sec_job_status', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '停用状态');
INSERT INTO `uc_sec_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'uc_sec_job_group', '', '', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '默认分组');
INSERT INTO `uc_sec_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'uc_sec_job_group', '', '', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '系统分组');
INSERT INTO `uc_sec_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '系统默认是');
INSERT INTO `uc_sec_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '系统默认否');
INSERT INTO `uc_sec_dict_data` VALUES (14, 1, '通知', '1', 'uc_sec_notice_type', '', 'warning', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '通知');
INSERT INTO `uc_sec_dict_data` VALUES (15, 2, '公告', '2', 'uc_sec_notice_type', '', 'success', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '公告');
INSERT INTO `uc_sec_dict_data` VALUES (16, 1, '正常', '0', 'uc_sec_notice_status', '', 'primary', 'Y', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '正常状态');
INSERT INTO `uc_sec_dict_data` VALUES (17, 2, '关闭', '1', 'uc_sec_notice_status', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '关闭状态');
INSERT INTO `uc_sec_dict_data` VALUES (18, 99, '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '其他操作');
INSERT INTO `uc_sec_dict_data` VALUES (19, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '新增操作');
INSERT INTO `uc_sec_dict_data` VALUES (20, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '修改操作');
INSERT INTO `uc_sec_dict_data` VALUES (21, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '删除操作');
INSERT INTO `uc_sec_dict_data` VALUES (22, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '授权操作');
INSERT INTO `uc_sec_dict_data` VALUES (23, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '导出操作');
INSERT INTO `uc_sec_dict_data` VALUES (24, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '导入操作');
INSERT INTO `uc_sec_dict_data` VALUES (25, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '强退操作');
INSERT INTO `uc_sec_dict_data` VALUES (26, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '生成操作');
INSERT INTO `uc_sec_dict_data` VALUES (27, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '清空操作');
INSERT INTO `uc_sec_dict_data` VALUES (28, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '正常状态');
INSERT INTO `uc_sec_dict_data` VALUES (29, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '停用状态');

-- ----------------------------
-- Table structure for uc_sec_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_dict_type`;
CREATE TABLE `uc_sec_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_dict_type
-- ----------------------------
INSERT INTO `uc_sec_dict_type` VALUES (1, '用户性别', 'uc_sec_user_sex', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '用户性别列表');
INSERT INTO `uc_sec_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '菜单状态列表');
INSERT INTO `uc_sec_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '系统开关列表');
INSERT INTO `uc_sec_dict_type` VALUES (4, '任务状态', 'uc_sec_job_status', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '任务状态列表');
INSERT INTO `uc_sec_dict_type` VALUES (5, '任务分组', 'uc_sec_job_group', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '任务分组列表');
INSERT INTO `uc_sec_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '系统是否列表');
INSERT INTO `uc_sec_dict_type` VALUES (7, '通知类型', 'uc_sec_notice_type', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '通知类型列表');
INSERT INTO `uc_sec_dict_type` VALUES (8, '通知状态', 'uc_sec_notice_status', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '通知状态列表');
INSERT INTO `uc_sec_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '操作类型列表');
INSERT INTO `uc_sec_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '登录状态列表');

-- ----------------------------
-- Table structure for uc_sec_job
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_job`;
CREATE TABLE `uc_sec_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_job
-- ----------------------------
INSERT INTO `uc_sec_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2024-03-13 19:02:13', '', NULL, '');

-- ----------------------------
-- Table structure for uc_sec_job_log
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_job_log`;
CREATE TABLE `uc_sec_job_log`  (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_sec_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_logininfor`;
CREATE TABLE `uc_sec_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示信息',
  `access_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_sec_menu
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_menu`;
CREATE TABLE `uc_sec_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1061 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_menu
-- ----------------------------
INSERT INTO `uc_sec_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2024-03-13 19:02:13', '', NULL, '系统管理目录');
INSERT INTO `uc_sec_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2024-03-13 19:02:13', '', NULL, '系统监控目录');
INSERT INTO `uc_sec_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2024-03-13 19:02:13', '', NULL, '系统工具目录');
INSERT INTO `uc_sec_menu` VALUES (4, 'TESTU官网', 0, 4, 'http://ruoyi.vip', NULL, '', 0, 0, 'M', '0', '0', '', 'guide', 'admin', '2024-03-13 19:02:13', '', NULL, 'TESTU官网地址');
INSERT INTO `uc_sec_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2024-03-13 19:02:13', '', NULL, '用户管理菜单');
INSERT INTO `uc_sec_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2024-03-13 19:02:13', '', NULL, '角色管理菜单');
INSERT INTO `uc_sec_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2024-03-13 19:02:13', '', NULL, '菜单管理菜单');
INSERT INTO `uc_sec_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2024-03-13 19:02:13', '', NULL, '部门管理菜单');
INSERT INTO `uc_sec_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2024-03-13 19:02:13', '', NULL, '岗位管理菜单');
INSERT INTO `uc_sec_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2024-03-13 19:02:13', '', NULL, '字典管理菜单');
INSERT INTO `uc_sec_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2024-03-13 19:02:13', '', NULL, '参数设置菜单');
INSERT INTO `uc_sec_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2024-03-13 19:02:13', '', NULL, '通知公告菜单');
INSERT INTO `uc_sec_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2024-03-13 19:02:13', '', NULL, '日志管理菜单');
INSERT INTO `uc_sec_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2024-03-13 19:02:13', '', NULL, '在线用户菜单');
INSERT INTO `uc_sec_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2024-03-13 19:02:13', '', NULL, '定时任务菜单');
INSERT INTO `uc_sec_menu` VALUES (111, 'Sentinel控制台', 2, 3, 'http://localhost:8718', '', '', 0, 0, 'C', '0', '0', 'monitor:sentinel:list', 'sentinel', 'admin', '2024-03-13 19:02:13', '', NULL, '流量控制菜单');
INSERT INTO `uc_sec_menu` VALUES (112, 'Nacos控制台', 2, 4, 'http://localhost:8848/nacos', '', '', 0, 0, 'C', '0', '0', 'monitor:nacos:list', 'nacos', 'admin', '2024-03-13 19:02:13', '', NULL, '服务治理菜单');
INSERT INTO `uc_sec_menu` VALUES (113, 'Admin控制台', 2, 5, 'http://localhost:9100/login', '', '', 0, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2024-03-13 19:02:13', '', NULL, '服务监控菜单');
INSERT INTO `uc_sec_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2024-03-13 19:02:13', '', NULL, '表单构建菜单');
INSERT INTO `uc_sec_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2024-03-13 19:02:13', '', NULL, '代码生成菜单');
INSERT INTO `uc_sec_menu` VALUES (116, '系统接口', 3, 3, 'http://localhost:8080/swagger-ui/index.html', '', '', 0, 0, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2024-03-13 19:02:13', '', NULL, '系统接口菜单');
INSERT INTO `uc_sec_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'system/operlog/index', '', 1, 0, 'C', '0', '0', 'system:operlog:list', 'form', 'admin', '2024-03-13 19:02:13', '', NULL, '操作日志菜单');
INSERT INTO `uc_sec_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'system/logininfor/index', '', 1, 0, 'C', '0', '0', 'system:logininfor:list', 'logininfor', 'admin', '2024-03-13 19:02:13', '', NULL, '登录日志菜单');
INSERT INTO `uc_sec_menu` VALUES (1000, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1001, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1002, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1003, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1004, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1005, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1006, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1007, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1008, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1009, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1010, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1011, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1012, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1013, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1014, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1015, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1016, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1017, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1018, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1019, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1020, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1021, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1022, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1023, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1024, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1025, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1026, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1027, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1028, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1029, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1030, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1031, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1032, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1033, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1034, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1035, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1036, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1037, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1038, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1039, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1040, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1041, '日志导出', 500, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1042, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1043, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1044, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1045, '账户解锁', 501, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:unlock', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1054, '任务导出', 110, 6, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2024-03-13 19:02:13', '', NULL, '');

-- ----------------------------
-- Table structure for uc_sec_notice
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_notice`;
CREATE TABLE `uc_sec_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_notice
-- ----------------------------
INSERT INTO `uc_sec_notice` VALUES (1, '温馨提醒：2018-07-01 TESTU新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2024-03-13 19:02:13', '', NULL, '管理员');
INSERT INTO `uc_sec_notice` VALUES (2, '维护通知：2018-07-01 TESTU系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2024-03-13 19:02:13', '', NULL, '管理员');

-- ----------------------------
-- Table structure for uc_sec_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_oper_log`;
CREATE TABLE `uc_sec_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_sec_post
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_post`;
CREATE TABLE `uc_sec_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_post
-- ----------------------------
INSERT INTO `uc_sec_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2024-03-13 19:02:13', '', NULL, '');
INSERT INTO `uc_sec_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2024-03-13 19:02:13', '', NULL, '');

-- ----------------------------
-- Table structure for uc_sec_role
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_role`;
CREATE TABLE `uc_sec_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_role
-- ----------------------------
INSERT INTO `uc_sec_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '超级管理员');
INSERT INTO `uc_sec_role` VALUES (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2024-03-13 19:02:13', '', NULL, '普通角色');

-- ----------------------------
-- Table structure for uc_sec_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_role_dept`;
CREATE TABLE `uc_sec_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_role_dept
-- ----------------------------
INSERT INTO `uc_sec_role_dept` VALUES (2, 100);
INSERT INTO `uc_sec_role_dept` VALUES (2, 101);
INSERT INTO `uc_sec_role_dept` VALUES (2, 105);

-- ----------------------------
-- Table structure for uc_sec_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_role_menu`;
CREATE TABLE `uc_sec_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_role_menu
-- ----------------------------
INSERT INTO `uc_sec_role_menu` VALUES (2, 1);
INSERT INTO `uc_sec_role_menu` VALUES (2, 2);
INSERT INTO `uc_sec_role_menu` VALUES (2, 3);
INSERT INTO `uc_sec_role_menu` VALUES (2, 4);
INSERT INTO `uc_sec_role_menu` VALUES (2, 100);
INSERT INTO `uc_sec_role_menu` VALUES (2, 101);
INSERT INTO `uc_sec_role_menu` VALUES (2, 102);
INSERT INTO `uc_sec_role_menu` VALUES (2, 103);
INSERT INTO `uc_sec_role_menu` VALUES (2, 104);
INSERT INTO `uc_sec_role_menu` VALUES (2, 105);
INSERT INTO `uc_sec_role_menu` VALUES (2, 106);
INSERT INTO `uc_sec_role_menu` VALUES (2, 107);
INSERT INTO `uc_sec_role_menu` VALUES (2, 108);
INSERT INTO `uc_sec_role_menu` VALUES (2, 109);
INSERT INTO `uc_sec_role_menu` VALUES (2, 110);
INSERT INTO `uc_sec_role_menu` VALUES (2, 111);
INSERT INTO `uc_sec_role_menu` VALUES (2, 112);
INSERT INTO `uc_sec_role_menu` VALUES (2, 113);
INSERT INTO `uc_sec_role_menu` VALUES (2, 114);
INSERT INTO `uc_sec_role_menu` VALUES (2, 115);
INSERT INTO `uc_sec_role_menu` VALUES (2, 116);
INSERT INTO `uc_sec_role_menu` VALUES (2, 500);
INSERT INTO `uc_sec_role_menu` VALUES (2, 501);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1000);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1001);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1002);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1003);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1004);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1005);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1006);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1007);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1008);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1009);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1010);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1011);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1012);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1013);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1014);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1015);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1016);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1017);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1018);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1019);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1020);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1021);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1022);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1023);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1024);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1025);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1026);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1027);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1028);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1029);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1030);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1031);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1032);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1033);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1034);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1035);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1036);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1037);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1038);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1039);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1040);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1041);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1042);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1043);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1044);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1045);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1046);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1047);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1048);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1049);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1050);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1051);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1052);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1053);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1054);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1055);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1056);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1057);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1058);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1059);
INSERT INTO `uc_sec_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for uc_sec_user
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_user`;
CREATE TABLE `uc_sec_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_user
-- ----------------------------
INSERT INTO `uc_sec_user` VALUES (1, 103, 'admin', 'TESTU', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2024-03-13 19:02:13', 'admin', '2024-03-13 19:02:13', '', NULL, '管理员');
INSERT INTO `uc_sec_user` VALUES (2, 105, 'ry', 'TESTU', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2024-03-13 19:02:13', 'admin', '2024-03-13 19:02:13', '', NULL, '测试员');

-- ----------------------------
-- Table structure for uc_sec_user_post
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_user_post`;
CREATE TABLE `uc_sec_user_post`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_user_post
-- ----------------------------
INSERT INTO `uc_sec_user_post` VALUES (1, 1);
INSERT INTO `uc_sec_user_post` VALUES (2, 2);

-- ----------------------------
-- Table structure for uc_sec_user_role
-- ----------------------------
DROP TABLE IF EXISTS `uc_sec_user_role`;
CREATE TABLE `uc_sec_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_sec_user_role
-- ----------------------------
INSERT INTO `uc_sec_user_role` VALUES (1, 1);
INSERT INTO `uc_sec_user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for uc_standard
-- ----------------------------
DROP TABLE IF EXISTS `uc_standard`;
CREATE TABLE `uc_standard`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `standard_type` enum('HEIGHT','WEIGHT') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sex` enum('GIRL','BOY') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '性别',
  `month_age` int(10) UNSIGNED NOT NULL COMMENT '月龄',
  `sd3_` double(10, 2) UNSIGNED NOT NULL,
  `sd2_` double(10, 2) UNSIGNED NOT NULL,
  `sd1_` double(10, 2) UNSIGNED NOT NULL,
  `center` double(10, 2) UNSIGNED NOT NULL,
  `sd1` double(10, 2) UNSIGNED NOT NULL,
  `sd2` double(10, 2) UNSIGNED NOT NULL,
  `sd3` double(10, 2) UNSIGNED NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '身高体重' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_target_prizes
-- ----------------------------
DROP TABLE IF EXISTS `uc_target_prizes`;
CREATE TABLE `uc_target_prizes`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户订购id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `prize_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_prize_id`(`user_id`, `prize_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户订购信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_user_addresses
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_addresses`;
CREATE TABLE `uc_user_addresses`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `contact_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '联系人姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '联系电话',
  `province_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '省id',
  `city_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '市id',
  `county_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '县id',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '联系地址',
  `zip_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮编',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系邮箱',
  `fax` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '联系传真',
  `default_status` bit(1) NOT NULL DEFAULT b'1' COMMENT '默认状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_contact_name`(`contact_name`) USING BTREE,
  UNIQUE INDEX `uk_email`(`email`) USING BTREE,
  INDEX `k_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `FKi3vbogqm8kgi4r50jxkbodchw` FOREIGN KEY (`user_id`) REFERENCES `uc_users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户地址，收货或者发货' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_user_area
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_area`;
CREATE TABLE `uc_user_area`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `area_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '区域ID',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '区域用户机构关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_dept`;
CREATE TABLE `uc_user_dept`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `dept_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '机构ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户机构关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_user_dept
-- ----------------------------
INSERT INTO `uc_user_dept` VALUES ('1001', '1', '4', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1002', '22', '34', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1003', '23', '34', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1004', '24', '34', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1005', '25', '33', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1006', '26', '33', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1007', '27', '33', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1008', '28', '33', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1009', '29', '35', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1010', '30', '35', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1011', '31', '35', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_dept` VALUES ('1012', '32', '35', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for uc_user_logins
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_logins`;
CREATE TABLE `uc_user_logins`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录日志标号',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `device_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '设备ID',
  `version_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '版本ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  `tag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '0虚拟/1真实',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `k_user_id`(`user_id`) USING BTREE,
  INDEX `k_version_id`(`version_id`) USING BTREE,
  INDEX `k_device_id`(`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户登录记录，不允许修改、删除' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_user_logistics
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_logistics`;
CREATE TABLE `uc_user_logistics`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `consigner_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '发货人ID',
  `mode` int(11) NOT NULL COMMENT '物流方式：-1未知，0发货，1收货',
  `consignee_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '收货人ID',
  `courier_number` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '快递单号',
  `sent_time` timestamp(6) NULL DEFAULT NULL COMMENT '发货时间',
  `logistics_status` int(11) NOT NULL COMMENT '物流状态。-1未知，0准备中，1在途，2在中转仓库，3到达，4已签收',
  `logistics_process` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '流程描述，描述几点到了哪个点',
  `received_time` timestamp(6) NULL DEFAULT NULL COMMENT '发货时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_courier_number`(`courier_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户物流' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_role`;
CREATE TABLE `uc_user_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_user_role
-- ----------------------------
INSERT INTO `uc_user_role` VALUES ('1', '1', '1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('2', '2', '1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('26', '5', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('33', '6', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('34', '4', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('35', '9', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('36', '10', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('37', '11', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('38', '12', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('39', '15', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('41', '16', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('42', '8', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('43', '7', '4', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('45', '18', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('46', '17', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('47', '3', '4', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('48', '21', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('50', '23', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('51', '24', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('52', '25', '8', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('53', '26', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('54', '27', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('56', '29', '8', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('57', '31', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('58', '30', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('59', '32', '3', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('68', '33', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('69', '22', '8', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('70', '22', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_role` VALUES ('71', '28', '2', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for uc_user_scores
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_scores`;
CREATE TABLE `uc_user_scores`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户积分id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `value` decimal(9, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '值',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户积分' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for uc_user_tokens
-- ----------------------------
DROP TABLE IF EXISTS `uc_user_tokens`;
CREATE TABLE `uc_user_tokens`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户ID',
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '令牌',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_user_tokens
-- ----------------------------
INSERT INTO `uc_user_tokens` VALUES ('1', '1', 'ee02ead2c1e3a113f82accafaf878b69', '2018-12-27 23:08:41', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_tokens` VALUES ('2', '17', '3d32077ccddb6eb2c4302feb93765cd0', '2018-09-24 05:11:17', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_tokens` VALUES ('3', '18', 'a939ac41fd309ca785485b4135b8baad', '2018-09-24 05:10:36', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');
INSERT INTO `uc_user_tokens` VALUES ('4', '33', '605dbcfa2277cbca3b2a124974816080', '2018-11-04 21:42:49', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1');

-- ----------------------------
-- Table structure for uc_users
-- ----------------------------
DROP TABLE IF EXISTS `uc_users`;
CREATE TABLE `uc_users`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `app_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '应用id',
  `user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '岗位/类型',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '账号,可以不是姓名，唯一',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '盐',
  `nick_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '昵称',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `gender` enum('0','1','2') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '性别-0女/1男/2保密',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '绑定电话',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '绑定邮箱',
  `age` double(3, 0) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '爱好-多个用/分割',
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像路径',
  `enable_status` bit(1) NOT NULL DEFAULT b'1' COMMENT '启用状态-0禁用/1启用',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  `tag` enum('0','1') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1' COMMENT '0虚拟/1真实',
  `postcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uc_users
-- ----------------------------
INSERT INTO `uc_users` VALUES ('1', '', NULL, 'admin', 'bd1718f058d8a02468134432b8656a86', 'YzcmCZNvbXocrsz9dm8e', '管理', NULL, '0', '13612345678', 'admin@hotmail.com', 9, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('22', '', NULL, 'tom', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '三', NULL, '0', '13889700023', 'zhangsan@hotmail.com', 9, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('23', '', NULL, 'edison', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '4', NULL, '0', '13889700023', '', 9, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('24', '', NULL, '王五', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '5', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('25', '', NULL, '周六', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '6', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('26', '', NULL, '孙七', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '7', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('27', '', NULL, '陆八', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '8', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('28', '', NULL, '黄九', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '9', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('29', '', NULL, '冯十', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '10', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('30', '', NULL, '十一太保', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '11', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('31', '', NULL, '十二太保', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '12', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);
INSERT INTO `uc_users` VALUES ('32', '', NULL, '十三太保', 'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '13', NULL, '0', '13889700023', NULL, 10, '跑步', NULL, b'1', NULL, '2018-08-14 11:11:11.000000', '2018-08-14 11:11:11.000000', 'admin', 'admin', b'1', '0', NULL);

-- ----------------------------
-- Table structure for uc_vaccines
-- ----------------------------
DROP TABLE IF EXISTS `uc_vaccines`;
CREATE TABLE `uc_vaccines`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '疫苗id',
  `month_age` int(10) UNSIGNED NOT NULL COMMENT '月龄',
  `vaccine_info` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '疫苗信息',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注-内部使用',
  `create_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建者id',
  `update_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改者id',
  `status` bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `k_sort`(`sort`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '疫苗' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `branch_id` bigint(20) NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int(11) NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'AT transaction mode undo table' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
