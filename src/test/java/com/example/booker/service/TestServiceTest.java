package com.example.booker.service;

import com.example.booker.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Scheelite
 * @date 2021/12/12
 * @email jwei.gan@qq.com
 * @description
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServiceTest {
    @Resource
    TestMapper testMapper;
    @Autowired
    TestService service;

    @Test
    public void insert(){
        testMapper.insertTest();
    }

    @Test
    public void insert2(){
        service.insert();
    }

    @Test
    public void delete(){
        service.delete();
    }

    @Test
    public void update(){
        service.update();
    }


}
