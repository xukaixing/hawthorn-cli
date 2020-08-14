package com.hawthorn.framework.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 自定义记录日志注解，使用该注解，表明需要将日志保存到数据库中
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:15 下午
 * @version v1.0.1
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Component
public @interface MarkLog
{
  String value() default "";
}
