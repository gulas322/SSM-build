package com.sun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.sun.service"})
//这里我们不希望把com.sun下面所有的都扫描成bean，因为有些需要单独管理
@Import({JdbcConfig.class, MybatisConfig.class})
@PropertySource("classpath:jdbc.properties")
// 这里一定要加classpath 要不然他就会从web-inf下面开始找

@EnableTransactionManagement
// 开启事务管理
public class SpringConfig {
}
