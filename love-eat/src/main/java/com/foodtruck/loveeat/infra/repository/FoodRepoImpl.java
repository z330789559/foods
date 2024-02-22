package com.foodtruck.loveeat.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.foodtruck.loveeat.domain.food.dos.FoodDo;
import com.foodtruck.loveeat.domain.food.repos.FoodRepo;
import com.foodtruck.loveeat.infra.cache.GeoService;
import com.foodtruck.loveeat.infra.dal.mapper.FoodMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metric;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.domain.geo.Metrics;
import org.springframework.stereotype.Repository;

/**
 * FoodRepoImpl
 *
 * @author libaozhong
 * @version 2024-02-21
 **/


@Repository
public class FoodRepoImpl implements FoodRepo {

  @Autowired
  private FoodMapper foodMapper;

  @Autowired
  private GeoService geoService;


  @Override
  public List<Integer> queryNearbyFoods(String Latitude, String Longitude, int distance) {

    GeoResults<RedisGeoCommands.GeoLocation<String>> foodPoses = geoService.getLocationsNearby(Double.parseDouble(Longitude), Double.parseDouble(Latitude), distance, Metrics.KILOMETERS);
     return  foodPoses.getContent().stream().map(foodPos -> Integer.valueOf(foodPos.getContent().getName())).collect(Collectors.toList());
  }

  @Override
  public List<FoodDo> queryFoods(List<Integer> foodIds) {
    return foodMapper.queryFoods(foodIds);
  }
}
