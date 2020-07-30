package com.hawthorn.admin.controller;

import com.hawthorn.admin.model.SysUser;
import com.hawthorn.admin.util.ret.BaseResult;
import com.hawthorn.admin.util.ret.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0.1
 * @className:HelloController
 * @descripion: helloController测试类
 * @author:andy.ten@tom.com
 * @date:2020/7/14 12:38 下午
 */

@Api(tags = {"接口swagger api"})
@RestController
public class HelloController
{
  @ApiOperation(value = "获取hello信息", notes = "【notes】:该方法为测试controller")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", paramType = "query", defaultValue = "andyten", required = false),
  })
  @GetMapping(value = "/findUser")
  public BaseResult<SysUser> findUserByUserName(@RequestParam(value = "username", required = true) String username)
  {
    SysUser su = new SysUser();
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
    return ResultUtil.success(s);
  }
}