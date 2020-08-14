package com.hawthorn.admin.controller.sysuser;

import com.hawthorn.admin.model.sysuser.SysUser;
import com.hawthorn.admin.service.sysuser.SysUserService;
import com.hawthorn.admin.service.sysuser.SysUserService2;
import com.hawthorn.framework.ret.BaseResult;
import com.hawthorn.framework.ret.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 系统用户controller
 * @author:andy.ten@tom.com
 * @date:2020/8/13 2:48 下午
 * @version v1.0.1
 */
@Api(tags = {"sysusermng-sysuser-controller"})
@RestController
@RequestMapping("/sysuser/")
@Slf4j
public class SysUserController
{
  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 2:56 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->全部用户信息", notes = "查询全部用户信息服务 不带参数")
  @GetMapping(value = "/selectUsersAll")
  public BaseResult<List<SysUser>> selectUsersAll()
  {
    List<SysUser> users = sysUserService.selectAll();
    log.info("====== show userlist ====== ");
    users.forEach(System.out::println);
    return ResultUtil.success(users);
  }

  @Resource
  SysUserService sysUserService;

  @Resource
  SysUserService2 sysUserService2;

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 9:21 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->全部用户信息(Privider方式)", notes = "查询全部用户信息服务 使用Privider方式 无须配置mapper xml")
  @ApiImplicitParams({

  })
  @GetMapping(value = "/selectUsersAllPrivider")
  public BaseResult<List<SysUser>> selectUsersAllPrivider()
  {
    List<SysUser> users = sysUserService.selectAllPrivider();
    return ResultUtil.success(users);
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 6:25 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->按状态查询用户", notes = "按状态查询用户信息服务 带参数status")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "status", value = "状态", required = false, dataType = "byte", paramType = "query")
  })
  @GetMapping(value = "/selectUsersByStatus")
  public BaseResult<List<SysUser>> selectUsersByStatus(@RequestParam(value = "status", required = false) Byte status)
  {
    List<SysUser> users = sysUserService.selectAllByStatus(status);
    log.info("====== show userlist ====== ");
    users.forEach(x -> log.info(String.valueOf(x)));
    return ResultUtil.success(users);
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 6:31 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->按属性查询用户", notes = "按属性查询用户信息服务")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "fieldName", value = "属性名", required = true, dataType = "string", paramType = "query"),
      @ApiImplicitParam(name = "fieldValue", value = "属性值", required = false, dataType = "string", paramType = "query")
  })
  @GetMapping(value = "/selectUsersByField")
  public BaseResult<List<SysUser>> selectUsersByField(@RequestParam(value = "fieldName") String fieldName, @RequestParam(value = "fieldValue") String fieldValue)
  {
    List<SysUser> users = sysUserService.selectAllByField(fieldName, fieldValue);
    return ResultUtil.success(users);
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/14 12:03 上午
   * @version: 1.0.1
   */
  @ApiOperation(value = "保存->用户新增", notes = "用户新增服务")
  @ApiImplicitParams({
  })
  @PutMapping(value = "/insertUser")
  public boolean insertUser()
  {
    sysUserService.insertUser();
    //sysUserService2.insertUser();
    //sysUserService.insertUser2();
    //sysUserService.insertUser();
    return true;
  }
}
