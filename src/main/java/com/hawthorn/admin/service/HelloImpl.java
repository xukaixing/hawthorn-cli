package com.hawthorn.admin.service;

import org.springframework.stereotype.Service;

/**
 * @remark 测试service层异常处理
 * @author: andy.ten@tom.com
 * @date: 2020/8/8 8:38 下午
 * @version: 1.0.1
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
