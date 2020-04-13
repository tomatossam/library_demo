package com.springboot.demo1.controller;

import com.springboot.demo1.entity.BorrowInfo;
import com.springboot.demo1.service.BorrowInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/borrowInfo")
public class BorrowInfoController {

    @Resource
    private BorrowInfoService borrowInfoService;

    @PostMapping(value = "/get")
    @ResponseBody
    public List<BorrowInfo> getBorrowInfoList() {
        return borrowInfoService.getBorrowInfoList();
    }

    @PostMapping(value = "/update/{userId}/{bookId}/{type}")
    @ResponseBody
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
