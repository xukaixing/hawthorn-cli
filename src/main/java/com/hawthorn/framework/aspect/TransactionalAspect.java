package com.hawthorn.framework.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: MarkLog注解的切面类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:21 下午
 * @version v1.0.1
 */
@Aspect
@Configuration
@Slf4j
@Order(1)
public class TransactionalAspect
{
  /*
   * @remark: 定义切入点
   * @param:
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/11 5:15 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/11    andy.ten        v1.0.1             init
   */
  @Pointcut("execution(public * com.hawthorn.admin.service..*.*(..)))")
  public void transactionalPointcut()
  {
  }

}
