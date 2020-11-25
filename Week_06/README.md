##订单表
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(11) NOT NULL COMMENT '订单id',
  `member_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `member_id` int(11) NOT NULL COMMENT '用户id',
  `total_price` int(13) NOT NULL COMMENT '订单总金额 单位为分',
  `order_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `order_status` int(10) NOT NULL COMMENT '订单状态 0未支付 1代发货 2已发货 3已完成 4已关闭',
  `confirm_status` int(2) NOT NULL COMMENT '收货状态 0未收货 1已收货',
  `pay_type` int(2) NOT NULL COMMENT '支付方式 1支付宝 2微信 3银行卡',
  `create_time` int(13) NOT NULL COMMENT '创建时间',
  `update_time` int(13) NOT NULL COMMENT '修改时间 此处应该有一张 订单状态更改表 暂时不添加',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

##订单商品表
DROP TABLE IF EXISTS `t_order_product`;
CREATE TABLE `t_order_product`  (
  `id` int(11) NOT NULL COMMENT '订单商品ID',
  `order_id` int(11) NOT NULL COMMENT '订单id',
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `product_sku_id` int(11) NOT NULL COMMENT '商品的skuid',
  `product_category` int(11) NOT NULL COMMENT '商品分类',
  `brand_id` int(11) NOT NULL COMMENT '品牌id',
  `product_price` int(11) NOT NULL COMMENT '商品价格 单位为分',
  `product_quantity` int(11) NOT NULL COMMENT '商品购买数量',
  `product_sku_attributes` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品属性',
  `create_time` int(13) NOT NULL COMMENT '创建时间',
  `update_time` int(13) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单商品表' ROW_FORMAT = Dynamic;


##商品表
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` int(11) NOT NULL COMMENT '商品ID',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_category_id` int(11) NOT NULL COMMENT '商品分类ID',
  `pictures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片 json存储 ',
  `product_brand_id` int(11) NOT NULL COMMENT '商品对应卖家ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品主表 可增加字段进行适当冗余' ROW_FORMAT = Dynamic;

##商品分类表
DROP TABLE IF EXISTS `t_product_category`;
CREATE TABLE `t_product_category`  (
  `id` int(11) NOT NULL COMMENT '商品分类ID',
  `category_parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '商品父类ID  为0时代表1级分类',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品分类名称',
  `category_level` int(5) NOT NULL DEFAULT 0 COMMENT '商品分类级别 ',
  `category_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图标',
  `category_unit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品单位  件/个/次',
  `create_time` bigint(13) NOT NULL COMMENT '创建时间',
  `update_time` bigint(13) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

##用户表
DROP TABLE IF EXISTS `t_user_member`;
CREATE TABLE `t_user_member`  (
  `id` int(11) NOT NULL COMMENT '用户id',
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `member_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `member_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `member_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱',
  `create_time` int(13) NOT NULL COMMENT '创建时间',
  `update_time` int(13) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

