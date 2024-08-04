import com.gmgx.entity.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean8 {

    ClassPathXmlApplicationContext applicationContext= null;

    @Before
    public void beforeMethod(){
        String fileName  ="applicationContext8.xml";
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

        Teacher t2 = (Teacher) applicationContext.getBean("t2");
        System.out.println(t2);

        System.out.println(t1.getClassroom()==t2.getClassroom());

    }




}
