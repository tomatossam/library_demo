package com.springboot.demo1.service.impl;

import com.springboot.demo1.entity.BaseException;
import com.springboot.demo1.entity.BorrowInfo;

import java.util.List;

public interface BorrowInfoServiceImpl {

    public List<BorrowInfo> getBorrowInfoList();

    public void updateBorrowInfoList(Integer userId, Integer bookId, Integer type) throws BaseException;

}
