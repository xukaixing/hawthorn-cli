package com.hawthorn.admin.service.sysuser;

import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;

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
  List<SysUserDTO> selectAll();

  List<SysUserDTO> selectAllPrivider();

  List<SysUserDTO> selectAllByStatus(Byte status);

  List<SysUserDTO> selectAllByField(String fieldName, String fieldValue);

  boolean insertUser();

  boolean insertUser2();
}
