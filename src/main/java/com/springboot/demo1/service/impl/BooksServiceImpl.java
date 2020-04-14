package com.springboot.demo1.service.impl;

import com.springboot.demo1.entity.BaseException;
import com.springboot.demo1.entity.Books;

import java.util.List;

public interface BooksServiceImpl {

    public List<Books> getBooksList();

    public Books getBookById(Integer bookId) throws BaseException;

    public void addBook(String bookName) throws BaseException;

    public void deleteBook(Integer bookId) throws BaseException;

}
