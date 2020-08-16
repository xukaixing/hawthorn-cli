package com.hawthorn.admin.service.sysuser;

import com.hawthorn.admin.model.sysuser.SysUser;

import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 系统用户interface
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:57 下午
 * @version v1.0.1
 */
public interface SysUserService
{
  List<SysUser> selectAll();

  List<SysUser> selectAllPrivider();

  List<SysUser> selectAllByStatus(Byte status);

  List<SysUser> selectAllByField(String fieldName, String fieldValue);

  boolean insertUser();

  boolean insertUser2();
}
