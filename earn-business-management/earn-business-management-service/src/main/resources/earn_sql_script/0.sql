#奖池表
CREATE TABLE `pool` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `pool_id` bigint(20) NOT NULL COMMENT '奖池编号(期数)',
  `init_integration` int(8) DEFAULT NULL COMMENT '初始奖励积分',
  `init_participate_integration` int(8) DEFAULT NULL COMMENT '初始参与挑战积分',
  `integration_max` int(8) DEFAULT NULL COMMENT '奖池累积上线',
  `integration_min` int(8) DEFAULT NULL COMMENT '奖池累积下限',
  `plan_rate` int(4) DEFAULT NULL COMMENT '计划成功率',
  `current_rate` int(4) DEFAULT 0 COMMENT '当前成功率',
  `current_integration` int(8) DEFAULT NULL COMMENT '当前累积积分',
  `current_participate_integration` int(8) DEFAULT NULL COMMENT '当前挑战所需积分',
  `participant_num` int(4) DEFAULT 0 COMMENT '参与人数',
  `participation_times` int(4) DEFAULT 0 COMMENT '参与次数',
  `winner_num` int(4) DEFAULT 0 COMMENT '成功人数',
  `success_times` int(4) DEFAULT 0 COMMENT '成功次数',
  `plan_period` int(4) DEFAULT 0 COMMENT '计划持续时长',
  `plan_end_time` timestamp DEFAULT NULL COMMENT '计划结束时间',
  `actually_period` int(4) DEFAULT 0 COMMENT '实际持续时长',
  `actually_end_time` timestamp DEFAULT NULL COMMENT '实际结束时间',
  `award_integration` int(8) DEFAULT NULL COMMENT '奖励积分',
  `profit_integration` int(8) DEFAULT NULL COMMENT '利润',
  `is_earn` tinyint(1) DEFAULT NULL COMMENT '是否盈利',
  `need_meddle` tinyint(1) DEFAULT NULL COMMENT '是否需要干预',
  `status` varchar(1) DEFAULT NULL COMMENT '状态 C:新建;O:进行中;L:锁定;D:完成',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_pool_id` (`pool_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='奖池表(POOL)';

# 题库表
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `question_id` bigint(20) NOT NULL COMMENT '题目编号',
  `content` varchar(256) DEFAULT NULL COMMENT '题目内容',
  `options` varchar(256) DEFAULT NULL COMMENT '题目选项',
  `answer` varchar(256) DEFAULT NULL COMMENT '答案',
  `parsing` varchar(256) DEFAULT NULL COMMENT '答案解析',
  `topic_id` bigint(20) DEFAULT NULL COMMENT '话题编号',
  `type` int(1) DEFAULT NULL COMMENT '题目类型',
  `difficulty` int(4) DEFAULT NULL COMMENT '题目难度值',
  `current_rate` int(4) DEFAULT NULL COMMENT '答对率 0：选择题；1：判断题；2：问答题',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_question_id` (`question_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='题库表(QUESTION)';

# 题目话题表
CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `topic_id` bigint(20) NOT NULL COMMENT '话题编号',
  `name` varchar(32) DEFAULT NULL COMMENT '话题名称',
  `description` varchar(256) DEFAULT NULL COMMENT '话题描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_topic_id` (`topic_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='题目话题表(TOPIC)';

