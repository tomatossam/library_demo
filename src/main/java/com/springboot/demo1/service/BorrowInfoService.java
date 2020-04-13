package com.springboot.demo1.service;

import com.springboot.demo1.dao.BooksRepository;
import com.springboot.demo1.dao.BorrowInfoRepository;
import com.springboot.demo1.entity.Books;
import com.springboot.demo1.entity.BorrowInfo;
import com.springboot.demo1.service.impl.BorrowInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String updateBorrowInfoList(BorrowInfo borrowInfo) {
        BorrowInfo borrowInfo1 = new BorrowInfo();
        Books books = new Books();
        books = booksRepository.findBooksByBookId(borrowInfo.getBookId());
        if(books == null){
            return "不存在该书籍";
        }
        //根据传进的用户ID和书籍ID查找是否有过借书记录
        borrowInfo1 = borrowInfoRepository.getBorrowInfoByUserIdAndBookId(borrowInfo.getUserId(), borrowInfo.getBookId());
        //根据书籍ID查找该书籍
        if (null != borrowInfo1) {
            //type==1表示借书，bookState==1表示书籍已借出
            if (borrowInfo.getType() == 1 && books.getBookState() == 0) { //借书
                borrowInfo.setBorrowId(borrowInfo1.getBorrowId()); //将对应借书记录进行修改
                books.setBookState(1);
            } else if (borrowInfo.getType() == 0 && books.getBookState() == 1) { //还书
                borrowInfo.setBorrowId(borrowInfo1.getBorrowId());
                books.setBookState(0);
            } else if (borrowInfo.getType() == 1 && books.getBookState() == 1) {
                return "该书籍已被借出";
            } else {
                return "操作错误";
            }
        } else {//原先没有借书记录，此时必为借书
            if (borrowInfo.getType() == 0) {
                return "操作错误";
            } else if (books.getBookState() == 1) {
                return "该书籍已被借出";
            } else {
                if(books.getBookState() == 0) {
                    books.setBookState(1);
                } else {
                    books.setBookState(0);
                }
            }
        }
        borrowInfoRepository.save(borrowInfo);
        booksRepository.save(books);
        return "操作成功";

    }
}
