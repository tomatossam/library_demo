package com.springboot.demo1.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@DynamicUpdate(true)
public class BorrowInfo {

    /**
     * 借阅信息ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer borrowId;

    /**
     * 用户ID
     */
    @Column(nullable = false)
    private Integer userId;

    /**
     * 书籍ID
     */
    @Column(nullable = false)
    private Integer bookId;

    /**
     * 借阅状态 ==1表示借书 ==0表示还书
     */
    @Column(nullable = false)
    private Integer type;

    @Column
    private Date borrowTime;

    @Column
    private Date returnTime;

}
