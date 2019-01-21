--创建数据库
create database seckill;
use seckill;
--创建秒杀库存表
create table seckill(
`seck_id` bigint not null auto_increment comment '商品库存ID',
`name` varchar(120) not null comment '商品名称',
`number` int not null comment '库存数量',
`start_time`  timestamp not null comment '秒杀开始时间',
`end_time` timestamp not null comment ' 秒杀结束时间',
`create_time` timestamp not null default current_timestamp comment '创建时间',
primary key (seck_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';


--初始化数据
insert into seckill(`name`,`number`,`start_time`,`end_time`)
values('1000元秒杀iwatch',10,'2019-01-19 00:00:00','2019-01-19 00:01:00'),
	('20元秒杀手环',10,'2019-01-19 01:00:00','2019-01-19 02:00:00'),
	('9.9元秒杀床单4件套',20,'2019-01-19 00:00:00','2019-01-19 01:00:00'),
	('1元秒杀鸡蛋（4个）',30,'2019-01-19 00:00:00','2019-01-19 01:00:00');

--秒杀成功明细表
--用户登陆认证相关信息
create table success_killed(
`seck_id` bigint not null comment '秒杀商品id',
`user_phone` bigint not null comment '用户手机号',
`state` tinyint not null default -1 comment '状态标示： -1：无效 0：成功 1：已付款 2：已发货 3.已收货',
`create_time` timestamp not null comment '创建时间',
primary key(`seck_id`,`user_phone`),
key `idx_create_time`(`create_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';