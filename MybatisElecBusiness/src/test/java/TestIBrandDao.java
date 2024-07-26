import com.gmgx.dao.IBrandDao;
import com.gmgx.entity.Brand;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class TestIBrandDao {
    SqlSession session   =null;
    IBrandDao brandDao =null;

    @Before
    public  void beforeMethod(){
        // 1 找到 sqlmapConfig.xml
        String name  ="SqlMapConfig.xml";
        // 实际上 要从工程角度出发，当前这个文件是在工程的相对位置 得到它的io流
        InputStream is  = TestIBrandDao.class.getClassLoader().getResourceAsStream(name);

        // 2 把它加载到 sql会话工厂中 帮你解析(给工厂 加载 了 装备（指导书）)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3 通过会话工程 ，获得一个 sql会话
        session   =  sessionFactory.openSession();

        brandDao  =  session.getMapper(IBrandDao.class);
    }
    @After
    public void afterMethod(){

        // 6 关闭资源
        session.close();

    }

    @Test
    public void testQueryAllBrand(){
        System.out.println(brandDao.queryAllBrand());
    }

    @Test
    public void testQueryDescription(){
        System.out.println(brandDao.queryDescription(1));
    }

    @Test
    public void testQueruBrandByMultipleConditions(){
        System.out.println(brandDao.queruBrandByMultipleConditions(1, "米", "里"));
    }

    @Test
    public void testInsertBrand(){

        brandDao.insertBrand(new Brand("oppo","这里是企业描述",1,"111111","1"));

        session.commit();
    }

    @Test
    public void testDeleteBrand(){
        brandDao.deleteBrand(4);
        session.commit();
    }

    @Test
    public void testUpdateBrand(){

        brandDao.updateBrand(new Brand(5,"三星","这里是企业描述",1,"111111","1"));

        session.commit();
    }

    @Test
    public void testqueryBrandByChoose3(){
        System.out.println(brandDao.queryBrandByChoose3("当前状态", "1"));
    }
}
