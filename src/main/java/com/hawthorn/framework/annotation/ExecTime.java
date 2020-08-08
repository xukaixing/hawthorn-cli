package com.hawthorn.framework.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/*
 * @author: andy.ten@tom.com
 * @date: 2020/8/8 2:37 下午
 * @version: 1.0.1
 * @remark: 自定义方法执行时间注解；该注解用来记录方法执行时间
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ExecTime
{
  String value() default "";
}
