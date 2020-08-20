package com.hawthorn.admin.repository.sysuser;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;
import com.hawthorn.admin.model.po.SysUserPO;
import com.hawthorn.admin.repository.sysuser.provider.SysUserSqlProvider;
import com.hawthorn.framework.repository.DBMapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: SysUser Mapper类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 11:47 上午
 * @version v1.0.1
 */
@Repository
public interface SysUserMapper extends DBMapper<SysUserPO>
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
  List<SysUserDTO> selectAll();

  IPage<SysUserDTO> selectUsersByPage(Page<?> page);

  @SelectProvider(SysUserSqlProvider.class)
  List<SysUserDTO> selectAllPrivider();

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
  List<SysUserDTO> selectAllByStatus(Byte status);

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
  List<SysUserDTO> selectAllByField(String fieldName, String fieldValue);

  SysUserDTO update(SysUserPO u);
}
