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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='结论\r\n满足规则后的结论\r\n这里的动作是设置相关的变量\r\n';

-- 正在导出表  decision.Conclusion 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `Conclusion` DISABLE KEYS */;
INSERT INTO `Conclusion` (`cId`, `ruleId`, `label`, `variate`, `value`, `status`) VALUES
	(1, 1, '是否通过', 'passFlag', 'false', 1),
	(2, 2, '是否通过', 'passFlag', 'false', 1),
	(3, 3, '是否通过', 'passFlag', 'false', 1),
	(4, 4, '是否通过', 'passFlag', 'false', 1),
	(5, 5, '是否通过', 'passFlag', 'false', 1),
	(6, 6, '发放额度', 'ceiling', '15000', 1),
	(7, 7, '发放额度', 'ceiling', '6000', 1),
	(8, 8, '发放额度', 'ceiling', '3000', 1),
	(9, 9, '发放额度', 'ceiling', '5000', 1),
	(10, 10, '发放额度', 'ceiling', '5000', 1),
	(11, 11, '发放额度', 'ceiling', '8000', 1),
	(12, 12, '发放额度', 'ceiling', '8000', 1),
	(13, 13, '发放额度', 'ceiling', '9000', 1);
/*!40000 ALTER TABLE `Conclusion` ENABLE KEYS */;

