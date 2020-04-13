package com.springboot.demo1.controller;

import com.springboot.demo1.entity.Books;
import com.springboot.demo1.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    @Resource
    private BooksService booksService;

    //获取图书列表
    @PostMapping(value = "/get")
    public List<Books> getBooksList(){
        return booksService.getBooksList();
    }

    //根据书本ID查找书籍
    @PostMapping(value = "/get/{bookId}")
    public Books getBookById(@PathVariable Integer bookId){
        return booksService.getBookById(bookId);
    }

    //添加书籍
    @PostMapping(value = "/add/{bookName}")
    public String addBook(@PathVariable String bookName) {
        if(bookName == null || bookName.length() < 1) {
            return "书名信息有误";
        } else {
            String res = booksService.addBook(bookName);
            if(res != null) {
                return res;
            } else {
                return "内部错误";
            }
        }
    }

    //根据书本ID删除书籍
    @PostMapping(value = "/delete/{bookId}")
    public String deleteBook(@PathVariable Integer bookId) {
        String res = booksService.deleteBook(bookId);
        if(res != null) {
            return res;
        } else {
            return "内部错误";
        }
    }

}
