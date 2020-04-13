package com.springboot.demo1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BorrowInfo {

    //借阅信息ID
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer borrowId;

    //用户ID
    @Column(nullable = false)
    private Integer userId;

    //书籍ID
    @Column(nullable = false)
    private Integer bookId;

    //借阅状态 ==1表示借书 ==0表示还书
    @Column(nullable = false)
    private Integer type;

}
