package com.hawthorn.framework.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.update.Update;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: mybatis-plus物理分页配置类
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

    // 阻止恶意的全表更新或删除sql begin
    List<ISqlParser> sqlParserList = new ArrayList<>();
    // 攻击 SQL 阻断解析器、加入解析链
    sqlParserList.add(new BlockAttackSqlParser()
    {
      @Override
      public void processDelete(Delete delete)
      {
        super.processDelete(delete);
      }

      @Override
      public void processUpdate(Update update)
      {
        super.processUpdate(update);
      }
    });
    paginationInterceptor.setSqlParserList(sqlParserList);
    // end

    return paginationInterceptor;
  }

  /**
   * @remark: 乐观锁
   * @param:
   * @return: com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor

   * @author: andy.ten@tom.com
   * @date: 2020/8/21 2:04 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/21    andy.ten        v1.0.1             init
   */
  @Bean
  public OptimisticLockerInterceptor optimisticLockerInterceptor()
  {
    return new OptimisticLockerInterceptor();
  }

  /**
   * @remark: SQL 逻辑删除注入器 mp版本在3.1.1以后不需要该步骤
   * @param:
   * @return: com.baomidou.mybatisplus.core.injector.ISqlInjector

   * @author: andy.ten@tom.com
   * @date: 2020/8/21 12:56 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/21    andy.ten        v1.0.1             init
   */
  // @Bean
  // public ISqlInjector sqlInjector()
  // {
  //   return new LogicSqlInjector();
  // }

}
