package com.hawthorn.admin.repository.sysuser;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hawthorn.admin.model.sysuser.SysUser;

import java.util.List;

/**
 * @Copyright: Copyright (c) SysUserMapper$ andyten
 * @remark: SysUser Mapper类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 11:47 上午
 * @version v1.0.1
 */
public interface SysUserMapper extends BaseMapper<SysUser>
{
  /**
   * @remark:查询全部的用户信息
   * @param:
   * @return: java.util.List<com.hawthorn.admin.model.sysuser.SysUser>

   * @author: andy.ten@tom.com
   * @date: 2020/8/13 3:47 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/13    andy.ten        v1.0.1             init
   */
  List<SysUser> selectAll();

  /**
   * @remark:根据状态查询用户信息
   * @param:
   * @return: java.util.List<com.hawthorn.admin.model.sysuser.SysUser>

   * @author: andy.ten@tom.com
   * @date: 2020/8/13 5:46 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/13    andy.ten        v1.0.1             init
   */
  List<SysUser> selectAllByStatus(Byte status);
}
