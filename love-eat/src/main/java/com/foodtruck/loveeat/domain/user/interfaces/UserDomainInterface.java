package com.foodtruck.loveeat.domain.user.interfaces;

import com.foodtruck.loveeat.domain.user.dos.UserDo;

/**
 * UserDomainInterface
 *
 * @author libaozhong
 * @version 2024-02-21
 **/
public interface UserDomainInterface {



    int saveUser(UserDo userDo);

	String login(String username, String password);
}
