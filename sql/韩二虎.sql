
DROP PROCEDURE IF EXISTS a11;
CREATE PROCEDURE a11()
BEGIN

 IF NOT EXISTS (select * from information_schema.`TABLES` WHERE TABLE_SCHEMA = 'guns' and TABLE_NAME = 'han_custom')  THEN
CREATE TABLE `han_custom` (
  `id` varchar(50) NOT NULL COMMENT '主键,用java随机码',
  `name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `age` int COMMENT '客户年龄',
  phone01 varchar(50) COMMENT '客户电话1',
  phone02 varchar(50) COMMENT '客户电话2',
  phone03 varchar(50) COMMENT '客户电话3',
  phone04 varchar(50) COMMENT '客户电话4',
  car01 varchar(100) COMMENT '客户常用车型01',
  car02 varchar(100) COMMENT '客户常用车型02',
  car03 varchar(100) COMMENT '客户常用车型03',
  rem01 varchar (2000) COMMENT '备注一',
  rem02 varchar (2000) COMMENT '备注二',
  rem03 varchar (2000) COMMENT '备注三',
  introduce varchar (50)COMMENT '介绍人',
  introduce_phone varchar (50)COMMENT '介绍人电话',
  create_by varchar(100) comment'创建人',
  create_time datetime comment'创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='汽车维修客户表';
end if;
alter table han_custom add unique(name) --设置唯一

 IF NOT EXISTS (select * from information_schema.`TABLES` WHERE TABLE_SCHEMA = 'guns' and TABLE_NAME = 'han_fix')  THEN
CREATE TABLE `han_fix` (
  `id` varchar(50) NOT NULL COMMENT '维修id',
  custom_id varchar(50) comment '维修用户id',
  ispay varchar(50) comment '是否已经付款,填写是或者不是',
  `cost` decimal (50) DEFAULT NULL COMMENT '该次维修费用',
  car01 varchar(100) comment '客户维修车型',
  fix_program varchar (2000) comment '维修项目',
  fix_time datetime comment '维修时间',
  use_part varchar (2000) comment '使用零件',
  rem01 varchar (2000) comment '备注',
  create_by varchar(100) comment'创建人',
  create_time datetime comment'创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='汽车维修项目表';
end if;



end;
CALL a11();
DROP PROCEDURE IF EXISTS a11;