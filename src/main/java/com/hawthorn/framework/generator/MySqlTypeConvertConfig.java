package com.hawthorn.framework.generator;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 自定义类型转换
 * @author:andy.ten@tom.com
 * @date:2020/8/22 3:36 下午
 * @version v1.0.1
 */
public class MySqlTypeConvertConfig extends MySqlTypeConvert implements ITypeConvert
{
  @Override
  public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType)
  {
    String t = fieldType.toLowerCase();
    // 生成的时候将tinyint转换为Integer
    if (t.contains("tinyint(1)" ) || t.contains("tinyint(4)" ))
    {
      return DbColumnType.INTEGER;
    }
    return super.processTypeConvert(globalConfig, fieldType);
  }
}
