package com.springboot.demo1.service;

import com.springboot.demo1.dao.BooksRepository;
import com.springboot.demo1.dao.BorrowInfoRepository;
import com.springboot.demo1.entity.BaseException;
import com.springboot.demo1.entity.Books;
import com.springboot.demo1.entity.BorrowInfo;
import com.springboot.demo1.service.impl.BorrowInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowInfoService implements BorrowInfoServiceImpl {

    @Autowired
    private BorrowInfoRepository borrowInfoRepository;
    @Autowired
    private BooksRepository booksRepository;

    public List<BorrowInfo> getBorrowInfoList(){
        return borrowInfoRepository.findAll();
    }

    public void updateBorrowInfoList(Integer userId, Integer bookId, Integer type) throws BaseException {
        if (userId == null || bookId == null || type == null) {
            throw new BaseException("参数为空", 506);
        }
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setUserId(userId);
        borrowInfo.setBookId(bookId);
        borrowInfo.setType(type);
        //根据传进的用户ID和书籍ID查找是否有过借书记录
        BorrowInfo borrowInfo1 = borrowInfoRepository.getBorrowInfoByUserIdAndBookId(userId, bookId);
        Books books = booksRepository.findBooksByBookId(bookId);
        if(books == null){
            throw new BaseException("不存在该书籍", 506) ;
        }
        //根据书籍ID查找该书籍
        if (null != borrowInfo1) {
            //type==1表示借书，bookState==1表示书籍已借出
            if (type == 1 && books.getBookState() == 0) { //借书
                borrowInfo.setBorrowId(borrowInfo1.getBorrowId()); //将对应借书记录进行修改
                borrowInfo.setBorrowTime(new Date());
                books.setBookState(1);
            } else if (type == 0 && books.getBookState() == 1) { //还书
                borrowInfo.setBorrowId(borrowInfo1.getBorrowId());
                borrowInfo.setBorrowTime(borrowInfo1.getBorrowTime());
                borrowInfo.setReturnTime(new Date());
                books.setBookState(0);
            } else if (type == 1 && books.getBookState() == 1) {
                throw new BaseException("该书籍已被借出", 506);
            } else {
                throw new BaseException("操作错误", 506);
            }
        } else {//原先没有借书记录，此时必为借书
            if (type == 0) {
                throw new BaseException("操作错误", 506);
            } else if (books.getBookState() == 1) {
                throw new BaseException("该书籍已被借出", 506);
            } else {
                borrowInfo.setBorrowTime(new Date());
                if(books.getBookState() == 0) {
                    books.setBookState(1);
                } else {
                    books.setBookState(0);
                }
            }
        }
        borrowInfoRepository.save(borrowInfo);
        booksRepository.save(books);
    }
}
