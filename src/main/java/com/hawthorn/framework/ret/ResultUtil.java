package com.hawthorn.framework.ret;

import com.hawthorn.framework.exception.BizCode;

/**
 * @version v1.0.1
 * @className:RetResponse
 * @descripion: 返回结果封装类
 * @author:andy.ten@tom.com
 * @date:2020/7/15 7:18 下午
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
