-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.10 - MySQL Community Server (GPL)
-- 服务器操作系统:                      osx10.9
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 decision.Conclusion 结构
CREATE TABLE IF NOT EXISTS `Conclusion` (
  `cId` bigint(20) NOT NULL AUTO_INCREMENT,
  `ruleId` bigint(20) DEFAULT NULL,
  `label` varchar(50) DEFAULT NULL COMMENT '变量的显示名称',
  `variate` varchar(50) DEFAULT NULL COMMENT '变量',
  `value` varchar(50) DEFAULT NULL COMMENT '值或脚本',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`cId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='结论\r\n满足规则后的结论\r\n这里的动作是设置相关的变量\r\n';

-- 数据导出被取消选择。
-- 导出  表 decision.Factor 结构
CREATE TABLE IF NOT EXISTS `Factor` (
  `fid` bigint(20) NOT NULL AUTO_INCREMENT,
  `ruleId` bigint(20) DEFAULT NULL,
  `label` varchar(50) DEFAULT NULL COMMENT '变量的显示名',
  `variate` varchar(50) DEFAULT NULL COMMENT '变量',
  `boolExpression` varchar(500) DEFAULT NULL COMMENT '布尔表达式（java语法）',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='单个条件决策因素\r\n';

-- 数据导出被取消选择。
-- 导出  表 decision.Rule 结构
CREATE TABLE IF NOT EXISTS `Rule` (
  `ruleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `gid` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `exeOrder` smallint(6) DEFAULT NULL COMMENT '执行顺序',
  `descp` varchar(500) DEFAULT NULL COMMENT '描述',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ruleId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='规则定义表';

-- 数据导出被取消选择。
-- 导出  表 decision.RuleGroup 结构
CREATE TABLE IF NOT EXISTS `RuleGroup` (
  `gid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '规则组名称',
  `descp` varchar(500) DEFAULT NULL COMMENT '描述',
  `status` smallint(6) DEFAULT NULL COMMENT '状态\r\n            0--无效\r\n            1--有效\r\n            \r\n            ',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='规则组\r\n也可以理解为一个业务逻辑场景的所包含规则的定义\r\n';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
