package com.hawthorn.framework.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: andy.ten@tom.com
 * @date: 2020/8/9 10:18 上午
 * @version: 1.0.1
 * @remark: 业务异常类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException
{
  // spring中，只有RuntimeException才会进行事务回滚，Exception不会进行事务回滚
  private int code;
  private String status;
  private String msg;

  public BizException(int code, String msg)
  {
    super(msg);
    this.code = code;
    this.msg = msg;
    this.status = "fail";
  }

  public BizException(BizCode bizcode)
  {
    super(bizcode.getMsg());
    this.code = bizcode.getCode();
    this.msg = bizcode.getMsg();
    this.status = "fail";
  }

  public BizException(String msg)
  {
    super(msg);
    this.code = -99999;
    this.msg = msg;
    this.status = "fail";
  }
}
