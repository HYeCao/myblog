package com.example.demo.dao;


import com.example.demo.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User GetUser(String ID);
    boolean UpDateUser(User user);
    boolean DeleteUser(String ID);
    boolean AddUser(User user);

    User LoginUser(@Param("username")String username, @Param("password")String password);

    User findUserByUsername(String username);
}
