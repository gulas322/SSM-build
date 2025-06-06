package com.sun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.sun.controller","com.sun.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
