package com.gmgx.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 使用注解方式 配到 Spring容器中 */
@Component
public class VisitInterceptor2 implements HandlerInterceptor {  // 实现 处理拦截器 接口 实现三个方法


    /*  访问目标前   相当于 过滤器的 doFilter方法   */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle");

        /* 判断 访问路径是否 带 login，有就放行 */
       if( request.getRequestURI().contains("login")){
           return true;
       }

       //  false 拒绝访问 true 放行
        // /* 判断 session中是否有 my属性，有代表登录过了，可以继续访问（放行） */
        HttpSession session  = request.getSession();
       Object my  =      session.getAttribute("my");
       if(my!=null){
           return true;
        }
            //  如果没有，则 重定向到 登录界面，并显示 信息（session中）
            session.setAttribute("msg","请先登录后，再访问");
            response.sendRedirect("login.jsp");
        return false;
    }
    /*  访问后，控制类方法之后，回到 前置控制器 之前（视图还没渲染）  */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
        request.setAttribute("info","招生简介：联系人~~~~");




            // 执行完 控制器方法之后，还可以做一些调整（比如 添加、删除 修改 一个 request 中属性 ）

    }
    /*  访问后，  */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /*  访问后，控制类方法之后，回到 前置控制器 之后（视图已经渲染）  */
        System.out.println("afterCompletion");
        request.removeAttribute("info");
    // 我的场景，每次使用完 msg 数据，就会 remove ，
        // 所以，我直接在这里写？
        request.getSession().removeAttribute("msg");
    }
}
