package com.springboot.demo1.controller;

import com.springboot.demo1.entity.BorrowInfo;
import com.springboot.demo1.service.BorrowInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/borrowInfo")
public class BorrowInfoController {

    @Resource
    private BorrowInfoService borrowInfoService;

    //获取借阅信息列表
    @PostMapping(value = "/get")
    public List<BorrowInfo> getBorrowInfoList() {
        return borrowInfoService.getBorrowInfoList();
    }

    //借书还书
    @PostMapping(value = "/update/{userId}/{bookId}/{type}")
    public String updateBorrowInfo(@PathVariable Integer userId,@PathVariable Integer bookId,@PathVariable Integer type) {
        if(userId == null || bookId == null || type == null) {
            return "error 504";
        } else {
            BorrowInfo borrowInfo = new BorrowInfo();
            borrowInfo.setUserId(userId);
            borrowInfo.setBookId(bookId);
            borrowInfo.setType(type);
            String res = borrowInfoService.updateBorrowInfoList(borrowInfo);
            if(res != null) {
                return res;
            } else {
                return "内部错误";
            }
        }
    }

}
