import com.gmgx.controller.ClassroomController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean11 {

    ClassPathXmlApplicationContext applicationContext= null;

    @Before
    public void beforeMethod(){
        String fileName  ="applicationContext10.xml";
        applicationContext  = new ClassPathXmlApplicationContext(fileName);

    }
    @After
    public void  afterMethod(){
        applicationContext.close();
    }


    @Test
    public void test1(){


        ClassroomController controller  =  applicationContext.getBean(ClassroomController.class);

        System.out.println(controller.login("", ""));

    }




}
