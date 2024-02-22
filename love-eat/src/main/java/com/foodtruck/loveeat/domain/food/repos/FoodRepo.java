package com.foodtruck.loveeat.domain.food.repos;

import java.util.List;

import com.foodtruck.loveeat.domain.food.dos.FoodDo;

/**
 * FoodRepo
 *
 * @author libaozhong
 * @version 2024-02-21
 **/
public interface FoodRepo {

    List<Integer> queryNearbyFoods(String Latitude,String Longitude, int distance);

    List<FoodDo> queryFoods(List<Integer> foodIds);
}
