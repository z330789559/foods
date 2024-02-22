package com.foodtruck.loveeat.infra.dal.mapper;

import java.util.List;

import com.foodtruck.loveeat.domain.food.dos.FoodDo;
import com.foodtruck.loveeat.domain.food.repos.FoodRepo;
import com.foodtruck.loveeat.infra.dal.po.FoodGeoLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * FoodMapper
 *
 * @author libaozhong
 * @version 2024-02-21
 **/
@Mapper
public interface FoodMapper  {

	@Select("<script>"
			+ "select * from food where locationid in "
			+ "<foreach collection='foodIds' item='foodId' open='(' separator=',' close=')'>"
			+ "#{foodId}"
			+ "</foreach>"
			+ "</script>"
	)
	List<FoodDo> queryFoods(@Param("foodIds") List<Integer> foodIds);

	@Select("select locationid,Latitude, Longitude from food")
	List<FoodGeoLocation> queryAllLocations();
}
