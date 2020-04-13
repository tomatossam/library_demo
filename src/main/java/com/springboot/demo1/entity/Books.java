package com.springboot.demo1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Books {

    //书籍ID
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer bookId;

    //书名
    @Column(nullable = false, unique = true)
    private String bookName;

    //借阅状态 ==0表示书籍未被借阅 ==1表示书籍已被借阅
    @Column(nullable = false)
    private Integer bookState;

}
