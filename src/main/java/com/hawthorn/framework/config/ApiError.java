package com.hawthorn.framework.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version v1.0.1
 * @className:ApiError
 * @descripion: TODO
 * @author:andy.ten@tom.com
 * @date:2020/7/15 6:30 下午
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
