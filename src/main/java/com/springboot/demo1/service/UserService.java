package com.springboot.demo1.service;

import com.springboot.demo1.dao.UserRepository;
import com.springboot.demo1.entity.User;
import com.springboot.demo1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserList(){
        return userRepository.findAll();
    }


}
