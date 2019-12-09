package com.boot.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
自定义拦截器
登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("LoginUser");
        if(user == null){ //未登录，返回登录界面
            request.setAttribute("msg","没有权限，请先登录！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{            //已登录
            return true;
        }
    }
}
