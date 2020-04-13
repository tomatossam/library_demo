package com.springboot.demo1;

import com.springboot.demo1.controller.BooksController;
import com.springboot.demo1.controller.BorrowInfoController;
import com.springboot.demo1.entity.BorrowInfo;
import com.springboot.demo1.service.BorrowInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

    @Test
    void contextLoads() {
        BooksController booksController = new BooksController();
        BorrowInfoController borrowInfoController = new BorrowInfoController();
    }

}
