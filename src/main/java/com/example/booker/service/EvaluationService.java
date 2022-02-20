package com.example.booker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.booker.entity.Evaluation;

import java.util.List;

/**
 * @author Scheelite
 * @date 2022/2/20
 * @email jwei.gan@qq.com
 * @description
 **/
public interface EvaluationService extends IService<Evaluation> {

    /**
     * 获取评价信息
     * @param bookId
     * @return
     */
    List<Evaluation> getEvaluation(Long bookId);
}
