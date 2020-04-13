package com.springboot.demo1.service.impl;

import com.springboot.demo1.entity.BorrowInfo;

import java.util.List;

public interface BorrowInfoServiceImpl {

    public List<BorrowInfo> getBorrowInfoList();

    public String updateBorrowInfoList(BorrowInfo borrowInfo);

}
