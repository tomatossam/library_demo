package com.springboot.demo1.service;

import com.springboot.demo1.dao.BooksRepository;
import com.springboot.demo1.entity.Books;
import com.springboot.demo1.service.impl.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService implements BooksServiceImpl {

    @Autowired
    private BooksRepository booksRepository;

    public List<Books> getBooksList(){
        return booksRepository.findAll();
    }

}
