package com.hawthorn.framework.ret;

import com.hawthorn.framework.utils.http.HttpStatusUtil;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 定义结果集code
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:27 下午
 * @version v1.0.1
 */
public enum RetCode
{
  // 成功
  SUCCESS(HttpStatusUtil.SC_OK),

  // 失败
  FAIL(HttpStatusUtil.SC_BAD_REQUEST),

  // 未认证（签名错误）
  UNAUTHORIZED(HttpStatusUtil.SC_UNAUTHORIZED),

  // 接口不存在
  NOT_FOUND(HttpStatusUtil.SC_NOT_FOUND),

  // 客户端发送的实体主体部分比服务器能够或者希望处理的要大
  Entity_TOOLARGE(HttpStatusUtil.SC_REQUEST_TOO_LONG),

  // 服务器内部错误
  INTERNAL_SERVER_ERROR(HttpStatusUtil.SC_INTERNAL_SERVER_ERROR);

  public int code;

  RetCode(int code)
  {
    this.code = code;
  }
}
