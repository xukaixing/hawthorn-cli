package com.hawthorn.admin.util.ret;

public enum RetCode
{
  // 成功
  SUCCESS(200),

  // 失败
  FAIL(400),

  // 未认证（签名错误）
  UNAUTHORIZED(401),

  // 接口不存在
  NOT_FOUND(404),

  // 客户端发送的实体主体部分比服务器能够或者希望处理的要大
  Entity_TOOLARGE(413),

  // 服务器内部错误
  INTERNAL_SERVER_ERROR(500);

  public int code;

  RetCode(int code)
  {
    this.code = code;
  }
}
