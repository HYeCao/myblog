package com.example.demo.config;

import com.example.demo.interceptor.BackInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
//    public final static String SESSION_KEY = "user";
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new BackInterceptor()).addPathPatterns("/admin/*.html").excludePathPatterns("/index.html");
//
//    }
}
