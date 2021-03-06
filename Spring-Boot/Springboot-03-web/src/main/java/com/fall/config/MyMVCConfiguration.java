package com.fall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;


/** 如果想自定义一些功能，只要写这个组件然后将它交给springboot，springboot就会帮我们自动装配
 *  如果此类使用@EnableWebMvc注释，就是导入了DelegatingWebConfiguration类，会使自动配置默认属性失效
 * */
@Configuration
public class MyMVCConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("coming/index");
        registry.addViewController("/index.html").setViewName("coming/index");
        registry.addViewController("/creative").setViewName("creative/index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/static/**");
    }

    // 试图跳转
    /*** @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/fox").setViewName("test");
    }

    // viewResolver 实现试图解析器接口的类，我们就可以把它看成试图解析器
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    // 定义一个自己的视图解析器myViewResolver
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }*/
}
