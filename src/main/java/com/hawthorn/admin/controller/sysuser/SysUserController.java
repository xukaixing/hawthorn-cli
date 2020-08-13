package com.hawthorn.admin.controller.sysuser;

import com.hawthorn.admin.model.sysuser.SysUser;
import com.hawthorn.admin.service.sysuser.SysUserService;
import com.hawthorn.framework.annotation.ExecTime;
import com.hawthorn.framework.ret.BaseResult;
import com.hawthorn.framework.ret.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Copyright (c) SysUserController$ andyten
 * @remark: 系统用户controller
 * @author:andy.ten@tom.com
 * @date:2020/8/13 2:48 下午
 * @version v1.0.1
 */
@Api(tags = {"sysusermng-sysuser-controller"})
@RestController
@ExecTime
@RequestMapping("/sysuser/")
@Slf4j
public class SysUserController
{
  @Resource
  SysUserService sysUserService;

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 2:56 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询全部用户信息", notes = "查询全部用户信息 不带参数")
  @GetMapping(value = "/selectUsersAll")
  public BaseResult<List<SysUser>> selectUsersAll()
  {
    List<SysUser> users = sysUserService.selectAll();
    log.info("====== show userlist ====== ");
    users.forEach(System.out::println);
    return ResultUtil.success(users);
  }

  @ApiOperation(value = "按状态查询用户信息", notes = "按状态查询用户信息 带参数status")
  @GetMapping(value = "/selectUsersByStatus")
  public BaseResult<List<SysUser>> selectUsersByStatus(@RequestParam(value = "status", defaultValue = "1") Byte status)
  {
    List<SysUser> users = sysUserService.selectAllByStatus(status);
    log.info("====== show userlist ====== ");
    users.forEach(x -> log.info(String.valueOf(x)));
    return ResultUtil.success(users);
  }
}
