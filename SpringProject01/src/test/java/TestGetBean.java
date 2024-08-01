import com.gmgx.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {

    @Test
    public void test01(){


        String fileName  = "applicationContext.xml";

        ClassPathXmlApplicationContext applicationContext =    new   ClassPathXmlApplicationContext(fileName);

        Student stu1  = (Student) applicationContext.getBean("stu1");

        System.out.println(stu1);

    }
}
