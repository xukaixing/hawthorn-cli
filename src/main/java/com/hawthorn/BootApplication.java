package com.hawthorn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.hawthorn.admin", "com.hawthorn.framework.config"})
@MapperScan("com.hawthorn.admin.repository")
public class BootApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(BootApplication.class, args);
  }

}
