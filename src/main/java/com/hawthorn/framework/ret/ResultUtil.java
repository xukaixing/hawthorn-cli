package com.hawthorn.framework.ret;

import com.hawthorn.framework.exception.BizCode;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 返回结果封装类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:26 下午
 * @version v1.0.1
 */
public class ResultUtil
{
  private final static String SUCCESS = "success";
  private final static String FAIL = "fail";

  public static <T> BaseResult<T> success()
  {
    return new BaseResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setStatus(SUCCESS);
  }

  public static <T> BaseResult<T> success(T data)
  {
    return new BaseResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data).setStatus(SUCCESS);
  }

  public static <T> BaseResult<T> success(int code, String msg)
  {
    return new BaseResult<T>().setCode(code).setMsg(msg).setStatus(SUCCESS);
  }

  public static <T> BaseResult<T> fail(BizCode bizCode)
  {
    return new BaseResult<T>().setCode(bizCode.getCode()).setMsg(bizCode.getMsg()).setStatus(FAIL);
  }

  public static <T> BaseResult<T> fail(BizCode bizCode, T data)
  {
    return new BaseResult<T>().setCode(bizCode.getCode()).setMsg(bizCode.getMsg()).setData(data).setStatus(FAIL);
  }

  public static <T> BaseResult<T> fail(String message)
  {
    return new BaseResult<T>().setCode(RetCode.FAIL).setMsg(message).setStatus(FAIL);
  }

  public static <T> BaseResult<T> fail(int code, String msg)
  {
    return new BaseResult<T>().setCode(code).setMsg(msg).setStatus(FAIL);
  }

  public static <T> BaseResult<T> fail(int code, String msg, T data)
  {
    return new BaseResult<T>().setCode(code).setMsg(msg).setData(data).setStatus(FAIL);
  }
}
