package com.hawthorn.admin.repository.sysuser;

import com.hawthorn.admin.model.sysuser.SysUser;
import com.hawthorn.admin.repository.sysuser.provider.SysUserSqlProvider;
import com.hawthorn.framework.repository.IBaseMapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: SysUser Mapper类,使用java定义sql方式，无须配置mapper xml
 * @author:andy.ten@tom.com
 * @date:2020/8/13 11:47 上午
 * @version v1.0.1
 */
public interface SysUserMapperPrivider extends IBaseMapper<SysUser>
{
  @SuppressWarnings("MybatisMapperMethodInspection")
  @SelectProvider(SysUserSqlProvider.class)
  List<SysUser> selectAll();
}
