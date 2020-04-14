package com.springboot.demo1.controller;

import com.springboot.demo1.entity.BaseException;
import com.springboot.demo1.entity.Response;
import com.springboot.demo1.service.BorrowInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/borrowInfo")
public class BorrowInfoController {

    @Resource
    private BorrowInfoService borrowInfoService;

    /**
     * 获取借阅信息列表
     */
    @PostMapping(value = "/get")
    public Response getBorrowInfoList() {
        return new Response().normalResponse(borrowInfoService.getBorrowInfoList());
    }

    /**
     * 借书/还书
     */
    @PostMapping(value = "/update/{userId}/{bookId}/{type}")
    public Response updateBorrowInfo(@PathVariable Integer userId,@PathVariable Integer bookId,@PathVariable Integer type) throws BaseException {
        borrowInfoService.updateBorrowInfoList(userId, bookId, type);
        return new Response().normalResponse();
    }

}
