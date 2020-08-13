package com.hawthorn.framework.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 读取application.yml自定义属性类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:27 下午
 * @version v1.0.1
 */
@Component
@ConfigurationProperties(prefix = "myprops")
public class MyPropsConfig
{
  //接收exectime属性
  private Map<String, Long> exectime = new HashMap<String, Long>();

  public Map<String, Long> getExectime()
  {
    return exectime;
  }

  public void setExectime(Map<String, Long> exectime)
  {
    this.exectime = exectime;
  }
  
}
