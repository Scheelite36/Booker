package com.example.booker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @author Scheelite
 * @date 2022/2/20
 * @email jwei.gan@qq.com
 * @description
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("evaluation")
public class Evaluation {

    @TableId(type = IdType.AUTO)
    private Long evaluationId;

    private String content;

    private Integer score;

    private Date createTime;

    private Long memberId;

    private Long bookId;

    private Integer enjoy;

    private String disableReason;

    private Date disableTime;

    private String state;

    @TableField(exist = false)
    private Book book;

    @TableField(exist = false)
    private Member member;
}
