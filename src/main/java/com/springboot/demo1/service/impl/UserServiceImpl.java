package com.springboot.demo1.service.impl;

import com.springboot.demo1.entity.User;

import java.util.List;

public interface UserServiceImpl {

    public List<User> getUserList();

    public User getUserByUserId(Integer userId);

    public String addUser(User user);
}
