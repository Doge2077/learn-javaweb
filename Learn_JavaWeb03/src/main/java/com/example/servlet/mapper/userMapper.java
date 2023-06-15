package com.example.servlet.mapper;

import com.example.servlet.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface userMapper {

    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);
}
