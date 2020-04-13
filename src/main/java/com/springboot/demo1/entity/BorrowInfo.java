package com.springboot.demo1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BorrowInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer borrowId;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer bookId;

    @Column(nullable = false)
    private Integer type;

}
