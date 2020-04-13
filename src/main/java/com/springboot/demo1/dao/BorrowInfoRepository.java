package com.springboot.demo1.dao;

import com.springboot.demo1.entity.BorrowInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowInfoRepository extends JpaRepository<BorrowInfo, Integer> {

    BorrowInfo getBorrowInfoByUserIdAndBookId(Integer userId, Integer bookId);

}
