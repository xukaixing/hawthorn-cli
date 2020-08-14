package com.hawthorn.framework.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Copyright: Copyright (c) 2020$ andyten
 * @remark: DruidConfig配置类
 * @author:andy.ten@tom.com
 * @date:2020/8/14 2:01 上午
 * @version v1.0.1
 */
@Configuration
public class DruidConfig
{
  @Bean
  @ConfigurationProperties("spring.datasource.druid")
  public DataSource dataSource()
  {
    return DruidDataSourceBuilder.create().build();
  }
}
