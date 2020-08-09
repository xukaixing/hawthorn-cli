package com.hawthorn.framework.ret;

import com.hawthorn.framework.util.http.HttpStatusUtils;

public enum RetCode
{
  // 成功
  SUCCESS(HttpStatusUtils.SC_OK),

  // 失败
  FAIL(HttpStatusUtils.SC_BAD_REQUEST),

  // 未认证（签名错误）
  UNAUTHORIZED(HttpStatusUtils.SC_UNAUTHORIZED),

  // 接口不存在
  NOT_FOUND(HttpStatusUtils.SC_NOT_FOUND),

  // 客户端发送的实体主体部分比服务器能够或者希望处理的要大
  Entity_TOOLARGE(HttpStatusUtils.SC_REQUEST_TOO_LONG),

  // 服务器内部错误
  INTERNAL_SERVER_ERROR(HttpStatusUtils.SC_INTERNAL_SERVER_ERROR);

  public int code;

  RetCode(int code)
  {
    this.code = code;
  }
}
