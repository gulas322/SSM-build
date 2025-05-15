package com.sun.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        // 这个类是mybatis的，用来创建SqlSessionFactory对象，给他数据源，
        // 然后创建sqlsessionfactory的对象
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.sun.domain");
        return factoryBean;
    }

/**
 * 创建MapperScannerConfigurer的Bean实例
 * 该实例用于扫描指定包下的Mapper接口，并将其注册为Spring的Bean
 *
 * @return MapperScannerConfigurer的实例，用于配置MyBatis的Mapper扫描
 */
@Bean
public MapperScannerConfigurer mapperScannerConfigurer(){
    MapperScannerConfigurer msc = new MapperScannerConfigurer();
    // 设置基础包，指定该包下所有的Mapper接口将被扫描
    msc.setBasePackage("com.sun.dao");
    return msc;
}


}
