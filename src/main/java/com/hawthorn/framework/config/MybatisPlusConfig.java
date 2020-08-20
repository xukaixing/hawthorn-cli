package com.hawthorn.framework.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: mybatis-plus配置类
 * @author:andy.ten@tom.com
 * @date:2020/8/19 2:08 下午
 * @version v1.0.1
 */
@Configuration
@ConditionalOnClass({MybatisPlusAutoConfiguration.class, PaginationInterceptor.class})
public class MybatisPlusConfig
{
  @Bean
  public PaginationInterceptor paginationInterceptor()
  {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
    // paginationInterceptor.setOverflow(false);
    // 设置最大单页限制数量，默认 500 条，-1 不受限制
    // paginationInterceptor.setLimit(500);
    // 开启 count 的 join 优化,只针对部分 left join
    //paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));

    return paginationInterceptor;
  }
}
