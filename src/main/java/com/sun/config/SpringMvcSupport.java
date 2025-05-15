package com.sun.config;

import com.sun.controller.interceptor.ProjectInterceptor;
import com.sun.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurerAdapter {

    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Autowired
    private ProjectInterceptor2  projectInterceptor2;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 这样就加了两个拦截器，按照先后顺序执行
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books", "/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books", "/books/*");
    }
}
