package com.springboot.demo1.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
public class User {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @Column(nullable = false, unique = true)
    private String userName;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String passWord;

    /**
     * 邮箱
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * 昵称
     */
    @Column(nullable = true, unique = true)
    private String nickName;

}
