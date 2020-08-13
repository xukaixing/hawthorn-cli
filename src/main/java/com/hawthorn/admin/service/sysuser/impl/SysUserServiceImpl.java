package com.hawthorn.admin.service.sysuser.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hawthorn.admin.model.sysuser.SysUser;
import com.hawthorn.admin.repository.sysuser.SysUserMapper;
import com.hawthorn.admin.service.sysuser.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Copyright (c) SysUserImpl$ andyten
 * @remark: 系统用户service
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:56 下午
 * @version v1.0.1
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService
{
  @Resource
  private SysUserMapper sysUserMapper;

  public List<SysUser> selectAll()
  {
    return sysUserMapper.selectAll();
  }

  public List<SysUser> selectAllByStatus(Byte status)
  {
    return sysUserMapper.selectAllByStatus(status);
  }
}

