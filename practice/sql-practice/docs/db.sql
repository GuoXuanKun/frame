drop database if exists blue;
create database blue charset utf8mb4;
use blue;

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address_book
-- ----------------------------
DROP TABLE IF EXISTS `address_book`;
CREATE TABLE `address_book`
(
    `id`            varchar(32)  NOT NULL DEFAULT '' COMMENT '主键',
    `user_id`       varchar(32)  NOT NULL DEFAULT '' COMMENT '用户id',
    `consignee`     varchar(50)  NOT NULL DEFAULT '' COMMENT '收货人',
    `gender`        tinyint(4)   NOT NULL DEFAULT 2 COMMENT '性别 0-女 1-男 2-保密',
    `phone`         varchar(11)  NOT NULL DEFAULT '' COMMENT '手机号',
    `province_code` varchar(12)  NOT NULL DEFAULT '' COMMENT '省级区划编号',
    `province_name` varchar(32)  NOT NULL DEFAULT '' COMMENT '省级名称',
    `city_code`     varchar(12)  NOT NULL DEFAULT '' COMMENT '市级区划编号',
    `city_name`     varchar(32)  NOT NULL DEFAULT '' COMMENT '市级名称',
    `district_code` varchar(12)  NOT NULL DEFAULT '' COMMENT '区级区划编号',
    `district_name` varchar(32)  NOT NULL DEFAULT '' COMMENT '区级名称',
    `detail`        varchar(200) NOT NULL DEFAULT '' COMMENT '详细地址',
    `label`         varchar(100) NOT NULL DEFAULT '' COMMENT '标签',
    `is_default`    tinyint(1)   NOT NULL DEFAULT '0' COMMENT '默认 0 否 1是',
    `create_time`   datetime     NOT NULL COMMENT '创建时间',
    `update_time`   datetime     NOT NULL COMMENT '更新时间',
    `create_user`   bigint(20)   NOT NULL COMMENT '创建人',
    `update_user`   bigint(20)   NOT NULL COMMENT '修改人',
    `is_deleted`    int(1)       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) COMMENT ='地址管理';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`          varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
    `type`        int(1)      NOT NULL DEFAULT 1 COMMENT '类型   1 商品分类 2 套餐分类',
    `name`        varchar(64) NOT NULL COMMENT '分类名称',
    `sort`        int(11)     NOT NULL DEFAULT 1 COMMENT '顺序',
    `create_time` datetime    NOT NULL COMMENT '创建时间',
    `update_time` datetime    NOT NULL COMMENT '更新时间',
    `create_user` varchar(32) NOT NULL COMMENT '创建人',
    `update_user` varchar(32) NOT NULL COMMENT '修改人',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_category_name` (`name`)
) COMMENT ='商品及套餐分类';


