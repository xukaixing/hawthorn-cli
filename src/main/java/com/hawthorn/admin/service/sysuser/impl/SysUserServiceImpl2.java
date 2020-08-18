package com.hawthorn.admin.service.sysuser.impl;

import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;
import com.hawthorn.admin.model.po.SysUserPO;
import com.hawthorn.admin.repository.sysuser.SysUserMapper;
import com.hawthorn.admin.service.sysuser.SysUserService2;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.service.DBService;
import com.hawthorn.framework.utils.iassert.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 测试@transactional事务一致性类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:56 下午
 * @version v1.0.1
 */
@Service
@Slf4j
public class SysUserServiceImpl2 implements SysUserService2
{
  @Resource
  private SysUserMapper sysUserMapper;
  @Resource
  private DBService<SysUserPO> dbService;

  public List<SysUserDTO> selectAll()
  {
    return sysUserMapper.selectAll();
  }

  public List<SysUserDTO> selectAllPrivider()
  {
    return sysUserMapper.selectAllPrivider();
  }

  public List<SysUserDTO> selectAllByStatus(Byte status)
  {
    AssertUtil.notNull(status, BizCode.METHOD_ARGS_NOTNULL, "status");
    return sysUserMapper.selectAllByStatus(status);
  }

  public List<SysUserDTO> selectAllByField(String fieldName, String fieldValue)
  {
    AssertUtil.notNull(fieldName, BizCode.METHOD_ARGS_NOTNULL, "fieldName");
    return sysUserMapper.selectAllByField(fieldName, fieldValue);
  }

  //@Transactional(rollbackFor = {Exception.class})
  public boolean insertUser()
  {
    SysUserPO u = new SysUserPO();
    u.setName("test");
    u.setNickName("test");
    //baseMapper.insert(u);
    dbService.saveOrUpdate(u);
    log.info("1");
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // u2.setStatus((byte) 0);
    // saveOrUpdate(u2);
    insertUser2();
    return true;
  }

  @Transactional(rollbackFor = {Exception.class})
  public boolean insertUser2()
  {
    SysUserPO u = new SysUserPO();
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

