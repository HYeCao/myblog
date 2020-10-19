package com.example.demo.config;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("执行授权的逻辑");

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("执行认证逻辑");

        String username = (String) token.getPrincipal();

        User user = userMapper.findUserByUsername(username);

        //1 判断用户名
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;

        if(!usernamePasswordToken.getUsername().equals(user.getUserName())){

            //用户名
            return null;
        }

        //判断密码
        return new SimpleAuthenticationInfo("", user.getPassword(), "");
    }
}
