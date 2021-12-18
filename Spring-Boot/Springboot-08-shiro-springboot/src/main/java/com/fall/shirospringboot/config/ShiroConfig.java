package com.fall.shirospringboot.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager
    ){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 授权 正常情况会调到未授权页面
        filterChainDefinitionMap.put("/user/add", "perms[user:add]");
        filterChainDefinitionMap.put("/user/update", "perms[user:update]");

        filterChainDefinitionMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        bean.setUnauthorizedUrl("/noauth");
        bean.setLoginUrl("/toLogin");
        return bean;
    }

    // DefaultWebSecurityManager
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联Realm
        securityManager.setRealm(userRealm);
        return  securityManager;
    }

    // 创建Realm
    @Bean
    public  UserRealm userRealm(){
        return new UserRealm();
    }

}
