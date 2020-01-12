package com.kim.p2p.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class DataSourceConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(value = {"druid"})
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
