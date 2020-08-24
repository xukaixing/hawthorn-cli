package com.hawthorn.admin.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;
import com.hawthorn.admin.model.po.SysUserPO;
import com.hawthorn.admin.repository.provider.SysUserSqlProvider;
import com.hawthorn.framework.repository.DBMapper;
import com.hawthorn.framework.utils.bean.QcBean;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

  IPage<SysUserDTO> select(Page<?> page, Map<String, QcBean> qc);

  List<SysUserDTO> select(Map<String, QcBean> qc);

  List<SysUserDTO> selectNoPage();

  IPage<SysUserDTO> selectByPage(Page<?> page);

  @SelectProvider(SysUserSqlProvider.class)
  List<SysUserDTO> selectAllPrivider();

  @DeleteProvider(SysUserSqlProvider.class)
  int deleteAllPrivider();

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

  SysUserDTO updateBySql(SysUserPO u);
}
