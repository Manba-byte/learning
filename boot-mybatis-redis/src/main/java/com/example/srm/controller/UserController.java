package com.example.srm.controller;

import com.example.srm.entity.User;
import com.example.srm.service.impl.UserImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wh
 * @description
 * @date 2019/4/2
 */
@Api(description = "用户控制层")
@RestController
public class UserController {
    @Autowired
    private UserImpl userImpl;
    @ApiOperation(value = "查询所有用户")
    @GetMapping("/findUser")
    public List<User> selectUser(){
        return userImpl.selectUser();
    }
}
