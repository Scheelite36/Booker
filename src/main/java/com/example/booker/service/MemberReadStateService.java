package com.example.booker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.booker.entity.MemberReadState;

/**
 * @author Scheelite
 * @date 2022/3/20
 * @email jwei.gan@qq.com
 * @description
 **/

public interface MemberReadStateService extends IService<MemberReadState> {
    /**
     * 获取用户的某一本图书的阅读状态
     * @param bookId
     * @param memberId
     * @return
     */
    MemberReadState getState(Long bookId, Long memberId);

    /**
     * 更新用户的阅读状态
     * @param bookId
     * @param readState
     */
    void updateReadState(Long bookId, Integer readState);
}
