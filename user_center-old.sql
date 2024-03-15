-- ----------------------------
-- init
-- ----------------------------
set character set utf8;
SET FOREIGN_KEY_CHECKS=0;
SET NAMES utf8mb4;

-- ----------------------------
-- DATABASE user_center
-- ----------------------------

drop database IF EXISTS user_center;
create database user_center DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use user_center;

DROP TABLE IF EXISTS `uc_apps`;
DROP TABLE IF EXISTS `uc_appstore`;
DROP TABLE IF EXISTS `uc_prizes`;
DROP TABLE IF EXISTS `uc_standard`;
DROP TABLE IF EXISTS `uc_diaries`;
DROP TABLE IF EXISTS `uc_collections`;
DROP TABLE IF EXISTS `uc_browses`;
DROP TABLE IF EXISTS `uc_vaccines`;

DROP TABLE IF EXISTS `uc_family_members`;
DROP TABLE IF EXISTS `uc_rewards`;

DROP TABLE IF EXISTS `uc_target_prizes`;
DROP TABLE IF EXISTS `uc_score_exchanges`;
DROP TABLE IF EXISTS `uc_score_detail`;
DROP TABLE IF EXISTS `uc_user_scores`;
DROP TABLE IF EXISTS `uc_user_logins`;
DROP TABLE IF EXISTS `uc_user_logistics`;

DROP TABLE IF EXISTS `uc_user_addresses`;
DROP TABLE IF EXISTS uc_user_tokens;
DROP TABLE IF EXISTS uc_user_role;
DROP TABLE IF EXISTS uc_user_area;
DROP TABLE IF EXISTS uc_user_dept;
DROP TABLE IF EXISTS uc_certifications;
DROP TABLE IF EXISTS uc_users;
DROP TABLE IF EXISTS uc_acls;
DROP TABLE IF EXISTS uc_role_dept;
DROP TABLE IF EXISTS uc_roles;
DROP TABLE IF EXISTS uc_resources;
DROP TABLE IF EXISTS uc_logs;
DROP TABLE IF EXISTS uc_dictionaries;
DROP TABLE IF EXISTS uc_area_dept;

DROP TABLE IF EXISTS uc_departments;
DROP TABLE IF EXISTS uc_areas;
DROP TABLE IF EXISTS undo_log;

-- ----------------------------
-- Table structure for areas
-- ----------------------------

