/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : pcb

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2013-12-27 17:47:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_sh_bg_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_sh_bg_userinfo`;
CREATE TABLE `t_sh_bg_userinfo` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键(用户编号)',
  `username` varchar(30) collate utf8_unicode_ci default NULL COMMENT '用户姓名',
  `umobile` varchar(30) collate utf8_unicode_ci default NULL COMMENT '手机号码',
  `shopids` varchar(300) collate utf8_unicode_ci default NULL COMMENT '用户所属门店编号(多个门店用半角逗号分隔)',
  `shopnames` varchar(500) collate utf8_unicode_ci default NULL COMMENT '用户所属门店名称(多个门店用半角逗号分隔)',
  `userpic` varchar(100) collate utf8_unicode_ci default NULL COMMENT '用户图像',
  `uemail` varchar(50) collate utf8_unicode_ci default NULL COMMENT '邮箱',
  `utel` varchar(30) collate utf8_unicode_ci default NULL COMMENT '联系电话',
  `regdate` datetime default NULL COMMENT '注册时间',
  `isbdmobile` char(1) collate utf8_unicode_ci default '0' COMMENT '是否已绑定手机号码(1是0否)',
  `isbdemail` char(1) collate utf8_unicode_ci default '0' COMMENT '是否验证邮箱(1是0否)',
  `ustatus` char(1) collate utf8_unicode_ci default NULL COMMENT '状态(1冻结2激活3锁定4废弃关闭5正常)',
  `actdate` datetime default NULL COMMENT '激活时间',
  `closedate` datetime default NULL COMMENT '锁定/关闭时间',
  `optuserid` int(11) default NULL COMMENT '操作人编号',
  `optusername` varchar(30) collate utf8_unicode_ci default NULL COMMENT '操作人姓名',
  `optdate` datetime default NULL COMMENT '操作时间',
  `realname` varchar(30) collate utf8_unicode_ci default NULL COMMENT '用户真实姓名',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5267 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商户信息表';

-- ----------------------------
-- Records of t_sh_bg_userinfo
-- ----------------------------
INSERT INTO `t_sh_bg_userinfo` VALUES ('1', '13692278566', '13692278566', '10000', '老北方饺子馆(南园路店)', null, null, '13692278565', '2013-09-17 17:28:17', '1', '0', '2', '2013-11-08 16:48:05', null, null, null, '2013-09-17 17:28:17', null);

-- ----------------------------
-- Table structure for `t_sh_bg_userlogin`
-- ----------------------------
DROP TABLE IF EXISTS `t_sh_bg_userlogin`;
CREATE TABLE `t_sh_bg_userlogin` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键',
  `userid` int(11) default NULL COMMENT '用户编码',
  `username` varchar(30) collate utf8_unicode_ci default NULL COMMENT '用户名',
  `upassword` varchar(50) character set utf8 default NULL COMMENT '用户密码',
  `pwlevel` char(1) character set utf8 default NULL COMMENT '密码安全级别( 1弱2中3强)',
  `shopids` varchar(300) collate utf8_unicode_ci default NULL COMMENT '用户所属门店编号(多个门店用半角逗号分隔)',
  `shopnames` varchar(500) collate utf8_unicode_ci default NULL COMMENT '用户所属门店名称(多个门店用半角逗号分隔)',
  `email` varchar(50) character set utf8 default NULL COMMENT '用户登录邮箱',
  `umobile` varchar(30) character set utf8 default NULL COMMENT '用户登录手机号码',
  `utype` char(1) character set utf8 default '1' COMMENT '用户类别(1普通用户2付费用户3VIP4其他)',
  `ustatus` char(1) character set utf8 default '1' COMMENT '状态(1冻结2激活3锁定4废弃关闭5正常)',
  `ismajor` char(1) collate utf8_unicode_ci default '0' COMMENT '是否主帐号(1是0否)',
  `majorid` int(11) default NULL COMMENT '主帐号编号',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='商户登录表';

-- ----------------------------
-- Records of t_sh_bg_userlogin
-- ----------------------------
INSERT INTO `t_sh_bg_userlogin` VALUES ('1', '1', '13692278566', '59F2443A4317918CE29AD28A14E1BDB7', '1', '10000', '老北方饺子馆(南园路店)', null, '13692278566', '1', '2', '1', '5255');

-- ----------------------------
-- Table structure for `t_wx_sys_mobilecheck`
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_sys_mobilecheck`;
CREATE TABLE `t_wx_sys_mobilecheck` (
  `id` int(11) NOT NULL auto_increment COMMENT '主键',
  `userid` int(11) default NULL COMMENT '用户编号',
  `mobileno` varchar(20) collate utf8_unicode_ci default NULL COMMENT '手机号码',
  `checkno` varchar(20) collate utf8_unicode_ci default NULL COMMENT '验证码',
  `senddate` datetime default NULL COMMENT '发送时间',
  `step` int(11) default NULL COMMENT '失效间隔时长(分)',
  `lostdate` datetime default NULL COMMENT '失效时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=234 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='手机验证码记录';

-- ----------------------------
-- Records of t_wx_sys_mobilecheck
-- ----------------------------