-- 导出  表 decision.Factor 结构
CREATE TABLE IF NOT EXISTS `Factor` (
  `fid` bigint(20) NOT NULL AUTO_INCREMENT,
  `ruleId` bigint(20) DEFAULT NULL,
  `label` varchar(50) DEFAULT NULL COMMENT '变量的显示名',
  `variate` varchar(50) DEFAULT NULL COMMENT '变量',
  `boolExpression` varchar(500) DEFAULT NULL COMMENT '布尔表达式（java语法）',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='单个条件决策因素\r\n';

-- 正在导出表  decision.Factor 的数据：~46 rows (大约)
/*!40000 ALTER TABLE `Factor` DISABLE KEYS */;
INSERT INTO `Factor` (`fid`, `ruleId`, `label`, `variate`, `boolExpression`, `status`) VALUES
	(1, 1, '学历', 'xieli', '(xieli<2)', 1),
	(2, 1, '薪水', 'xinshui', '(xinshui<5000)', 1),
	(3, 1, '车子', 'chezi', '(chezi==0)', 1),
	(4, 1, '房子', 'fangzi', '(fangzi==0)', 1),
	(5, 1, '信用卡数量', 'xinyonka', '(xinyonka==0)', 1),
	(6, 2, '学历', 'xieli', '(xieli==2)', 1),
	(7, 2, '薪水', 'xinshui', '(xinshui<3000)', 0),
	(8, 2, '车子', 'chezi', '(chezi==0)', 1),
	(9, 2, '房子', 'fangzi', '(fangzi==0)', 1),
	(10, 2, '信用卡数量', 'xinyonka', '(xinyonka==0)', 1),
	(11, 3, '学历', 'xieli', '(xieli==3)', 1),
	(12, 3, '薪水', 'xinshui', '(xinshui<3000)', 1),
	(13, 3, '车子', 'chezi', '(chezi==0)', 1),
	(14, 3, '房子', 'fangzi', '(fangzi==0)', 1),
	(15, 3, '信用卡数量', 'xinyonka', '(xinyonka==0)', 1),
	(16, 4, '学历', 'xieli', '(xieli>3)', 1),
	(17, 4, '薪水', 'xinshui', '(xinshui<2000)', 1),
	(18, 4, '车子', 'chezi', '(chezi==0)', 1),
	(19, 4, '房子', 'fangzi', '(fangzi==0)', 1),
	(20, 4, '信用卡数量', 'xinyonka', '(xinyonka==0)', 1),
	(21, 5, '学历', 'xieli', '/', 0),
	(22, 5, '薪水', 'xinshui', '/', 0),
	(23, 5, '车子', 'chezi', '/', 0),
	(24, 5, '房子', 'fangzi', '/', 0),
	(25, 5, '信用卡数量', 'xinyonka', '(xinyonka>10)', 1),
	(26, 6, '薪水', 'xinshui', '(xinshui>20000)', 1),
	(27, 6, '车子', 'chezi', '(chezi>=1)', 1),
	(28, 6, '房子', 'fangzi', '(fangzi>=1)', 1),
	(29, 7, '薪水', 'xinshui', '(xinshui>=10000 && xinshui<=20000)', 1),
	(30, 7, '车子', 'chezi', '(chezi==0)', 1),
	(31, 7, '房子', 'fangzi', '(fangzi==0)', 1),
	(32, 8, '薪水', 'xinshui', '(xinshui<10000)', 1),
	(33, 8, '车子', 'chezi', '(chezi==0)', 1),
	(34, 8, '房子', 'fangzi', '(fangzi==0)', 1),
	(35, 9, '薪水', 'xinshui', '(xinshui<10000)', 1),
	(36, 9, '车子', 'chezi', '(chezi==0)', 1),
	(37, 9, '房子', 'fangzi', '(fangzi>=1)', 1),
	(38, 10, '薪水', 'xinshui', '(xinshui<10000)', 1),
	(39, 10, '车子', 'chezi', '(chezi>=1)', 1),
	(40, 10, '房子', 'fangzi', '(fangzi==0)', 1),
	(41, 11, '薪水', 'xinshui', '(xinshui>=10000 && xinshui<=20000)', 1),
	(42, 11, '车子', 'chezi', '(chezi==0)', 1),
	(43, 11, '房子', 'fangzi', '(fangzi>=1)', 1),
	(44, 12, '薪水', 'xinshui', '(xinshui>=10000 && xinshui<=20000)', 1),
	(45, 12, '车子', 'chezi', '(chezi>=1)', 1),
	(46, 12, '房子', 'fangzi', '(fangzi==0)', 1),
	(47, 13, '薪水', 'xinshui', '(xinshui>=10000 && xinshui<=20000)', 1),
	(48, 13, '车子', 'chezi', '(chezi>=1)', 1),
	(49, 13, '房子', 'fangzi', '(fangzi>=1)', 1);
/*!40000 ALTER TABLE `Factor` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='规则定义表';

-- 正在导出表  decision.Rule 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `Rule` DISABLE KEYS */;
INSERT INTO `Rule` (`ruleId`, `gid`, `name`, `exeOrder`, `descp`, `status`, `createTime`) VALUES
	(1, 1, 'rule1', 1, '针对低学历的', 1, '2017-01-18 12:15:05'),
	(2, 1, 'rule2', 2, '针对大专学历的', 1, '2017-01-18 12:15:05'),
	(3, 1, 'rule3', 3, '针对本科学历的', 1, '2017-01-18 12:15:05'),
	(4, 1, 'rule4', 4, '针对高学历的', 1, '2017-01-18 12:15:05'),
	(5, 1, 'rule5', 5, '针对已有信用卡用户', 1, '2017-01-18 12:15:05'),
	(6, 2, 'rule1', 1, '针对高收入人群', 1, '2017-01-18 16:49:56'),
	(7, 2, 'rule2', 2, '针对中等收入人群', 1, '2017-01-18 12:15:40'),
	(8, 2, 'rule3', 3, '针对低收入人群', 1, '2017-01-18 12:15:40'),
	(9, 2, 'rule4', 4, '针对有房人群', 1, '2017-01-18 12:15:40'),
	(10, 2, 'rule5', 5, '针对有车人群', 1, '2017-01-18 12:15:40'),
	(11, 2, 'rule6', 6, '针对有房中等收入人群', 1, '2017-01-18 12:15:40'),
	(12, 2, 'rule7', 7, '针对有车中等收入人群', 1, '2017-01-18 12:15:40'),
	(13, 2, 'rule8', 8, '针对有房有车的中等收入人群', 1, '2017-01-18 16:04:12');
/*!40000 ALTER TABLE `Rule` ENABLE KEYS */;

-- 导出  表 decision.RuleGroup 结构
CREATE TABLE IF NOT EXISTS `RuleGroup` (
  `gid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '规则组名称',
  `descp` varchar(500) DEFAULT NULL COMMENT '描述',
  `status` smallint(6) DEFAULT NULL COMMENT '状态\r\n            0--无效\r\n            1--有效\r\n            \r\n            ',
  `catalog` smallint(6) DEFAULT NULL COMMENT '目录，分类，例如：某一类规则组归到企业画像的目录下',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='规则组\r\n也可以理解为一个业务逻辑场景的所包含规则的定义\r\n';

-- 正在导出表  decision.RuleGroup 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `RuleGroup` DISABLE KEYS */;
INSERT INTO `RuleGroup` (`gid`, `name`, `descp`, `status`, `catalog`, `createTime`) VALUES
	(1, '用户合法性校验', '用户申请信用卡合法性检测，适配规则的则为不通过', 1, NULL, '2017-01-18 12:15:05'),
	(2, '用户信用卡发放规则', '通过的用户发放的信用额度', 1, NULL, '2017-01-18 12:15:40');
/*!40000 ALTER TABLE `RuleGroup` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
