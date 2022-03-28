package com.example.booker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Scheelite
 * @date 2022/3/20
 * @email jwei.gan@qq.com
 * @description
 **/
@TableName("member_read_state")
@Getter
@Setter
@Builder
public class MemberReadState {

    @TableId(type = IdType.AUTO)
    private Long rsId;

    private Long bookId;

    private Long memberId;

    private Integer readState;

    private LocalDate createTime;
}
