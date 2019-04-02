package com.example.springbootswagger.service;

import com.example.springbootswagger.entity.User;

import java.util.List;

/**
 * @author wh
 * @description 用户接口
 * @date 2019/3/13
 */
public interface UserService {

    List<User> getUser();

    int addUser(User user);

    User findUser(String id);
}
