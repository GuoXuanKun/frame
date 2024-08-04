package com.gmgx.controller;

import com.gmgx.service.IClassroomService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/*
 * 如果是控制层：使用 @Controller注解 来表示
 * */
@Controller
public class ClassroomController {
    /*
    如果只存在一个对应类型的实现类，直接用即可（相当于是 之前设置的 byType）
    如果存在 多个 同类型的实现类：怎么区分？
    *   1 通过 通过属性名来判定（ 属性名等于 对应 实现类的首字母小写 方式  ） 缺点：一处修改，处处修改
    *   2 在@Resource后面加个属性：name值 等于 对应 实现类的首字母小写 缺点：如果当前方法是我写的，实现类是别人写的，我不能因为别人的修改，一直我的代码
        3 修改实现类上的注解  比如 ：@Service("名字") 名字 和我的属性名同名，则使用该 实现类（注入该实现类的对象）
    *  */
    @Resource
//    @Resource(name = "classroomServiceImpl2")
    private IClassroomService classroomService;

    public boolean login(String username, String password){
        return classroomService.login(username,password);

    }

    public ClassroomController() {

        System.out.println("ClassroomController的无参构造");
    }
}
