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

    public User getUserByUserId(Integer userId) {
        return userRepository.getUserByUserId(userId);
    }

    public String addUser(User user) {
        Integer numByEmail = userRepository.countUserByEmail(user.getEmail());
        Integer numByUserName = userRepository.countUserByUserName(user.getUserName());
        if(numByEmail > 0) {
            return "该邮箱已被使用";
        } else if(numByUserName > 0) {
            return "该用户名已被使用";
        } else {
            userRepository.save(user);
        }
        return "新建用户成功";
    }


}
