import com.Student;

import com.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void tsst(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userBean.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
