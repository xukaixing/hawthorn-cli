package com.hawthorn.admin.controller;

import com.hawthorn.admin.model.po.SysUserPO;
import com.hawthorn.admin.service.Hello;
import com.hawthorn.framework.annotation.ExecTime;
import com.hawthorn.framework.ret.BaseResult;
import com.hawthorn.framework.ret.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: helloController测试类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 8:10 下午
 * @version v1.0.1
 */
@Api(tags = {"demo-hello-controller"})
@RestController
@ExecTime
public class HelloController
{
  private final Hello hello;

  @Autowired
  public HelloController(Hello hello)
  {
    this.hello = hello;
  }


  @ApiOperation(value = "获取hello信息", notes = "【notes】:该方法为测试controller")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", paramType = "query", defaultValue = "andyten", required = false),
  })
  @GetMapping(value = "/findUser")
  public BaseResult<SysUserPO> findUserByUserName(@RequestParam(value = "username", required = true) String username)
  {
    SysUserPO su = new SysUserPO();
    su.setId(1L);
    su.setName(username);
    return ResultUtil.success(su);
  }

  /*
   * @author: andy.ten@tom.com
   * @date: 2020/7/16 2:52 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "", notes = "")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "username", value = "", required = false, dataType = "string", paramType = "query"),
      @ApiImplicitParam(name = "name", value = "", required = false, dataType = "string", paramType = "query")
  })

  @GetMapping(value = "sayHello")
  public BaseResult<String> sayHello(String username, String name)
  {
    String s = "Hello Hawthorn By " + username;
    //s = "a";
    //System.out.println("ss" + s.substring(111));
    // 测试异常
    hello.sayHello();
    return ResultUtil.success(s);
  }

  @Autowired
  private DataSource dataSource;

  @GetMapping("/db")
  @ResponseBody
  public String getDBInfo() throws SQLException
  {
    System.out.println(dataSource.getConnection());
    System.out.println(dataSource);
    return "hello spring boot";
  }
}
