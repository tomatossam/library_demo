package com.springboot.demo1.dao;

import com.springboot.demo1.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {

    Books findBooksByBookId(Integer bookId);

    Integer countBooksByBookName(String bookName);

}
