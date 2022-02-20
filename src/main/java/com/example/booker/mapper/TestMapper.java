package com.example.booker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.booker.entity.TestTable;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Scheelite
 * @date 2021/12/7
 * @email jwei.gan@qq.com
 * @description
 **/

public interface TestMapper extends BaseMapper<TestTable> {
    void insertTest();
}
