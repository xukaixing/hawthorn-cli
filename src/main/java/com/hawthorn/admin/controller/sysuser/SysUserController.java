package com.hawthorn.admin.controller.sysuser;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;
import com.hawthorn.admin.service.sysuser.SysUserService;
import com.hawthorn.framework.utils.bean.QcBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 系统用户controller
 * @author:andy.ten@tom.com
 * @date:2020/8/13 2:48 下午
 * @version v1.0.1
 */
@Api(tags = {"admin-sysuser-controller"})
@RestController
@RequestMapping("/sysuser/" )
@Slf4j
public class SysUserController
{
  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 2:56 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->全部用户信息", notes = "查询全部用户信息服务 不带参数" )
  @GetMapping(value = "/selectUsersAll" )
  public List<SysUserDTO> selectUsersAll()
  {
    List<SysUserDTO> users = sysUserService.selectNoPage();
    log.info("====== show userlist ====== " );
    users.forEach(System.out::println);
    return users;
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/19 2:36 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->全部用户信息(物理分页)", notes = "查询全部用户信息服务 带分页" )
  @ApiImplicitParams({

  })
  @GetMapping(value = "/selectUsersByPage" )
  public IPage<SysUserDTO> selectUsersByPage()
  {
    int pageNum = 1;
    int pageSize = 2;
    Page<SysUserDTO> page = new Page<>(pageNum, pageSize);

    IPage<SysUserDTO> users = sysUserService.selectByPage(page);
    return users;
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/19 2:36 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->全部用户信息(物理分页带where条件)", notes = "查询全部用户信息服务 带分页" )
  @ApiImplicitParams({

  })
  @GetMapping(value = "/select" )
  public IPage<SysUserDTO> select()
  {
    int pageNum = 1;
    int pageSize = 2;
    Page<SysUserDTO> page = new Page<>(pageNum, pageSize);
    QcBean qc = new QcBean();
    qc.setId("delFlag" );
    qc.setOp("=" );
    qc.setDs("del_flag" );
    qc.setValue("0" );
    QcBean qc2 = new QcBean();
    qc2.setId("nickName" );
    qc2.setOp("=" );
    qc2.setDs("nick_name" );
    qc2.setValue("%tet%" );
    HashMap<String, QcBean> hm = new HashMap<>();
    hm.put(qc.getId(), qc);
    hm.put(qc2.getId(), qc2);
    return sysUserService.select(page, hm);
  }

  @Autowired
  SysUserService sysUserService;


  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 9:21 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->全部用户信息(Privider方式)", notes = "查询全部用户信息服务 使用Privider方式 无须配置mapper xml" )
  @ApiImplicitParams({

  })
  @GetMapping(value = "/selectUsersAllPrivider" )
  public List<SysUserDTO> selectUsersAllPrivider()
  {
    List<SysUserDTO> users = sysUserService.selectAllPrivider();
    return users;
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 6:25 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->按状态查询用户", notes = "按状态查询用户信息服务 带参数status" )
  @ApiImplicitParams({
      @ApiImplicitParam(name = "status", value = "状态", required = false, dataType = "byte", paramType = "query" )
  })
  @GetMapping(value = "/selectUsersByStatus" )
  public List<SysUserDTO> selectUsersByStatus(@RequestParam(value = "status", required = false) Byte status)
  {
    List<SysUserDTO> users = sysUserService.selectAllByStatus(status);
    log.info("====== show userlist ====== " );
    users.forEach(x -> log.info(String.valueOf(x)));
    return users;
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/13 6:31 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->按属性查询用户", notes = "按属性查询用户信息服务" )
  @ApiImplicitParams({
      @ApiImplicitParam(name = "fieldName", value = "属性名", required = true, dataType = "string", paramType = "query" ),
      @ApiImplicitParam(name = "fieldValue", value = "属性值", required = false, dataType = "string", paramType = "query" )
  })
  @GetMapping(value = "/selectUsersByField" )
  public List<SysUserDTO> selectUsersByField(@RequestParam(value = "fieldName" ) String fieldName, @RequestParam(value = "fieldValue" ) String fieldValue)
  {
    List<SysUserDTO> users = sysUserService.selectAllByField(fieldName, fieldValue);
    return users;
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/14 12:03 上午
   * @version: 1.0.1
   */
  @ApiOperation(value = "保存->用户新增", notes = "用户新增服务" )
  @ApiImplicitParams({
  })
  @PutMapping(value = "/insertUser" )
  public boolean insertUser()
  {
    sysUserService.insertUser();
    //sysUserService2.insertUser();
    //sysUserService.insertUser2();
    //sysUserService.insertUser();
    return true;
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/17 10:37 上午
   * @version: 1.0.1
   */
  @ApiOperation(value = "保存->用户更新", notes = "用户更新服务" )
  @ApiImplicitParams({
  })
  @PostMapping(value = "/updateUser" )
  public void updateUser()
  {
    SysUserDTO u = sysUserService.updateUser();
    //sysUserService2.insertUser();
    //sysUserService.insertUser2();
    //sysUserService.insertUser();
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/21 3:19 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "保存->用户更新(带乐观锁)", notes = "用户更新服务" )
  @ApiImplicitParams({

  })
  @PostMapping(value = "/updateUserByVersion" )
  public void updateUserByVersion()
  {
    SysUserDTO u = sysUserService.updateUserByVersion();
    //sysUserService2.insertUser();
    //sysUserService.insertUser2();
    //sysUserService.insertUser();
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020/8/21 1:13 下午
   * @version: 1.0.1
   */
  @ApiOperation(value = "保存->用户删除", notes = "用户删除服务" )
  @ApiImplicitParams({

  })
  @DeleteMapping(value = "/deleteAllUser" )
  public void deleteAll()
  {
    sysUserService.deleteAll();
    //sysUserService2.insertUser();
    //sysUserService.insertUser2();
    //sysUserService.insertUser();
  }
}
