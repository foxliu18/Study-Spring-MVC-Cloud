package com.fall.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问，功能业有权限才可以访问
        http.authorizeHttpRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1");


        // 没有权限调回登陆页面, 需要开启登陆页面
        http.formLogin().loginPage("/toLogin")
                .usernameParameter("user") // 接受的用户名和密码
                .passwordParameter("pwd")
                .loginProcessingUrl("/login");

        // 关闭CSRF 防止跨站攻击
        http.csrf().disable();

        // 开启注销
        http.logout().logoutSuccessUrl("/");

        // 开启记住我 存储cookie，默认存两周 自定义接收前端的参数
        http.rememberMe().rememberMeParameter("remember");
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("fox").password(new BCryptPasswordEncoder().encode("1234")).roles("vip1");
    }
}
