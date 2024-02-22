package com.foodtruck.loveeat.contoller;

import java.util.List;

import com.foodtruck.loveeat.domain.food.dos.FoodDo;
import com.foodtruck.loveeat.domain.food.interfaces.FoodDomainInterface;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FoodController
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@RestController("food")
@RequestMapping("food")
public class FoodController {

  @Autowired
  private FoodDomainInterface foodDomainInterface;


    @GetMapping("nearby")
    public List<FoodDo> queryNearbyFoods(@RequestParam(value = "latitude",required = true) String latitude, @RequestParam(value = "longitude",required = true) String longitude, int distance) {
       distance= distance > 0 ? distance : 1;
       return  foodDomainInterface.queryNearbyFoods(latitude, longitude, distance);
    }


}
