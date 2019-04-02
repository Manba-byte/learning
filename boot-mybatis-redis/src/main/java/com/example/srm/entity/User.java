package com.example.srm.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户表
 * 实体类对应的数据表为：user
 * @author wh
 */
@ApiModel(value = "User")
public class User implements Serializable {
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("用户年龄")
    private Integer userAge;

    private static final long serialVersionUID = 1L;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}