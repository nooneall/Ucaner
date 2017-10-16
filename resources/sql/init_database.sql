-- ----------------------------
-- Table structure for SYS_RESOURCE
-- ----------------------------
DROP TABLE IF EXISTS SYS_RESOURCE;
CREATE TABLE SYS_RESOURCE (
  ID varchar(32) NOT NULL DEFAULT '',
  NAME varchar(100) NOT NULL,
  TYPE varchar(40) NOT NULL,
  STATUS int(11) NOT NULL COMMENT '资源状态 1:正常 0:删除 2:禁用 默认为1',
  CODE varchar(50) NOT NULL DEFAULT '',
  VALUE varchar(255) DEFAULT NULL COMMENT '资源url',
  CLASS_NAME varchar(100) DEFAULT NULL COMMENT '对应的实体对象类',
  SORT int(11) DEFAULT NULL COMMENT '资源排序',
  OPERATION_TYPE int(11) DEFAULT NULL COMMENT '按钮显示方式 1 界面上端  2操作栏  3 两种都有 ',
  DATA_AUTHORITY_CODE varchar(500) DEFAULT NULL COMMENT '数据权限码',
  PARENT_ID varchar(32) DEFAULT '',
  REMARK varchar(500) DEFAULT NULL,
  CP varchar(32) DEFAULT NULL COMMENT '创建人',
  CP_NAME varchar(50) DEFAULT NULL COMMENT '创建人名称',
  CT datetime DEFAULT NULL COMMENT '创建时间',
  EP varchar(32) DEFAULT NULL COMMENT '修改人',
  EP_NAME varchar(50) DEFAULT NULL COMMENT '修改名称',
  ET datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SYS_RESOURCE
-- ----------------------------
INSERT INTO SYS_RESOURCE VALUES ('1', '系统管理', '1', '1', 'xtgl', '', null, null, null, null, '',  null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('10', '用户修改', '2', '1', 'yhxg', 'toEdit', null, '2', '2', null, '3', null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('11', '用户删除', '2', '1', 'yhsc', 'toDelete', null, '3', '2', null, '3', null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('12', '资源新增', '2', '1', 'zyxz', 'toAdd', null, '1', '2', null, '5', null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('13', '资源修改', '2', '1', 'zyxg', 'toEdit', null, '2', '2', null, '5', null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('14', '资源删除', '2', '1', 'zysc', 'toDelete', null, '3', '2', null, '5',  null, null, null, '2016-04-13 11:49:04', null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('25a1d8ccb77a4cc487ce37a259404424', '流程管理', '1', '1', 'lggl', '', '', null, null, '', '',  null, null, null, '2017-07-07 14:27:30', null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('3', '账号管理', '1', '1', 'zhgl', '/platform/user/list', '', null, '1', '', '1',  null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('4', '角色管理', '1', '1', 'jsgl', '/platform/role/list', null, null, '1', null, '1',  null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('5', '资源管理', '1', '1', 'zygl', '/platform/resource/list', null, null, '1', null, '1',  null, null, null, '2016-04-12 17:44:56', null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('6', '角色新增', '2', '1', 'jsxz', 'toAdd', null, '1', '2', null, '4',  null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('7', '角色修改', '2', '1', 'jsxg', 'toEdit', null, '2', '2', null, '4', null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('8', '角色删除', '2', '1', 'jssc', 'toDelete', null, '3', '2', null, '4',  null, null, null, '2016-04-13 10:29:10', null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('9', '用户新增', '2', '1', 'yhxz', 'toAdd', null, '1', '2', null, '3', null, null, null, null, null, null, null);
INSERT INTO SYS_RESOURCE VALUES ('e118748a4a194e7e9323ffba1f8f8a7a', '流程设计', '1', '1', 'lcsj', '', '', null, null, '', '25a1d8ccb77a4cc487ce37a259404424', null, null, null, '2017-07-07 14:28:08', null, null, null);

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE IF EXISTS SYS_ROLE;
CREATE TABLE SYS_ROLE (
  ID varchar(32) NOT NULL DEFAULT '',
  ROLE_NAME varchar(40) NOT NULL,
  ROLE_DESC varchar(500) DEFAULT '',
  STATUS int(11) NOT NULL COMMENT '角色状态 1:正常 0:删除 2:禁用 默认为1',
  ROLE_CODE varchar(50) NOT NULL DEFAULT '',
  CP varchar(32) DEFAULT NULL COMMENT '创建人',
  CP_NAME varchar(50) DEFAULT NULL COMMENT '创建人名称',
  CT datetime DEFAULT NULL COMMENT '创建时间',
  EP varchar(32) DEFAULT NULL COMMENT '修改人',
  EP_NAME varchar(50) DEFAULT NULL COMMENT '修改名称',
  ET datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO SYS_ROLE VALUES ('1', '系统管理员', null, '1', 'admin', null, null, '2016-04-11 09:33:12', null, null, null);
INSERT INTO SYS_ROLE VALUES ('2236156e0740453ebc68333b573f4e0c', 'test001', null, '1', 'test001', null, null, '2017-07-06 18:32:36', null, null, null);

-- ----------------------------
-- Table structure for SYS_ROLE_RESOURCE
-- ----------------------------
DROP TABLE IF EXISTS SYS_ROLE_RESOURCE;
CREATE TABLE SYS_ROLE_RESOURCE (
  ID varchar(32) NOT NULL,
  ROLE_ID varchar(32) NOT NULL,
  RESOURCE_ID varchar(32) NOT NULL,
  STATUS int(11) NOT NULL COMMENT '状态 1:正常 0:删除 2:禁用 默认为1',
  PRIMARY KEY (ID),
  KEY FK_PUB_ROLE_RE_AU (ROLE_ID) USING BTREE,
  KEY FK_PUB_ROLE_RE_RE (RESOURCE_ID) USING BTREE,
  CONSTRAINT FK_PUB_ROLE_RE_AU FOREIGN KEY (ROLE_ID) REFERENCES SYS_ROLE (ID),
  CONSTRAINT FK_PUB_ROLE_RE_RE FOREIGN KEY (RESOURCE_ID) REFERENCES SYS_RESOURCE (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SYS_ROLE_RESOURCE
-- ----------------------------
INSERT INTO SYS_ROLE_RESOURCE VALUES ('034038debc3a4bc5bc0bd453dffe888b', '1', '12', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('0d1d3d6859154afabe0f76a21a134b72', '1', '10', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('0da249d19cac45d5a8eb0aa4cfc3f815', '2236156e0740453ebc68333b573f4e0c', '6', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('0f82d0b41a0b479098f9e9ae9923f9dc', '1', '7', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('237e51e0dd884473a3bf28f16a08fd4e', '2236156e0740453ebc68333b573f4e0c', '5', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('23c24a759635477a9d63660f62d0c2f9', '1', '14', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('260d8a3058354ec69fdb43696d9dbe88', '1', '3', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('3ace5812de9344cf97659c4bc1f672f4', '1', '1', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('48054ee4bad34fb68e07b5730ca86fac', '1', '11', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('4c2c421b7e414dedb9873897e129cea4', '2236156e0740453ebc68333b573f4e0c', '10', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('634904d4c6084771831365984e5853f8', '1', 'e118748a4a194e7e9323ffba1f8f8a7a', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('645af9019e544ddca92d4f6cdb1bf2fa', '1', '13', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('687ff1e5da3f4088b12727ec46f0646a', '2236156e0740453ebc68333b573f4e0c', '1', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('8843bfc97f7141a1be8b539f339ea6e0', '2236156e0740453ebc68333b573f4e0c', '11', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('b7ae97c3cf2649da99d0466ab523f5fd', '2236156e0740453ebc68333b573f4e0c', '4', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('b80ea84ed46140838a00a6ac114513f5', '1', '4', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('b82fde89fac64695801143b6257f9594', '1', '25a1d8ccb77a4cc487ce37a259404424', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('b85921280f184e57a5bbf67a4b15f78c', '1', '9', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('d03d362e92a54bae8ad22e3cad0f02c8', '2236156e0740453ebc68333b573f4e0c', '14', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('d61415ea05934d12b0d2f51f7a3bf9bc', '1', '6', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('dade0118ccff49e5aae428747639218f', '1', '8', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('e35c83c09e754f41ab9991d6f5d80908', '2236156e0740453ebc68333b573f4e0c', '3', '1');
INSERT INTO SYS_ROLE_RESOURCE VALUES ('ed14ed17186f4b839b7a91dc926c812b', '1', '5', '1');

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE IF EXISTS SYS_USER;
CREATE TABLE SYS_USER (
  ID varchar(32) NOT NULL DEFAULT '',
  ACCOUNT varchar(40) NOT NULL,
  NAME varchar(50) NOT NULL COMMENT '药材名',
  PASSWORD varchar(100) NOT NULL,
  REMARK varchar(500) DEFAULT NULL,
  MOBILE varchar(20) DEFAULT NULL COMMENT '电话号码',
  ROLE_IDS varchar(250) DEFAULT NULL,
  DEPT_ID varchar(32) DEFAULT NULL COMMENT '所属部门ID',
  DEPT_NAME varchar(50) DEFAULT NULL COMMENT '所属部门名称',
  STATUS int(11) NOT NULL COMMENT '用户状态 1:正常 0:删除 2:禁用 默认为1',
  CP varchar(32) DEFAULT NULL COMMENT '创建人',
  CP_NAME varchar(50) DEFAULT NULL COMMENT '创建人名称',
  CT datetime DEFAULT NULL COMMENT '创建时间',
  EP varchar(32) DEFAULT NULL COMMENT '修改人',
  EP_NAME varchar(50) DEFAULT NULL COMMENT '修改名称',
  ET datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (ID),
  KEY INX_USER_ACCOUNT (ACCOUNT),
  KEY INX_USER_DEPT_ID (DEPT_ID),
  KEY INX_USER_DEPT_NAME (DEPT_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO SYS_USER VALUES ('0f8e490135d24975ad318b8e472d19df', 'yuce', '于策', '965eb72c92a549dd', null, '18026266968', '[\"2236156e0740453ebc68333b573f4e0c\"]',null,null, '1', null, null, '2017-07-06 10:59:01', null, null, '2017-07-06 18:33:10');
INSERT INTO SYS_USER VALUES ('11111', 'admin', '系统管理员', '49ba59abbe56e057', null, '13888887788', '[\"1\"]',null,null, '1', null, null, '2016-04-11 09:33:12', 'admin', 'admin', '2017-07-06 10:04:57');

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS SYS_USER_ROLE;
CREATE TABLE SYS_USER_ROLE (
  ID varchar(32) NOT NULL,
  USER_ID varchar(32) NOT NULL,
  ROLE_ID varchar(32) NOT NULL,
  STATUS int(11) NOT NULL COMMENT '状态 1:正常 0:删除 2:禁用 默认为1',
  PRIMARY KEY (ID),
  KEY FK_USERS_ROLES_ROLES (ROLE_ID),
  KEY FK_USERS_ROLES_USERS (USER_ID),
  CONSTRAINT FK_USERS_ROLES_ROLES FOREIGN KEY (ROLE_ID) REFERENCES SYS_ROLE (ID),
  CONSTRAINT FK_USERS_ROLES_USERS FOREIGN KEY (USER_ID) REFERENCES SYS_USER (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SYS_USER_ROLE
-- ----------------------------
INSERT INTO SYS_USER_ROLE VALUES ('a3c862c02c2e48b6a8f07bc825858295', '11111', '1', '1');
INSERT INTO SYS_USER_ROLE VALUES ('c007ba94ff454706a6e87937d036754a', '0f8e490135d24975ad318b8e472d19df', '2236156e0740453ebc68333b573f4e0c', '1');


CREATE TABLE SYS_DEPT (
  ID varchar(32) NOT NULL,
  NAME varchar(50) NOT NULL COMMENT '部门名称',
  CODE varchar(50) NOT NULL COMMENT '部门编码',
  REMARK varchar(1000) DEFAULT NULL COMMENT '备注',
  PARENT_ID varchar(32) DEFAULT NULL COMMENT '父部门ID',
  PARENT_NAME varchar(50) DEFAULT NULL COMMENT '父部门名称',
  SORT_NUM int(2) DEFAULT NULL COMMENT '部门排序号',
  PRIMARY KEY (ID),
  KEY INX_DEPT_NAME (NAME),
  KEY INX_DEPT_CODE (CODE),
  KEY INX_DEPT_PARENT_ID (PARENT_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织结构表';


set global log_bin_trust_function_creators=TRUE;

-- ----------------------------
-- Function structure for getChildList
-- ----------------------------
DROP FUNCTION IF EXISTS getResourceChildList;
CREATE FUNCTION getResourceChildList(rootId text) RETURNS text CHARSET utf8
BEGIN   
DECLARE str text;  
DECLARE cid varchar(2000);   
SET str = '';   
SET cid = rootId;   
WHILE cid is not null DO 
    IF str != '' and str != cid THEN
			SET str = concat(str, ',', cid);   
		ELSE
       IF cid != rootId THEN
           SET str = cid;
			 END IF;	
    END IF;  
    
    SELECT group_concat(id) INTO cid FROM SYS_RESOURCE where FIND_IN_SET(PARENT_ID, cid) > 0;   
END WHILE;   
RETURN str;   
END;


-- ----------------------------
-- Function structure for getParentList
-- ----------------------------
DROP FUNCTION IF EXISTS getResourceParentList;
CREATE FUNCTION getResourceParentList(rootId varchar(100)) RETURNS text CHARSET utf8
BEGIN   
DECLARE fid varchar(100) default '';   
DECLARE str text;
SET str = ''; 
WHILE rootId is not null  do   
    SET fid =(SELECT PARENT_ID FROM SYS_RESOURCE  WHERE id = rootId);   
    IF fid is not null THEN  
        IF str = '' THEN  
				    SET str = fid;
				ELSE
						IF fid != '' THEN
               SET str = concat(str, ',', fid); 
            END IF;
				END IF;
        SET rootId = fid;   
    ELSE   
        SET rootId = fid;   
    END IF;   
END WHILE;   
return str;  
END;
-- ----------------------------
-- Function structure for getChildList
-- ----------------------------
DROP FUNCTION IF EXISTS getDeptChildList;
CREATE FUNCTION getDeptChildList(rootId text) RETURNS text CHARSET utf8
BEGIN   
DECLARE str text;  
DECLARE cid varchar(2000);   
SET str = '';   
SET cid = rootId;   
WHILE cid is not null DO 
    IF str != '' and str != cid THEN
			SET str = concat(str, ',', cid);   
		ELSE
       IF cid != rootId THEN
           SET str = cid;
			 END IF;	
    END IF;  
    
    SELECT group_concat(id) INTO cid FROM SYS_DEPT where FIND_IN_SET(PARENT_ID, cid) > 0;   
END WHILE;   
RETURN str;   
END;


-- ----------------------------
-- Function structure for getParentList
-- ----------------------------
DROP FUNCTION IF EXISTS getDeptParentList;
CREATE FUNCTION getDeptParentList(rootId varchar(100)) RETURNS text CHARSET utf8
BEGIN   
DECLARE fid varchar(100) default '';   
DECLARE str text;
SET str = ''; 
WHILE rootId is not null  do   
    SET fid =(SELECT PARENT_ID FROM SYS_DEPT  WHERE id = rootId);   
    IF fid is not null THEN  
        IF str = '' THEN  
				    SET str = fid;
				ELSE
						IF fid != '' THEN
               SET str = concat(str, ',', fid); 
            END IF;
				END IF;
        SET rootId = fid;   
    ELSE   
        SET rootId = fid;   
    END IF;   
END WHILE;   
return str;  
END;