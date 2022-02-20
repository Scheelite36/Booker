package com.example.booker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Scheelite
 * @date 2022/1/18
 * @email jwei.gan@qq.com
 * @description 图书分类对应的实体类
 **/

@Getter
@Setter
@TableName("category")
@ToString
public class Category {

    @TableId(type = IdType.AUTO)
    private Long categoryId;

    private String categoryName;

}
