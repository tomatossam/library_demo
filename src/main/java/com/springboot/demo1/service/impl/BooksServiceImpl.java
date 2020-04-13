package com.springboot.demo1.service.impl;

import com.springboot.demo1.entity.Books;

import java.util.List;

public interface BooksServiceImpl {

    public List<Books> getBooksList();

    public Books getBookById(Integer bookId);

    public String addBook(String bookName);

    public String deleteBook(Integer bookId);

}