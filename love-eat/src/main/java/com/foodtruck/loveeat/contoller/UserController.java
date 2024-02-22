package com.foodtruck.loveeat.contoller;

import com.foodtruck.loveeat.contoller.converts.UserDtoConverts;
import com.foodtruck.loveeat.contoller.request.UserDto;
import com.foodtruck.loveeat.contoller.response.ResponseUtils;
import com.foodtruck.loveeat.domain.user.interfaces.UserDomainInterface;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 *
 * @author libaozhong
 * @version 2024-02-20
 **/

@RestController("user")
@RequestMapping("user")
public class UserController {


  @Autowired
  private UserDomainInterface userDomainInterface;


   @PostMapping("register")
   public ResponseUtils.R<Integer> userRegister(@Valid  @RequestBody UserDto userDto) {
     int result = userDomainInterface.saveUser(UserDtoConverts.INSTANCE.toDo(userDto));
     if (result > 0) {
       return ResponseUtils.ok(result);
     }
     else {
       return ResponseUtils.fail(500, "fail");
     }
   }

    @GetMapping("login")
    public ResponseUtils.R<String> userLogin(@RequestParam String username, @RequestParam String password) {
       String token= userDomainInterface.login(username, password);
      if (StringUtils.hasText(token)) {
        return ResponseUtils.ok(token);
      }
      else {
        return ResponseUtils.fail(500, "fail");
      }
    }


}
