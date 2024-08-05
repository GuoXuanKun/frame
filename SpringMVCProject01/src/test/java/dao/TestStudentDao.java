package dao;

import com.gmgx.dao.StudentDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentDao {

    @Test
    public  void testQueryAllStudent(){

        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
       // StudentDao studentDao  =  new StudentDao(); 不能直接new，因为 JDBCUtils对象通过 IOC DI 方式获得的，并非自己new，
        StudentDao studentDao  =       applicationContext.getBean(StudentDao.class);
        System.out.println(studentDao.queryAllStudent());

    }

}
