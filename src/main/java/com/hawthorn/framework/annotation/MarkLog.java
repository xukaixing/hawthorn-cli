package com.hawthorn.framework.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/*
 * @author: andy.ten@tom.com
 * @date: 2020/8/8 2:36 下午
 * @version: 1.0.1
 * @remark: 自定义记录日志注解，使用该注解，表明需要将日志保存到数据库中
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MarkLog
{
  String value() default "";
}
