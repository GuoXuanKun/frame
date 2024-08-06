package com.gmgx.controller;

import com.gmgx.entity.Address;
import com.gmgx.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
@RequestMapping("addAddress")
    public ModelAndView addAddress(Integer aid,String name,String phone,String addr){

        System.out.println("aid:"+aid);
        System.out.println("name:"+name);
        System.out.println("phone:"+phone);
        System.out.println("addr:"+addr);
        ModelAndView mv  = new ModelAndView();
        return mv;
    }

    @RequestMapping("addAddress2")
    public ModelAndView addAddress2(Address addr){

        System.out.println("aid:"+addr.getAid());
        System.out.println("name:"+addr.getName());
        System.out.println("phone:"+addr.getPhone());
        System.out.println("addr:"+addr.getAddr());
        ModelAndView mv  = new ModelAndView();
        return mv;
    }

    @RequestMapping("addUser")
    public ModelAndView addUser(User user){

        System.out.println("uid:"+user.getUid());
        System.out.println("username:"+user.getUid());
        System.out.println("password:"+user.getUid());
        System.out.println("hobbys:");
       for(String hobby: user.getHobbys()){
           System.out.println("hobby:"+hobby);

       }
        System.out.println(user.getPhoneList());


        ModelAndView mv  = new ModelAndView();
        return mv;
    }

    @RequestMapping("addHobbys")
    public ModelAndView addHobbys(String[] hobbys){
        System.out.println("hobbys:");
        for(String hobby: hobbys){
            System.out.println("hobby:"+hobby);
        }

        ModelAndView mv  = new ModelAndView();
        return mv;
    }

    @RequestMapping("addPhoneList")
    /*  请求中：SpringMVC 识别  默认识别 如果使用 类对象来接数据，以POJO 普通级的java对象的方式接数据
    *   无脑：看一下这个类对象 有没有 一个 phoneList 属性，然后调用它 的构造方法，给他set数据
    *   我们用的List类型 集合 接口 所以没有办法直接new对象，同样也没有 phoneList这个属性名
    *java.lang.IllegalStateException: No primary or default constructor found for interface java.util.List
    * 解决方案：  @RequestParam("phoneList")
    * @RequestParam("phoneList") 2个作用：
    * 1 参数名  （当参数名和页面发过来的不一致，可以通过 @RequestParam("phoneList") 去个别名）
    * 2 让 SpringMVC 识别到 当前的这个参数比较特殊：判断，集合的话，就用集合的方式处理
    *  */
    public ModelAndView addPhoneList(@RequestParam("phoneList") List<String> phoneList){
        System.out.println("phoneList:"+phoneList);
        ModelAndView mv  = new ModelAndView();
        return mv;
    }


    @RequestMapping("addUserAndDog")
    public ModelAndView addUserAndDog(User user){
        System.out.println("user:"+user);

        ModelAndView mv  = new ModelAndView();
        return mv;
    }



    @RequestMapping("addUserAndAddress")
    public ModelAndView addUserAndAddress(User user){
        System.out.println("user:"+user);

        ModelAndView mv  = new ModelAndView();
        return mv;
    }
}
