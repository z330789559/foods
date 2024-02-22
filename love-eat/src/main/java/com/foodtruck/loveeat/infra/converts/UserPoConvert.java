package com.foodtruck.loveeat.infra.converts;

import com.foodtruck.loveeat.domain.user.dos.UserDo;
import com.foodtruck.loveeat.infra.dal.po.UserPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UserPoConvert
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Mapper
public interface UserPoConvert {
    UserPoConvert INSTANCE = Mappers.getMapper(UserPoConvert.class);


    UserPo convert(UserDo userDo);


    UserDo convert(UserPo userPo);

}
