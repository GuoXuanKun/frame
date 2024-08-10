package com.gmgx.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 使用注解方式 配到 Spring容器中 */
@Component
public class VisitInterceptor implements HandlerInterceptor {  // 实现 处理拦截器 接口 实现三个方法


}
