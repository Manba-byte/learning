package com.example.srm.service.impl;

import com.example.srm.entity.User;
import com.example.srm.mapper.UserMapper;
import com.example.srm.service.UserInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/4/2
 */
@Service
public class UserImpl implements UserInter {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(String userName) {
        return userMapper.deleteByPrimaryKey(userName);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String userName) {
        return userMapper.selectByPrimaryKey(userName);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    @Cacheable(value = "all",keyGenerator = "wiselyKeyGenerator") //使用该注解开启redis缓存
    public List<User> selectUser(){
        System.out.println("进来了");
        return userMapper.selectUser();
    }
}
