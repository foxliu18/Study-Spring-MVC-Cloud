import com.summer.mapper.CourseMapper;
import com.summer.mapper.CourseMapperImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseMapper bean = context.getBean(CourseMapper.class);
        bean.selectUser().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        CourseMapper bean = context.getBean(CourseMapper.class);
        bean.selectUser().forEach(user -> {
            System.out.println(user);
        });

    }
}
