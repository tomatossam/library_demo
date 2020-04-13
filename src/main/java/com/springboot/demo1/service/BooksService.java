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

    public List<Books> getBooksList() {
        return booksRepository.findAll();
    }

    public Books getBookById(Integer bookId) {
        return booksRepository.findBooksByBookId(bookId);
    }


    public String addBook(String bookName) {
        Integer numByBookName = booksRepository.countBooksByBookName(bookName);
        if(numByBookName > 0) {
            return "该书籍已经存在";
        } else {
            Books books = new Books();
            books.setBookName(bookName);
            books.setBookState(0);  //bookState为0表示书籍未被借出
            booksRepository.save(books);
            return "书籍上传成功";
        }
    }

    public String deleteBook(Integer bookId) {
        booksRepository.deleteById(bookId);
        return "书籍删除成功";
    }

}
