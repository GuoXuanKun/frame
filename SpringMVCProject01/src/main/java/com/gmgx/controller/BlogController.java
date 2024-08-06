package com.gmgx.controller;

import com.gmgx.entity.Blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SessionAttributes({"msg"})
/*  当 以下方法中  model或者 modelAndView 对象中 出现 msg 属性，就会把它的值 拷贝一份到session对象中  */
@RequestMapping("blog")
public class BlogController {

    /* 1 和  原来 servlet一样的写法 （不建议） */
    @RequestMapping("test1")
    public void test1(HttpServletRequest request){
       Integer  bno  = Integer.parseInt(request.getParameter("bno"));
    }


    /* 2 写普通 基本数据类型 +字符串 */
    @RequestMapping("test2")
    public void test2(int bno,String content ){
        System.out.println("bno:"+bno);
        System.out.println("content:"+content);
    }


    /* 3 用对象的方式接受前端传过来的参数 */
    @RequestMapping("test3")
    public void test3(Blog blog){
        System.out.println("bno:"+blog.getBno());
        System.out.println("title:"+blog.getTitle());
        System.out.println("content:"+blog.getContent());
    }




    /* 关于跳转 默认  转发到 指定 jsp页面 */
    /*1  通过 request对象转发 或 response  重定向 （不建议） */
    @RequestMapping("test4")
    public void test4(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        /* 如果通过下面这种写法，是不会经过试图解析器 */
        request.getRequestDispatcher("../index.jsp").forward(request,response);
        response.sendRedirect("../index.jsp");





    }


    /* 关于跳转 默认  转发到 指定 jsp页面 */
    /*1 直接用 返回类型为 字符串 写法 */
    @RequestMapping("test5")
    public String test5(){
        return  "index"; // 会根据视图解析器 拼接 /index.jsp
    }



    /* 关于跳转 默认  转发到 指定 jsp页面 */
    /*2 返回值  是 ModelAndView 方式，设置setViewName  */
    @RequestMapping("test6")
    public ModelAndView test6(){

        ModelAndView mv  = new ModelAndView();
        mv.setViewName("index");

        return mv; // 会根据视图解析器,会解读 mv对象，获得路径并拼接 /index.jsp

    }


    /* 关于 响应参数  不推荐  */
    @RequestMapping("test7")
    public String test7(HttpServletRequest request){

        request.setAttribute("content","jintiantianqibucuo");

        return "index"; // 会根据视图解析器,会解读 mv对象，获得路径并拼接 /index.jsp

    }

    /* 关于 传入一个 model对象参数 实现赋值  （不推荐 会和请求参数混在一起）  */
    @RequestMapping("test8")
    public String test8(int sno,String sname,Model model){

        model.addAttribute("bno","123");
        model.addAttribute("title","jttqbc");

        return "index"; // 会根据视图解析器,会解读 mv对象，获得路径并拼接 /index.jsp

    }



    /* 返回值类型 设为 ModelAndView  推荐（请求（入参）和响应（返回值）分离）  */
    @RequestMapping("test9")
    public ModelAndView test9(int sno,String sname){
        ModelAndView mv   = new ModelAndView();
        mv.addObject("bno",123);
        mv.addObject("title","今天天气不错");
        mv.addObject("content","呵呵");

        mv.setViewName("index");


        return mv; // 会根据视图解析器,会解读 mv对象，获得响应数据及路径，并拼接 /index.jsp

    }