CREATE TABLE uc_areas (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  code            varchar(20) DEFAULT NULL COMMENT '代号',
  name            varchar(100) DEFAULT NULL COMMENT '区域名称',
  parent_id       bigint(20) DEFAULT NULL COMMENT '上级区域ID，一级区域为0',
  acreage         bigint(20) DEFAULT NULL COMMENT '面积，单位：平方公里',
  population      bigint(20) DEFAULT NULL COMMENT '人口，单位：万人',
  households      bigint(20) DEFAULT NULL COMMENT '户数',
  `sort`          int(11) DEFAULT NULL COMMENT '排序',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  KEY k_sort (`sort`) USING BTREE,
  PRIMARY KEY pk_id(`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC  COMMENT='区域管理';

-- ----------------------------
-- Records of uc_areas
-- ----------------------------
INSERT INTO uc_areas VALUES ('1', 'sh', '上海', 0, null,null,null,		0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_areas VALUES ('2', 'mh', '闵行区', 1, null,null,null,	0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_areas VALUES ('3', 'zz', '紫竹科技园', 2,null,null,null, 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

-- ----------------------------
-- Table structure for uc_departments
-- ----------------------------

CREATE TABLE uc_departments (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  code            varchar(20) DEFAULT NULL COMMENT '代号',
  name            varchar(100) DEFAULT NULL COMMENT '机构名称',
  parent_id       bigint(20) DEFAULT NULL COMMENT '上级机构ID，一级机构为0',
  department_type varchar(20) DEFAULT 'department' COMMENT '类型，company公司，department部门，office-room科室，group小组，other其他',
  principal       varchar(50) DEFAULT NULL COMMENT '负责人',
  department_level varchar(50) DEFAULT NULL COMMENT '级别',
  address         varchar(500) DEFAULT NULL COMMENT '地址',
  telephone       varchar(50) DEFAULT NULL COMMENT '电话',
  fax             varchar(50) DEFAULT NULL COMMENT '传真',
  postcode        varchar(50) DEFAULT NULL COMMENT '邮编',
  `sort`          int(11) DEFAULT NULL COMMENT '排序',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  KEY k_sort (`sort`) USING BTREE,
  UNIQUE KEY uk_code (code) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC  COMMENT='机构管理';

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO uc_departments VALUES ('17', 'yjt', '第一集团', null,null,null,null,null,null,null,null,  0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('18', 'ejt', '第二集团', null,null,null,null,null,null,null,null,  0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('19', 'sjt', '第三集团', null,null,null,null,null,null,null,null,  0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('21', 'sh', '上海分公司', '18',null,null,null,null,null,null,null, 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('22', 'bj', '北京分公司', '17',null,null,null,null,null,null,null, 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('23', 'gz', '广州分公司', '18',null,null,null,null,null,null,null, 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('25', 'rj', '软件研发部', '22',null,null,null,null,null,null,null, 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('26', 'yj', '硬件研发部', '21',null,null,null,null,null,null,null, 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('27', 'yw', '交付运维部', '23',null,null,null,null,null,null,null, 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('29', 'yx', '营销部', '22',null,null,null,null,null,null,null,     0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('30', 'sc', '市场部', '23',null,null,null,null,null,null,null,     0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('33', 'xt', '系统组', '19',null,null,null,null,null,null,null,     0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('34', 'kf', '开发组', '19',null,null,null,null,null,null,null,     0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_departments VALUES ('35', 'cs', '测试组', '19',null,null,null,null,null,null,null,     0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

-- ----------------------------
-- Table structure for uc_area_dept
-- ----------------------------

CREATE TABLE uc_area_dept (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  area_id         bigint(20) DEFAULT NULL COMMENT '区域ID',
  dept_id         bigint(20) DEFAULT NULL COMMENT '机构ID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC  COMMENT='区域机构关系表，备用';

-- ----------------------------
-- Table structure for uc_dictionaries
-- ----------------------------

CREATE TABLE uc_dictionaries (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  value           varchar(100) NOT NULL COMMENT '数据值',
  label           varchar(100) NOT NULL COMMENT '标签名',
  type            varchar(100) NOT NULL COMMENT '类型',
  description     varchar(100) NOT NULL COMMENT '描述',
  `sort`          int(11) DEFAULT NULL COMMENT '排序',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  KEY k_sort (`sort`) USING BTREE,
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC  COMMENT='字典表';

-- ----------------------------
-- Records of uc_dictionaries
-- ----------------------------
INSERT INTO uc_dictionaries VALUES ('3', 'male', '男', 'sex', '性别',   0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_dictionaries VALUES ('4', 'female', '女', 'sex', '性别', 0, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

-- ----------------------------
-- Table structure for uc_logs
-- ----------------------------

CREATE TABLE uc_logs (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  user_name       varchar(50) DEFAULT NULL COMMENT '用户名',
  operation       varchar(50) DEFAULT NULL COMMENT '用户操作',
  method          varchar(200) DEFAULT NULL COMMENT '请求方法',
  params          varchar(5000) DEFAULT NULL COMMENT '请求参数',
  execute_time    bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  ip              varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC  COMMENT='系统日志,不允许修改删除';



-- ----------------------------
-- Table structure for uc_resources
-- ----------------------------

CREATE TABLE uc_resources (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  name            varchar(50) DEFAULT NULL COMMENT '资源名称',
  parent_id       varchar(64) DEFAULT NULL COMMENT '父资源ID，一级资源为NULL或者空串',
  url             varchar(200) DEFAULT NULL COMMENT '资源URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址), 4.表记录，使用rec:{tablename}/{id}，其中多个tablename使用逗号分隔，多个id使用逗号分隔',
  perms           varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  resource_type   int(11) DEFAULT NULL COMMENT '类型   0：目录/元数据   1：菜单   2：按钮 3：信息项/数据记录',
  icon            varchar(50) DEFAULT NULL COMMENT '图标',
  `sort`          int(11) DEFAULT NULL COMMENT '排序',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  KEY k_sort (`sort`) USING BTREE,
  UNIQUE KEY uk_name (name) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='资源管理';

-- ----------------------------
-- Records of uc_resources
-- ----------------------------
INSERT INTO uc_resources VALUES ('1', '系统管理', null, null, null, '0', 'el-icon-setting', '0',        null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('2', '用户管理', '1', '/sys/user', null, '1', 'el-icon-service', '1', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('3', '机构管理', '1', '/sys/dept', null, '1', 'el-icon-news', '2', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('4', '角色管理', '1', '/sys/role', null, '1', 'el-icon-view', '4', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('5', '资源管理', '1', '/sys/menu', null, '1', 'el-icon-menu', '5', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('7', '字典管理', '1', '/sys/dict', null, '1', 'el-icon-edit-outline', '7', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('8', '系统日志', '1', '/sys/log', 'sys:log:view', '1', 'el-icon-info', '8',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('9', '查看用户', '2', null, 'sys:user:view', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('10', '新增用户', '2', null, 'sys:user:add', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('11', '修改用户', '2', null, 'sys:user:edit', '2', null, '0', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('12', '删除用户', '2', null, 'sys:user:delete', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('13', '查看部门', '3', null, 'sys:dept:view', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('14', '新增部门', '3', null, 'sys:dept:add', '2', null, '0', 		null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('15', '修改部门', '3', null, 'sys:dept:edit', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('16', '删除部门', '3', null, 'sys:dept:delete', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('17', '查看角色', '4', null, 'sys:role:view', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('18', '新增角色', '4', null, 'sys:role:add', '2', null, '0', 		null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('19', '修改角色', '4', null, 'sys:role:edit', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('20', '删除角色', '4', null, 'sys:role:delete', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('21', '查看菜单', '5', null, 'sys:menu:view', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('22', '新增菜单', '5', null, 'sys:menu:add', '2', null, '0', 		null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('23', '修改菜单', '5', null, 'sys:menu:edit', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('24', '删除菜单', '5', null, 'sys:menu:delete', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('31', '查看字典', '7', null, 'sys:dict:view', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('32', '新增字典', '7', null, 'sys:dict:add', '2', null, '0', 		null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('33', '修改字典', '7', null, 'sys:dict:edit', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_resources VALUES ('34', '删除字典', '7', null, 'sys:dict:delete', '2', null, '0', 	null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

-- ----------------------------
-- Table structure for uc_roles
-- ----------------------------

CREATE TABLE uc_roles (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  code            varchar(20) DEFAULT NULL COMMENT '角色代号',
  name            varchar(100) DEFAULT NULL COMMENT '角色名称',
  parent_id       varchar(64) DEFAULT NULL COMMENT '父ID，一级为空',
  role_type       varchar(20) DEFAULT NULL COMMENT '职责/类型',
  `sort`          int(11) DEFAULT NULL COMMENT '排序',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  KEY k_sort (`sort`) USING BTREE,
  UNIQUE KEY uk_code (code) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色管理';

-- ----------------------------
-- Records of uc_roles
-- ----------------------------
INSERT INTO uc_roles VALUES ('1', 'admin', '超级管理员', 0, null,  0,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_roles VALUES ('2', 'dev', '开发人员', 0, null,      0,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_roles VALUES ('3', 'test', '测试人员', 0, null,     0,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_roles VALUES ('4', 'project', '项目经理',0, null,   0,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_roles VALUES ('8', 'mng', '部门经理',0, null,       0,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

-- ----------------------------
-- Table structure for uc_role_dept
-- ----------------------------

CREATE TABLE uc_role_dept (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  role_id         varchar(64) NOT NULL COMMENT '角色ID',
  dept_id         varchar(64) NOT NULL COMMENT '机构ID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色机构关系表，备用';

-- ----------------------------
-- Records of uc_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for uc_acls
-- ----------------------------

CREATE TABLE uc_acls (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  role_id         varchar(64) NOT NULL COMMENT '角色ID',
  resource_id     varchar(64) NOT NULL COMMENT '资源ID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='访问控制列表';

-- ----------------------------
-- Records of uc_acls
-- ----------------------------
INSERT INTO uc_acls VALUES ('224', '4', '1', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('225', '4', '2', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('226', '4', '9', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('227', '4', '3', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('228', '4', '13',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('229', '4', '4', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('230', '4', '17',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('231', '4', '5', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('232', '4', '21',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('233', '4', '6', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('234', '4', '7', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('235', '4', '31',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('236', '4', '8', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('237', '4', '25',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('238', '4', '26',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('239', '4', '27',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('240', '4', '28',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('241', '4', '29',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('242', '4', '30',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('243', '4', '35',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('388', '2', '1', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('389', '2', '2', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('390', '2', '9', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('391', '2', '3', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('392', '2', '13',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('393', '2', '17',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('394', '2', '5', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('395', '2', '21',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('396', '2', '7', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('397', '2', '31',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('398', '2', '8', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('399', '2', '6', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('400', '2', '35',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('401', '2', '28',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('402', '2', '29',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('403', '2', '30',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('404', '3', '1', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('405', '3', '2', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('406', '3', '9', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('407', '3', '3', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('408', '3', '13',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('409', '3', '8', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('410', '3', '6', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('411', '3', '28',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('412', '3', '29',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('413', '3', '30',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('431', '8', '1', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('432', '8', '2', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('433', '8', '9', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('434', '8', '3', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('435', '8', '13',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('436', '8', '4', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('437', '8', '17',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('438', '8', '5', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('439', '8', '21',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('440', '8', '7', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('441', '8', '31',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('442', '8', '8', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('443', '8', '6', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_acls VALUES ('444', '8', '35',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

-- ----------------------------
-- Table structure for uc_users
-- ----------------------------

CREATE TABLE uc_users (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  `app_id`        varchar(64) NOT NULL DEFAULT '' COMMENT '应用id',
  `user_type`     varchar(20) DEFAULT NULL COMMENT '岗位/类型',
  `username`      varchar(20) DEFAULT NULL COMMENT '账号,可以不是姓名，唯一',
  `password`      varchar(64) DEFAULT NULL COMMENT '密码',
  `salt`          varchar(40) DEFAULT NULL COMMENT '盐',
  `nick_name`     varchar(10) DEFAULT NULL COMMENT '昵称',
  `birthday`      date DEFAULT NULL COMMENT '生日',
  `gender`        enum('0','1','2') NOT NULL DEFAULT '1' COMMENT '性别-0女/1男/2保密',
  `phone`         varchar(11) DEFAULT NULL COMMENT '绑定电话',
  `email`         varchar(100) DEFAULT NULL COMMENT '绑定邮箱',
  `age`           double(3,0) unsigned DEFAULT NULL COMMENT '年龄',
  `hobby`         varchar(255) DEFAULT NULL COMMENT '爱好-多个用/分割',
  `head_url`      varchar(255) DEFAULT NULL COMMENT '头像路径',
  `enable_status` bit(1) NOT NULL DEFAULT b'1' COMMENT '启用状态-0禁用/1启用',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  `tag`           enum('0','1') NOT NULL DEFAULT '1' COMMENT '0虚拟/1真实',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY uk_username (username) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户';


-- ----------------------------
-- Records of uc_users
-- ----------------------------
INSERT INTO uc_users VALUES ('1' , '', null, 'admin', 'bd1718f058d8a02468134432b8656a86', 'YzcmCZNvbXocrsz9dm8e', '管理', null, 1, '13612345678', 'admin@hotmail.com', '9', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin',  1, '0');
INSERT INTO uc_users VALUES ('22', '', null, 'tom',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '三', null, 1, '13889700023', 'zhangsan@hotmail.com', '9', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('23', '', null, 'edison',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '4', null, 1, '13889700023', '', '9.5', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('24', '', null, '王五',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '5', null, 1, '13889700023', null, '10', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('25', '', null, '周六',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '6', null, 1, '13889700023', null, '10', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('26', '', null, '孙七',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '7', null, 1, '13889700023', null, '10','跑步',  null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin',1,  '0');
INSERT INTO uc_users VALUES ('27', '', null, '陆八',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '8', null, 1, '13889700023', null, '10', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('28', '', null, '黄九',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '9', null, 1, '13889700023', null, '10', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin',1,  '0');
INSERT INTO uc_users VALUES ('29', '', null, '冯十',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '10', null, 1, '13889700023', null, '10', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('30', '', null, '十一太保',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '11', null, 1, '13889700023', null, '10', '跑步', null, 1, null,'2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('31', '', null, '十二太保',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '12', null, 1, '13889700023', null, '10','跑步',  null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');
INSERT INTO uc_users VALUES ('32', '', null, '十三太保',  'fd80ebd493a655608dc893a9f897d845', 'YzcmCZNvbXocrsz9dm8e', '13', null, 1, '13889700023', null, '10', '跑步', null, 1, null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1, '0');


-- ----------------------------
-- Table structure for uc_certifications
-- ----------------------------

CREATE TABLE uc_certifications (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  user_id         varchar(64) NOT NULL COMMENT '用户ID',
  mode            int(11) DEFAULT 0 COMMENT '认证方式 0短信 1银行 2人脸识别 3公有云实名认证服务 4身份证查验 5护照查验',
  certfied_real_name     int(11) DEFAULT 0 COMMENT '是否已通过实名认证 0未通过 1通过',
  organization_real_name varchar(255) NOT NULL COMMENT '实名认证机构',
  certfied_result varchar(512) NOT NULL COMMENT '实名认证机构返回的认证结果',
  name            varchar(64) NOT NULL COMMENT '身份证姓名',
  id_card_number  varchar(64) NOT NULL COMMENT '身份证号码',
  passport_number varchar(64) NOT NULL COMMENT '护照号码',
  driving_license_number varchar(64) NOT NULL COMMENT '驾照号码',
  url             varchar(512) NOT NULL COMMENT '认证资料链接',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  UNIQUE KEY uk_name (name) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户认证表，不含密码认证';


-- ----------------------------
-- Table structure for uc_user_dept
-- ----------------------------

CREATE TABLE uc_user_dept (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  user_id         varchar(64) NOT NULL COMMENT '用户ID',
  dept_id         varchar(64) NOT NULL COMMENT '机构ID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户机构关系表';

-- ----------------------------
-- Records of uc_role_dept
-- ----------------------------
insert into uc_user_dept values('1001', '1' ,  '4', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1002', '22', '34', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1003', '23', '34', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1004', '24', '34', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1005', '25', '33', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1006', '26', '33', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1007', '27', '33', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1008', '28', '33', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1009', '29', '35', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1010', '30', '35', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1011', '31', '35', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
insert into uc_user_dept values('1012', '32', '35', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

-- ----------------------------
-- Table structure for uc_user_area
-- ----------------------------

CREATE TABLE uc_user_area (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  area_id         varchar(64) NOT NULL COMMENT '区域ID',
  user_id         varchar(64) NOT NULL COMMENT '用户ID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='区域用户机构关系表';

-- ----------------------------
-- Records of uc_user_area
-- ----------------------------

-- ----------------------------
-- Table structure for uc_user_role
-- ----------------------------

CREATE TABLE uc_user_role (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  user_id         varchar(64) NOT NULL COMMENT '用户ID',
  role_id         varchar(64) NOT NULL COMMENT '角色ID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户角色';

-- ----------------------------
-- Records of uc_user_role
-- ----------------------------
INSERT INTO uc_user_role VALUES ('1', '1', '1', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('2', '2', '1', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('26', '5', '3',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('33', '6', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('34', '4', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('35', '9', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('36', '10', '3',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('37', '11', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('38', '12', '3',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('39', '15', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('41', '16', '3',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('42', '8', '2' ,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('43', '7', '4' ,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('45', '18', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('46', '17', '3',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('47', '3', '4' ,null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('48', '21', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('50', '23', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('51', '24', '3',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('52', '25', '8',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('53', '26', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('54', '27', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('56', '29', '8',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('57', '31', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('58', '30', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('59', '32', '3',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('68', '33', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('69', '22', '8',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('70', '22', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_role VALUES ('71', '28', '2',null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);


-- ----------------------------
-- Table structure for uc_user_tokens
-- ----------------------------

CREATE TABLE uc_user_tokens (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  user_id         varchar(64) NOT NULL COMMENT '用户ID',
  token           varchar(100) NOT NULL COMMENT '令牌',
  expire_time     datetime DEFAULT NULL COMMENT '过期时间',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  UNIQUE KEY uk_token (token) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC  COMMENT='用户Token';

-- ----------------------------
-- Records of uc_user_token
-- ----------------------------
INSERT INTO uc_user_tokens VALUES ('1', '1', 'ee02ead2c1e3a113f82accafaf878b69', '2018-12-27 23:08:41',  null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_tokens VALUES ('2', '17', '3d32077ccddb6eb2c4302feb93765cd0', '2018-09-24 05:11:17', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_tokens VALUES ('3', '18', 'a939ac41fd309ca785485b4135b8baad', '2018-09-24 05:10:36', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);
INSERT INTO uc_user_tokens VALUES ('4', '33', '605dbcfa2277cbca3b2a124974816080', '2018-11-04 21:42:49', null, '2018-08-14 11:11:11', '2018-08-14 11:11:11','admin', 'admin', 1);

--
-- Table structure for table `uc_user_address`
--



CREATE TABLE `uc_user_addresses` (
  `id`             varchar(64) NOT NULL COMMENT 'id',
  `user_id`        varchar(64) NOT NULL COMMENT '用户id',
  `contact_name`   varchar(255) NOT NULL COMMENT '联系人姓名',
  `phone`          varchar(255) NOT NULL COMMENT '联系电话',
  `province_id`    varchar(6) NOT NULL COMMENT '省id',
  `city_id`        varchar(6) NOT NULL COMMENT '市id',
  `county_id`      varchar(6) NOT NULL COMMENT '县id',
  `address`        varchar(500) NOT NULL COMMENT '联系地址',
  `zip_code`       varchar(255) DEFAULT NULL COMMENT '邮编',
  `email`          varchar(100) DEFAULT NULL COMMENT '联系邮箱',
  `fax`            varchar(50) DEFAULT NULL COMMENT '联系传真',
  `default_status` bit(1) NOT NULL DEFAULT b'1' COMMENT '默认状态',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  KEY `k_user_id` (`user_id`) USING BTREE,
  UNIQUE KEY uk_contact_name (contact_name) USING BTREE,
  UNIQUE KEY uk_email (email) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户地址，收货或者发货';

--
-- Table structure for table `uc_user_logistics`
--



CREATE TABLE `uc_user_logistics` (
  `id`             varchar(64) NOT NULL COMMENT 'id',
  `consigner_id`   varchar(64) NOT NULL COMMENT '发货人ID',
  `mode`       	   int(11) NOT NULL COMMENT '物流方式：-1未知，0发货，1收货',
  `consignee_id`   varchar(64) NOT NULL COMMENT '收货人ID',
  `courier_number` varchar(500) DEFAULT NULL COMMENT '快递单号',
  `sent_time`    timestamp(6) NULL DEFAULT NULL COMMENT '发货时间',
  `logistics_status`     int(11) NOT NULL COMMENT '物流状态。-1未知，0准备中，1在途，2在中转仓库，3到达，4已签收',
  `logistics_process`    varchar(1024) NOT NULL COMMENT '流程描述，描述几点到了哪个点',
  `received_time` timestamp(6) NULL DEFAULT NULL COMMENT '发货时间',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  UNIQUE KEY uk_courier_number (courier_number) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户物流';

--
-- Table structure for table `uc_user_logins`
--


CREATE TABLE `uc_user_logins` (
  `id`            varchar(64) NOT NULL COMMENT '登录日志标号',
  `user_id`       varchar(64) NOT NULL COMMENT '用户ID',
  `device_id`     varchar(64) NOT NULL COMMENT '设备ID',
  `version_id`    varchar(64) NOT NULL COMMENT '版本ID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  `tag`           enum('0','1') NOT NULL DEFAULT '1' COMMENT '0虚拟/1真实',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  KEY `k_user_id` (`user_id`) USING BTREE,
  KEY `k_version_id` (`version_id`) USING BTREE,
  KEY `k_device_id` (`device_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户登录记录，不允许修改、删除';

--
-- Table structure for table `uc_user_scores`
--


CREATE TABLE `uc_user_scores` (
  `id`            varchar(64) NOT NULL COMMENT '用户积分id',
  `user_id`       varchar(64) NOT NULL COMMENT '用户id',
  `value`         decimal(9,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '值',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户积分';

--
-- Table structure for table `uc_score_detail`
--


CREATE TABLE `uc_score_detail` (
  `id`            varchar(64) NOT NULL COMMENT '用户积分明细id',
  `user_score_id` varchar(64) NOT NULL COMMENT '用户积分id',
  `change_value`  decimal(9,2) NOT NULL COMMENT '交易值',
  `after_value`   decimal(9,2) unsigned NOT NULL COMMENT '交易后的值',
  `change_type`   enum('EDU','EXCHANGE') NOT NULL COMMENT '交易类型-EDU:学习/EXCHANGE:兑换',
  `join_id`       varchar(64) DEFAULT NULL COMMENT '关联业务id, 现解释为appID',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户积分明细';

--
-- Table structure for table `uc_score_exchanges`
--


CREATE TABLE `uc_score_exchanges` (
  `id`            varchar(64) NOT NULL COMMENT '用户积分兑换id',
  `order_number`  varchar(64) NOT NULL COMMENT '订单号',
  `channel_id`    varchar(64) NOT NULL COMMENT '渠道id',
  `user_id`       varchar(64) NOT NULL COMMENT '用户id',
  `prize_id`      varchar(64) NOT NULL COMMENT '商品id',
  `prize_name`    varchar(255) NOT NULL COMMENT '商品名称',
  `prize_img`     varchar(1000) NOT NULL COMMENT '商品图片',
  `score`         decimal(9,2) unsigned NOT NULL COMMENT '积分',
  `logistics_id`  varchar(64) NOT NULL COMMENT '物流id',  
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  UNIQUE KEY `uk_order_number` (`order_number`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户积分兑换记录';

--
-- Table structure for table `uc_target_prizes`
--


CREATE TABLE `uc_target_prizes` (
  `id`            varchar(64) NOT NULL COMMENT '用户订购id',
  `user_id`       varchar(64) NOT NULL COMMENT '用户id',
  `prize_id`      varchar(64) NOT NULL COMMENT '商品id',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  UNIQUE KEY `uk_user_prize_id` (`user_id`,`prize_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户订购信息';

--
-- Table structure for table `uc_reward`
--



CREATE TABLE `uc_rewards` (
  `id`            varchar(64) NOT NULL COMMENT '奖励id',
  `user_id`       varchar(64) NOT NULL COMMENT '用户id',
  `resource_id`   varchar(64) NOT NULL COMMENT '资源id',
  `content_id`    varchar(64) DEFAULT NULL COMMENT '内容id',
  `reward_number` double(3,0) unsigned NOT NULL COMMENT '奖励数量',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  UNIQUE KEY `uk_resource_id` (`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='星星奖励记录';

--
-- Table structure for table `uc_family_members`
--



CREATE TABLE `uc_family_members` (
  `id`            varchar(64) NOT NULL COMMENT '标识',
  `user_id`       varchar(64) NOT NULL COMMENT '成员id，关联users表',
  `master_id`     varchar(64) NOT NULL COMMENT '家主id，关联users表',
  `relation_name` varchar(20) DEFAULT NULL COMMENT '关系名称',
  `education`     int(11) DEFAULT NULL COMMENT '教育阶段-0幼儿园/1小学/2中学',
  `grade`         int(11) DEFAULT NULL COMMENT '年级-1/2/3/4/5/6/7/8/9/10/11/12',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  UNIQUE KEY `uk_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='家庭成员';

--
-- Table structure for table `uc_vaccines`
--



CREATE TABLE `uc_vaccines` (
  `id`            varchar(64) NOT NULL COMMENT '疫苗id',
  `month_age`     int(10) unsigned NOT NULL COMMENT '月龄',
  `vaccine_info`  varchar(500) DEFAULT NULL COMMENT '疫苗信息',
  `sort`          int(11) DEFAULT NULL COMMENT '排序',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  KEY k_sort (`sort`) USING BTREE,
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='疫苗';

--
-- Table structure for table `uc_browses`
--


CREATE TABLE `uc_browses` (
  `id`            varchar(64) NOT NULL COMMENT '浏览id',
  `user_id`       varchar(64) NOT NULL COMMENT '用户id',
  `resource_id`   varchar(64) NOT NULL COMMENT '资源id',
  `content_id`    varchar(64) DEFAULT NULL COMMENT '内容id',
  `ratio`         double(3,0) unsigned NOT NULL DEFAULT '0' COMMENT '播放占比%',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  KEY `k_user_id` (`user_id`) USING BTREE,
  KEY `k_resource_id` (`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='浏览';

--
-- Table structure for table `uc_collections`
--


CREATE TABLE `uc_collections` (
  `id`            varchar(64) NOT NULL COMMENT '收藏id',
  `user_id`       varchar(64) NOT NULL COMMENT '用户id',
  `resource_id`   varchar(64) NOT NULL COMMENT '资源id',
  `content_id`    varchar(64) DEFAULT NULL COMMENT '内容id',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE,
  KEY `k_user_id` (`user_id`) USING BTREE,
  KEY `k_resource_id` (`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='收藏';

--
-- Table structure for table `uc_diaries`
--



CREATE TABLE `uc_diaries` (
  `id`            varchar(64) NOT NULL COMMENT '日记id',
  `user_id`       varchar(64) NOT NULL COMMENT '用户id',
  `content`       text NOT NULL COMMENT '内容',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='日记';


CREATE TABLE `uc_standard` (
  `id`            varchar(64) NOT NULL COMMENT 'id',
  `standard_type` enum('HEIGHT','WEIGHT') NOT NULL,
  `sex`           enum('GIRL','BOY') NOT NULL COMMENT '性别',
  `month_age`     int(10) unsigned NOT NULL COMMENT '月龄',
  `sd3_`          double(10,2) unsigned NOT NULL,
  `sd2_`          double(10,2) unsigned NOT NULL,
  `sd1_`          double(10,2) unsigned NOT NULL,
  `center`        double(10,2) unsigned NOT NULL,
  `sd1`           double(10,2) unsigned NOT NULL,
  `sd2`           double(10,2) unsigned NOT NULL,
  `sd3`           double(10,2) unsigned NOT NULL,
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',  
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='身高体重';


CREATE TABLE `uc_prizes` (
  `id` varchar(64) NOT NULL COMMENT '商品id',
  `channel_id` varchar(64) NOT NULL COMMENT '渠道id',
  `prize_name` varchar(255) NOT NULL COMMENT '商品名称',
  `prize_img` varchar(1000) NOT NULL COMMENT '商品图片',
  `score` decimal(9,2) unsigned NOT NULL COMMENT '积分',
  `inventory` double(9,0) unsigned NOT NULL DEFAULT '1' COMMENT '库存',
  `prize_status` enum('UP','DOWN') NOT NULL DEFAULT 'DOWN' COMMENT '商品状态-UP:上架/DOWN:下架',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',  
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='商品';


CREATE TABLE `uc_appstore` (
  `id` varchar(64) NOT NULL COMMENT '应用商店id',
  `channel_id` varchar(64) DEFAULT NULL COMMENT '渠道id',
  `app_name` varchar(255) NOT NULL COMMENT '应用名称',
  `package_name` varchar(500) NOT NULL COMMENT '包名',
  `call_class` varchar(500) DEFAULT NULL COMMENT '调用类名',
  `file_size` decimal(19,2) NOT NULL DEFAULT '0.00' COMMENT '文件大小(b)字节',
  `version_name` varchar(255) NOT NULL COMMENT '版本名',
  `version_code` varchar(255) NOT NULL COMMENT '版本号',
  `url` varchar(1000) NOT NULL COMMENT '文件地址',
  `md5` varchar(255) DEFAULT NULL COMMENT 'md5值',
  `icon` varchar(1000) NOT NULL COMMENT '图标',
  `instruction` text COMMENT '应用说明',
  `app_scope` enum('0','1') DEFAULT NULL COMMENT '应用范围-0所有/1指定',
  `download_number` int(11) DEFAULT NULL COMMENT '下载次数',
  `phase_tag` varchar(500) DEFAULT NULL COMMENT '阶段标签(0幼儿,1小学,2中学,3高中,100综合)',
  `release_time` date DEFAULT NULL COMMENT '发布时间',
  `content_type` enum('EDU','AMUSEMENT') DEFAULT NULL COMMENT '内容类型',
  `developer` varchar(255) DEFAULT NULL COMMENT '开发商',
  `images` text COMMENT '应用截图',
  `enable` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否启用',
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',  
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='应用商店';


CREATE TABLE `uc_apps` (
  `id` varchar(64) NOT NULL COMMENT '应用id',
  `channel_id` varchar(64) NOT NULL DEFAULT '' COMMENT '渠道id',
  `app_name` varchar(50) NOT NULL COMMENT '应用名称',
  `package_name` varchar(255) NOT NULL COMMENT '包名',
  `auth_type` enum('MAC','SN','MACSN') NOT NULL DEFAULT 'MACSN' COMMENT '认证方式',
  `app_type` enum('0','1') NOT NULL DEFAULT '0' COMMENT '应用类型-0 APP，1 固件',
  `instruction` text NOT NULL COMMENT '应用说明',
  `enable_sn` bit(1) NOT NULL DEFAULT b'1' COMMENT '启动激活码激活',
  `app_key` varchar(32) NOT NULL,
  `app_secret` varchar(32) NOT NULL,
  `remark`        varchar(255) DEFAULT NULL COMMENT '备注-内部使用',
  `create_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '创建时间,默认系统时间,不需要手动插入',
  `update_time`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '修改时间,默认系统时间,不需要手动插入',
  `create_user`   varchar(64) DEFAULT NULL COMMENT '创建者id',
  `update_user`   varchar(64) DEFAULT NULL COMMENT '修改者id',
  `status`        bit(1) NOT NULL DEFAULT b'1' COMMENT '数据有效性-0无效/1有效(实体类为boolean)',    
  PRIMARY KEY pk_id(`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='应用';


-- for AT mode you must to init this sql for you business database. the seata server not need it.
CREATE TABLE IF NOT EXISTS `undo_log`
(
    `branch_id`     BIGINT(20)   NOT NULL COMMENT 'branch transaction id',
    `xid`           VARCHAR(100) NOT NULL COMMENT 'global transaction id',
    `context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
    `log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   DATETIME(6)  NOT NULL COMMENT 'create datetime',
    `log_modified`  DATETIME(6)  NOT NULL COMMENT 'modify datetime',
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='AT transaction mode undo table';


-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists uc_sec_dept;
create table uc_sec_dept (
  dept_id           bigint(20)      not null auto_increment    comment '部门id',
  parent_id         bigint(20)      default 0                  comment '父部门id',
  ancestors         varchar(50)     default ''                 comment '祖级列表',
  dept_name         varchar(30)     default ''                 comment '部门名称',
  order_num         int(4)          default 0                  comment '显示顺序',
  leader            varchar(20)     default null               comment '负责人',
  phone             varchar(11)     default null               comment '联系电话',
  email             varchar(50)     default null               comment '邮箱',
  status            char(1)         default '0'                comment '部门状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (dept_id)
) engine=innodb auto_increment=200 comment = '部门表';

-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into uc_sec_dept values(100,  0,   '0',          'TESTU科技',   0, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(101,  100, '0,100',      '深圳总公司', 1, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(102,  100, '0,100',      '长沙分公司', 2, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(103,  101, '0,100,101',  '研发部门',   1, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(104,  101, '0,100,101',  '市场部门',   2, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(105,  101, '0,100,101',  '测试部门',   3, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(106,  101, '0,100,101',  '财务部门',   4, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(107,  101, '0,100,101',  '运维部门',   5, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(108,  102, '0,100,102',  '市场部门',   1, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into uc_sec_dept values(109,  102, '0,100,102',  '财务部门',   2, 'TESTU', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);


-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists uc_sec_user;
create table uc_sec_user (
  user_id           bigint(20)      not null auto_increment    comment '用户ID',
  dept_id           bigint(20)      default null               comment '部门ID',
  user_name         varchar(30)     not null                   comment '用户账号',
  nick_name         varchar(30)     not null                   comment '用户昵称',
  user_type         varchar(2)      default '00'               comment '用户类型（00系统用户）',
  email             varchar(50)     default ''                 comment '用户邮箱',
  phonenumber       varchar(11)     default ''                 comment '手机号码',
  sex               char(1)         default '0'                comment '用户性别（0男 1女 2未知）',
  avatar            varchar(100)    default ''                 comment '头像地址',
  password          varchar(100)    default ''                 comment '密码',
  status            char(1)         default '0'                comment '帐号状态（0正常 1停用）',
  del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  login_ip          varchar(128)    default ''                 comment '最后登录IP',
  login_date        datetime                                   comment '最后登录时间',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (user_id)
) engine=innodb auto_increment=100 comment = '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into uc_sec_user values(1,  103, 'admin', 'TESTU', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '管理员');
insert into uc_sec_user values(2,  105, 'ry',    'TESTU', '00', 'ry@qq.com',  '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '测试员');


-- ----------------------------
-- 3、岗位信息表
-- ----------------------------
drop table if exists uc_sec_post;
create table uc_sec_post
(
  post_id       bigint(20)      not null auto_increment    comment '岗位ID',
  post_code     varchar(64)     not null                   comment '岗位编码',
  post_name     varchar(50)     not null                   comment '岗位名称',
  post_sort     int(4)          not null                   comment '显示顺序',
  status        char(1)         not null                   comment '状态（0正常 1停用）',
  create_by     varchar(64)     default ''                 comment '创建者',
  create_time   datetime                                   comment '创建时间',
  update_by     varchar(64)     default ''			       comment '更新者',
  update_time   datetime                                   comment '更新时间',
  remark        varchar(500)    default null               comment '备注',
  primary key (post_id)
) engine=innodb comment = '岗位信息表';

-- ----------------------------
-- 初始化-岗位信息表数据
-- ----------------------------
insert into uc_sec_post values(1, 'ceo',  '董事长',    1, '0', 'admin', sysdate(), '', null, '');
insert into uc_sec_post values(2, 'se',   '项目经理',  2, '0', 'admin', sysdate(), '', null, '');
insert into uc_sec_post values(3, 'hr',   '人力资源',  3, '0', 'admin', sysdate(), '', null, '');
insert into uc_sec_post values(4, 'user', '普通员工',  4, '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 4、角色信息表
-- ----------------------------
drop table if exists uc_sec_role;
create table uc_sec_role (
  role_id              bigint(20)      not null auto_increment    comment '角色ID',
  role_name            varchar(30)     not null                   comment '角色名称',
  role_key             varchar(100)    not null                   comment '角色权限字符串',
  role_sort            int(4)          not null                   comment '显示顺序',
  data_scope           char(1)         default '1'                comment '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  menu_check_strictly  tinyint(1)      default 1                  comment '菜单树选择项是否关联显示',
  dept_check_strictly  tinyint(1)      default 1                  comment '部门树选择项是否关联显示',
  status               char(1)         not null                   comment '角色状态（0正常 1停用）',
  del_flag             char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
  create_by            varchar(64)     default ''                 comment '创建者',
  create_time          datetime                                   comment '创建时间',
  update_by            varchar(64)     default ''                 comment '更新者',
  update_time          datetime                                   comment '更新时间',
  remark               varchar(500)    default null               comment '备注',
  primary key (role_id)
) engine=innodb auto_increment=100 comment = '角色信息表';

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
insert into uc_sec_role values('1', '超级管理员',  'admin',  1, 1, 1, 1, '0', '0', 'admin', sysdate(), '', null, '超级管理员');
insert into uc_sec_role values('2', '普通角色',    'common', 2, 2, 1, 1, '0', '0', 'admin', sysdate(), '', null, '普通角色');


-- ----------------------------
-- 5、菜单权限表
-- ----------------------------
drop table if exists uc_sec_menu;
create table uc_sec_menu (
  menu_id           bigint(20)      not null auto_increment    comment '菜单ID',
  menu_name         varchar(50)     not null                   comment '菜单名称',
  parent_id         bigint(20)      default 0                  comment '父菜单ID',
  order_num         int(4)          default 0                  comment '显示顺序',
  path              varchar(200)    default ''                 comment '路由地址',
  component         varchar(255)    default null               comment '组件路径',
  query             varchar(255)    default null               comment '路由参数',
  is_frame          int(1)          default 1                  comment '是否为外链（0是 1否）',
  is_cache          int(1)          default 0                  comment '是否缓存（0缓存 1不缓存）',
  menu_type         char(1)         default ''                 comment '菜单类型（M目录 C菜单 F按钮）',
  visible           char(1)         default 0                  comment '菜单状态（0显示 1隐藏）',
  status            char(1)         default 0                  comment '菜单状态（0正常 1停用）',
  perms             varchar(100)    default null               comment '权限标识',
  icon              varchar(100)    default '#'                comment '菜单图标',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default ''                 comment '备注',
  primary key (menu_id)
) engine=innodb auto_increment=2000 comment = '菜单权限表';

-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
-- 一级菜单
insert into uc_sec_menu values('1', '系统管理', '0', '1', 'system',           null, '', 1, 0, 'M', '0', '0', '', 'system',   'admin', sysdate(), '', null, '系统管理目录');
insert into uc_sec_menu values('2', '系统监控', '0', '2', 'monitor',          null, '', 1, 0, 'M', '0', '0', '', 'monitor',  'admin', sysdate(), '', null, '系统监控目录');
insert into uc_sec_menu values('3', '系统工具', '0', '3', 'tool',             null, '', 1, 0, 'M', '0', '0', '', 'tool',     'admin', sysdate(), '', null, '系统工具目录');
insert into uc_sec_menu values('4', 'TESTU官网', '0', '4', 'http://ruoyi.vip', null, '', 0, 0, 'M', '0', '0', '', 'guide',    'admin', sysdate(), '', null, 'TESTU官网地址');
-- 二级菜单
insert into uc_sec_menu values('100',  '用户管理',       '1',   '1', 'user',       'system/user/index',                 '', 1, 0, 'C', '0', '0', 'system:user:list',        'user',          'admin', sysdate(), '', null, '用户管理菜单');
insert into uc_sec_menu values('101',  '角色管理',       '1',   '2', 'role',       'system/role/index',                 '', 1, 0, 'C', '0', '0', 'system:role:list',        'peoples',       'admin', sysdate(), '', null, '角色管理菜单');
insert into uc_sec_menu values('102',  '菜单管理',       '1',   '3', 'menu',       'system/menu/index',                 '', 1, 0, 'C', '0', '0', 'system:menu:list',        'tree-table',    'admin', sysdate(), '', null, '菜单管理菜单');
insert into uc_sec_menu values('103',  '部门管理',       '1',   '4', 'dept',       'system/dept/index',                 '', 1, 0, 'C', '0', '0', 'system:dept:list',        'tree',          'admin', sysdate(), '', null, '部门管理菜单');
insert into uc_sec_menu values('104',  '岗位管理',       '1',   '5', 'post',       'system/post/index',                 '', 1, 0, 'C', '0', '0', 'system:post:list',        'post',          'admin', sysdate(), '', null, '岗位管理菜单');
insert into uc_sec_menu values('105',  '字典管理',       '1',   '6', 'dict',       'system/dict/index',                 '', 1, 0, 'C', '0', '0', 'system:dict:list',        'dict',          'admin', sysdate(), '', null, '字典管理菜单');
insert into uc_sec_menu values('106',  '参数设置',       '1',   '7', 'config',     'system/config/index',               '', 1, 0, 'C', '0', '0', 'system:config:list',      'edit',          'admin', sysdate(), '', null, '参数设置菜单');
insert into uc_sec_menu values('107',  '通知公告',       '1',   '8', 'notice',     'system/notice/index',               '', 1, 0, 'C', '0', '0', 'system:notice:list',      'message',       'admin', sysdate(), '', null, '通知公告菜单');
insert into uc_sec_menu values('108',  '日志管理',       '1',   '9', 'log',        '',                                  '', 1, 0, 'M', '0', '0', '',                        'log',           'admin', sysdate(), '', null, '日志管理菜单');
insert into uc_sec_menu values('109',  '在线用户',       '2',   '1', 'online',     'monitor/online/index',              '', 1, 0, 'C', '0', '0', 'monitor:online:list',     'online',        'admin', sysdate(), '', null, '在线用户菜单');
insert into uc_sec_menu values('110',  '定时任务',       '2',   '2', 'job',        'monitor/job/index',                 '', 1, 0, 'C', '0', '0', 'monitor:job:list',        'job',           'admin', sysdate(), '', null, '定时任务菜单');
insert into uc_sec_menu values('111',  'Sentinel控制台', '2',   '3', 'http://localhost:8718',        '',                '', 0, 0, 'C', '0', '0', 'monitor:sentinel:list',   'sentinel',      'admin', sysdate(), '', null, '流量控制菜单');
insert into uc_sec_menu values('112',  'Nacos控制台',    '2',   '4', 'http://localhost:8848/nacos',  '',                '', 0, 0, 'C', '0', '0', 'monitor:nacos:list',      'nacos',         'admin', sysdate(), '', null, '服务治理菜单');
insert into uc_sec_menu values('113',  'Admin控制台',    '2',   '5', 'http://localhost:9100/login',  '',                '', 0, 0, 'C', '0', '0', 'monitor:server:list',     'server',        'admin', sysdate(), '', null, '服务监控菜单');
insert into uc_sec_menu values('114',  '表单构建',       '3',   '1', 'build',      'tool/build/index',                  '', 1, 0, 'C', '0', '0', 'tool:build:list',         'build',         'admin', sysdate(), '', null, '表单构建菜单');
insert into uc_sec_menu values('115',  '代码生成',       '3',   '2', 'gen',        'tool/gen/index',                    '', 1, 0, 'C', '0', '0', 'tool:gen:list',           'code',          'admin', sysdate(), '', null, '代码生成菜单');
insert into uc_sec_menu values('116',  '系统接口',       '3',   '3', 'http://localhost:8080/swagger-ui/index.html', '', '', 0, 0, 'C', '0', '0', 'tool:swagger:list',       'swagger',       'admin', sysdate(), '', null, '系统接口菜单');
-- 三级菜单
insert into uc_sec_menu values('500',  '操作日志', '108', '1', 'operlog',    'system/operlog/index',    '', 1, 0, 'C', '0', '0', 'system:operlog:list',    'form',          'admin', sysdate(), '', null, '操作日志菜单');
insert into uc_sec_menu values('501',  '登录日志', '108', '2', 'logininfor', 'system/logininfor/index', '', 1, 0, 'C', '0', '0', 'system:logininfor:list', 'logininfor',    'admin', sysdate(), '', null, '登录日志菜单');
-- 用户管理按钮
insert into uc_sec_menu values('1000', '用户查询', '100', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:query',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1001', '用户新增', '100', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:add',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1002', '用户修改', '100', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1003', '用户删除', '100', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1004', '用户导出', '100', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:export',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1005', '用户导入', '100', '6',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:import',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1006', '重置密码', '100', '7',  '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd',       '#', 'admin', sysdate(), '', null, '');
-- 角色管理按钮
insert into uc_sec_menu values('1007', '角色查询', '101', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:query',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1008', '角色新增', '101', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:add',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1009', '角色修改', '101', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1010', '角色删除', '101', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1011', '角色导出', '101', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:role:export',         '#', 'admin', sysdate(), '', null, '');
-- 菜单管理按钮
insert into uc_sec_menu values('1012', '菜单查询', '102', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1013', '菜单新增', '102', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1014', '菜单修改', '102', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1015', '菜单删除', '102', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove',         '#', 'admin', sysdate(), '', null, '');
-- 部门管理按钮
insert into uc_sec_menu values('1016', '部门查询', '103', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1017', '部门新增', '103', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1018', '部门修改', '103', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1019', '部门删除', '103', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove',         '#', 'admin', sysdate(), '', null, '');
-- 岗位管理按钮
insert into uc_sec_menu values('1020', '岗位查询', '104', '1',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:query',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1021', '岗位新增', '104', '2',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:add',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1022', '岗位修改', '104', '3',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1023', '岗位删除', '104', '4',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1024', '岗位导出', '104', '5',  '', '', '', 1, 0, 'F', '0', '0', 'system:post:export',         '#', 'admin', sysdate(), '', null, '');
-- 字典管理按钮
insert into uc_sec_menu values('1025', '字典查询', '105', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1026', '字典新增', '105', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1027', '字典修改', '105', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1028', '字典删除', '105', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1029', '字典导出', '105', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export',         '#', 'admin', sysdate(), '', null, '');
-- 参数设置按钮
insert into uc_sec_menu values('1030', '参数查询', '106', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query',        '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1031', '参数新增', '106', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1032', '参数修改', '106', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1033', '参数删除', '106', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove',       '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1034', '参数导出', '106', '5', '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export',       '#', 'admin', sysdate(), '', null, '');
-- 通知公告按钮
insert into uc_sec_menu values('1035', '公告查询', '107', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query',        '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1036', '公告新增', '107', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1037', '公告修改', '107', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1038', '公告删除', '107', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove',       '#', 'admin', sysdate(), '', null, '');
-- 操作日志按钮
insert into uc_sec_menu values('1039', '操作查询', '500', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:query',       '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1040', '操作删除', '500', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:remove',      '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1041', '日志导出', '500', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:export',      '#', 'admin', sysdate(), '', null, '');
-- 登录日志按钮
insert into uc_sec_menu values('1042', '登录查询', '501', '1', '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:query',    '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1043', '登录删除', '501', '2', '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:remove',   '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1044', '日志导出', '501', '3', '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:export',   '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1045', '账户解锁', '501', '4', '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:unlock',   '#', 'admin', sysdate(), '', null, '');
-- 在线用户按钮
insert into uc_sec_menu values('1046', '在线查询', '109', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query',       '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1047', '批量强退', '109', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1048', '单条强退', '109', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', sysdate(), '', null, '');
-- 定时任务按钮
insert into uc_sec_menu values('1049', '任务查询', '110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query',          '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1050', '任务新增', '110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1051', '任务修改', '110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1052', '任务删除', '110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove',         '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1053', '状态修改', '110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus',   '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1054', '任务导出', '110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export',         '#', 'admin', sysdate(), '', null, '');
-- 代码生成按钮
insert into uc_sec_menu values('1055', '生成查询', '115', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query',             '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1056', '生成修改', '115', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit',              '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1057', '生成删除', '115', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1058', '导入代码', '115', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import',            '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1059', '预览代码', '115', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview',           '#', 'admin', sysdate(), '', null, '');
insert into uc_sec_menu values('1060', '生成代码', '115', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code',              '#', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 6、用户和角色关联表  用户N-1角色
-- ----------------------------
drop table if exists uc_sec_user_role;
create table uc_sec_user_role (
  user_id   bigint(20) not null comment '用户ID',
  role_id   bigint(20) not null comment '角色ID',
  primary key(user_id, role_id)
) engine=innodb comment = '用户和角色关联表';

-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
insert into uc_sec_user_role values ('1', '1');
insert into uc_sec_user_role values ('2', '2');


-- ----------------------------
-- 7、角色和菜单关联表  角色1-N菜单
-- ----------------------------
drop table if exists uc_sec_role_menu;
create table uc_sec_role_menu (
  role_id   bigint(20) not null comment '角色ID',
  menu_id   bigint(20) not null comment '菜单ID',
  primary key(role_id, menu_id)
) engine=innodb comment = '角色和菜单关联表';

-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
insert into uc_sec_role_menu values ('2', '1');
insert into uc_sec_role_menu values ('2', '2');
insert into uc_sec_role_menu values ('2', '3');
insert into uc_sec_role_menu values ('2', '4');
insert into uc_sec_role_menu values ('2', '100');
insert into uc_sec_role_menu values ('2', '101');
insert into uc_sec_role_menu values ('2', '102');
insert into uc_sec_role_menu values ('2', '103');
insert into uc_sec_role_menu values ('2', '104');
insert into uc_sec_role_menu values ('2', '105');
insert into uc_sec_role_menu values ('2', '106');
insert into uc_sec_role_menu values ('2', '107');
insert into uc_sec_role_menu values ('2', '108');
insert into uc_sec_role_menu values ('2', '109');
insert into uc_sec_role_menu values ('2', '110');
insert into uc_sec_role_menu values ('2', '111');
insert into uc_sec_role_menu values ('2', '112');
insert into uc_sec_role_menu values ('2', '113');
insert into uc_sec_role_menu values ('2', '114');
insert into uc_sec_role_menu values ('2', '115');
insert into uc_sec_role_menu values ('2', '116');
insert into uc_sec_role_menu values ('2', '500');
insert into uc_sec_role_menu values ('2', '501');
insert into uc_sec_role_menu values ('2', '1000');
insert into uc_sec_role_menu values ('2', '1001');
insert into uc_sec_role_menu values ('2', '1002');
insert into uc_sec_role_menu values ('2', '1003');
insert into uc_sec_role_menu values ('2', '1004');
insert into uc_sec_role_menu values ('2', '1005');
insert into uc_sec_role_menu values ('2', '1006');
insert into uc_sec_role_menu values ('2', '1007');
insert into uc_sec_role_menu values ('2', '1008');
insert into uc_sec_role_menu values ('2', '1009');
insert into uc_sec_role_menu values ('2', '1010');
insert into uc_sec_role_menu values ('2', '1011');
insert into uc_sec_role_menu values ('2', '1012');
insert into uc_sec_role_menu values ('2', '1013');
insert into uc_sec_role_menu values ('2', '1014');
insert into uc_sec_role_menu values ('2', '1015');
insert into uc_sec_role_menu values ('2', '1016');
insert into uc_sec_role_menu values ('2', '1017');
insert into uc_sec_role_menu values ('2', '1018');
insert into uc_sec_role_menu values ('2', '1019');
insert into uc_sec_role_menu values ('2', '1020');
insert into uc_sec_role_menu values ('2', '1021');
insert into uc_sec_role_menu values ('2', '1022');
insert into uc_sec_role_menu values ('2', '1023');
insert into uc_sec_role_menu values ('2', '1024');
insert into uc_sec_role_menu values ('2', '1025');
insert into uc_sec_role_menu values ('2', '1026');
insert into uc_sec_role_menu values ('2', '1027');
insert into uc_sec_role_menu values ('2', '1028');
insert into uc_sec_role_menu values ('2', '1029');
insert into uc_sec_role_menu values ('2', '1030');
insert into uc_sec_role_menu values ('2', '1031');
insert into uc_sec_role_menu values ('2', '1032');
insert into uc_sec_role_menu values ('2', '1033');
insert into uc_sec_role_menu values ('2', '1034');
insert into uc_sec_role_menu values ('2', '1035');
insert into uc_sec_role_menu values ('2', '1036');
insert into uc_sec_role_menu values ('2', '1037');
insert into uc_sec_role_menu values ('2', '1038');
insert into uc_sec_role_menu values ('2', '1039');
insert into uc_sec_role_menu values ('2', '1040');
insert into uc_sec_role_menu values ('2', '1041');
insert into uc_sec_role_menu values ('2', '1042');
insert into uc_sec_role_menu values ('2', '1043');
insert into uc_sec_role_menu values ('2', '1044');
insert into uc_sec_role_menu values ('2', '1045');
insert into uc_sec_role_menu values ('2', '1046');
insert into uc_sec_role_menu values ('2', '1047');
insert into uc_sec_role_menu values ('2', '1048');
insert into uc_sec_role_menu values ('2', '1049');
insert into uc_sec_role_menu values ('2', '1050');
insert into uc_sec_role_menu values ('2', '1051');
insert into uc_sec_role_menu values ('2', '1052');
insert into uc_sec_role_menu values ('2', '1053');
insert into uc_sec_role_menu values ('2', '1054');
insert into uc_sec_role_menu values ('2', '1055');
insert into uc_sec_role_menu values ('2', '1056');
insert into uc_sec_role_menu values ('2', '1057');
insert into uc_sec_role_menu values ('2', '1058');
insert into uc_sec_role_menu values ('2', '1059');
insert into uc_sec_role_menu values ('2', '1060');

-- ----------------------------
-- 8、角色和部门关联表  角色1-N部门
-- ----------------------------
drop table if exists uc_sec_role_dept;
create table uc_sec_role_dept (
  role_id   bigint(20) not null comment '角色ID',
  dept_id   bigint(20) not null comment '部门ID',
  primary key(role_id, dept_id)
) engine=innodb comment = '角色和部门关联表';

-- ----------------------------
-- 初始化-角色和部门关联表数据
-- ----------------------------
insert into uc_sec_role_dept values ('2', '100');
insert into uc_sec_role_dept values ('2', '101');
insert into uc_sec_role_dept values ('2', '105');


-- ----------------------------
-- 9、用户与岗位关联表  用户1-N岗位
-- ----------------------------
drop table if exists uc_sec_user_post;
create table uc_sec_user_post
(
  user_id   bigint(20) not null comment '用户ID',
  post_id   bigint(20) not null comment '岗位ID',
  primary key (user_id, post_id)
) engine=innodb comment = '用户与岗位关联表';

-- ----------------------------
-- 初始化-用户与岗位关联表数据
-- ----------------------------
insert into uc_sec_user_post values ('1', '1');
insert into uc_sec_user_post values ('2', '2');


-- ----------------------------
-- 10、操作日志记录
-- ----------------------------
drop table if exists uc_sec_oper_log;
create table uc_sec_oper_log (
  oper_id           bigint(20)      not null auto_increment    comment '日志主键',
  title             varchar(50)     default ''                 comment '模块标题',
  business_type     int(2)          default 0                  comment '业务类型（0其它 1新增 2修改 3删除）',
  method            varchar(100)    default ''                 comment '方法名称',
  request_method    varchar(10)     default ''                 comment '请求方式',
  operator_type     int(1)          default 0                  comment '操作类别（0其它 1后台用户 2手机端用户）',
  oper_name         varchar(50)     default ''                 comment '操作人员',
  dept_name         varchar(50)     default ''                 comment '部门名称',
  oper_url          varchar(255)    default ''                 comment '请求URL',
  oper_ip           varchar(128)    default ''                 comment '主机地址',
  oper_location     varchar(255)    default ''                 comment '操作地点',
  oper_param        varchar(2000)   default ''                 comment '请求参数',
  json_result       varchar(2000)   default ''                 comment '返回参数',
  status            int(1)          default 0                  comment '操作状态（0正常 1异常）',
  error_msg         varchar(2000)   default ''                 comment '错误消息',
  oper_time         datetime                                   comment '操作时间',
  primary key (oper_id)
) engine=innodb auto_increment=100 comment = '操作日志记录';


-- ----------------------------
-- 11、字典类型表
-- ----------------------------
drop table if exists uc_sec_dict_type;
create table uc_sec_dict_type
(
  dict_id          bigint(20)      not null auto_increment    comment '字典主键',
  dict_name        varchar(100)    default ''                 comment '字典名称',
  dict_type        varchar(100)    default ''                 comment '字典类型',
  status           char(1)         default '0'                comment '状态（0正常 1停用）',
  create_by        varchar(64)     default ''                 comment '创建者',
  create_time      datetime                                   comment '创建时间',
  update_by        varchar(64)     default ''                 comment '更新者',
  update_time      datetime                                   comment '更新时间',
  remark           varchar(500)    default null               comment '备注',
  primary key (dict_id),
  unique (dict_type)
) engine=innodb auto_increment=100 comment = '字典类型表';

insert into uc_sec_dict_type values(1,  '用户性别', 'uc_sec_user_sex',        '0', 'admin', sysdate(), '', null, '用户性别列表');
insert into uc_sec_dict_type values(2,  '菜单状态', 'sys_show_hide',       '0', 'admin', sysdate(), '', null, '菜单状态列表');
insert into uc_sec_dict_type values(3,  '系统开关', 'sys_normal_disable',  '0', 'admin', sysdate(), '', null, '系统开关列表');
insert into uc_sec_dict_type values(4,  '任务状态', 'uc_sec_job_status',      '0', 'admin', sysdate(), '', null, '任务状态列表');
insert into uc_sec_dict_type values(5,  '任务分组', 'uc_sec_job_group',       '0', 'admin', sysdate(), '', null, '任务分组列表');
insert into uc_sec_dict_type values(6,  '系统是否', 'sys_yes_no',          '0', 'admin', sysdate(), '', null, '系统是否列表');
insert into uc_sec_dict_type values(7,  '通知类型', 'uc_sec_notice_type',     '0', 'admin', sysdate(), '', null, '通知类型列表');
insert into uc_sec_dict_type values(8,  '通知状态', 'uc_sec_notice_status',   '0', 'admin', sysdate(), '', null, '通知状态列表');
insert into uc_sec_dict_type values(9,  '操作类型', 'sys_oper_type',       '0', 'admin', sysdate(), '', null, '操作类型列表');
insert into uc_sec_dict_type values(10, '系统状态', 'sys_common_status',   '0', 'admin', sysdate(), '', null, '登录状态列表');


-- ----------------------------
-- 12、字典数据表
-- ----------------------------
drop table if exists uc_sec_dict_data;
create table uc_sec_dict_data
(
  dict_code        bigint(20)      not null auto_increment    comment '字典编码',
  dict_sort        int(4)          default 0                  comment '字典排序',
  dict_label       varchar(100)    default ''                 comment '字典标签',
  dict_value       varchar(100)    default ''                 comment '字典键值',
  dict_type        varchar(100)    default ''                 comment '字典类型',
  css_class        varchar(100)    default null               comment '样式属性（其他样式扩展）',
  list_class       varchar(100)    default null               comment '表格回显样式',
  is_default       char(1)         default 'N'                comment '是否默认（Y是 N否）',
  status           char(1)         default '0'                comment '状态（0正常 1停用）',
  create_by        varchar(64)     default ''                 comment '创建者',
  create_time      datetime                                   comment '创建时间',
  update_by        varchar(64)     default ''                 comment '更新者',
  update_time      datetime                                   comment '更新时间',
  remark           varchar(500)    default null               comment '备注',
  primary key (dict_code)
) engine=innodb auto_increment=100 comment = '字典数据表';

insert into uc_sec_dict_data values(1,  1,  '男',       '0',       'uc_sec_user_sex',        '',   '',        'Y', '0', 'admin', sysdate(), '', null, '性别男');
insert into uc_sec_dict_data values(2,  2,  '女',       '1',       'uc_sec_user_sex',        '',   '',        'N', '0', 'admin', sysdate(), '', null, '性别女');
insert into uc_sec_dict_data values(3,  3,  '未知',     '2',       'uc_sec_user_sex',        '',   '',        'N', '0', 'admin', sysdate(), '', null, '性别未知');
insert into uc_sec_dict_data values(4,  1,  '显示',     '0',       'sys_show_hide',       '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '显示菜单');
insert into uc_sec_dict_data values(5,  2,  '隐藏',     '1',       'sys_show_hide',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '隐藏菜单');
insert into uc_sec_dict_data values(6,  1,  '正常',     '0',       'sys_normal_disable',  '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into uc_sec_dict_data values(7,  2,  '停用',     '1',       'sys_normal_disable',  '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '停用状态');
insert into uc_sec_dict_data values(8,  1,  '正常',     '0',       'uc_sec_job_status',      '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into uc_sec_dict_data values(9,  2,  '暂停',     '1',       'uc_sec_job_status',      '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '停用状态');
insert into uc_sec_dict_data values(10, 1,  '默认',     'DEFAULT', 'uc_sec_job_group',       '',   '',        'Y', '0', 'admin', sysdate(), '', null, '默认分组');
insert into uc_sec_dict_data values(11, 2,  '系统',     'SYSTEM',  'uc_sec_job_group',       '',   '',        'N', '0', 'admin', sysdate(), '', null, '系统分组');
insert into uc_sec_dict_data values(12, 1,  '是',       'Y',       'sys_yes_no',          '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '系统默认是');
insert into uc_sec_dict_data values(13, 2,  '否',       'N',       'sys_yes_no',          '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '系统默认否');
insert into uc_sec_dict_data values(14, 1,  '通知',     '1',       'uc_sec_notice_type',     '',   'warning', 'Y', '0', 'admin', sysdate(), '', null, '通知');
insert into uc_sec_dict_data values(15, 2,  '公告',     '2',       'uc_sec_notice_type',     '',   'success', 'N', '0', 'admin', sysdate(), '', null, '公告');
insert into uc_sec_dict_data values(16, 1,  '正常',     '0',       'uc_sec_notice_status',   '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态');
insert into uc_sec_dict_data values(17, 2,  '关闭',     '1',       'uc_sec_notice_status',   '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '关闭状态');
insert into uc_sec_dict_data values(18, 99, '其他',     '0',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '其他操作');
insert into uc_sec_dict_data values(19, 1,  '新增',     '1',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '新增操作');
insert into uc_sec_dict_data values(20, 2,  '修改',     '2',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', sysdate(), '', null, '修改操作');
insert into uc_sec_dict_data values(21, 3,  '删除',     '3',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '删除操作');
insert into uc_sec_dict_data values(22, 4,  '授权',     '4',       'sys_oper_type',       '',   'primary', 'N', '0', 'admin', sysdate(), '', null, '授权操作');
insert into uc_sec_dict_data values(23, 5,  '导出',     '5',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, '导出操作');
insert into uc_sec_dict_data values(24, 6,  '导入',     '6',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, '导入操作');
insert into uc_sec_dict_data values(25, 7,  '强退',     '7',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '强退操作');
insert into uc_sec_dict_data values(26, 8,  '生成代码', '8',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', sysdate(), '', null, '生成操作');
insert into uc_sec_dict_data values(27, 9,  '清空数据', '9',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '清空操作');
insert into uc_sec_dict_data values(28, 1,  '成功',     '0',       'sys_common_status',   '',   'primary', 'N', '0', 'admin', sysdate(), '', null, '正常状态');
insert into uc_sec_dict_data values(29, 2,  '失败',     '1',       'sys_common_status',   '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '停用状态');


-- ----------------------------
-- 13、参数配置表
-- ----------------------------
drop table if exists uc_sec_config;
create table uc_sec_config (
  config_id         int(5)          not null auto_increment    comment '参数主键',
  config_name       varchar(100)    default ''                 comment '参数名称',
  config_key        varchar(100)    default ''                 comment '参数键名',
  config_value      varchar(500)    default ''                 comment '参数键值',
  config_type       char(1)         default 'N'                comment '系统内置（Y是 N否）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (config_id)
) engine=innodb auto_increment=100 comment = '参数配置表';

insert into uc_sec_config values(1, '主框架页-默认皮肤样式名称',     'sys.index.skinName',       'skin-blue',     'Y', 'admin', sysdate(), '', null, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow' );
insert into uc_sec_config values(2, '用户管理-账号初始密码',         'sys.user.initPassword',    '123456',        'Y', 'admin', sysdate(), '', null, '初始化密码 123456' );
insert into uc_sec_config values(3, '主框架页-侧边栏主题',           'sys.index.sideTheme',      'theme-dark',    'Y', 'admin', sysdate(), '', null, '深色主题theme-dark，浅色主题theme-light' );
insert into uc_sec_config values(4, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false',         'Y', 'admin', sysdate(), '', null, '是否开启注册用户功能（true开启，false关闭）');


-- ----------------------------
-- 14、系统访问记录
-- ----------------------------
drop table if exists uc_sec_logininfor;
create table uc_sec_logininfor (
  info_id        bigint(20)     not null auto_increment   comment '访问ID',
  user_name      varchar(50)    default ''                comment '用户账号',
  ipaddr         varchar(128)   default ''                comment '登录IP地址',
  status         char(1)        default '0'               comment '登录状态（0成功 1失败）',
  msg            varchar(255)   default ''                comment '提示信息',
  access_time    datetime                                 comment '访问时间',
  primary key (info_id)
) engine=innodb auto_increment=100 comment = '系统访问记录';


-- ----------------------------
-- 15、定时任务调度表
-- ----------------------------
drop table if exists uc_sec_job;
create table uc_sec_job (
  job_id              bigint(20)    not null auto_increment    comment '任务ID',
  job_name            varchar(64)   default ''                 comment '任务名称',
  job_group           varchar(64)   default 'DEFAULT'          comment '任务组名',
  invoke_target       varchar(500)  not null                   comment '调用目标字符串',
  cron_expression     varchar(255)  default ''                 comment 'cron执行表达式',
  misfire_policy      varchar(20)   default '3'                comment '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  concurrent          char(1)       default '1'                comment '是否并发执行（0允许 1禁止）',
  status              char(1)       default '0'                comment '状态（0正常 1暂停）',
  create_by           varchar(64)   default ''                 comment '创建者',
  create_time         datetime                                 comment '创建时间',
  update_by           varchar(64)   default ''                 comment '更新者',
  update_time         datetime                                 comment '更新时间',
  remark              varchar(500)  default ''                 comment '备注信息',
  primary key (job_id, job_name, job_group)
) engine=innodb auto_increment=100 comment = '定时任务调度表';

insert into uc_sec_job values(1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams',        '0/10 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null, '');
insert into uc_sec_job values(2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')',  '0/15 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null, '');
insert into uc_sec_job values(3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)',  '0/20 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 16、定时任务调度日志表
-- ----------------------------
drop table if exists uc_sec_job_log;
create table uc_sec_job_log (
  job_log_id          bigint(20)     not null auto_increment    comment '任务日志ID',
  job_name            varchar(64)    not null                   comment '任务名称',
  job_group           varchar(64)    not null                   comment '任务组名',
  invoke_target       varchar(500)   not null                   comment '调用目标字符串',
  job_message         varchar(500)                              comment '日志信息',
  status              char(1)        default '0'                comment '执行状态（0正常 1失败）',
  exception_info      varchar(2000)  default ''                 comment '异常信息',
  create_time         datetime                                  comment '创建时间',
  primary key (job_log_id)
) engine=innodb comment = '定时任务调度日志表';


-- ----------------------------
-- 17、通知公告表
-- ----------------------------
drop table if exists uc_sec_notice;
create table uc_sec_notice (
  notice_id         int(4)          not null auto_increment    comment '公告ID',
  notice_title      varchar(50)     not null                   comment '公告标题',
  notice_type       char(1)         not null                   comment '公告类型（1通知 2公告）',
  notice_content    longblob        default null               comment '公告内容',
  status            char(1)         default '0'                comment '公告状态（0正常 1关闭）',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time       datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(255)    default null               comment '备注',
  primary key (notice_id)
) engine=innodb auto_increment=10 comment = '通知公告表';

-- ----------------------------
-- 初始化-公告信息表数据
-- ----------------------------
insert into uc_sec_notice values('1', '温馨提醒：2018-07-01 TESTU新版本发布啦', '2', '新版本内容', '0', 'admin', sysdate(), '', null, '管理员');
insert into uc_sec_notice values('2', '维护通知：2018-07-01 TESTU系统凌晨维护', '1', '维护内容',   '0', 'admin', sysdate(), '', null, '管理员');


-- ----------------------------
-- 18、代码生成业务表
-- ----------------------------
drop table if exists gen_table;
create table gen_table (
  table_id          bigint(20)      not null auto_increment    comment '编号',
  table_name        varchar(200)    default ''                 comment '表名称',
  table_comment     varchar(500)    default ''                 comment '表描述',
  sub_table_name    varchar(64)     default null               comment '关联子表的表名',
  sub_table_fk_name varchar(64)     default null               comment '子表关联的外键名',
  class_name        varchar(100)    default ''                 comment '实体类名称',
  tpl_category      varchar(200)    default 'crud'             comment '使用的模板（crud单表操作 tree树表操作）',
  package_name      varchar(100)                               comment '生成包路径',
  module_name       varchar(30)                                comment '生成模块名',
  business_name     varchar(30)                                comment '生成业务名',
  function_name     varchar(50)                                comment '生成功能名',
  function_author   varchar(50)                                comment '生成功能作者',
  gen_type          char(1)         default '0'                comment '生成代码方式（0zip压缩包 1自定义路径）',
  gen_path          varchar(200)    default '/'                comment '生成路径（不填默认项目路径）',
  options           varchar(1000)                              comment '其它生成选项',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  remark            varchar(500)    default null               comment '备注',
  primary key (table_id)
) engine=innodb auto_increment=1 comment = '代码生成业务表';


-- ----------------------------
-- 19、代码生成业务表字段
-- ----------------------------
drop table if exists gen_table_column;
create table gen_table_column (
  column_id         bigint(20)      not null auto_increment    comment '编号',
  table_id          varchar(64)                                comment '归属表编号',
  column_name       varchar(200)                               comment '列名称',
  column_comment    varchar(500)                               comment '列描述',
  column_type       varchar(100)                               comment '列类型',
  java_type         varchar(500)                               comment 'JAVA类型',
  java_field        varchar(200)                               comment 'JAVA字段名',
  is_pk             char(1)                                    comment '是否主键（1是）',
  is_increment      char(1)                                    comment '是否自增（1是）',
  is_required       char(1)                                    comment '是否必填（1是）',
  is_insert         char(1)                                    comment '是否为插入字段（1是）',
  is_edit           char(1)                                    comment '是否编辑字段（1是）',
  is_list           char(1)                                    comment '是否列表字段（1是）',
  is_query          char(1)                                    comment '是否查询字段（1是）',
  query_type        varchar(200)    default 'EQ'               comment '查询方式（等于、不等于、大于、小于、范围）',
  html_type         varchar(200)                               comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  dict_type         varchar(200)    default ''                 comment '字典类型',
  sort              int                                        comment '排序',
  create_by         varchar(64)     default ''                 comment '创建者',
  create_time 	    datetime                                   comment '创建时间',
  update_by         varchar(64)     default ''                 comment '更新者',
  update_time       datetime                                   comment '更新时间',
  primary key (column_id)
) engine=innodb auto_increment=1 comment = '代码生成业务表字段';
