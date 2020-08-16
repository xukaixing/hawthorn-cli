package com.hawthorn.admin.service.sysuser.impl;

import com.hawthorn.admin.model.sysuser.SysUser;
import com.hawthorn.admin.repository.sysuser.SysUserMapper;
import com.hawthorn.admin.service.sysuser.SysUserService;
import com.hawthorn.admin.service.sysuser.SysUserService2;
import com.hawthorn.framework.annotation.ExecTime;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.service.DBService;
import com.hawthorn.framework.util.iassert.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 系统用户service
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:56 下午
 * @version v1.0.1
 */
@Service
@ExecTime
@Slf4j
public class SysUserServiceImpl implements SysUserService
{

  @Resource
  private SysUserMapper sysUserMapper;
  @Resource
  private DBService<SysUser> dbService;

  public List<SysUser> selectAll()
  {
    return sysUserMapper.selectAll();
  }

  public List<SysUser> selectAllPrivider()
  {
    return sysUserMapper.selectAllPrivider();
  }

  public List<SysUser> selectAllByStatus(Byte status)
  {
    AssertUtil.notNull(status, BizCode.METHOD_ARGS_ISNULL, "status");
    return sysUserMapper.selectAllByStatus(status);
  }

  public List<SysUser> selectAllByField(String fieldName, String fieldValue)
  {
    AssertUtil.notNull(fieldName, BizCode.METHOD_ARGS_ISNULL, fieldName);
    return sysUserMapper.selectAllByField(fieldName, fieldValue);
  }

  @Autowired
  private SysUserService2 sysUserService2;

  //@Transactional(rollbackFor = {Exception.class})
  public boolean insertUser()
  {
    SysUser u = new SysUser();
    u.setName("test");
    u.setNickName("test");
    //baseMapper.insert(u);
    sysUserMapper.insert(u);
    log.info("1");
    sysUserService2.insertUser();
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // u2.setStatus((byte) 0);
    // saveOrUpdate(u2);
    //insertUser2();
    return true;
  }

  /**
   * @remark: 测试transactional方法
   * @param:
   * @return: boolean

   * @author: andy.ten@tom.com
   * @date: 2020/8/14 10:24 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/14    andy.ten        v1.0.1             init
   */
  //@Transactional(rollbackFor = {Exception.class})
  public boolean insertUser2()
  {
    SysUser u = new SysUser();
    u.setName("test");
    u.setNickName("test");
    //baseMapper.insert(u);
    dbService.saveOrUpdate(u);
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // u2.setStatus((byte) 0);
    // saveOrUpdate(u2);
    log.info("2");
    return true;
  }

}

