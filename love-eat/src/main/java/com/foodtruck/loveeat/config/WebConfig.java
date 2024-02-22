package com.foodtruck.loveeat.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author libaozhong
 * @version 2024-02-22
 **/

@Component
public class WebConfig  implements WebMvcConfigurer {



//下面是跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
              .allowedOrigins("http://localhost:8088,http://192.168.10.7:10086")
              .allowedMethods("GET", "POST", "PUT", "DELETE")
              .allowCredentials(true)
              .maxAge(3600);
    }


}
