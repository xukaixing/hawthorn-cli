package com.hawthorn.framework.utils.common;

import cn.hutool.core.util.StrUtil;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.utils.iassert.AssertUtil;

import java.util.Locale;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 字符串工具类
 * @author:andy.ten@tom.com
 * @date:2020/8/16 8:57 下午
 * @version v1.0.1
 */
public class Str2Util extends StrUtil
{
  private static final char SEPARATOR = '_';

  /**
   * @remark: 将首字母转换为小写
   * @param: str
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 9:03 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static String firstCharToLowerCase(String str)
  {
    char firstChar = str.charAt(0);
    if (firstChar >= 'A' && firstChar <= 'Z')
    {
      char[] arr = str.toCharArray();
      arr[0] += ('a' - 'A');
      return new String(arr);
    }
    return str;
  }

  /**
   * @remark: 将首字母转换为大写
   * @param: str
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 9:03 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static String firstCharToUpperCase(String str)
  {
    char firstChar = str.charAt(0);
    if (firstChar >= 'a' && firstChar <= 'z')
    {
      char[] arr = str.toCharArray();
      arr[0] -= ('a' - 'A');
      return new String(arr);
    }
    return str;
  }

  /**
   * @remark: 将占位符 {} 按照顺序替换为参数:format("this is {} for {}", "a", "b") =》 this is a for b
   * @param: template
   * @param: params
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 3:45 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static String placeHolder(CharSequence template, Object... params)
  {
    AssertUtil.notNull(template, BizCode.METHOD_ARGS_NOTNULL, "template");
    return StrUtil.format(template, params);
  }

  /**
   * @remark: 将驼峰格式字符串转换为下划线格式字符串
   * @param: inputString
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:09 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static String toUnderline(String underlineString)
  {
    AssertUtil.notNull(underlineString, BizCode.METHOD_ARGS_NOTNULL, "underlineString");
    StringBuilder sb = new StringBuilder();
    boolean upperCase = false;
    for (int i = 0; i < underlineString.length(); i++)
    {
      char c = underlineString.charAt(i);
      boolean nextUpperCase = true;
      if (i < (underlineString.length() - 1))
      {
        nextUpperCase = Character.isUpperCase(underlineString.charAt(i + 1));
      }
      if (Character.isUpperCase(c))
      {
        if (!upperCase || !nextUpperCase)
        {
          sb.append(SEPARATOR);
        }
        upperCase = true;
      } else
      {
        upperCase = false;
      }
      sb.append(Character.toLowerCase(c));
    }

    return sb.toString();
  }

  /**
   * @remark: 将下划线格式字符串转换为驼峰格式字符串
   * @param: inputString
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:54 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static String toCamelCase(String inputString)
  {
    return toCamelCase(inputString, false);
  }

  /**
   * @remark: 将下划线格式字符串转换为驼峰格式字符串
   * @param: inputString
   * @param: firstCharacterUppercase 第一个字符是否大写
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:57 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static String toCamelCase(String inputString, boolean firstCharacterUppercase)
  {
    AssertUtil.notNull(inputString, BizCode.METHOD_ARGS_NOTNULL, "inputString");
    StringBuilder sb = new StringBuilder();
    boolean nextUpperCase = false;
    for (int i = 0; i < inputString.length(); i++)
    {
      char c = inputString.charAt(i);
      switch (c)
      {
        case '_':
        case '-':
        case '@':
        case '$':
        case '#':
        case ' ':
        case '/':
        case '&':
          if (sb.length() > 0)
          {
            nextUpperCase = true;
          }
          break;

        default:
          if (nextUpperCase)
          {
            sb.append(Character.toUpperCase(c));
            nextUpperCase = false;
          } else
          {
            sb.append(Character.toLowerCase(c));
          }
          break;
      }
    }
    if (firstCharacterUppercase)
    {
      sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
    }
    return sb.toString();
  }

  /**
   * @remark: 获取javaBean标准属性名称
   * @param: inputString
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:58 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static String getValidPropertyName(String inputString)
  {
    String answer;
    if (inputString == null)
    {
      answer = null;
    } else if (inputString.length() < 2)
    {
      answer = inputString.toLowerCase(Locale.US);
    } else
    {
      if (Character.isUpperCase(inputString.charAt(0)) && !Character.isUpperCase(inputString.charAt(1)))
      {
        answer = inputString.substring(0, 1).toLowerCase(Locale.US) + inputString.substring(1);
      } else
      {
        answer = inputString;
      }
    }
    return answer;
  }

  /**
   * @remark: 通过属性名返回javabean的setter方法名字符串
   * @param: property
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:59 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static String getSetterMethodName(String property)
  {
    StringBuilder sb = new StringBuilder();

    sb.append(property);
    if (Character.isLowerCase(sb.charAt(0)) && sb.length() > 1 && !Character.isUpperCase(sb.charAt(1)))
    {
      sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
    }
    sb.insert(0, "set");
    return sb.toString();
  }

  /**
   * @remark: 通过属性名返回javabean的getter方法名字符串
   * @param: property
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 12:00 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static String getGetterMethodName(String property)
  {
    StringBuilder sb = new StringBuilder();

    sb.append(property);
    if (Character.isLowerCase(sb.charAt(0)) && sb.length() > 1 && !Character.isUpperCase(sb.charAt(1)))
    {
      sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
    }
    sb.insert(0, "get");
    return sb.toString();
  }
}
