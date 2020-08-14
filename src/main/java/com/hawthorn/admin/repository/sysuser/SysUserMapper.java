package com.hawthorn.admin.repository.sysuser;

import com.hawthorn.admin.model.sysuser.SysUser;
import com.hawthorn.framework.repository.IBaseMapper;

import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: SysUser Mapper类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 11:47 上午
 * @version v1.0.1
 */
public interface SysUserMapper extends IBaseMapper<SysUser>
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

  /**
   * @remark: 根据字段查询结果集
   * @param: fieldName
   * @param: v
   * @return: java.util.List<com.hawthorn.admin.model.sysuser.SysUser>

   * @author: andy.ten@tom.com
   * @date: 2020/8/13 6:23 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/13    andy.ten        v1.0.1             init
   */
  List<SysUser> selectAllByField(String fieldName, String fieldValue);
  
}
