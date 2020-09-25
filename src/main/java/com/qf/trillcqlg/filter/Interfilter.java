package com.qf.trillcqlg.filter;

import com.qf.trillcqlg.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interfilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //请求之前添加代码
        //获取请求的地址
        String uri = httpServletRequest.getRequestURI();
        if(!uri.contains("/login.html")){
            User user =(User) httpServletRequest.getSession().getAttribute("user");
            if(user==null){
                //需要跳转到登陆界面
                httpServletResponse.sendRedirect("/login.html");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
