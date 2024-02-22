package com.foodtruck.loveeat.domain.user.service;

import com.foodtruck.loveeat.domain.user.dos.UserDo;
import com.foodtruck.loveeat.domain.user.repos.UserRepo;
import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Service
public class UserService {

  @Resource
  private UserRepo userRepo;


  public int saveUser(UserDo userDo) {

    return userRepo.saveUser(userDo);
  }


  public UserDo queryUser(String username) {
    return userRepo.queryUser(username);
  }
}
