package com.foodtruck.loveeat.domain.food.interfaces;

import java.util.List;

import com.foodtruck.loveeat.domain.food.dos.FoodDo;

/**
 * FoodDomainInterface
 *
 * @author libaozhong
 * @version 2024-02-21
 **/
public interface FoodDomainInterface {

    List<FoodDo> queryNearbyFoods(String Latitude,String Longitude, int distance);
}
