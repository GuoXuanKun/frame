import com.gmgx.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean4 {

    ClassPathXmlApplicationContext applicationContext= null;

    @Before
    public void beforeMethod(){
        String fileName  ="applicationContext4.xml";
        applicationContext  = new ClassPathXmlApplicationContext(fileName);

    }
    @After
    public void  afterMethod(){
        applicationContext.close();
    }


    @Test
    public void test1(){

    Student s1  = (Student) applicationContext.getBean("stu1");

        System.out.println(s1);


    }


    @Test
    public void test2(){

        Student s2  = (Student) applicationContext.getBean("stu2");

        System.out.println(s2);


    }


}
