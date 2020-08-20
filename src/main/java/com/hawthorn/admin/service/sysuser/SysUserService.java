package com.hawthorn.admin.service.sysuser;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;

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
  List<SysUserDTO> selectAll();

  IPage<SysUserDTO> selectUsersByPage(Page<SysUserDTO> page);

  List<SysUserDTO> selectAllPrivider();

  List<SysUserDTO> selectAllByStatus(Byte status);

  List<SysUserDTO> selectAllByField(String fieldName, String fieldValue);

  boolean insertUser();

  boolean insertUser2();

  SysUserDTO updateUser();
}
