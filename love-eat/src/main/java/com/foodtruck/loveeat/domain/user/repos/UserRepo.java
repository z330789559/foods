package com.foodtruck.loveeat.domain.user.repos;

import com.foodtruck.loveeat.domain.user.dos.UserDo;

/**
 * UserRepo
 *
 * @author libaozhong
 * @version 2024-02-21
 **/
public interface UserRepo {

	int saveUser(UserDo userDo);

	UserDo queryUser(String username);
}
