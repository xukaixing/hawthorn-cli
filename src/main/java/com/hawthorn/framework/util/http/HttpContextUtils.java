package com.hawthorn.framework.util.http;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @version v1.0.1
 * @remark: HttpContext工具类
 * @author:andy.ten@tom.com
 * @date:2020/8/9 11:40 上午
 */
public class HttpContextUtils
{
  public static HttpServletRequest getHttpServletRequest()
  {
    return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
  }
}
