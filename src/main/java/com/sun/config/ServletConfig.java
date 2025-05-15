package com.sun.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletConfig extends AbstractDispatcherServletInitializer {
    protected WebApplicationContext createServletApplicationContext() {
        // 创建springmvc容器
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    protected String[] getServletMappings() {
        // 映射路径,所有/之后的都拦截交给springmvc处理
        return new String[]{"/"};
    }

    protected WebApplicationContext createRootApplicationContext() {
        // 创建spring容器，spring的bean
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfig.class);
        return ctx;
    }

   // 乱码处理
    @Override
    protected Filter[] getServletFilters() {
        // 创建 CharacterEncodingFilter 并设置编码为 UTF-8
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true); // 强制请求和响应都使用 UTF-8 编码

        return new Filter[]{filter};
    }
}
