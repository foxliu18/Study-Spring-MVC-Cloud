import com.summer.mapper.UserMapper;
import com.summer.mapper.UserMapperImpl;
import com.summer.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectUser();
        users.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapperImpl bean = context.getBean(UserMapperImpl.class);
        bean.selectUser().forEach(user -> {
            System.out.println(user);
        });

    }
}
