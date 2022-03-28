package com.example.booker.filter;

import com.example.booker.consts.Consts;
import com.example.booker.entity.Member;
import com.example.booker.utils.UserUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Scheelite
 * @date 2022/3/20
 * @email jwei.gan@qq.com
 * @description 登陆过滤器
 **/
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute(Consts.BOOKER_MEMBER);
        if (Objects.isNull(member)) {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
        // 放入线程安全的用户对象中
        UserUtils.setMember(member);
        try{
            // 继续对请求进行过滤
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            // 请求完成后释放用户对象
            UserUtils.removeMember();
        }
    }
}
