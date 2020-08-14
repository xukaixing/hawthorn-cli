package com.hawthorn.framework.util.iassert;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.exception.BizException;

/**
 * @Copyright: Copyright (c) 2020$ andyten
 * @remark: 自定义断言类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 10:30 下午
 * @version v1.0.1
 */
@SuppressWarnings("UnusedReturnValue")
public class AssertUtil extends Assert
{
  public AssertUtil()
  {
  }

  final static private String assert_prefix = "[Assertion failed] -";

  public static void isNull(Object object, BizCode bizCode) throws IllegalArgumentException
  {
    if (object != null)
    {
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
      throw new BizException(bizCode.getCode(), assert_prefix + bizCode.getMsg());
    }
  }

  public static void isNull(Object object, BizCode bizCode, Object... params) throws IllegalArgumentException
  {
    if (object != null)
    {
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
      throw new BizException(bizCode.getCode(), assert_prefix + StrUtil.format(bizCode.getMsg(), params));
    }
  }

  public static <T> T notNull(T object, BizCode bizCode) throws BizException
  {
    if (object == null)
    {
      throw new BizException(bizCode.getCode(), assert_prefix + bizCode.getMsg());
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
    } else
    {
      return object;
    }
  }

  public static <T> T notNull(T object, BizCode bizCode, Object... params) throws BizException
  {
    if (object == null)
    {
      throw new BizException(bizCode.getCode(), assert_prefix + StrUtil.format(bizCode.getMsg(), params));
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
    } else
    {
      return object;
    }
  }
}
