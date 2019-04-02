package com.example.springbootswagger.mapper;

import com.example.springbootswagger.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询用户信息的方法
     * @return 用户对象
     */
    List<User> getUser();

    int addUser(User user);

    User findUser(String name);
}
