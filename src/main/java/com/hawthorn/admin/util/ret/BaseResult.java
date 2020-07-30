package com.hawthorn.admin.util.ret;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

/**
 * @version v1.0.1
 * @className:BaseResult
 * @descripion: 基础返回结果类
 * @author:andy.ten@tom.com
 * @date:2020/7/15 7:17 下午
 */
@ApiModel(value = "结果返回类", description = "通用结果返回类对象")
@Component
public class BaseResult<T>
{
  @ApiModelProperty(value = "代码", name = "code")
  public int code;
  @ApiModelProperty(value = "结果状态", name = "status")
  public String status;
  @ApiModelProperty(value = "信息", name = "msg")
  private String msg;
  @ApiModelProperty(value = "数据", name = "data")
  private T data;

  public BaseResult<T> setCode(RetCode retCode)
  {
    this.code = retCode.code;
    return this;
  }

  public int getCode()
  {
    return code;
  }

  public BaseResult<T> setCode(int code)
  {
    this.code = code;
    return this;
  }

  public String getStatus()
  {
    return status;
  }

  public BaseResult<T> setStatus(String status)
  {
    this.status = status;
    return this;
  }

  public String getMsg()
  {
    return msg;
  }

  public BaseResult<T> setMsg(String msg)
  {
    this.msg = msg;
    return this;
  }

  public T getData()
  {
    return data;
  }

  public BaseResult<T> setData(T data)
  {
    this.data = data;
    return this;
  }
}