# 用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `nick_name` varchar(32) NOT NULL COMMENT '昵称',
  `telphone` varchar(32) NOT NULL COMMENT '手机号码',
  `wechat` varchar(32) DEFAULT NULL COMMENT '微信号',
  `qq` varchar(32) DEFAULT NULL COMMENT 'qq号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `sign_saying` varchar(128) DEFAULT NULL COMMENT '个人签名',
  `head_sculpture_image_url` varchar(64) DEFAULT NULL COMMENT '头像图片路径',
  `plan_rate` int(4) DEFAULT NULL COMMENT '计划挑战成功概率',
  `current_rate` int(4) DEFAULT NULL COMMENT '当前概率',
  `good_at` bigint(20) DEFAULT NULL COMMENT '擅长话题编号',
  `interest_in` bigint(20) DEFAULT NULL COMMENT '兴趣话题编号',
  `can_invite` tinyint(1) DEFAULT NULL COMMENT '是否有权邀请',
  `invite_code` varchar(32) DEFAULT NULL COMMENT '邀请码',
  `invite_friend_num_limit` int(4) DEFAULT NULL COMMENT '邀请朋友数量限制',
  `invited_friend_num` int(4) DEFAULT NULL COMMENT '邀请朋友数量',
  `is_invited` tinyint(1) DEFAULT NULL COMMENT '是否受邀而来',
  `invitor_user_id` bigint(20) DEFAULT NULL COMMENT '介绍人编号',
  `is_robot` tinyint(1) DEFAULT NULL COMMENT '是否机器人',
  `integration` int(8) DEFAULT NULL COMMENT '积分余额',
  `last_withdraw` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '上次提现时间',
  `can_withdraw` tinyint(1) DEFAULT NULL COMMENT '是否有权提现',
  `withdraw` decimal(9,2) DEFAULT NULL COMMENT '提现总金额',
  `gain` int(8) DEFAULT NULL COMMENT '积分盈利',
  `last_week_gain` int(8) DEFAULT NULL COMMENT '上周盈利',
  `charge` decimal(9,2) DEFAULT NULL COMMENT '充值总金额',
  `last_login_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
  `rank` int(1) DEFAULT NULL COMMENT '等级 1：最高级；2：次之；3：次次之',
  `challenge_num` int(4) DEFAULT NULL COMMENT '挑战次数',
  `success_num` int(4) DEFAULT NULL COMMENT '挑战成功次数',
  `status` varchar(1) DEFAULT NULL COMMENT '状态 F:冻结;A:活跃;C:不活跃',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='奖池表(USER)';

# 用户充值记录表
CREATE TABLE `charge_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `charge_record_id` bigint(20) NOT NULL COMMENT '充值记录编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `balance` decimal(9,2) DEFAULT NULL COMMENT '充值金额',
  `channel` varchar(1) DEFAULT NULL COMMENT '充值渠道 A:支付宝；W:微信支付',
  `get_integration` int(8) DEFAULT NULL COMMENT '获取积分数量',
  `before_charge_integration` int(8) DEFAULT NULL COMMENT '充值前积分余额',
  `after_charge_integration` int(8) DEFAULT NULL COMMENT '充值后积分余额',
  `status` varchar(1) DEFAULT NULL COMMENT '状态 S:支付成功 F:支付失败',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_charge_record_id` (`charge_record_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='充值记录表(CHARGE_RECORD)';

