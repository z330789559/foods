package com.foodtruck.loveeat.infra.cache;

import java.util.ArrayList;
import java.util.List;

import com.foodtruck.loveeat.infra.dal.mapper.FoodMapper;
import com.foodtruck.loveeat.infra.dal.po.FoodGeoLocation;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.domain.geo.GeoShape;
import org.springframework.stereotype.Service;

/**
 * GeoService
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Service
public class GeoService {


  private static final String GEO_KEY = "locations::city";
  @Autowired
  private RedisTemplate<String, String> redisTemplate;


  @Autowired
  private FoodMapper foodMapper;

  @PostConstruct
  public void initGeoData(){
    List<FoodGeoLocation> locations = foodMapper.queryAllLocations();
    List<RedisGeoCommands.GeoLocation<String>> geoLocations = new ArrayList<>(300);
    for (FoodGeoLocation location : locations) {
      if(geoLocations.size() < 300){
          geoLocations.add(new RedisGeoCommands.GeoLocation<>(String.valueOf(location.getLocationid()), new Point(Double.parseDouble(location.getLongitude()), Double.parseDouble(location.getLatitude()))));
        }else{
          batchAddLocation(geoLocations);
          geoLocations.clear();
        }
    }
    if(!geoLocations.isEmpty()){
      batchAddLocation(geoLocations);
    }
  }


  public void addLocation(Integer locationId, double longitude, double latitude) {
    // 使用RedisTemplate的GeoOperations接口执行GEOADD命令
    redisTemplate.opsForGeo().add(GEO_KEY, new Point(longitude, latitude), String.valueOf(locationId));
  }


  public void batchAddLocation(  List<RedisGeoCommands.GeoLocation<String>> locations) {
      // 使用RedisTemplate的GeoOperations接口执行GEOADD命令
      redisTemplate.opsForGeo().add(GEO_KEY, locations);
  }

    public void removeLocation(Integer locationId) {
        // 使用RedisTemplate的GeoOperations接口执行ZREM命令
        redisTemplate.opsForGeo().remove(GEO_KEY, String.valueOf(locationId));
    }
  public GeoResults<RedisGeoCommands.GeoLocation<String>> getLocationsNearby(double longitude, double latitude, double radius, Metric unit) {
    // 设置查询参数
    RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeDistance().sortAscending().limit(100);

    // 使用RedisTemplate的GeoOperations接口执行GEORADIUS命令
    return redisTemplate.opsForGeo().radius(GEO_KEY, new Circle(new Point(longitude, latitude), new Distance(radius, unit)), args);
  }


}
