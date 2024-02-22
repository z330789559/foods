package com.foodtruck.loveeat.contoller.converts;

import com.foodtruck.loveeat.contoller.request.UserDto;
import com.foodtruck.loveeat.domain.user.dos.UserDo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * UserDtoConverts
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@Mapper
public interface UserDtoConverts {

        UserDtoConverts INSTANCE = Mappers.getMapper(UserDtoConverts.class);

        UserDo toDo(UserDto userDto);

        UserDto toDto(UserDo userDo);
}
