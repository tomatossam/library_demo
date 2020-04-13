package com.springboot.demo1.controller;

import com.springboot.demo1.entity.Books;
import com.springboot.demo1.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BooksController {

    @Resource
    private BooksService booksService;

    @PostMapping(value = "/get")
    @ResponseBody
    public List<Books> getBooksList(){
        return booksService.getBooksList();
    }

}
