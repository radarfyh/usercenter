-- ----------------------------
-- init
-- ----------------------------
set character set utf8;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- DATABASE user_center
-- ----------------------------

--drop database IF EXISTS user_center;
--create database user_center;

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
