-- Active: 1699267571361@@127.0.0.1@3306@batch_task

CREATE TABLE
    `BT_TASK`(
        `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
        `name` VARCHAR(64),
        `status` VARCHAR(32),
        `version` INT,
        `owner` VARCHAR(64),
        `expire_time` DATETIME COMMENT 'Expire Time',
        `create_time` DATETIME COMMENT 'Create Time',
        INDEX `bt_task_owner_index` (`owner`),
        INDEX `bt_task_expire_time_index` (`expire_time`)
    ) engine = innodb DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_bin COMMENT '批量任务';

-- 批量进度总表

CREATE TABLE
    `BT_BATCH`(
        `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
        `type` VARCHAR(32),
        `name` VARCHAR(64),
        `status` VARCHAR(32),
        `create_time` DATETIME COMMENT 'Create Time',
    ) engine = innodb DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_bin COMMENT '批量进度';

-- 批量进度详情

CREATE TABLE
    `BT_BATCH_PART` (
        `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
        `task_id` INT NOT NULL COMMENT 'Task Id',
        `batch_id` INT NOT NULL COMMENT 'Batch Id',
        `status` VARCHAR(32),
        `create_time` DATETIME COMMENT 'Create Time',
    ) engine = innodb DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_bin COMMENT '批量进度详情';

-- 任务信息表

CREATE TABLE
    `BT_BATCH_TASK_MESSAGE` (
        `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
        `part_id` INT NOT NULL COMMENT 'Part Id',
        `message` VARCHAR(1024),
        `create_time` DATETIME COMMENT 'Create Time',
    ) engine = innodb DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_bin COMMENT '任务信息表';