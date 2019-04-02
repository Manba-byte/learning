package com.example.springbootswagger.service.impl;

import com.example.springbootswagger.entity.User;
import com.example.springbootswagger.mapper.UserMapper;
import com.example.springbootswagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wh
 * @description 用户服务层实现类
 * @date 2019/3/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser() {

        return userMapper.getUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User findUser(String id) {
        return userMapper.findUser(id);
    }


}
