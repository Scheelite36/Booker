package com.example.booker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.booker.entity.Evaluation;
import com.example.booker.entity.Member;
import com.example.booker.mapper.EvaluationMapper;
import com.example.booker.mapper.MemberMapper;
import com.example.booker.service.EvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Scheelite
 * @date 2022/2/20
 * @email jwei.gan@qq.com
 * @description
 **/
@Service("EvaluationService")
@Slf4j
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation>
        implements EvaluationService {

    @Resource
    MemberMapper memberMapper;

    @Override
    public List<Evaluation> getEvaluation(Long bookId){
        LambdaQueryWrapper<Evaluation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Evaluation::getBookId,bookId).eq(Evaluation::getState,"enable")
                .orderByDesc(Evaluation::getCreateTime);
        List<Evaluation> evaluations = this.baseMapper.selectList(queryWrapper);
        evaluations.forEach(item -> {
            Member member = memberMapper.selectById(item.getMemberId());
            item.setMember(member);
        });
        return evaluations;
    }
}
