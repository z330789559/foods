package com.foodtruck.loveeat.domain.user.interfaces.impls;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.jwt.JWTUtil;
import com.foodtruck.loveeat.biz.enums.UserStatusEnum;
import com.foodtruck.loveeat.domain.user.dos.UserDo;
import com.foodtruck.loveeat.domain.user.interfaces.UserDomainInterface;
import com.foodtruck.loveeat.domain.user.service.UserService;
import jakarta.annotation.Resource;


import org.springframework.stereotype.Service;

/**
 * UserDomainServiceImpl
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Service
public class UserDomainServiceImpl implements UserDomainInterface {

	private String jwtSecret = "foodtruck";

	@Resource
	private UserService userService;


	@Override
	public int saveUser(UserDo userDo) {
		if(null==userDo.getStatus()){
			userDo.setStatus(UserStatusEnum.Normal);
		}
		userDo.setPassword(SecureUtil.md5(userDo.getPassword()));
		return userService.saveUser(userDo);
	}

	@Override
	public String login(String username, String password) {
		UserDo userDo = userService.queryUser(username);
		if(null!=userDo){
			if(userDo.getPassword().equals(SecureUtil.md5(password))){
				Map<String, Object> map = new HashMap<String, Object>(2) {
					private static final long serialVersionUID = 1L;
					{
						put("uid",userDo.getId());
						put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
					}
				};

			return	JWTUtil.createToken(map,jwtSecret.getBytes(StandardCharsets.UTF_8));
			}
		}
		return null;
	}
}
