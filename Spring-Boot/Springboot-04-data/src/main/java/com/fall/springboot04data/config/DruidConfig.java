package com.fall.springboot04data.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    // 后台监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid");

        HashMap<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "1234");
        // 允许访问
        initParameters.put("allow","");
        // 禁止访问
        // initParameters.put("fox", "192.168.110.118");

        bean.setInitParameters(initParameters);
        return  bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();

        initParameters.put("exclusions", "*.hs, *.css, /druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }

}
