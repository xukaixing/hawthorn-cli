package com.hawthorn.admin.service.sysuser;

import com.hawthorn.admin.model.sysuser.SysUser;

import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 测试@Transactional事务一致性类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:57 下午
 * @version v1.0.1
 */
public interface SysUserService2 //extends IBaseService<SysUser>
{
  List<SysUser> selectAll();

  List<SysUser> selectAllPrivider();

  List<SysUser> selectAllByStatus(Byte status);

  List<SysUser> selectAllByField(String fieldName, String fieldValue);

  boolean insertUser();

  boolean insertUser2();
}