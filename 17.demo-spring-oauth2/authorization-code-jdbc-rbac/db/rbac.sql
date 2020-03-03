/*
rbac访问控制模型
*/

# permission
drop table if exists `sys_permission`;
create table `sys_permission`
(
    `id`          bigint       not null auto_increment comment '权限主键',
    `name`        varchar(255) not null default '' comment '权限名称',
    `creator`     bigint       not null default 0 comment '创建者',
    `updator`     bigint       not null default 0 comment '更新者',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `update_time` datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    `status`      int(2)       not null default 0 comment '状态标记',
    primary key (id)
) engine INNODB
  default charset = utf8mb4;

# user
drop table if EXISTS `sys_user`;
create table `sys_user`
(
    `id`           bigint       not null AUTO_INCREMENT COMMENT 'user_id',
    `username`     varchar(25)  not null default '' comment '账号',
    `password`     varchar(255) not null DEFAULT '' COMMENT '密码',
    `email`        varchar(255) not null default '' comment '邮箱',
    `phone_prefix` varchar(10)  not null DEFAULT '+86' comment '区号,默认中国',
    `phone`        varchar(32)  not null default '' comment '手机号',
    `creator`      bigint       not null default 0 comment '创建者',
    `updator`      bigint       not null default 0 comment '更新者',
    `create_time`  datetime     not null default CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time`  datetime     not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间,更新则修改',
    `status`       int(2)       not null default 0 comment '状态标记',
    PRIMARY KEY (`id`)
) ENGINE INNODB
  default CHARSET = utf8mb4;

# role
drop table if exists `sys_role`;
create table `sys_role`
(
    `id`          bigint   not null auto_increment comment '主键',
    `creator`     bigint   not null default 0 comment '创建者',
    `updator`     bigint   not null default 0 comment '更新者',
    `create_time` datetime not null default CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间,更新则修改',
    `status`      int(2)   not null default 0 comment '状态标记',
    PRIMARY KEY (`id`)
) engine INNODB
  default charset = utf8mb4;
# group
drop table if exists `sys_group`;
create table `sys_group`
(
    `id`          bigint       not null auto_increment comment '主键',
    `name`        varchar(255) not null default '' comment '组名',
    `parent_id`   bigint       not null default 1 comment '父级id',
    `level`       int          not null default '1' comment '层级',
    `master_id`   bigint       not null default 0 comment '管理者id',
    `creator`     bigint       not null default 0 comment '创建者',
    `updator`     bigint       not null default 0 comment '更新者',
    `create_time` datetime     not null default CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime     not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间,更新则修改',
    `status`      int(2)       not null default 0 comment '状态标记',
    PRIMARY KEY (`id`)
) engine INNODB
  default charset = utf8mb4;

#中间表 permission-role
drop table if exists `sys_permission_role`;
create table `sys_permission_role`
(
    `permission_id` bigint   not null default 0 comment '权限id',
    `role_id`       bigint   not null default 0 comment '角色id',
    `creator`       bigint   not null default 0 comment '创建者',
    `updator`       bigint   not null default 0 comment '更新者',
    `create_time`   datetime not null default CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time`   datetime not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间,更新则修改',
    `status`        int(2)   not null default 0 comment '状态标记',
    primary key (`permission_id`, `role_id`)
) engine INNODB
  default charset = utf8mb4;

#中间表 permission-group
drop table if exists `sys_permission_group`;
create table `sys_permission_group`
(
    `permission_id` bigint   not null default 0 comment '权限id',
    `group_id`      bigint   not null default 0 comment '组id',
    `creator`       bigint   not null default 0 comment '创建者',
    `updator`       bigint   not null default 0 comment '更新者',
    `create_time`   datetime not null default CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time`   datetime not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间,更新则修改',
    `status`        int(2)   not null default 0 comment '状态标记',
    primary key (permission_id, group_id)
) engine INNODB
  default charset = utf8mb4;

#中间表 user-role
drop table if exists `sys_user_role`;
create table `sys_user_role`
(
    `user_id`     bigint   not null default 0 comment '用户id',
    `role_id`     bigint   not null default 0 comment '角色id',
    `creator`     bigint   not null default 0 comment '创建者',
    `updator`     bigint   not null default 0 comment '更新者',
    `create_time` datetime not null default CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间,更新则修改',
    `status`      int(2)   not null default 0 comment '状态标记',
    primary key (`user_id`, `role_id`)
) engine INNODB
  default charset = utf8mb4;

#中间表 user-group
drop table if exists `sys_user_group`;
create table `sys_user_group`
(
    `user_id`     bigint   not null default 0 comment '用户id',
    `group_id`    bigint   not null default 0 comment '组id',
    `creator`     bigint   not null default 0 comment '创建者',
    `updator`     bigint   not null default 0 comment '更新者',
    `create_time` datetime not null default CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_time` datetime not null default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT '修改时间,更新则修改',
    `status`      int(2)   not null default 0 comment '状态标记',
    primary key (`user_id`, `group_id`)
) engine INNODB
  default charset = utf8mb4;
