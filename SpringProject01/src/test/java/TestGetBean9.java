import com.gmgx.controller.StudentController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean9 {

    ClassPathXmlApplicationContext applicationContext= null;

    @Before
    public void beforeMethod(){
        String fileName  ="applicationContext9.xml";
        applicationContext  = new ClassPathXmlApplicationContext(fileName);

    }
    @After
    public void  afterMethod(){
        applicationContext.close();
    }


    @Test
    public void test1(){
        //

        //通过扫描+注解的方式 取代了原来的逐个 配置bean标签方式，更加简便

        //如何获得这个bean ，getBean
        // 1 没有其他配置；默认  类名首字母小写
        // 2 如果在@Controller(“名字”) 通过 名字
        // 3 直接用类名.class 的方式获得（推荐）


       // System.out.println(applicationContext.getBean("student"));
        System.out.println(applicationContext.getBean(StudentController.class));
        StudentController studentController  =    applicationContext.getBean(StudentController.class);
        System.out.println(studentController.login("1", "zhw"));


    }




}
