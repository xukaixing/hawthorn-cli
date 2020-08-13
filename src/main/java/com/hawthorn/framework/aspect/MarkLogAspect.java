package com.hawthorn.framework.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: MarkLog注解的切面类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:21 下午
 * @version v1.0.1
 */
@Aspect
@Component
@Slf4j
public class MarkLogAspect
{
  // 定义切入点

  /**
   * 切面表达式：
   * execution 代表所要执行的表达式主体
   * 第一处 * 代表方法返回类型 *代表所有类型
   * 第二处 包名代表aop监控的类所在的包
   * 第三处 .. 代表该包以及其子包下的所有类方法
   * 第四处 * 代表类名，*代表所有类
   * 第五处 *(..) *代表类中的方法名，(..)表示方法中的任何参数
   */
  @Pointcut("@within(com.hawthorn.framework.annotation.MarkLog) || @annotation(com.hawthorn.framework.annotation.MarkLog)")
  public void markLogPointcut()
  {
  }

  // 环绕
  @Around("markLogPointcut()")
  public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable
  {
    return null;
  }
}
