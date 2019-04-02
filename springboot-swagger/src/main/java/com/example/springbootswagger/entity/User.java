package com.example.springbootswagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

/**
 * @author wh
 * @description 用户实体类
 * @date 2019/3/13
 */
//@Component
@ApiModel(value = "ddd")
public class User {
    @ApiModelProperty(value = "aaaaaa",name = "userName",example="dafdsafdasfasdf")
    private String userName;
    @Min(value = 18,message = "未成年人禁止入内")
    @ApiModelProperty(hidden = true)
    private Integer userAge;

    public String getUserName() {
        return userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public User(String userName, Integer userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
