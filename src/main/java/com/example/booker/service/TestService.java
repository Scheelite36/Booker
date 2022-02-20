package com.example.booker.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.booker.entity.TestTable;
import com.example.booker.mapper.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Scheelite
 * @date 2021/12/7
 * @email jwei.gan@qq.com
 * @description
 **/
@Service
public class TestService {
    public static final Logger logger = LoggerFactory.getLogger(TestService.class);

    @Autowired
    TestMapper testMapper;

    public void insert(){
        TestTable testTable = new TestTable();
        testTable.setContent("hello mybatis-plus");
        testMapper.insert(testTable);
        logger.info("giao------------");
    }

    public void insertTest(){
        testMapper.insertTest();
    }

    public void delete(){
        testMapper.deleteById(5);
    }
    public void update(){
        TestTable testTable = new TestTable();
        testTable.setContent("update content");
        LambdaUpdateWrapper<TestTable> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(TestTable::getId, 4).set(TestTable::getContent,"wdnmd");
        testMapper.update(null,lambdaUpdateWrapper);
        testTable.setId(3);
        testMapper.updateById(testTable);
    }
}
