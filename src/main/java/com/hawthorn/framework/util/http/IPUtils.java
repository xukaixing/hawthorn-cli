package com.hawthorn.framework.util.http;

import javax.servlet.http.HttpServletRequest;

/**
 * @version v1.0.1
 * @remark: 获取ip地址工具类
 * @author:andy.ten@tom.com
 * @date:2020/8/9 11:35 上午
 */
public class IPUtils
{
  public static String getIpAddr(HttpServletRequest request)
  {
    String ip = request.getHeader("x-real-ip");

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
    {
      ip = request.getHeader("x-forwarded-for");
      if (ip != null)
      {
        ip = ip.split(",")[0].trim();
      }
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
    {
      ip = request.getHeader("Proxy-Client-IP");
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
    {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
    {
      ip = request.getRemoteAddr();
    }

    return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
  }
}
