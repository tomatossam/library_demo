package com.springboot.demo1.service;

import com.springboot.demo1.dao.UserRepository;
import com.springboot.demo1.entity.BaseException;
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

    public void addUser(String userName, String passWord, String email, String nickName) throws BaseException {
        if(passWord == null || passWord.length() < 6) {
            throw new BaseException("密码格式有误", 506) ;
        }
        if(email == null || email.length() < 6) {
            throw new BaseException("邮箱格式有误", 506) ;
        }
        Integer numByEmail = userRepository.countUserByEmail(email);
        Integer numByUserName = userRepository.countUserByUserName(userName);
        if(numByEmail > 0) {
            throw new BaseException("该邮箱已被使用", 506);
        }
        if(numByUserName > 0) {
            throw new BaseException("该用户名已被占用", 506);
        }
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassWord(passWord);
        user.setNickName(nickName);
        userRepository.save(user);

    }


}
