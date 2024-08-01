import com.gmgx.entity.Classroom;
import com.gmgx.entity.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean2 {
    ClassPathXmlApplicationContext applicationContext =null;

    @Before
    public void beforeMethod(){
        String fileName  = "applicationContext2.xml";

         applicationContext =    new   ClassPathXmlApplicationContext(fileName);

    }

    @After
    public void afterMethod(){
        applicationContext.close();
    }


    @Test
    public void test1(){

      Teacher t1   = (Teacher) applicationContext.getBean("t1");
        System.out.println(t1);

    }


    @Test
    public void test2(){

        Classroom c2   = (Classroom) applicationContext.getBean("c2");
        System.out.println(c2);

    }


}
