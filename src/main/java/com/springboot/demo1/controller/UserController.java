package com.springboot.demo1.controller;

import com.springboot.demo1.entity.BaseException;
import com.springboot.demo1.entity.Response;
import com.springboot.demo1.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取用户列表
     */
    @PostMapping(value = "/get")
    public Response getUserList(){
        return new Response().normalResponse(userService.getUserList());
    }

    /**
     * 根据用户ID获取用户
     */
    @PostMapping(value = "/get/{userId}")
    public Response getUserById(@PathVariable Integer userId){
        return new Response().normalResponse(userService.getUserByUserId(userId));
    }

    /**
     * 添加用户
     */
    @PostMapping(value = "/add/{userName}/{passWord}/{email}/{nickName}")
    public Response addUser(@PathVariable String userName,@PathVariable String passWord,@PathVariable String email,
                          @PathVariable String nickName) throws BaseException{
        userService.addUser(userName, passWord, email, nickName);
        return new Response().normalResponse();
    }

}
