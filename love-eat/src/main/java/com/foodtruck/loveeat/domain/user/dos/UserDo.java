package com.foodtruck.loveeat.domain.user.dos;

import com.foodtruck.loveeat.biz.enums.LoginTypeEnum;
import com.foodtruck.loveeat.biz.enums.UserStatusEnum;
import lombok.Data;

/**
 * UserDo
 *
 * @author libaozhong
 * @version 2024-02-21
 **/


@Data
public class UserDo {
	private Integer id;

	private String name;

	private LoginTypeEnum type;

	private String password;

	private UserStatusEnum status;

	private String email;

}
