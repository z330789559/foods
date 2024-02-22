package com.foodtruck.loveeat.infra.dal.mapper;

import com.foodtruck.loveeat.domain.user.dos.UserDo;
import com.foodtruck.loveeat.domain.user.repos.UserRepo;
import com.foodtruck.loveeat.infra.converts.UserPoConvert;
import com.foodtruck.loveeat.infra.dal.po.UserPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * UserMapper
 *
 * @author libaozhong
 * @version 2024-02-21
 **/
@Mapper
public interface UserMapper extends UserRepo {

    @Select("select * from user where id = #{id}")
    UserPo selectUserById(Integer id);


    @Select("select * from user where name = #{name}")
    UserPo selectUserByName(String name);

    @Insert("insert into user(name,type,password,status) values(#{name},#{type},#{password},#{status})")
    int save(UserPo userPo);

    @Override
    default int saveUser(UserDo userDo) {
        return save(UserPoConvert.INSTANCE.convert(userDo));
    }

    @Override
    default UserDo queryUser(String username) {
        return UserPoConvert.INSTANCE.convert(selectUserByName(username));
    }
}
