package com.fall.springboot04data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        // 查看默认数据
        System.out.println(dataSource.getClass());

        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);


        // xxxTemplate: SpringBoot配置好的模板bean

        connection.close();
    }

}
