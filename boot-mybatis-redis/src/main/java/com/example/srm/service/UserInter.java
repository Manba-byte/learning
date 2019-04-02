package com.example.srm.service;

import com.example.srm.entity.User;

import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/4/2
 */
public interface UserInter {
    int deleteByPrimaryKey(String userName);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUser();
}
