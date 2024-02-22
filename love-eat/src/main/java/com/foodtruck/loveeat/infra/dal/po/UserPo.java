package com.foodtruck.loveeat.infra.dal.po;

import com.foodtruck.loveeat.biz.enums.LoginTypeEnum;
import com.foodtruck.loveeat.biz.enums.UserStatusEnum;
import com.foodtruck.loveeat.infra.dal.handler.LoginTypeEnumHandler;
import lombok.Data;

/**
 * UserPo
 *
 * @author libaozhong
 * @version 2024-02-21
 * CREATE TABLE `user` (
 *   `id` int NOT NULL AUTO_INCREMENT COMMENT 'primary key',
 *   `name` varchar(30) NOT NULL DEFAULT '' COMMENT 'login name',
 *   `type` smallint NOT NULL DEFAULT '1' COMMENT 'login type 1 defult account login 2 email  3 sms',
 *   `password` varchar(20) NOT NULL DEFAULT '' COMMENT 'password',
 *   `status` smallint NOT NULL DEFAULT '0' COMMENT 'account status',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COMMENT='user table'
 **/




@Data
public class UserPo {

   private Integer id;

   private String name;

   private LoginTypeEnum type;

   private String password;

    private UserStatusEnum status = UserStatusEnum.Normal;

    private String email;

}
