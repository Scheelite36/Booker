package com.example.booker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.booker.consts.ResponseEnum;
import com.example.booker.entity.Evaluation;
import com.example.booker.entity.Member;
import com.example.booker.exception.BussinessException;
import com.example.booker.mapper.EvaluationMapper;
import com.example.booker.mapper.MemberMapper;
import com.example.booker.service.EvaluationService;
import com.example.booker.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author Scheelite
 * @date 2022/2/20
 * @email jwei.gan@qq.com
 * @description
 **/
@Service("EvaluationService")
@Slf4j
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation>
        implements EvaluationService {

    @Resource
    MemberMapper memberMapper;

    @Override
    public List<Evaluation> getEvaluation(Long bookId) {
        LambdaQueryWrapper<Evaluation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Evaluation::getBookId, bookId).eq(Evaluation::getState, "enable")
                .orderByDesc(Evaluation::getCreateTime);
        List<Evaluation> evaluations = this.baseMapper.selectList(queryWrapper);
        evaluations.forEach(item -> {
            Member member = memberMapper.selectById(item.getMemberId());
            item.setMember(member);
        });
        return evaluations;
    }

    @Override
    public void evaluate(Long bookId, Integer score, String content){
        Long memberId = UserUtils.getMemberId();
        LambdaQueryWrapper<Evaluation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Evaluation::getBookId,bookId).eq(Evaluation::getMemberId,memberId);
        Evaluation one = this.getOne(queryWrapper);
        Evaluation build = Evaluation.builder().content(content).bookId(bookId).
                score(score).memberId(memberId).createTime(Date.valueOf(LocalDate.now())).build();
        if (!Objects.isNull(one)) {
            build.setEvaluationId(one.getEvaluationId());
        }
        // 更新id来判断是否更新或保存
        this.saveOrUpdate(build);
    }

    @Override
    public Evaluation getOneBySelect(Long memberId, Long bookId){
        LambdaQueryWrapper<Evaluation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Evaluation::getBookId,bookId).eq(Evaluation::getMemberId,memberId);
        return this.getOne(queryWrapper);
    }

    @Override
    public Evaluation enjoy(Long evaluationId){
        LambdaQueryWrapper<Evaluation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Evaluation::getEvaluationId,evaluationId);
        Evaluation one = this.getOne(queryWrapper);
        if (Objects.isNull(one)){
            throw new BussinessException(ResponseEnum.NOT_EXSIT.getCode(),"记录不存在");
        }
        one.setEnjoy(one.getEnjoy()+1);
        this.saveOrUpdate(one);
        return one;
    }
}
