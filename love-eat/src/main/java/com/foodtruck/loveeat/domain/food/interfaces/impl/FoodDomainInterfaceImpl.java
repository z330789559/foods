package com.foodtruck.loveeat.domain.food.interfaces.impl;

import java.util.List;

import cn.hutool.core.collection.ListUtil;
import com.foodtruck.loveeat.domain.food.dos.FoodDo;
import com.foodtruck.loveeat.domain.food.interfaces.FoodDomainInterface;
import com.foodtruck.loveeat.domain.food.repos.FoodRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FoodDomainInterfaceImpl
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Service
public class FoodDomainInterfaceImpl implements FoodDomainInterface {

  @Autowired
  private FoodRepo foodRepo;
  @Override
  public List<FoodDo> queryNearbyFoods(String Latitude, String Longitude, int distance) {
    List<Integer> locationIds = foodRepo.queryNearbyFoods(Latitude, Longitude, distance);
    if(locationIds.isEmpty()){
      return ListUtil.empty();
    }
    return foodRepo.queryFoods(locationIds);
  }
}
