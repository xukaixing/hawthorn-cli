package com.hawthorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.hawthorn.**.controller", "com.hawthorn.**.service", "com.hawthorn.**.model"})
public class HawthornApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(HawthornApplication.class, args);
  }

}
