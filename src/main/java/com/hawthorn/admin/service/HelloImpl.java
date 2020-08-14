package com.hawthorn.admin.service;

import org.springframework.stereotype.Service;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 测试service层异常处理
 * @author:andy.ten@tom.com
 * @date:2020/8/13 8:11 下午
 * @version v1.0.1
 */
@Service
public class HelloImpl implements Hello
{

  @Override
  public void sayHello()
  {

    String s = "a";
    System.out.println("ss" + s.substring(111));
  }
}
