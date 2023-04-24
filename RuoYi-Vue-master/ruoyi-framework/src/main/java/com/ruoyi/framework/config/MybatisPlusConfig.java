package com.ruoyi.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.ruoyi.system.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
}