package com.nexa.demo.mapper;

import com.nexa.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户Mapper
 *
 * @Author: nexa
 * @Date: 2025/6/29 19:22
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);
}
