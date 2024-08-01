import com.gmgx.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class TestGetBean {
    ClassPathXmlApplicationContext applicationContext =null;

    @Before
    public void beforeMethod(){
        String fileName  = "applicationContext.xml";

        applicationContext =    new   ClassPathXmlApplicationContext(fileName);

    }

    @After
    public void afterMethod(){
        applicationContext.close();
    }

    @Test
    public void test01(){



        System.out.println("======= 调用getBean之前=========");

        //单例模式下：getBean去容器中找 对象 原型模式：只会让容器创建出一个新对象，给我们用
        Student stu1  = (Student) applicationContext.getBean("stu1");
        Student stu2  = (Student) applicationContext.getBean("stu1");
        System.out.println("======= 调用getBean之后=========");

//        Student stu2  = (Student) applicationContext.getBean("stu");
        System.out.println("======= 使用这个对象之前=========");
        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println(stu1==stu2);
        System.out.println("======= 使用这个对象之后=========");
        System.out.println("======= 关闭上下文对象之前=========");
        applicationContext.close();
        System.out.println("======= 关闭上下文对象之后=========");

    }


    @Test
    public void test02(){

        // 1 使用的是 setter 的方式 赋值
        Student stu1  = (Student) applicationContext.getBean("stu2");




    }
    @Test
    public void test03(){

        // 1 使用的是 setter 的方式 赋值
        Student stu3  = (Student) applicationContext.getBean("stu3");
        System.out.println(stu3);


    }

    /**
     * 测试 如果数据 非 基本数据类型 （比如 数组  或集合 元素类型 是 基本数据类型 或 字符串 ） 怎么赋值
     */
    @Test
    public void test04(){

        // 1 使用的是 setter 的方式 赋值
//        Student stu  = (Student) applicationContext.getBean("stu6");

        Student stu  = (Student) applicationContext.getBean("stu7");
        for (Integer score:stu.getScoreArr()){
            System.out.println(score);
        }


    }

    @Test
    public void test05(){

        // 1 使用的是 setter 的方式 赋值
//        Student stu  = (Student) applicationContext.getBean("stu6");

        Student stu  = (Student) applicationContext.getBean("stu8");
        for (String addr:stu.getAddrList()){
            System.out.println(addr);
        }


    }

    @Test
    public void test06(){

        // 1 使用的是 setter 的方式 赋值
//        Student stu  = (Student) applicationContext.getBean("stu6");

        Student stu  = (Student) applicationContext.getBean("stu9");
        Map<Integer,String> phoneMap  = stu.getPhoneMap();
        for (Integer key:phoneMap.keySet()){
            System.out.println(phoneMap.get(key));
        }

    }


    public   void test(){

        // set方式赋值
        Student stu1  = new Student();
        stu1.setSno(1);
        stu1.setSname("zhw");
//        通过构造方法的方式赋值
        new Student(3,"bai");


        Student stu2  = new Student();
        stu2.setSno(2);
        stu2.setSname("zhw2");


    }


}
