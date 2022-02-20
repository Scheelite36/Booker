package com.example.booker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author Scheelite
 * @date 2021/12/12
 * @email jwei.gan@qq.com
 * @description
 **/

@TableName("test_book_reader")
public class TestTable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String content;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
