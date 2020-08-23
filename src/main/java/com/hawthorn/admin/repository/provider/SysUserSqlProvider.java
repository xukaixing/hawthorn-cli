package com.hawthorn.admin.repository.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: privider sql 类demo
 * @author:andy.ten@tom.com
 * @date:2020/8/13 8:37 下午
 * @version v1.0.1
 */
@Slf4j
public class SysUserSqlProvider implements ProviderMethodResolver
{
  // 默认实现中，会将映射器方法的调用解析到实现的同名方法上（版本3.5.1+）
  public static String selectAllPrivider()
  {
    return " SELECT * FROM SYS_USER ";

  }

  public static String deleteAllPrivider()
  {
    return " delete from  sys_user ";

  }
}
