package com.foodtruck.loveeat.contoller.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.foodtruck.loveeat.biz.enums.LoginTypeEnum;
import com.foodtruck.loveeat.biz.enums.UserStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;


/**
 * UserDto
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Data
public class UserDto {

  private Integer id;

  @NotBlank(message = "name can not be null")
  private String name;

  @NotNull
  private LoginTypeEnum type=LoginTypeEnum.PwdLogin;

  @NotBlank(message = "password can not be null")
  private String password;

  @Positive(message = "status must be positive")
  private UserStatusEnum status;

  private String email;

}
