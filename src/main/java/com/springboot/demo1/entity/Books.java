package com.springboot.demo1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Books {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer bookId;

    @Column(nullable = false, unique = true)
    private String bookName;

    @Column(nullable = false)
    private Integer bookState;

}
