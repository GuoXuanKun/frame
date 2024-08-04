import com.gmgx.entity.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean6 {

    ClassPathXmlApplicationContext applicationContext= null;

    @Before
    public void beforeMethod(){
        String fileName  ="applicationContext6.xml";
        applicationContext  = new ClassPathXmlApplicationContext(fileName);

    }
    @After
    public void  afterMethod(){
        applicationContext.close();
    }


    @Test
    public void test1(){
    /*  */
      Teacher t1  = (Teacher) applicationContext.getBean("t1");
        System.out.println(t1);

    }




}
