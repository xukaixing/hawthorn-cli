package com.hawthorn.framework.utils.iassert;

import cn.hutool.core.lang.Assert;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.exception.BizException;
import com.hawthorn.framework.utils.common.Str2Util;

/**
 * @Copyright: Copyright (c) 2020 andyten
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

  final static private String assert_prefix = "[Assert failed] -";

  /**
   * @remark: 断言对象是否为null，如果不为null,抛出异常
   * @param: object
   * @param: bizCode
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 5:48 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static void isNull(Object object, BizCode bizCode) throws IllegalArgumentException
  {
    if (object != null)
    {
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
      throw new BizException(bizCode.getCode(), assert_prefix + bizCode.getMsg());
    }
  }

  /**
   * @remark: 断言对象是否为null，如果不为null,抛出异常
   * @param: object
   * @param: bizCode
   * @param: params 消息模版中带有{}时，params为参数列表
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 3:48 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static void isNull(Object object, BizCode bizCode, Object... params) throws IllegalArgumentException
  {
    if (object != null)
    {
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
      throw new BizException(bizCode.getCode(), assert_prefix + Str2Util.placeHolder(bizCode.getMsg(), params));
    }
  }

  /**
   * @remark: 断言对象是否不为null ，如果为null 抛出异常
   * @param: object
   * @param: bizCode
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 5:49 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
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
      throw new BizException(bizCode.getCode(), assert_prefix + Str2Util.placeHolder(bizCode.getMsg(), params));
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
    } else
    {
      return object;
    }
  }

  /**
   * @remark: 检查给定字符串是否不为空，为空 抛出异常（为空是指 null 或 ""）
   * @param: text
   * @param: errorMsgTemplate
   * @param: params
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 5:50 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static <T extends CharSequence> T notEmpty(T text, BizCode bizCode, Object... params) throws BizException
  {
    if (Str2Util.isEmpty(text))
    {
      throw new BizException(bizCode.getCode(), assert_prefix + Str2Util.placeHolder(bizCode.getMsg(), params));
      //throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
    } else
    {
      return text;
    }
  }

  public static <T extends CharSequence> T notEmpty(T text, BizCode bizCode) throws BizException
  {
    if (Str2Util.isEmpty(text))
    {
      throw new BizException(bizCode);
    } else
    {
      return text;
    }
  }

}