# 用户提现记录
CREATE TABLE `withdraw_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `withdraw_record_id` bigint(20) NOT NULL COMMENT '充值记录编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `balance` decimal(9,2) DEFAULT NULL COMMENT '充值金额',
  `channel` varchar(1) DEFAULT NULL COMMENT '充值渠道 A:支付宝；W:微信支付',
  `consume_integration` int(8) DEFAULT NULL COMMENT '获取积分数量',
  `before_withdraw_integration` int(8) DEFAULT NULL COMMENT '充值前积分余额',
  `after_withdraw_integration` int(8) DEFAULT NULL COMMENT '充值后积分余额',
  `status` varchar(1) DEFAULT NULL COMMENT '状态 S:提现成功 F:提现失败',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_withdraw_record_id` (`withdraw_record_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='提现记录表(WITHDRAW_RECORD)';

# 用户参与奖池记录表
CREATE TABLE `user_pool_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `user_pool_record_id` bigint(20) NOT NULL COMMENT '挑战记录编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `pool_id` bigint(20) DEFAULT NULL COMMENT '奖池编号',
  `user_nick_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `right_num` int(4) DEFAULT NULL COMMENT '答对题数',
  `result` tinyint(1) DEFAULT NULL COMMENT '挑战结果 0：挑战失败；1：挑战成功',
  `status` varchar(1) DEFAULT NULL COMMENT '记录状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_pool_record_id` (`user_pool_record_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='奖池参与记录表(USER_POOL_RECORD)';

# 挑战成功记录排名表
CREATE TABLE `pool_record_chart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `pool_record_chart_id` bigint(20) NOT NULL COMMENT '挑战成功排名编号',
  `user_pool_record_id` bigint(20) DEFAULT NULL COMMENT '挑战记录编号',
  `pool_id` bigint(20) DEFAULT NULL COMMENT '奖池编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `user_nick_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `right_num` int(4) DEFAULT NULL COMMENT '答对题数',
  `grade` int(8) DEFAULT NULL COMMENT '得分',
  `position` int(4) DEFAULT NULL COMMENT '排名',
  `award_level` int(1) DEFAULT NULL COMMENT '奖励等级',
  `award_integration` int(8) DEFAULT NULL COMMENT '奖励积分',
  `status` varchar(1) DEFAULT NULL COMMENT '排名状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_pool_record_chart_id` (`pool_record_chart_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='挑战成功记录排名表(POOL_RECORD_CHART)';

# 成功挑战者收益排名表
CREATE TABLE `participant_pool_chart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `participant_pool_chart_id` bigint(20) NOT NULL COMMENT '记录排名编号',
  `user_pool_record_id` bigint(20) DEFAULT NULL COMMENT '挑战记录编号',
  `pool_id` bigint(20) DEFAULT NULL COMMENT '奖池编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `user_nick_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `participate_times` int(4) DEFAULT NULL COMMENT '参与次数',
  `success_times` int(4) DEFAULT NULL COMMENT '成功次数',
  `earnings` int(8) DEFAULT NULL COMMENT '收益',
  `position` int(4) DEFAULT NULL COMMENT '排名',
  `status` varchar(1) DEFAULT NULL COMMENT '排名状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_participant_pool_chart_id` (`participant_pool_chart_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='挑战者收益排名表(PARTICIPANT_POOL_CHART)';

# 用户答题记录表
CREATE TABLE `answer_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `answer_record_id` bigint(20) NOT NULL COMMENT '记录排名编号',
  `user_pool_record_id` bigint(20) DEFAULT NULL COMMENT '挑战记录编号',
  `pool_id` bigint(20) DEFAULT NULL COMMENT '奖池编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `question_id` bigint(20) DEFAULT NULL COMMENT '用户昵称',
  `answer` varchar(256) DEFAULT NULL COMMENT '答案',
  `result` tinyint(1) DEFAULT NULL COMMENT '回答结果',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_answer_record_id` (`answer_record_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='答题记录表(ANSWER_RECORD)';

# 邀请码表
CREATE TABLE `invite_number` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `invite_number_id` bigint(20) NOT NULL COMMENT '邀请码编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `number` varchar(16) DEFAULT NULL COMMENT '邀请码',
  `invite_friend_num_limit` int(4) DEFAULT NULL COMMENT '邀请人数限制',
  `invited_friend_num` int(4) DEFAULT NULL COMMENT '已邀请人数',
  `status` varchar(1) DEFAULT NULL COMMENT '状态 F:冻结禁用；A:活跃',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_invite_number_id` (`invite_number_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='邀请码表(invite_number)';

# 系统参数表
CREATE TABLE `sys_parameter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库编号',
  `withdraw_exchange_rate` int(4) DEFAULT NULL COMMENT '提现汇率',
  `charge_exchange_rate` int(4) DEFAULT NULL COMMENT '充值汇率',
  `pool_init_integration` int(8) DEFAULT NULL COMMENT '初始奖励积分（成本）',
  `pool_init_participate_integration` int(8) DEFAULT NULL COMMENT '初始参与所需积分',
  `pool_plan_rate` int(4) DEFAULT NULL COMMENT '奖池计划挑战成功率',
  `pool_integration_max` int(8) DEFAULT NULL COMMENT '奖池累积的积分上限',
  `pool_integration_min` int(8) DEFAULT NULL COMMENT '奖池累积的积分下限',
  `pool_need_meddle` tinyint(1) DEFAULT NULL COMMENT '是否干预',
  `user_plan_rate` int(4) DEFAULT NULL COMMENT '用户挑战成功率',
  `user_can_invite` tinyint(1) DEFAULT NULL COMMENT '是否开通邀请功能',
  `user_num_limit` int(4) DEFAULT NULL COMMENT '总用户人数限制',
  `invite_friend_num_limit` int(4) DEFAULT NULL COMMENT '邀请人数限制',
  `app_version` int(4) DEFAULT NULL COMMENT '系统版本号',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT 'SYS' COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `update_by` varchar(32) DEFAULT 'SYS' COMMENT '最后更新人',
  `ver` int(8) DEFAULT '0' COMMENT '版本号',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标志(0:正常,1:已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统参数表(SYS_PARAMETER)';


