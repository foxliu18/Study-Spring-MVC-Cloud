package com.fall.shirospringboot.config;

import com.fall.shirospringboot.pojo.User;
import com.fall.shirospringboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // info.addStringPermission("user:add");

        // 拿到当前用户
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();

        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(userToken.getUsername());

        if (user == null ){
            return null; // 抛出异常 没有用户
        }
        return new SimpleAuthenticationInfo(user, user.getPwd(), "");
    }
}
