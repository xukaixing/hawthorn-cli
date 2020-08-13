package com.hawthorn.framework.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: MarkLog注解的切面类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:21 下午
 * @version v1.0.1
 */
@Data
@AllArgsConstructor
public class ApiError
{
  private String[] codes;
  private String message;

  public ApiError(String code, String message)
  {
    this(new String[]{code}, message);
  }
}
