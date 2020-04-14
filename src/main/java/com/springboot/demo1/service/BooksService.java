package com.springboot.demo1.service;

import com.springboot.demo1.dao.BooksRepository;
import com.springboot.demo1.entity.BaseException;
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

    public Books getBookById(Integer bookId) throws BaseException{
        if(!booksRepository.findById(bookId).isPresent()) {
            throw new BaseException("书籍不存在", 506);
        }
        return booksRepository.findBooksByBookId(bookId);
    }


    public void addBook(String bookName) throws BaseException {
        if (bookName == null || bookName.length() < 1) {
            throw new BaseException("书名信息有误", 506);
        }
        Integer numByBookName = booksRepository.countBooksByBookName(bookName);
        if (numByBookName > 0) {
            throw new BaseException("该书籍已经存在", 506);
        } else {
            Books books = new Books();
            books.setBookName(bookName);
            books.setBookState(0);  //bookState为0表示书籍未被借出
            booksRepository.save(books);
        }
    }

    public void deleteBook(Integer bookId) throws BaseException {
        if(!booksRepository.findById(bookId).isPresent()) {
            throw new BaseException("书籍不存在", 506);
        }
        booksRepository.deleteById(bookId);
    }

}
