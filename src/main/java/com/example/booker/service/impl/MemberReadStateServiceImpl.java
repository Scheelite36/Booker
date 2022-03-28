package com.example.booker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.booker.entity.MemberReadState;
import com.example.booker.mapper.MemberReadStateMapper;
import com.example.booker.service.MemberReadStateService;
import com.example.booker.service.MemberService;
import com.example.booker.utils.UserUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Scheelite
 * @date 2022/3/20
 * @email jwei.gan@qq.com
 * @description
 **/
@Service("MemberReadStateService")
public class MemberReadStateServiceImpl extends ServiceImpl<MemberReadStateMapper, MemberReadState>
        implements MemberReadStateService {

    @Override
    public MemberReadState getState(Long bookId, Long memberId){
        LambdaQueryWrapper<MemberReadState> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MemberReadState::getBookId,bookId).eq(MemberReadState::getMemberId,memberId);
        MemberReadState one = this.getOne(queryWrapper);
        if (Objects.isNull(one)) {
            return null;
        }
        return one;
    }

    @Override
    public void updateReadState(Long bookId, Integer readState){
        Long memberId = UserUtils.getMemberId();
        LambdaQueryWrapper<MemberReadState> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MemberReadState::getBookId,bookId).eq(MemberReadState::getMemberId,memberId);
        MemberReadState one = this.getOne(queryWrapper);
        MemberReadState build = MemberReadState.builder().readState(readState).memberId(memberId).bookId(bookId).createTime(LocalDate.now()).build();
        if (!Objects.isNull(one)) {
            build.setRsId(one.getRsId());
        }
        this.saveOrUpdate(build);
    }
}
