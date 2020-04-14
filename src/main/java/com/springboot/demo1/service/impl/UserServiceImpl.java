package com.springboot.demo1.service.impl;

import com.springboot.demo1.entity.BaseException;
import com.springboot.demo1.entity.User;

import java.util.List;

public interface UserServiceImpl {

    public List<User> getUserList();

    public User getUserByUserId(Integer userId);

    public void addUser(String userName, String passWord, String email, String nickName) throws BaseException;
}
