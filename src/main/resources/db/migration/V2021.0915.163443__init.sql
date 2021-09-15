CREATE TABLE `user` (
    `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(64) DEFAULT NULL COMMENT '用户名称',
    `iam` enum('teacher','student') NOT NULL DEFAULT 'student' COMMENT '我是',
    `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
    `created_at` bigint unsigned NOT NULL,
    `updated_at` bigint unsigned NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci COMMENT='用户';