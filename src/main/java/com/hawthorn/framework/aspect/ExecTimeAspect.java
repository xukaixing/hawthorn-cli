package com.hawthorn.framework.aspect;

import com.hawthorn.framework.utils.http.HttpContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static java.util.Map.Entry;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: ExecTime注解的切面类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:24 下午
 * @version v1.0.1
 */
@Aspect
@Component
@Slf4j
@Order(-1)
public class ExecTimeAspect<T>
{

  @Value("${myprops.exectime.errtime:3000}")
  private long errtime;
  @Value("${myprops.exectime.warntime:2000}")
  private long warntime;

  // final MyPropsConfig myPropsConfig;
  // @Autowired
  // public ExecTimeAspect(MyPropsConfig myPropsConfig)
  // {
  //   this.myPropsConfig = myPropsConfig;
  // }

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
  // 针对所有匹配的文件进行切入拦截
  @Pointcut("execution(public * com.hawthorn.*.service..*.*(..)))")
  //使用切入注解，@annotation：无法识别类上的注解，是针对方法的注解
  //@within和@target:标注在类上的自定义注解
  //标注在类或者方法上执行切入
  //@Pointcut("@within(com.hawthorn.framework.annotation.ExecTime) || @annotation(com.hawthorn.framework.annotation.ExecTime)")
  public void execTimePointcut()
  {
  }

  // 环绕
  @Around("execTimePointcut()")
  public Object handleExecTimeLog(ProceedingJoinPoint joinPoint) throws Throwable
  {
    //@Before
    // config用法，spring推荐使用该方法获取参数值
    // long errtime = 3000;
    // long warntime = 2000;
    // if (myPropsConfig.getExectime() != null && myPropsConfig.getExectime().size() == 2)
    // {
    //   errtime = myPropsConfig.getExectime().get("errtime");
    //   warntime = myPropsConfig.getExectime().get("warntime");
    // }


    HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
    String url = "";
    String method = "";
    String remoteIp = "";
    StringBuilder args = new StringBuilder();
    url = request.getRequestURI();
    method = request.getMethod(); //返回的是Get/Post/Put等
    remoteIp = request.getRemoteAddr();
    //args = Arrays.toString(joinPoint.getArgs());
    Map<String, String[]> args1 = request.getParameterMap();
    //遍历请求的参数
    for (Entry<String, String[]> element : args1.entrySet())
    {
      //key值
      Object strKey = element.getKey();
      //value,数组形式
      String[] value = element.getValue();
      for (String s : value)
      {
        if (args.length() > 0)
          args.append("&").append(strKey).append("=").append(s);
        else
          args.append("?").append(strKey).append("=").append(s);
      }
    }
    String targetClass = joinPoint.getTarget().getClass().toString();
    String targetMethod = joinPoint.getSignature().getName();
    log.info("====== 开始执行 {}.{} ======",
        joinPoint.getTarget().getClass(),
        joinPoint.getSignature().getName());
    // 记录开始时间
    long begin = System.currentTimeMillis();
    // 执行目标 service
    Object result = null;

    //exec 切入点方法执行
    //try
    //{
    result = joinPoint.proceed();
    //} catch (Throwable t)
    //{
    //@AfterThrowing
    //log.error("====== 执行结束 发生异常 {} {}.{} {}->{}{} ======", t.getMessage(), targetClass, targetMethod, method, url, args);
    // 抛出RuntimeException异常，给GlobalExceptionHandle
    //throw new RuntimeException(t.getMessage());
    //}

    //@AfterReturning
    // 记录结束时间
    long end = System.currentTimeMillis();
    long takeTime = end - begin;
    if (takeTime > errtime)
    {
      log.error("====== 执行结束 错误 超过{}秒！ 耗时：{} 秒 {}.{} {}->{}{} ======", errtime / 1000, takeTime / 1000, targetClass, targetMethod, method, url, args);
    } else if (takeTime > warntime)
    {
      log.warn("====== 执行结束 警告 超过{}秒！ 耗时：{} 秒 {}.{} {}->{}{} ======", warntime / 1000, takeTime / 1000, targetClass, targetMethod, method, url, args);
    } else
    {
      log.info("====== 执行结束 耗时：{} 毫秒 ======", takeTime);
    }
    // TODO 日志保存到数据库中

    return result;
  }
}