-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `id`          varchar(32)    NOT NULL DEFAULT '' COMMENT '主键',
    `name`        varchar(64)    NOT NULL DEFAULT '' COMMENT '名称',
    `category_id` varchar(32)    NOT NULL DEFAULT '' COMMENT '分类id',
    `price`       decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
    `code`        varchar(64)    NOT NULL DEFAULT '' COMMENT '商品码',
    `image`       varchar(200)   NOT NULL DEFAULT '' COMMENT '图片',
    `description` varchar(400)   NOT NULL DEFAULT '' DEFAULT '' COMMENT '描述信息',
    `status`      int(1)         NOT NULL DEFAULT '1' DEFAULT 1 COMMENT '0 停售 1 起售',
    `sort`        int(11)        NOT NULL DEFAULT '0' DEFAULT 0 COMMENT '顺序',
    `create_user` varchar(32)    NOT NULL DEFAULT '' COMMENT '创建人',
    `update_user` varchar(32)    NOT NULL DEFAULT '' COMMENT '修改人',
    `create_time` datetime       NOT NULL COMMENT '创建时间',
    `update_time` datetime       NOT NULL COMMENT '更新时间',
    `is_deleted`  int(11)        NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_goods_name` (`name`)
) COMMENT ='商品管理';


-- ----------------------------
-- Table structure for goods_flavor
-- ----------------------------
DROP TABLE IF EXISTS `goods_flavor`;
CREATE TABLE `goods_flavor`
(
    `id`          varchar(32)  NOT NULL DEFAULT '' COMMENT '主键',
    `goods_id`    varchar(32)  NOT NULL DEFAULT '' COMMENT '商品',
    `name`        varchar(64)  NOT NULL DEFAULT '' COMMENT '口味名称',
    `value`       varchar(500) NOT NULL DEFAULT '' COMMENT '口味数据list',
    `create_time` datetime              DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime              DEFAULT NULL COMMENT '更新时间',
    `create_user` varchar(32)  NOT NULL DEFAULT '' COMMENT '创建人',
    `update_user` varchar(32)  NOT NULL DEFAULT '' COMMENT '修改人',
    `is_deleted`  int(11)      NOT NULL DEFAULT '' DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
)
    COMMENT ='商品口味关系表';

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`
(
    `id`          varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
    `name`        varchar(32) NOT NULL DEFAULT '' COMMENT '姓名',
    `username`    varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
    `phone`       varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
    `sex`         varchar(2)  NOT NULL DEFAULT '' COMMENT '性别',
    `id_number`   varchar(18) NOT NULL DEFAULT '' COMMENT '身份证号',
    `status`      int(11)     NOT NULL DEFAULT '1' COMMENT '状态 0:禁用，1:正常',
    `create_time` datetime    NOT NULL COMMENT '创建时间',
    `update_time` datetime    NOT NULL COMMENT '更新时间',
    `create_user` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人',
    `update_user` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username` (`username`)
) COMMENT ='员工信息';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` (id, name, username, password, phone, sex, id_number, status, create_time, update_time,
                        create_user, update_user)
VALUES ('1', '管理员', 'admin', '$2a$10$vZO5a2W7EgNlN6PYsMzoRercNc5SE6EDHVqSwlaF18vv56or7ujGq', '13812312312', '1',
        '110101199001010047', '1',
        '2021-05-06 17:20:07', '2021-05-10 02:24:09', '1', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`              varchar(32)    NOT NULL DEFAULT '' COMMENT '主键-订单号',
    `status`          int(1)         NOT NULL DEFAULT '1' COMMENT '订单状态 1待付款，2待派送，3已派送，4已完成，5已取消',
    `member_id`       varchar(32)    NOT NULL DEFAULT '' COMMENT '下单用户',
    `address_book_id` varchar(32)     NOT NULL DEFAULT '' COMMENT '地址id',
    `order_time`      datetime       DEFAULT NULL COMMENT '下单时间',
    `checkout_time`   datetime       DEFAULT NULL COMMENT '结账时间',
    `pay_method`      int(1)         NOT NULL DEFAULT '1' COMMENT '支付方式 1微信,2支付宝',
    `amount`          decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '实收金额',
    `remark`          varchar(100)   NOT NULL DEFAULT ''  COMMENT '备注',
    `phone`           varchar(13)    NOT NULL DEFAULT '' COMMENT '收件人手机号',
    `address`         varchar(255)   NOT NULL DEFAULT '' COMMENT '收件地址',
    `consignee`       varchar(255)   NOT NULL DEFAULT '' COMMENT '收货人姓名',
    PRIMARY KEY (`id`)
) COMMENT ='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`
(
    `id`           varchar(32)    NOT NULL DEFAULT '' COMMENT '主键',
    `name`         varchar(50)    NOT NULL DEFAULT '' COMMENT '名字',
    `image`        varchar(100)   NOT NULL DEFAULT '' COMMENT '图片',
    `order_id`     varchar(32)    NOT NULL COMMENT '订单id',
    `goods_id`     varchar(32)    NOT NULL DEFAULT '' COMMENT '商品id',
    `set_meal_id`  varchar(32)    NOT NULL DEFAULT '' COMMENT '套餐id',
    `goods_flavor` varchar(50)    NOT NULL DEFAULT '' COMMENT '口味',
    `number`       int(11)        NOT NULL DEFAULT '1' COMMENT '数量',
    `amount`       decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '金额',
    PRIMARY KEY (`id`)
) COMMENT ='订单明细表';

-- ----------------------------
-- Table structure for setmeal
-- ----------------------------
DROP TABLE IF EXISTS `set_meal`;
CREATE TABLE `set_meal`
(
    `id`          varchar(32)    NOT NULL DEFAULT '' COMMENT '主键',
    `category_id` varchar(32)    NOT NULL DEFAULT '' COMMENT '商品分类id',
    `name`        varchar(64)    NOT NULL DEFAULT '' COMMENT '套餐名称',
    `price`       decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '套餐价格',
    `status`      int(1)         NOT NULL DEFAULT '1' COMMENT '状态 0:停用 1:启用',
    `code`        varchar(32)    NOT NULL DEFAULT '' COMMENT '编码',
    `description` varchar(512)   NOT NULL DEFAULT '' COMMENT '描述信息',
    `image`       varchar(255)   NOT NULL DEFAULT '' COMMENT '图片',
    `create_time` datetime       DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime       DEFAULT NULL COMMENT '更新时间',
    `create_user` varchar(32)    NOT NULL DEFAULT '' COMMENT '创建人',
    `update_user` varchar(32)    NOT NULL DEFAULT '' COMMENT '修改人',
    `is_deleted`  int(11)        NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_set_meal_name` (`name`)
) COMMENT ='套餐';

-- ----------------------------
-- Table structure for setmeal_goods
-- ----------------------------
DROP TABLE IF EXISTS `set_meal_goods`;
CREATE TABLE `set_meal_goods`
(
    `id`          varchar(32)    NOT NULL DEFAULT '' COMMENT '主键',
    `set_meal_id` varchar(32)    NOT NULL DEFAULT '' COMMENT '套餐id ',
    `goods_id`    varchar(32)    NOT NULL DEFAULT '' COMMENT '商品id',
    `name`        varchar(32)    NOT NULL DEFAULT '' COMMENT '商品名称 （冗余字段）',
    `price`       decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '商品原价（冗余字段）',
    `copies`      int(11)        NOT NULL DEFAULT 0 COMMENT '份数',
    `sort`        int(11)        NOT NULL DEFAULT '0' COMMENT '排序',
    `create_time` datetime       DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime       DEFAULT NULL COMMENT '更新时间',
    `create_user` varchar(32)    NOT NULL DEFAULT '' COMMENT '创建人',
    `update_user` varchar(32)    NOT NULL DEFAULT '' COMMENT '修改人',
    `is_deleted`  int(11)        NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) COMMENT ='套餐商品关系';

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`
(
    `id`           varchar(32)    NOT NULL DEFAULT '' COMMENT '主键',
    `name`         varchar(50)             DEFAULT NULL COMMENT '名称',
    `image`        varchar(100)            DEFAULT NULL COMMENT '图片',
    `member_id`    varchar(32)    NOT NULL COMMENT '用户id',
    `goods_id`     varchar(32)             DEFAULT NULL COMMENT '商品id',
    `set_meal_id`  bigint(20)              DEFAULT NULL COMMENT '套餐id',
    `goods_flavor` varchar(50)             DEFAULT NULL COMMENT '口味',
    `number`       int(11)        NOT NULL DEFAULT '1' COMMENT '数量',
    `amount`       decimal(10, 2) NOT NULL COMMENT '金额',
    `create_time`  datetime                DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT ='购物车';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`
(
    `id`      varchar(32)  NOT NULL DEFAULT '' COMMENT '主键',
    `name`    varchar(50)           DEFAULT NULL COMMENT '姓名',
    `phone`   varchar(100) NOT NULL COMMENT '手机号',
    `gender`  varchar(2)            DEFAULT NULL COMMENT '性别',
    `id_card` varchar(18)           DEFAULT NULL COMMENT '身份证号',
    `avatar`  varchar(500)          DEFAULT NULL COMMENT '头像',
    `status`  int(1)                DEFAULT '0' COMMENT '状态 0:禁用，1:正常',
    PRIMARY KEY (`id`)
) COMMENT ='用户信息';