    /* 关于 转发：
    * 默认：   mv.setViewName("index"); 转发到指定的jsp页面（会经过视图解析器）
    * 根据需要：
    * 设置 转发 或 重定向  不会经过视图解析器 ，所以需要写全路径
    * 如果涉及到
    *  1 要 跳转到 其他 控制层的方法
    * 登录后（student/login），直接查看全部(sutdent/queryAllStudent)
    *  可以使用 转发 或  重定向
     2 要求，直接重定向到 某个页面：
    * 注册后，直接 重定向到 首页 或者 登录界面
    *
    * 有2种方式：
    * 1 和 Servlet一样，传入 request 和response  ,使用他们进行转发 或重定向（略）
    * 2 在 setViewName(”前缀:xxxx路径“)
    * 运用在 跳转到 某个jsp页面：
    *   重定向 ：redirect   redirect:../main.jsp  (注意 全路径 )
    *   转发： forward   forward:.../main.jsp
    *
    * 运用在 跳转到其他控制层方法：
    *redirect   redirect:queryAllStudent  (重定向到 xxx/queryAllStudent )
    * forward  同理
    * */


    /* 通过   redirect   forward 实现 跳转 页面 （不经过视图解析器）  */
    @RequestMapping("test10")
    public ModelAndView test10(){
        ModelAndView mv   = new ModelAndView();
        mv.addObject("bno",123);
        mv.addObject("title","今天天气不错");
        mv.addObject("content","呵呵");
        // 当前访问路径 blog/test10  -->  要 返回上一级
//        mv.setViewName("redirect:../index.jsp");

        mv.setViewName("forward:../index.jsp"); //经过了视图解析器
        return mv; // 会根据视图解析器,会解读 mv对象，获得响应数据及路径，并拼接 /index.jsp

    }

    /* 通过   redirect   forward 实现  跳转到 其他控制层方法 （不经过视图解析器）  */
    @RequestMapping("test11")
    public ModelAndView test11(){
        ModelAndView mv   = new ModelAndView();

        //mv.setViewName("show"); //至经过了视图解析器 跳转到 页面
        mv.setViewName("redirect:show");// 只能 通过
        // 使用转发或重定向 跳转到 指定控制层方法
        return mv;

    }

    @RequestMapping("show")
    public ModelAndView show(){
        ModelAndView mv   = new ModelAndView();
        mv.addObject("show","实现查询所有的blog信息");

        mv.setViewName("show"); //经过了视图解析器
        return mv; // 会根据视图解析器,会解读 mv对象，获得响应数据及路径，并拼接 /index.jsp

    }


    /* 关于 将数据保存到 request 或 session
    *
    * 如果是 给 model 直接设值，默认在requset范围内的
    *  */
    @RequestMapping("test12")
    public ModelAndView test12(){
        ModelAndView mv   = new ModelAndView();
        /*  默认在requset范围内，所以 重定向的话，就无法拿到数据 */
        mv.addObject("msg","test12的数据");

        mv.setViewName("redirect:../main.jsp");// 只能 通过
        // 使用转发或重定向 跳转到 指定控制层方法
        return mv;

    }

    /*解决方案 三种
    * 1 通过  参数 传入一个requst 对象 getSession setAttribute (不建议)
    * 2 通过   参数 传入一个 session 对象，setAttribute         (不建议)
    * 3 在 类上面添加一个 注解 @SessionAttributes({"msg","my"}) // 值是可以多个的
/*  当 以下方法中  model或者 modelAndView 对象中 出现 msg 属性，就会把它的值 拷贝一份到session对象中

    * */

    @RequestMapping("test13")
    public ModelAndView test13(){
        ModelAndView mv   = new ModelAndView();
        /*  默认在requset范围内，所以 重定向的话，就无法拿到数据 */
        mv.addObject("msg","test13的数据");

        mv.setViewName("redirect:../main.jsp");// 只能 通过
        // 使用转发或重定向 跳转到 指定控制层方法
        return mv;

    }


    @RequestMapping("test14")
    public ModelAndView test14(HttpServletRequest request, HttpSession session){

        request.getSession().setAttribute("msg","data");
        session.setAttribute("msg","data");


        ModelAndView mv   = new ModelAndView();
        /*  默认在requset范围内，所以 重定向的话，就无法拿到数据 */
        mv.addObject("msg","test13的数据");

        mv.setViewName("redirect:../main.jsp");// 只能 通过
        // 使用转发或重定向 跳转到 指定控制层方法
        return mv;

    }




}
