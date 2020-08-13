package com.hawthorn.admin.controller;

import com.hawthorn.BootApplication;
import com.hawthorn.admin.service.Hello;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApplication.class})
@Slf4j
public class HelloControllerTest
{
  @Autowired
  private Hello hello;

  @Test
  public void sayHello()
  {
    hello.sayHello();
  }
}
