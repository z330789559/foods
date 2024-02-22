package com.foodtruck.loveeat.infra.dal.handler;

import com.foodtruck.loveeat.biz.enums.LoginTypeEnum;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

import org.springframework.stereotype.Component;

/**
 * RegisterEnumHandlerConfig
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Component
public class RegisterEnumHandlerConfig implements ConfigurationCustomizer {
  @Override
  public void customize(Configuration configuration) {
    configuration.getTypeHandlerRegistry().register(LoginTypeEnum.class,new LoginTypeEnumHandler());
  }
}
