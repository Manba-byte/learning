package com.example.springbootswagger.controller;

import com.example.springbootswagger.entity.User;
import com.example.springbootswagger.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author wh
 * @description 用户信息控制层
 * @date 2019/3/13
 */
@Controller
@RequestMapping("/testboot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(Model model){
        List<User> user = userService.getUser();
        model.addAttribute("userList",user);
        return "hom";
    }

    @RequestMapping("/addUser")
    public String addUser(@Validated User user, BindingResult bindingResult , Model model){
        System.out.println(user.getUserName());
        userService.addUser(user);
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());

        }
        return getUser(model);
    }
    @GetMapping("/user/{userName}/{userAge}")
    @ResponseBody
    public Object findByName(@PathVariable("userName") String userName,@PathVariable String userAge){
        System.out.println(userName+","+userAge);
        List<User> user = userService.getUser();
        for (User user1 : user) {
            System.out.println(user1.getUserName().equals(userName));
            System.out.println("length比较：");
            System.out.println(user1.getUserName().length() == userName.length());
            System.out.println("对象:"+user1.getUserName().length());
            System.out.println("参数:"+userName.length());
            if(user1.getUserName().equals(userName)){
                System.out.println("if语句进来了");
                return user1;
            }
        }
        return "没有找到";
    }
     // 访问地址
     @ApiOperation(value = "查找用户" , notes = "根据id查找用户")
     @ApiImplicitParam(name = "id" , value = "用户id" , dataType = "String" , paramType = "query")
     @GetMapping("/findUser")
     @ResponseBody
     public User findUser(String id){
         System.out.println("进来了"+id);
        return userService.findUser(id);

     }
}
