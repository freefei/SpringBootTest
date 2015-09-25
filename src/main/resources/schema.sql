DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(50) NOT NULL COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;