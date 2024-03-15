-- ----------------------------
-- init
-- ----------------------------
set character set utf8;
SET FOREIGN_KEY_CHECKS=0;
SET NAMES utf8mb4;

/******************************************/
/*   数据库全名 = nacos   */
/*   包含注册中心、配置中心和seata分布式事务   */
/******************************************/

drop database IF EXISTS nacos;
create database nacos DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use nacos;

/******************************************/
/*   表名称 = config_info   */
/******************************************/

DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) DEFAULT NULL,
  `content` longtext NOT NULL COMMENT 'content',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COMMENT 'source user',
  `src_ip` varchar(50) DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) DEFAULT NULL,
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) DEFAULT NULL,
  `c_use` varchar(64) DEFAULT NULL,
  `effect` varchar(64) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `c_schema` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.type', 'SEATA_GROUP', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2023-11-23 04:44:50', '2023-11-23 04:44:50', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.server', 'SEATA_GROUP', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2023-11-23 04:44:52', '2023-11-23 04:44:52', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.heartbeat', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2023-11-23 04:44:54', '2023-11-23 04:44:54', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.enableTmClientBatchSendRequest', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:44:59', '2023-11-23 04:44:59', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.enableRmClientBatchSendRequest', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2023-11-23 04:45:03', '2023-11-23 04:45:03', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.enableTcServerBatchSendResponse', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:45:08', '2023-11-23 04:45:08', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.rpcRmRequestTimeout', 'SEATA_GROUP', '30000', '5ecc613150de01b7e6824594426f24f4', '2023-11-23 04:45:12', '2023-11-23 04:45:12', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.rpcTmRequestTimeout', 'SEATA_GROUP', '30000', '5ecc613150de01b7e6824594426f24f4', '2023-11-23 04:45:15', '2023-11-23 04:45:15', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.rpcTcRequestTimeout', 'SEATA_GROUP', '30000', '5ecc613150de01b7e6824594426f24f4', '2023-11-23 04:45:19', '2023-11-23 04:45:19', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.bossThreadPrefix', 'SEATA_GROUP', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2023-11-23 04:45:24', '2023-11-23 04:45:24', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.workerThreadPrefix', 'SEATA_GROUP', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2023-11-23 04:45:30', '2023-11-23 04:45:30', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.serverExecutorThreadPrefix', 'SEATA_GROUP', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2023-11-23 04:45:36', '2023-11-23 04:45:36', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.shareBossWorker', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:45:41', '2023-11-23 04:45:41', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.clientSelectorThreadPrefix', 'SEATA_GROUP', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2023-11-23 04:45:48', '2023-11-23 04:45:48', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.clientSelectorThreadSize', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2023-11-23 04:45:53', '2023-11-23 04:45:53', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.clientWorkerThreadPrefix', 'SEATA_GROUP', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2023-11-23 04:45:59', '2023-11-23 04:45:59', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.bossThreadSize', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2023-11-23 04:46:03', '2023-11-23 04:46:03', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.threadFactory.workerThreadSize', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2023-11-23 04:46:09', '2023-11-23 04:46:09', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.shutdown.wait', 'SEATA_GROUP', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2023-11-23 04:46:12', '2023-11-23 04:46:12', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.serialization', 'SEATA_GROUP', 'seata', 'b943081c423b9a5416a706524ee05d40', '2023-11-23 04:46:15', '2023-11-23 04:46:15', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('transport.compressor', 'SEATA_GROUP', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2023-11-23 04:46:17', '2023-11-23 04:46:17', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('service.vgroupMapping.default_tx_group', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2023-11-23 04:46:22', '2023-11-23 04:46:22', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('service.default.grouplist', 'SEATA_GROUP', '127.0.0.1:8091', 'c32ce0d3e264525dcdada751f98143a3', '2023-11-23 04:46:26', '2023-11-23 04:46:26', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('service.enableDegrade', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:46:29', '2023-11-23 04:46:29', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('service.disableGlobalTransaction', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:46:33', '2023-11-23 04:46:33', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.asyncCommitBufferLimit', 'SEATA_GROUP', '10000', 'b7a782741f667201b54880c925faec4b', '2023-11-23 04:46:36', '2023-11-23 04:46:36', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.lock.retryInterval', 'SEATA_GROUP', '10', 'd3d9446802a44259755d38e6d163e820', '2023-11-23 04:46:40', '2023-11-23 04:46:40', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.lock.retryTimes', 'SEATA_GROUP', '30', '34173cb38f07f89ddbebc2ac9128303f', '2023-11-23 04:46:42', '2023-11-23 04:46:42', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.lock.retryPolicyBranchRollbackOnConflict', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2023-11-23 04:46:48', '2023-11-23 04:46:48', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.reportRetryCount', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2023-11-23 04:46:51', '2023-11-23 04:46:51', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.tableMetaCheckEnable', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2023-11-23 04:46:54', '2023-11-23 04:46:54', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.tableMetaCheckerInterval', 'SEATA_GROUP', '60000', '2b4226dd7ed6eb2d419b881f3ae9c97c', '2023-11-23 04:46:58', '2023-11-23 04:46:58', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.sqlParserType', 'SEATA_GROUP', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2023-11-23 04:47:01', '2023-11-23 04:47:01', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.reportSuccessEnable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:47:05', '2023-11-23 04:47:05', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.sagaBranchRegisterEnable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:47:09', '2023-11-23 04:47:09', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.sagaJsonParser', 'SEATA_GROUP', 'fastjson', 'd00d3dbc0834f08411c7b6c4c39e9f00', '2023-11-23 04:47:12', '2023-11-23 04:47:12', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.rm.tccActionInterceptorOrder', 'SEATA_GROUP', '-2147482648', 'f056d9efa5dae3872f9da035c83bcde8', '2023-11-23 04:47:17', '2023-11-23 04:47:17', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.tm.commitRetryCount', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2023-11-23 04:47:20', '2023-11-23 04:47:20', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.tm.rollbackRetryCount', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2023-11-23 04:47:23', '2023-11-23 04:47:23', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.tm.defaultGlobalTransactionTimeout', 'SEATA_GROUP', '60000', '2b4226dd7ed6eb2d419b881f3ae9c97c', '2023-11-23 04:47:27', '2023-11-23 04:47:27', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.tm.degradeCheck', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:47:30', '2023-11-23 04:47:30', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.tm.degradeCheckAllowTimes', 'SEATA_GROUP', '10', 'd3d9446802a44259755d38e6d163e820', '2023-11-23 04:47:34', '2023-11-23 04:47:34', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.tm.degradeCheckPeriod', 'SEATA_GROUP', '2000', '08f90c1a417155361a5c4b8d297e0d78', '2023-11-23 04:47:37', '2023-11-23 04:47:37', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.tm.interceptorOrder', 'SEATA_GROUP', '-2147482648', 'f056d9efa5dae3872f9da035c83bcde8', '2023-11-23 04:47:41', '2023-11-23 04:47:41', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.undo.dataValidation', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2023-11-23 04:47:44', '2023-11-23 04:47:44', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.undo.logSerialization', 'SEATA_GROUP', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2023-11-23 04:47:47', '2023-11-23 04:47:47', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.undo.onlyCareUpdateColumns', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2023-11-23 04:47:51', '2023-11-23 04:47:51', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.undo.logSaveDays', 'SEATA_GROUP', '7', '8f14e45fceea167a5a36dedd4bea2543', '2023-11-23 04:47:54', '2023-11-23 04:47:54', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.undo.logDeletePeriod', 'SEATA_GROUP', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2023-11-23 04:47:57', '2023-11-23 04:47:57', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.undo.logTable', 'SEATA_GROUP', 'undo_log', '2842d229c24afe9e61437135e8306614', '2023-11-23 04:48:00', '2023-11-23 04:48:00', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.undo.compress.enable', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2023-11-23 04:48:04', '2023-11-23 04:48:04', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.undo.compress.type', 'SEATA_GROUP', 'zip', 'adcdbd79a8d84175c229b192aadc02f2', '2023-11-23 04:48:07', '2023-11-23 04:48:07', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('client.undo.compress.threshold', 'SEATA_GROUP', '64k', 'bd44a6458bdbff0b5cac721ba361f035', '2023-11-23 04:48:10', '2023-11-23 04:48:10', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('tcc.fence.logTableName', 'SEATA_GROUP', 'tcc_fence_log', 'db229b665c7cfd5abc03971d4ed284c6', '2023-11-23 04:48:14', '2023-11-23 04:48:14', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('tcc.fence.cleanPeriod', 'SEATA_GROUP', '1h', '7c68645d71b803bf0ba2f22519f73e08', '2023-11-23 04:48:16', '2023-11-23 04:48:16', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('log.exceptionRate', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2023-11-23 04:48:19', '2023-11-23 04:48:19', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.mode', 'SEATA_GROUP', 'db', 'd77d5e503ad1439f585ac494268b351b', '2023-11-23 04:48:20', '2023-11-23 04:48:20', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.lock.mode', 'SEATA_GROUP', 'db', 'd77d5e503ad1439f585ac494268b351b', '2023-11-23 04:48:22', '2023-11-23 04:48:22', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.session.mode', 'SEATA_GROUP', 'db', 'd77d5e503ad1439f585ac494268b351b', '2023-11-23 04:48:24', '2023-11-23 04:48:24', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.file.dir', 'SEATA_GROUP', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2023-11-23 04:48:29', '2023-11-23 04:48:29', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.file.maxBranchSessionSize', 'SEATA_GROUP', '16384', 'c76fe1d8e08462434d800487585be217', '2023-11-23 04:48:33', '2023-11-23 04:48:33', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.file.maxGlobalSessionSize', 'SEATA_GROUP', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2023-11-23 04:48:37', '2023-11-23 04:48:37', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.file.fileWriteBufferCacheSize', 'SEATA_GROUP', '16384', 'c76fe1d8e08462434d800487585be217', '2023-11-23 04:48:41', '2023-11-23 04:48:41', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.file.flushDiskMode', 'SEATA_GROUP', 'async', '0df93e34273b367bb63bad28c94c78d5', '2023-11-23 04:48:44', '2023-11-23 04:48:44', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.file.sessionReloadReadSize', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2023-11-23 04:48:47', '2023-11-23 04:48:47', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.datasource', 'SEATA_GROUP', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2023-11-23 04:48:50', '2023-11-23 04:48:50', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.dbType', 'SEATA_GROUP', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2023-11-23 04:48:52', '2023-11-23 04:48:52', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.driverClassName', 'SEATA_GROUP', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2023-11-23 04:48:57', '2023-11-23 04:48:57', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.url', 'SEATA_GROUP', 'jdbc:mysql://localhost:3306/seata?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC', 'ef930285238ad2373e5a2a7046761b23', '2023-11-23 04:49:06', '2023-11-23 04:56:03', NULL, '0:0:0:0:0:0:0:1', '', 'seata', '', '', '', 'text', '');
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.user', 'SEATA_GROUP', 'seata', 'b943081c423b9a5416a706524ee05d40', '2023-11-23 04:49:08', '2023-11-23 04:49:08', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.password', 'SEATA_GROUP', 'seata', 'b943081c423b9a5416a706524ee05d40', '2023-11-23 04:49:10', '2023-11-23 04:49:10', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.minConn', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2023-11-23 04:49:12', '2023-11-23 04:49:12', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.maxConn', 'SEATA_GROUP', '30', '34173cb38f07f89ddbebc2ac9128303f', '2023-11-23 04:49:14', '2023-11-23 04:49:14', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.globalTable', 'SEATA_GROUP', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2023-11-23 04:49:18', '2023-11-23 04:49:18', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.branchTable', 'SEATA_GROUP', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2023-11-23 04:49:21', '2023-11-23 04:49:21', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.distributedLockTable', 'SEATA_GROUP', 'distributed_lock', '26146b7a3a4907101617cb0f19bf613f', '2023-11-23 04:49:26', '2023-11-23 04:49:26', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.queryLimit', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2023-11-23 04:49:29', '2023-11-23 04:49:29', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.lockTable', 'SEATA_GROUP', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2023-11-23 04:49:32', '2023-11-23 04:49:32', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.db.maxWait', 'SEATA_GROUP', '5000', 'a35fe7f7fe8217b4369a0af4244d1fca', '2023-11-23 04:49:34', '2023-11-23 04:49:34', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.mode', 'SEATA_GROUP', 'single', 'dd5c07036f2975ff4bce568b6511d3bc', '2023-11-23 04:49:36', '2023-11-23 04:49:36', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.single.host', 'SEATA_GROUP', '127.0.0.1', 'f528764d624db129b32c21fbca0cb8d6', '2023-11-23 04:49:40', '2023-11-23 04:49:40', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.single.port', 'SEATA_GROUP', '6379', '92c3b916311a5517d9290576e3ea37ad', '2023-11-23 04:49:43', '2023-11-23 04:49:43', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.maxConn', 'SEATA_GROUP', '10', 'd3d9446802a44259755d38e6d163e820', '2023-11-23 04:49:56', '2023-11-23 04:49:56', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.minConn', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2023-11-23 04:49:58', '2023-11-23 04:49:58', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.maxTotal', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2023-11-23 04:50:01', '2023-11-23 04:50:01', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.database', 'SEATA_GROUP', '0', 'cfcd208495d565ef66e7dff9f98764da', '2023-11-23 04:50:03', '2023-11-23 04:50:03', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('store.redis.queryLimit', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2023-11-23 04:50:08', '2023-11-23 04:50:08', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.recovery.committingRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2023-11-23 04:50:12', '2023-11-23 04:50:12', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.recovery.asynCommittingRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2023-11-23 04:50:17', '2023-11-23 04:50:17', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.recovery.rollbackingRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2023-11-23 04:50:21', '2023-11-23 04:50:21', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.recovery.timeoutRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2023-11-23 04:50:25', '2023-11-23 04:50:25', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.maxCommitRetryTimeout', 'SEATA_GROUP', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2023-11-23 04:50:28', '2023-11-23 04:50:28', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.maxRollbackRetryTimeout', 'SEATA_GROUP', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2023-11-23 04:50:31', '2023-11-23 04:50:31', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.rollbackRetryTimeoutUnlockEnable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:50:35', '2023-11-23 04:50:35', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.distributedLockExpireTime', 'SEATA_GROUP', '10000', 'b7a782741f667201b54880c925faec4b', '2023-11-23 04:50:39', '2023-11-23 04:50:39', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.xaerNotaRetryTimeout', 'SEATA_GROUP', '60000', '2b4226dd7ed6eb2d419b881f3ae9c97c', '2023-11-23 04:50:42', '2023-11-23 04:50:42', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.session.branchAsyncQueueSize', 'SEATA_GROUP', '5000', 'a35fe7f7fe8217b4369a0af4244d1fca', '2023-11-23 04:50:46', '2023-11-23 04:50:46', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.session.enableBranchAsyncRemove', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:50:51', '2023-11-23 04:50:51', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('server.enableParallelRequestHandle', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:50:55', '2023-11-23 04:50:55', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('metrics.enabled', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2023-11-23 04:50:57', '2023-11-23 04:50:57', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('metrics.registryType', 'SEATA_GROUP', 'compact', '7cf74ca49c304df8150205fc915cd465', '2023-11-23 04:51:00', '2023-11-23 04:51:00', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('metrics.exporterList', 'SEATA_GROUP', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2023-11-23 04:51:03', '2023-11-23 04:51:03', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('metrics.exporterPrometheusPort', 'SEATA_GROUP', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2023-11-23 04:51:06', '2023-11-23 04:51:06', 'nacos', '127.0.0.1', '', 'seata', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('ruoyi-gateway-dev.yml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    host: localhost\n    port: 6379\n    password:\n  cloud:\n    gateway:\n      discovery:\n        locator:\n          lowerCaseServiceId: true\n          enabled: true\n      routes:\n        # 认证中心\n        - id: ruoyi-auth\n          uri: lb://ruoyi-auth\n          predicates:\n            - Path=/auth/**\n          filters:\n            # 验证码处理\n            - CacheRequestFilter\n            - ValidateCodeFilter\n            - StripPrefix=1\n        # 代码生成\n        - id: ruoyi-gen\n          uri: lb://ruoyi-gen\n          predicates:\n            - Path=/code/**\n          filters:\n            - StripPrefix=1\n        # 定时任务\n        - id: ruoyi-job\n          uri: lb://ruoyi-job\n          predicates:\n            - Path=/schedule/**\n          filters:\n            - StripPrefix=1\n        # 系统模块\n        - id: ruoyi-system\n          uri: lb://ruoyi-system\n          predicates:\n            - Path=/system/**\n          filters:\n            - StripPrefix=1\n        # 文件服务\n        - id: ruoyi-file\n          uri: lb://ruoyi-file\n          predicates:\n            - Path=/file/**\n          filters:\n            - StripPrefix=1\n\n# 安全配置\nsecurity:\n  # 验证码\n  captcha:\n    enabled: true\n    type: math\n  # 防止XSS攻击\n  xss:\n    enabled: true\n    excludeUrls:\n      - /system/notice\n  # 不校验白名单\n  ignore:\n    whites:\n      - /auth/logout\n      - /auth/login\n      - /auth/register\n      - /*/v2/api-docs\n      - /csrf\n', '57cec5abd0e0a6b77d853750344a9dc0', '2020-05-14 14:17:55', '2022-09-29 02:48:32', 'nacos', '0:0:0:0:0:0:0:1', '', '', '网关模块', 'null', 'null', 'yaml', '');
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('ruoyi-auth-dev.yml', 'DEFAULT_GROUP', 'spring:\n  redis:\n    host: localhost\n    port: 6379\n    password:\n', '8bd9dada9a94822feeab40de55efced6', '2020-11-20 00:00:00', '2022-09-29 02:48:42', 'nacos', '0:0:0:0:0:0:0:1', '', '', '认证中心', 'null', 'null', 'yaml', '');
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('ruoyi-monitor-dev.yml', 'DEFAULT_GROUP', '# spring\nspring:\n  security:\n    user:\n      name: ruoyi\n      password: 123456\n  boot:\n    admin:\n      ui:\n        title: TESTU服务状态监控\n', '6f122fd2bfb8d45f858e7d6529a9cd44', '2020-11-20 00:00:00', '2022-09-29 02:48:54', 'nacos', '0:0:0:0:0:0:0:1', '', '', '监控中心', 'null', 'null', 'yaml', '');
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('ruoyi-system-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: localhost\n    port: 6379\n    password:\n  datasource:\n    druid:\n      stat-view-servlet:\n        enabled: true\n        loginUsername: admin\n        loginPassword: 123456\n    dynamic:\n      druid:\n        initial-size: 5\n        min-idle: 5\n        maxActive: 20\n        maxWait: 60000\n        timeBetweenEvictionRunsMillis: 60000\n        minEvictableIdleTimeMillis: 300000\n        validationQuery: SELECT 1 FROM DUAL\n        testWhileIdle: true\n        testOnBorrow: false\n        testOnReturn: false\n        poolPreparedStatements: true\n        maxPoolPreparedStatementPerConnectionSize: 20\n        filters: stat,slf4j\n        connectionProperties: druid.stat.mergeSql\\=true;druid.stat.slowSqlMillis\\=5000\n      datasource:\n          # 主库数据源\n          master:\n            driver-class-name: com.mysql.cj.jdbc.Driver\n            url: jdbc:mysql://localhost:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n            username: root\n            password: password\n          # 从库数据源\n          # slave:\n            # username: \n            # password: \n            # url: \n            # driver-class-name: \n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.system\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 系统模块接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip', '48e0ed4a040c402bdc2444213a82c910', '2020-11-20 00:00:00', '2022-09-29 02:49:09', 'nacos', '0:0:0:0:0:0:0:1', '', '', '系统模块', 'null', 'null', 'yaml', '');
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('ruoyi-gen-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: localhost\n    port: 6379\n    password:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: password\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.gen.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 代码生成接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n\n# 代码生成\ngen:\n  # 作者\n  author: ruoyi\n  # 默认生成包路径 system 需改成自己的模块名称 如 system monitor tool\n  packageName: com.ruoyi.system\n  # 自动去除表前缀，默认是false\n  autoRemovePre: false\n  # 表前缀（生成类名不会包含表前缀，多个用逗号分隔）\n  tablePrefix: sys_\n', 'eb592420b3fceae1402881887b8a6a0d', '2020-11-20 00:00:00', '2022-09-29 02:49:42', 'nacos', '0:0:0:0:0:0:0:1', '', '', '代码生成', 'null', 'null', 'yaml', '');
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('ruoyi-job-dev.yml', 'DEFAULT_GROUP', '# spring配置\nspring:\n  redis:\n    host: localhost\n    port: 6379\n    password: \n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/ry-cloud?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8\n    username: root\n    password: password\n\n# mybatis配置\nmybatis:\n    # 搜索指定包别名\n    typeAliasesPackage: com.ruoyi.job.domain\n    # 配置mapper的扫描，找到所有的mapper.xml映射文件\n    mapperLocations: classpath:mapper/**/*.xml\n\n# swagger配置\nswagger:\n  title: 定时任务接口文档\n  license: Powered By ruoyi\n  licenseUrl: https://ruoyi.vip\n', 'edcf0e3fe13fea07b4ec08b1088f30b3', '2020-11-20 00:00:00', '2022-09-29 02:50:50', 'nacos', '0:0:0:0:0:0:0:1', '', '', '定时任务', 'null', 'null', 'yaml', '');
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('ruoyi-file-dev.yml', 'DEFAULT_GROUP', '# 本地文件上传    \r\nfile:\r\n    domain: http://127.0.0.1:9300\r\n    path: D:/ruoyi/uploadPath\r\n    prefix: /statics\r\n\r\n# FastDFS配置\r\nfdfs:\r\n  domain: http://8.129.231.12\r\n  soTimeout: 3000\r\n  connectTimeout: 2000\r\n  trackerList: 8.129.231.12:22122\r\n\r\n# Minio配置\r\nminio:\r\n  url: http://8.129.231.12:9000\r\n  accessKey: minioadmin\r\n  secretKey: minioadmin\r\n  bucketName: test', '5382b93f3d8059d6068c0501fdd41195', '2020-11-20 00:00:00', '2020-12-21 21:01:59', NULL, '0:0:0:0:0:0:0:1', '', '', '文件服务', 'null', 'null', 'yaml', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('sentinel-ruoyi-gateway', 'DEFAULT_GROUP', '[\r\n    {\r\n        \"resource\": \"ruoyi-auth\",\r\n        \"count\": 500,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"ruoyi-system\",\r\n        \"count\": 1000,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"ruoyi-gen\",\r\n        \"count\": 200,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    },\r\n	{\r\n        \"resource\": \"ruoyi-job\",\r\n        \"count\": 300,\r\n        \"grade\": 1,\r\n        \"limitApp\": \"default\",\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0\r\n    }\r\n]', '9f3a3069261598f74220bc47958ec252', '2020-11-20 00:00:00', '2020-11-20 00:00:00', NULL, '0:0:0:0:0:0:0:1', '', '', '限流策略', 'null', 'null', 'json', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('application-dev.yml', 'DEFAULT_GROUP', 'spring:\n  autoconfigure:\n    exclude: com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure\n  mvc:\n    pathmatch:\n      matching-strategy: ant_path_matcher\n\n# feign 配置\nfeign:\n  sentinel:\n    enabled: true\n  okhttp:\n    enabled: true\n  httpclient:\n    enabled: false\n  client:\n    config:\n      default:\n        connectTimeout: 10000\n        readTimeout: 10000\n  compression:\n    request:\n      enabled: true\n    response:\n      enabled: true\n\n# 暴露监控端点\nmanagement:\n  endpoints:\n    web:\n      exposure:\n        include: \'*\'\n', 'aaa73b809cfd4d0058893aa13da57806', '2020-05-20 12:00:00', '2022-04-24 10:26:34', 'nacos', '0:0:0:0:0:0:0:1', '', '', '通用配置', 'null', 'null', 'yaml', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('baas-questionaire-dev.yml', 'DEFAULT_GROUP', 'server:\n  port: 9102\n  \nspring:\n  servlet:\n    multipart:\n      enabled: true\n      max-file-size: 300MB\n      max-request-size: 300MB\n  http:\n    encoding:\n      force: true\n  resources:\n    static-locations: classpath:/static/    \n  thymeleaf:\n    prefix: classpath:/templates/\n    check-template-location: true\n    suffix: .html\n    encoding: UTF-8\n    servlet:\n      content-type: text/html \n    mode: HTML\n    cache: false\n\ndubbo:\n  application:\n    #id: ${spring.application.name}-consumer\n    #name: ${spring.application.name}-consumer\n    qosEnable: false\n  cloud:\n    subscribed-services: daas-questionnaire,daas-device,daas-usercenter\n#  consumer:\n#    check: false\n  protocol:\n    id: dubbo\n    name: dubbo\n    port: -1\n  provider:\n    loadbalance: roundrobin\n    retries: 0\n    timeout: 60000\n    version: 1.0.0\n#  scan:\n#    base-packages: work.metanet.client.questionnaire\n  registry:\n    id: ${spring.application.name}-registry\n    address: nacos://192.168.10.181:8848\n\n\nmapper:\n  identity: MYSQL\n  mappers: tk.mybatis.mapper.common.Mapper\n  not-empty: false\n  \nmybatis:\n  configuration:\n    call-setters-on-nulls: true\n    map-underscore-to-camel-case: true\n  mapper-locations: classpath:mapper/*.xml\nlogging:\n  level:\n    com.alibaba.nacos.client.config.impl: WARN', '3d8a26597168e583d5b30f42f1001745', '2024-03-15 03:48:27', '2024-03-15 03:48:27', NULL, '192.168.10.181', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('bass-user-dev.yml', 'DEFAULT_GROUP', 'server:\n  port: 9101\n  servlet:\n    encoding:\n      force: true  \ndubbo:\n  cloud:\n    subscribed-services: daas-usercenter,daas-device\n  protocol:\n    name: dubbo\n    port: -1\n  registry:\n    address: nacos://192.168.10.181:8848\n  provider:\n    loadbalance: roundrobin\n    retries: 0\n    timeout: 60000\n    version: 1.0.0\n    \nlogging: \n  level:\n    root: warn\n    \'[work.metanet.client.user.config]\': debug\n\nspring: \n  servlet:\n    multipart:\n      enabled: true\n      max-file-size: 300MB\n      max-request-size: 300MB\n  resources:\n    static-locations: classpath:/static/    \n  thymeleaf:\n    prefix: classpath:/templates/\n    check-template-location: true\n    suffix: .html\n    encoding: UTF-8\n    servlet:\n      content-type: text/html \n    mode: HTML\n    cache: false ', '74823b3a65fc6db947b52917bdec3797', '2024-03-15 03:48:27', '2024-03-15 03:48:27', NULL, '192.168.10.181', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('daas-device-dev.yml', 'DEFAULT_GROUP', 'server:\n  port: 9002\nspring:\n  jpa:\n    hibernate:\n      ddl-auto: update\n    show-sql: true\n    open-in-view: false\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    druid:\n      connection-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000\n      filters: config,stat,log4j\n      initial-size: 5\n      max-active: 200\n      max-pool-prepared-statement-per-connection-size: 20\n      max-wait: 60000\n      min-evictable-idle-time-millis: 300000\n      min-idle: 5\n      pool-prepared-statements: true\n      stat-view-servlet:\n        allow: \'*\'\n        deny: none\n        login-password: admin\n        login-username: admin\n        reset-enable: false\n      test-on-borrow: false\n      test-on-return: false\n      test-while-idle: true\n      time-between-eviction-runs-millis: 60000\n      validation-query: SELECT 1 FROM DUAL\n    type: com.alibaba.druid.pool.DruidDataSource\n    url: jdbc:mysql://192.168.10.181:3306/user_center?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true\n    username: root\n    password: radar\n  quartz:\n    job-store-type: jdbc\n    overwrite-existing-jobs: true\n    properties:\n      org:\n        quartz:\n          jobStore:\n            class: org.quartz.impl.jdbcjobstore.JobStoreTX\n            driverDelegateClass: org.quartz.impl.jdbcjobstore.StdJDBCDelegate\n            isClustered: true\n            tablePrefix: QRTZ_\n          plugin:\n            shutdownHook:\n              class: org.quartz.plugins.management.ShutdownHookPlugin\n              cleanShutdown: \'TRUE\'\n          scheduler:\n            instanceId: AUTO\n            instanceName: MetanetClusteredScheduler\n          threadPool:\n            class: org.quartz.simpl.SimpleThreadPool\n    startup-delay: 10s\n    wait-for-jobs-to-complete-on-shutdown: true\n  redis:\n    database: 1\n    host: 192.168.10.181\n    lettuce:\n      pool:\n        max-active: 30\n        max-idle: 30\n        max-wait: 10000\n        min-idle: 10\n    password: radar\n    port: 6379\ndubbo:\n  cloud:\n    subscribed-services: daas-usercenter\n  protocol:\n    name: dubbo\n    port: -1\n  scan:\n    base-packages: work.metanet.server.service\n  registry:\n    address: nacos://192.168.10.181:8848\n  provider:\n    loadbalance: roundrobin\n    retries: 0\n    timeout: 60000\n    version: 1.0.0\nlogging:\n  level:\n    \'[work.metanet.server.dao]\': trace\n', '78fb6fccf664e232f78981d342df681a', '2024-03-15 03:48:27', '2024-03-15 03:48:27', NULL, '192.168.10.181', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('daas-questionaire-dev.yml', 'DEFAULT_GROUP', 'server:\n  port: 9003\n\nspring:\n  datasource:\n    type: com.alibaba.druid.pool.DruidDataSource\n    driver-class-name: com.mysql.jdbc.Driver\n    url: jdbc:mysql://192.168.10.181:3306/questionnaire?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true&&allowMultiQueries=true\n    username: root\n    password: radar\n    druid:\n      connection-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000\n      filters: config,stat,log4j\n      initial-size: 5\n      max-active: 200\n      max-pool-prepared-statement-per-connection-size: 20\n      max-wait: 60000\n      min-evictable-idle-time-millis: 300000\n      min-idle: 5\n      pool-prepared-statements: true\n      stat-view-servlet:\n        allow: \'*\'\n        deny: none\n        login-password: admin\n        login-username: admin\n        reset-enable: false\n      test-on-borrow: false\n      test-on-return: false\n      test-while-idle: true\n      time-between-eviction-runs-millis: 60000\n      validation-query: SELECT 1 FROM DUAL\n    \n  quartz:\n    job-store-type: jdbc\n    overwrite-existing-jobs: true\n    properties:\n      org:\n        quartz:\n          jobStore:\n            class: org.quartz.impl.jdbcjobstore.JobStoreTX\n            driverDelegateClass: org.quartz.impl.jdbcjobstore.StdJDBCDelegate\n            isClustered: true\n            tablePrefix: QRTZ_\n          plugin:\n            shutdownHook:\n              class: org.quartz.plugins.management.ShutdownHookPlugin\n              cleanShutdown: \'TRUE\'\n          scheduler:\n            instanceId: AUTO\n            instanceName: MetanetClusteredScheduler\n          threadPool:\n            class: org.quartz.simpl.SimpleThreadPool\n    startup-delay: 10s\n    wait-for-jobs-to-complete-on-shutdown: true\n    \n  redis:\n    database: 2\n    host: 192.168.10.181\n    lettuce:\n      pool:\n        max-active: 30\n        max-idle: 30\n        max-wait: 10003\n        min-idle: 10\n    password: radar\n    port: 6379\n\ndubbo:\n  scan:\n    base-packages: work.metanet.questionnaire.service\n  protocol:\n    name: dubbo\n    port: -1\n  registry:\n    address: nacos://192.168.10.181:8848\n  provider:\n    loadbalance: roundrobin\n    retries: 0\n    timeout: 60000\n    version: 1.0.0\n    \nseata:\n  registry: # TC服务注册中心的配置，微服务根据这些信息去注册中心获取tc服务地址\n    # 参考tc服务自己的registry.conf中的配置\n    type: nacos\n    nacos: # tc\n      server-addr: 192.168.10.181:8848\n      namespace: public\n      group: DEFAULT_GROUP\n      application: seata-tc-server # tc服务在nacos中的服务名称\n      username: nacos\n      password: nacos\n  tx-service-group: daas-questionaire-group # 事务组，根据这个获取tc服务的cluster名称\n  service:\n    vgroup-mapping: # 事务组与TC服务cluster的映射关系\n      daas-questionaire-group: default\n  data-source-proxy-mode: AT #XA\n\nmapper:\n  identity: MYSQL\n  mappers: tk.mybatis.mapper.common.Mapper\n  not-empty: false\n  \nmybatis:\n  configuration:\n    call-setters-on-nulls: true\n    map-underscore-to-camel-case: true\n  mapper-locations: classpath:mapper/*.xml\nlogging:\n  level:\n    \'[work.metanet.questionnaire.dao]\': trace', '6ae031d52f3731c063594a5b01a1e878', '2024-03-15 03:48:27', '2024-03-15 03:48:27', NULL, '192.168.10.181', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('daas-usercenter-dev.yml', 'DEFAULT_GROUP', 'server:\n  port: 9001\nspring:\n  jpa:\n    hibernate:\n      ddl-auto: update\n    show-sql: true\n    open-in-view: false\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    druid:\n      connection-properties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000\n      filters: config,stat,log4j\n      initial-size: 5\n      max-active: 200\n      max-pool-prepared-statement-per-connection-size: 20\n      max-wait: 60000\n      min-evictable-idle-time-millis: 300000\n      min-idle: 5\n      pool-prepared-statements: true\n      stat-view-servlet:\n        allow: \'*\'\n        deny: none\n        login-password: admin\n        login-username: admin\n        reset-enable: false\n      test-on-borrow: false\n      test-on-return: false\n      test-while-idle: true\n      time-between-eviction-runs-millis: 60000\n      validation-query: SELECT 1 FROM DUAL\n    type: com.alibaba.druid.pool.DruidDataSource\n    url: jdbc:mysql://192.168.10.181:3306/user_center?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true\n    username: root\n    password: radar\n  quartz:\n    job-store-type: jdbc\n    overwrite-existing-jobs: true\n    properties:\n      org:\n        quartz:\n          jobStore:\n            class: org.quartz.impl.jdbcjobstore.JobStoreTX\n            driverDelegateClass: org.quartz.impl.jdbcjobstore.StdJDBCDelegate\n            isClustered: true\n            tablePrefix: QRTZ_\n          plugin:\n            shutdownHook:\n              class: org.quartz.plugins.management.ShutdownHookPlugin\n              cleanShutdown: \'TRUE\'\n          scheduler:\n            instanceId: AUTO\n            instanceName: MetanetClusteredScheduler\n          threadPool:\n            class: org.quartz.simpl.SimpleThreadPool\n    startup-delay: 10s\n    wait-for-jobs-to-complete-on-shutdown: true\n  redis:\n    database: 1\n    host: 192.168.10.181\n    lettuce:\n      pool:\n        max-active: 30\n        max-idle: 30\n        max-wait: 10000\n        min-idle: 10\n    password: radar\n    port: 6379\ndubbo:\n  application:\n    name: daas-usercenter\n  cloud:\n    subscribed-services: \n  protocol:\n    name: dubbo\n    port: -1\n  scan:\n    base-packages: work.metanet.server.usercenter.service.impl\n  registry:\n    address: nacos://192.168.10.181:8848\n  provider:\n    loadbalance: roundrobin\n    retries: 0\n    timeout: 60000\n    version: 1.0.0\nlogging:\n  level:\n    \'[work.metanet.server.usercenter.repository]\': trace', '4d1433c8758730a5f11665827b0899ca', '2024-03-15 03:48:27', '2024-03-15 03:48:27', NULL, '192.168.10.181', '', '', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info`(`data_id`,`group_id`,`content`,`md5`,`gmt_create`,`gmt_modified`,`src_user`,`src_ip`,`app_name`,`tenant_id`,`c_desc`,`c_use`,`effect`,`type`,`c_schema`) VALUES ('baas-openapi-dev.properties', 'DEFAULT_GROUP', 'server.port=9103\r\nspring.profiles.active=dev\r\nspring.application.name=baas-openapi\r\nspring.main.allow-bean-definition-overriding=true\r\n\r\n############################ spring.cloud.nacos ##############################\r\nspring.cloud.nacos.config.server-addr=192.168.10.181\r\nspring.cloud.nacos.config.group=DEFAULT_GROUP\r\nspring.cloud.nacos.config.namespace=\r\nspring.cloud.nacos.config.file-extension=properties\r\nspring.cloud.nacos.discovery.server-addr=192.168.10.181\r\nspring.cloud.nacos.discovery.group=DEFAULT_GROUP\r\nspring.cloud.nacos.discovery.namespace=\r\nspring.cloud.nacos.discovery.ip=192.168.10.181\r\n\r\n############################ dubbo ##############################\r\ndubbo.protocol.name=dubbo\r\ndubbo.protocol.port=-1\r\ndubbo.application.qosEnable=false\r\ndubbo.consumer.check=false\r\ndubbo.scan.base-packages=work.metanet.server.service,work.metanet.usercenter.service\r\ndubbo.cloud.subscribed-services=daas-device,daas-usercenter\r\n\r\n############################ servlet ##############################\r\nspring.servlet.multipart.enabled=true\r\nspring.servlet.multipart.max-file-size=300MB\r\nspring.servlet.multipart.max-request-size=300MB\r\nspring.http.encoding.force=true\r\n\r\n############################ Thymeleaf ##############################\r\nspring.thymeleaf.prefix=classpath:/templates/\r\nspring.resources.static-locations=classpath:/static/\r\nspring.thymeleaf.check-template-location=true\r\nspring.thymeleaf.suffix=.html\r\nspring.thymeleaf.encoding=UTF-8\r\nspring.thymeleaf.servlet.content-type=text/html \r\nspring.thymeleaf.mode=HTML\r\nspring.thymeleaf.cache=false\r\n', '2c617ea40666a88cbf1c51fe4c583e11', '2024-03-15 03:48:40', '2024-03-15 03:48:40', NULL, '192.168.10.181', '', '', NULL, NULL, NULL, 'properties', NULL);


/******************************************/
/*   表名称 = config_info_aggr   */
/******************************************/
CREATE TABLE `config_info_aggr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) NOT NULL COMMENT 'datum_id',
  `content` longtext NOT NULL COMMENT '内容',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) DEFAULT NULL,
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`,`group_id`,`tenant_id`,`datum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='增加租户字段';


/******************************************/
/*   表名称 = config_info_beta   */
/******************************************/
CREATE TABLE `config_info_beta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) DEFAULT NULL COMMENT 'app_name',
  `content` longtext NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COMMENT 'source user',
  `src_ip` varchar(50) DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_beta';

/******************************************/
/*   表名称 = config_info_tag   */
/******************************************/
CREATE TABLE `config_info_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) DEFAULT NULL COMMENT 'app_name',
  `content` longtext NOT NULL COMMENT 'content',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `src_user` text COMMENT 'source user',
  `src_ip` varchar(50) DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`,`group_id`,`tenant_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info_tag';

/******************************************/
/*   表名称 = config_tags_relation   */
/******************************************/
CREATE TABLE `config_tags_relation` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`),
  UNIQUE KEY `uk_configtagrelation_configidtag` (`id`,`tag_name`,`tag_type`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_tag_relation';

/******************************************/
/*   表名称 = group_capacity   */
/******************************************/
CREATE TABLE `group_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='集群、各Group容量信息表';

/******************************************/
/*   表名称 = his_config_info   */
/******************************************/
CREATE TABLE `his_config_info` (
  `id` bigint(64) unsigned NOT NULL,
  `nid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) NOT NULL,
  `group_id` varchar(128) NOT NULL,
  `app_name` varchar(128) DEFAULT NULL COMMENT 'app_name',
  `content` longtext NOT NULL,
  `md5` varchar(32) DEFAULT NULL,
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `src_user` text,
  `src_ip` varchar(50) DEFAULT NULL,
  `op_type` char(10) DEFAULT NULL,
  `tenant_id` varchar(128) DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`),
  KEY `idx_gmt_create` (`gmt_create`),
  KEY `idx_gmt_modified` (`gmt_modified`),
  KEY `idx_did` (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='多租户改造';


/******************************************/
/*   表名称 = tenant_capacity   */
/******************************************/
CREATE TABLE `tenant_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
  `usage` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '使用量',
  `max_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='租户容量信息表';


CREATE TABLE `tenant_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) default '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) default '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`,`tenant_id`),
  KEY `idx_tenant_id` (`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='tenant_info';

INSERT INTO `tenant_info` VALUES (1, '1', 'seata', 'seata', 'seata', 'nacos', 1710476327057, 1710476327057);

CREATE TABLE `users` (
	`username` varchar(50) NOT NULL PRIMARY KEY,
	`password` varchar(500) NOT NULL,
	`enabled` boolean NOT NULL
);

CREATE TABLE `roles` (
	`username` varchar(50) NOT NULL,
	`role` varchar(50) NOT NULL,
	UNIQUE INDEX `idx_user_role` (`username` ASC, `role` ASC) USING BTREE
);

CREATE TABLE `permissions` (
    `role` varchar(50) NOT NULL,
    `resource` varchar(255) NOT NULL,
    `action` varchar(8) NOT NULL,
    UNIQUE INDEX `uk_role_permission` (`role`,`resource`,`action`) USING BTREE
);

INSERT INTO users (username, password, enabled) VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', TRUE);

INSERT INTO roles (username, role) VALUES ('nacos', 'ROLE_ADMIN');


-- -------------------------------- The seata script used when storeMode is 'db' --------------------------------
-- the table to store GlobalSession data
CREATE TABLE IF NOT EXISTS `global_table`
(
    `xid`                       VARCHAR(128) NOT NULL,
    `transaction_id`            BIGINT,
    `status`                    TINYINT      NOT NULL,
    `application_id`            VARCHAR(32),
    `transaction_service_group` VARCHAR(32),
    `transaction_name`          VARCHAR(128),
    `timeout`                   INT,
    `begin_time`                BIGINT,
    `application_data`          VARCHAR(2000),
    `gmt_create`                DATETIME,
    `gmt_modified`              DATETIME,
    PRIMARY KEY (`xid`),
    KEY `idx_gmt_modified_status` (`gmt_modified`, `status`),
    KEY `idx_transaction_id` (`transaction_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- the table to store BranchSession data
CREATE TABLE IF NOT EXISTS `branch_table`
(
    `branch_id`         BIGINT       NOT NULL,
    `xid`               VARCHAR(128) NOT NULL,
    `transaction_id`    BIGINT,
    `resource_group_id` VARCHAR(32),
    `resource_id`       VARCHAR(256),
    `branch_type`       VARCHAR(8),
    `status`            TINYINT,
    `client_id`         VARCHAR(64),
    `application_data`  VARCHAR(2000),
    `gmt_create`        DATETIME(6),
    `gmt_modified`      DATETIME(6),
    PRIMARY KEY (`branch_id`),
    KEY `idx_xid` (`xid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- the table to store lock data
CREATE TABLE IF NOT EXISTS `lock_table`
(
    `row_key`        VARCHAR(128) NOT NULL,
    `xid`            VARCHAR(128),
    `transaction_id` BIGINT,
    `branch_id`      BIGINT       NOT NULL,
    `resource_id`    VARCHAR(256),
    `table_name`     VARCHAR(32),
    `pk`             VARCHAR(36),
    `gmt_create`     DATETIME,
    `gmt_modified`   DATETIME,
    PRIMARY KEY (`row_key`),
    KEY `idx_branch_id` (`branch_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
  
SET FOREIGN_KEY_CHECKS = 1;
