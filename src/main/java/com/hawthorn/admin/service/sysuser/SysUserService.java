package com.hawthorn.admin.service.sysuser;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hawthorn.admin.model.sysuser.SysUser;

import java.util.List;

/**
 * @Copyright: Copyright (c) SysUser$ andyten
 * @remark: 系统用户interface
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:57 下午
 * @version v1.0.1
 */
public interface SysUserService extends IService<SysUser>
{
  List<SysUser> selectAll();

  List<SysUser> selectAllByStatus(Byte status);

}
