import com.gmgx.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {

    @Test
    public void test01(){


        String fileName  = "applicationContext.xml";

        ClassPathXmlApplicationContext applicationContext =    new   ClassPathXmlApplicationContext(fileName);
        System.out.println("======= 调用getBean之前=========");

        //单例模式下：getBean去容器中找 对象 原型模式：只会让容器创建出一个新对象，给我们用
        Student stu1  = (Student) applicationContext.getBean("stu");
        Student stu2  = (Student) applicationContext.getBean("stu");
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
}
