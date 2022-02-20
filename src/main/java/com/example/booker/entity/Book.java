package com.example.booker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Scheelite
 * @date 2022/2/1
 * @email jwei.gan@qq.com
 * @description
 **/
@TableName("book")
@Getter
@Setter
@ToString
public class Book {
    @TableId(type=IdType.AUTO)
    private Long bookId;

    private String bookName;

    private String subTitle;

    private String author;

    private String cover;

    private String description;

    private Long categoryId;

    @TableField("evaluation_score")
    private Float score;

    @TableField("evaluation_quantity")
    private Integer quantity;
}
