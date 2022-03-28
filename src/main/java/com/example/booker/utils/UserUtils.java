package com.example.booker.utils;

import com.example.booker.entity.Member;

import java.util.Objects;

/**
 * @author Scheelite
 * @date 2022/3/20
 * @email jwei.gan@qq.com
 * @description
 **/
public class UserUtils {
    private static final ThreadLocal<Member> memberThreadLocal = new ThreadLocal<>();

    public static void setMember(Member member){
        memberThreadLocal.set(member);
    }

    public static Member getMember(){
        return memberThreadLocal.get();
    }

    public static void removeMember(){
        memberThreadLocal.remove();
    }

    public static Long getMemberId(){
        Member member = memberThreadLocal.get();
        if (Objects.isNull(member)) {
            return null;
        }
        return member.getMemberId();
    }
}
