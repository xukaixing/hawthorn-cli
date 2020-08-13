package com.hawthorn.framework.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 自定义方法执行时间注解；该注解用来记录方法执行时间
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:15 下午
 * @version v1.0.1
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ExecTime
{
  String value() default "";
}
