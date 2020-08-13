package com.hawthorn.framework.util.http;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: HttpContext工具类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:27 下午
 * @version v1.0.1
 */
public class HttpContextUtils
{
  public static HttpServletRequest getHttpServletRequest()
  {
    return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
  }
}
