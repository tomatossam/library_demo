package com.springboot.demo1.controller;

import com.springboot.demo1.entity.BaseException;
import com.springboot.demo1.entity.Books;
import com.springboot.demo1.entity.Response;
import com.springboot.demo1.service.BooksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    @Resource
    private BooksService booksService;

    /**
     * 获取图书列表
     */
    @PostMapping(value = "/get")
    public Response getBooksList(){
        List<Books> booksList = booksService.getBooksList();
        return new Response().normalResponse(booksList);
    }

    /**
     * 根据书本ID查找书籍
     * @param bookId
     * @return
     */
    @PostMapping(value = "/get/{bookId}")
    public Response getBookById(@PathVariable Integer bookId) throws BaseException{
        Books books = booksService.getBookById(bookId);
        return new Response().normalResponse(books);
    }

    /**
     * 添加书籍
     * @param bookName
     * @return
     * @throws BaseException
     */
    @PostMapping(value = "/add/{bookName}")
    public Response addBook(@PathVariable String bookName) throws BaseException{
        Response response = new Response();
        booksService.addBook(bookName);
        return response.normalResponse();
    }

    /**
     * 根据书本ID删除书籍
     * @param bookId
     * @return
     */
    @PostMapping(value = "/delete/{bookId}")
    public Response deleteBook(@PathVariable Integer bookId) throws BaseException{
        Response response = new Response();
        booksService.deleteBook(bookId);
        return response.normalResponse();
    }

}
