import com.summer.mapper.UserDaoImpl;
import com.summer.mapper.UserDaoMySqlImpl;
import com.summer.mapper.UserDaoOracleImpl;
import com.summer.service.UserService;
import com.summer.service.UserServiceImpl;

public class MyIocTest {


    public static void main(String[] args){

        UserService userService = new UserServiceImpl();

        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
        userService.getUser();

        ((UserServiceImpl) userService).setUserDao(new UserDaoMySqlImpl());
        userService.getUser();

        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
