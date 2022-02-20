package com.example.booker.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 * @author Scheelite
 * @date 2022/2/20
 * @email jwei.gan@qq.com
 * @description
 **/
@TableName("member")
@Getter
@Setter
@ToString
public class Member {

    @TableId(type = IdType.AUTO)
    private Long memberId;

    private String username;

    private String password;

    private String nickname;

    private Integer salt;

    private Date createTime;
}
