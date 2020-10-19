package com.example.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 最基本shiro配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * shiro内置过滤器 可以实现权限相关的拦截
         *
         * 常用过滤器：
         *      anon: 无需认证（登陆既可以访问）
         *      authc:必须认证才可以访问
         *      user：如果使用remember 可以直接访问
         *      perms：该资源必须得到权限才可以访问
         *      role：该资源必须得到角色权限才可以访问
         */
        Map<String, String> filteMap = new LinkedHashMap<String, String>();

        //拦截
//        filteMap.put("/add", "authc");
//
//        filteMap.put("/update", "authc");

        //user目录下所有都使用这个过滤器
        filteMap.put("/static/**", "anon");

        filteMap.put("/test", "anon");

        filteMap.put("/login", "anon");

        filteMap.put("/admin/article.html", "authc");
        filteMap.put("/admin/category.html", "authc");
        filteMap.put("/admin/comment.html", "authc");
        filteMap.put("/admin/index.html", "authc");
        filteMap.put("/admin", "authc");




        //修改跳转登陆页面
        shiroFilterFactoryBean.setLoginUrl("/admin/toLogin");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filteMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {

        return new UserRealm();
    }


}