import com.gmgx.dao.IBrandDao;
import com.gmgx.dao.ICommodityDao;
import com.gmgx.entity.Brand;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestICommodityDao {
    SqlSession session   =null;
    ICommodityDao commodityDao =null;

    @Before
    public  void beforeMethod(){
        // 1 找到 sqlmapConfig.xml
        String name  ="SqlMapConfig.xml";
        // 实际上 要从工程角度出发，当前这个文件是在工程的相对位置 得到它的io流
        InputStream is  = TestICommodityDao.class.getClassLoader().getResourceAsStream(name);

        // 2 把它加载到 sql会话工厂中 帮你解析(给工厂 加载 了 装备（指导书）)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 3 通过会话工程 ，获得一个 sql会话
        session   =  sessionFactory.openSession();

        commodityDao  =  session.getMapper(ICommodityDao.class);
    }
    @After
    public void afterMethod(){

        // 6 关闭资源
        session.close();

    }

    @Test
    public void testQueryAllCommodityByCommodityName(){
        System.out.println(commodityDao.queryAllCommodityByCommodityName("苹果"));
    }

    @Test
    public void testQueryAllCommodityByChoose(){
        System.out.println(commodityDao.queryAllCommodityByChoose("销量","降序"));
    }
}
