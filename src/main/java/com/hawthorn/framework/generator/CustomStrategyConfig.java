package com.hawthorn.framework.generator;

import lombok.Data;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 策略配置自定义属性
 * @author:andy.ten@tom.com
 * @date:2020/8/16 6:46 下午
 * @version v1.0.1
 */
@Data
public class CustomStrategyConfig
{
  // 设置父类实体字段
  private String[] superEntityColumns;

  // 设置父类实体类
  private String superEntityClass;

  // 设置父类Mapper 类
  private String superMapperClass;

  // 设置父类Controller 类
  private String superControllerClass;

  // 设置逻辑删除字段
  private String logicDeleteFieldName;

  // 设置乐观锁字段
  private String versionFieldName;

  //设计删除boolean 类型前缀
  private boolean entityBooleanColumnRemoveIsPrefix;
}
