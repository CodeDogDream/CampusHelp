CREATE DATABASE dream;
USE dream;
CREATE TABLE loginInfo (
  uid        INT    NOT NULL   AUTO_INCREMENT
  COMMENT '用户id',
  mobile     BIGINT NOT NULL
  COMMENT '用户手机号',
  captcha    INT
  COMMENT '手机验证码',
  send_time  BIGINT NOT NULL   DEFAULT 0
  COMMENT '上次短信发送时间',
  send_count INT    NOT NULL   DEFAULT 1
  COMMENT '发送短信次数',
  PRIMARY KEY (uid),
  KEY idx_send_time(send_time),
  KEY idx_mobile(mobile)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '登录信息表';

CREATE TABLE userInfo (
  uid       INT                         NOT NULL  AUTO_INCREMENT
  COMMENT '用户id',
  uname     VARCHAR(10)                 NOT NULL
  COMMENT '用户昵称',
  mobile    BIGINT                      NOT NULL
  COMMENT '用户手机号',
  uintro    VARCHAR(20)
  COMMENT '用户个性签名',
  uavatar   VARCHAR(30)                 NOT NULL
  COMMENT '用户头像',
  age       INT                         NOT NULL  DEFAULT 20
  COMMENT '用户年龄',
  gender    ENUM ('男', '女') DEFAULT '男' NOT NULL
  COMMENT '用户性别',
  school    VARCHAR(30)                 NOT NULL
  COMMENT '学校名称',
  tag       TEXT
  COMMENT '用户擅长什么内容',
  longitude DOUBLE
  COMMENT '用户所在的经度',
  latitue   DOUBLE
  COMMENT '用户所在的纬度',
  PRIMARY KEY (uid),
  KEY idx_age(age)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '用户信息表';

CREATE TABLE helpInfo (
  info_id   INT         NOT NULL  AUTO_INCREMENT
  COMMENT '求助信息的编号',
  uid       INT         NOT NULL
  COMMENT '发布者id',
  uname     VARCHAR(10) NOT NULL
  COMMENT '发布者昵称',
  title     VARCHAR(20) NOT NULL
  COMMENT '发布的求助信息标题',
  content   TEXT        NOT NULL
  COMMENT '发布的求助信息内容',
  date      BIGINT
  COMMENT '发布的时间',
  longitude DOUBLE
  COMMENT '发布的位置经度',
  latitue   DOUBLE
  COMMENT '发布的纬度',
  tag       VARCHAR(10) NOT NULL
  COMMENT '求助信息的分类',
  uavatar   VARCHAR(200)
  COMMENT '发布者的头像',
  PRIMARY KEY (info_id),
  KEY idx_date(date)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '求助信息详情';

CREATE TABLE token_uid (
  token       VARCHAR(64) NOT NULL
  COMMENT '登录验证的token',
  create_time BIGINT      NOT NULL
  COMMENT 'token创建时间',
  end_time    BIGINT      NOT NULL
  COMMENT 'token失效时间',
  uid         INT         NOT NULL
  COMMENT '用户的id',
  PRIMARY KEY (token),
  KEY idx_uid(uid),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = 'token和用户id的关联';