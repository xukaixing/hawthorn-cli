package com.hawthorn.admin.service.sysuser;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;
import com.hawthorn.framework.utils.bean.QcBean;

import java.util.List;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * * <p></p>
 * @remark: 系统用户interface
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:57 下午
 * @version v1.0.1
 */
public interface SysUserService
{
  List<SysUserDTO> selectNoPage();

  IPage<SysUserDTO> selectByPage(Page<SysUserDTO> page);

  IPage<SysUserDTO> select(Page<SysUserDTO> page, Map<String, QcBean> qc);

  List<SysUserDTO> select(Map<String, QcBean> qc);

  List<SysUserDTO> selectAllPrivider();

  List<SysUserDTO> selectAllByStatus(Byte status);

  List<SysUserDTO> selectAllByField(String fieldName, String fieldValue);

  SysUserDTO insertUser();

  SysUserDTO insertUser2();

  SysUserDTO updateUser();

  SysUserDTO updateUserByVersion();

  int deleteAll();
}
