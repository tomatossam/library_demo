package com.springboot.demo1.controller;

import com.springboot.demo1.entity.User;
import com.springboot.demo1.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    //获取用户列表
    @PostMapping(value = "/get")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    //根据用户ID获取用户
    @PostMapping(value = "/get/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.getUserByUserId(userId);
    }

    //添加用户
    /*@PostMapping(value = "/add/{userName}/{passWord}/{email}/{nickName}")
    public String addUser(@PathVariable String userName,@PathVariable String passWord,@PathVariable String email,
                          @PathVariable String nickName){*/
    @PostMapping(value = "/add")
    public String addUser(String userName, String passWord, String email, String nickName){
        if(passWord == null || passWord.length() < 6) {
            return "密码格式有误";
        } else if(email == null || email.length() < 6) {
            return "邮箱格式有误";
        } else {
            User user = new User();
            user.setUserName(userName);
            user.setPassWord(passWord);
            user.setEmail(email);
            user.setNickName(nickName);
            String res = userService.addUser(user);
            if(res != null) {
                return res;
            } else {
                return "内部错误";
            }
        }
    }

}
