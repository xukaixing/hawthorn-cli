package com.hawthorn.framework.utils.bean;

import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.exception.BizException;
import com.hawthorn.framework.utils.common.Str2Util;
import com.hawthorn.framework.utils.iassert.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: map与object相互转换工具类
 * @author:andy.ten@tom.com
 * @date:2020/8/17 5:40 下午
 * @version v1.0.1
 */
@Slf4j
public class Map2ObjectUtil extends MapUtils
{
  /**
   * @remark: 将对象orig的属性值复制到clazz类中
   * @param: orig 对象实例
   * @param: clazz 对象.class
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:33 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static <T> T copyProperties(Object orig, Class<T> clazz)
  {
    AssertUtil.notNull(orig, BizCode.METHOD_ARGS_NOTNULL, "orig");
    T t = null;
    try
    {
      t = clazz.getDeclaredConstructor().newInstance();
    } catch (ReflectiveOperationException e)
    {
      //log.error(e.getMessage(), e);
    }
    AssertUtil.notNull(t, BizCode.CLASS_NOT_FOUND);
    org.springframework.beans.BeanUtils.copyProperties(orig, t);
    return t;
  }

  /**
   * @remark: 将对象orig的属性值复制到对象destObj中
   * @param: orig 对象实例
   * @param: destObj 对象实例
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:42 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static void copyProperties(Object orig, Object destObj)
  {
    org.springframework.beans.BeanUtils.copyProperties(orig, destObj);
  }

  /**
   * @remark: 将对象orig的属性值复制到对象destObj中
   * @param: orig 对象实例
   * @param: destObj 对象实例
   * @param: ignoreProperties 忽略的属性，多个属性用","分隔
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:43 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static void copyProperties(Object orig, Object destObj, String... ignoreProperties)
  {
    org.springframework.beans.BeanUtils.copyProperties(orig, destObj, ignoreProperties);
  }

  /**
   * @remark: bean对象属性值为null的属性不进行copy 操作
   * @param: orig 对象实例
   * @param: destObj 对象实例
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:47 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static void copyPropertiesWithOutNull(Object orig, Object destObj)
  {
    org.springframework.beans.BeanUtils.copyProperties(orig, destObj, getNullValueByPropertyNames(orig));
  }


  /**
   * @remark: 获取bean对象属性值为null的属性
   * @param: source 对象实例
   * @return: java.lang.String[]

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:44 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  private static String[] getNullValueByPropertyNames(Object source)
  {
    final BeanWrapper src = new BeanWrapperImpl(source);
    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    HashSet<String> emptyNames = new HashSet<>();
    for (java.beans.PropertyDescriptor pd : pds)
    {
      Object srcValue = src.getPropertyValue(pd.getName());
      if (srcValue == null)
      {
        emptyNames.add(pd.getName());
      }
    }
    String[] result = new String[emptyNames.size()];
    return emptyNames.toArray(result);
  }

  /**
   * @remark: 批量将origList 的属性值复制到 destList中
   * @param: origList 对象实例list
   * @param: destClass 对象.class的list
   * @return: java.util.List<T>

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:51 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static <T> List<T> copyList(List<?> origList, Class<T> destClass)
  {
    List<T> destList = new ArrayList<>();
    for (Object orig : origList)
    {
      destList.add(copyProperties(orig, destClass));
    }
    return destList;
  }

  /**
   * @remark: 将map转换成对象实例
   * @param: map 需要转换的map对象实例
   * @param: object 转换为目标的对象实例
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 8:06 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static <T, V> T toObject(Map<String, V> map, T object)
  {
    try
    {
      org.apache.commons.beanutils.BeanUtils.populate(object, map);
      return object;
    } catch (Exception e)
    {
      throw new BizException(BizCode.CLASS_MAP_OBJECT_FAIL);
    }
  }

  /**
   * @remark: 将map转换成class对象
   * @param: clazz 对象.class
   * @param: map
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:52 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static <T, V> T toObject(Map<String, V> map, Class<T> clazz)
  {
    try
    {
      T object = clazz.getDeclaredConstructor().newInstance();
      return toObject(map, object);
    } catch (Exception e)
    {
      throw new BizException(BizCode.CLASS_MAP_OBJECT_FAIL);
    }
  }

  /**
   * @remark: 将map转换成class对象
   * @param: clazz
   * @param: map
   * @param: toCamelCase 驼峰方式
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 8:50 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public static <T, V> T toObject(Map<String, V> map, Class<T> clazz, boolean toCamelCase)
  {
    try
    {
      T object = clazz.getDeclaredConstructor().newInstance();
      return toObject(map, object, toCamelCase);
    } catch (Exception e)
    {
      throw new BizException(BizCode.CLASS_MAP_OBJECT_FAIL);
    }
  }


  /**
   * 将map 转换成对象,将完成驼峰式转换
   *
   * @param object
   * @param map
   * @param toCamelCase
   * @return T
   * @throws
   * @author zhangxianchao
   * @since 2018/7/22 0022
   */
  public static <T, V> T toObject(Map<String, V> map, T object, boolean toCamelCase)
  {
    try
    {
      if (toCamelCase)
      {
        map = toMapForCamelCase(map);
      }
      org.apache.commons.beanutils.BeanUtils.populate(object, map);
      return object;
    } catch (Exception e)
    {
      throw new BizException(BizCode.CLASS_MAP_OBJECT_FAIL);
    }
  }

  /**
   * @remark: 将对象转换成MAP
   * @param: obj
   * @return: java.util.Map<java.lang.String, java.lang.Object>

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:07 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static Map<String, Object> toMap(Object obj)
  {
    try
    {
      AssertUtil.notNull(obj, BizCode.METHOD_ARGS_NOTNULL, "obj");
      Map<String, Object> map = new HashMap<>();
      BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
      PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
      for (PropertyDescriptor property : propertyDescriptors)
      {
        String key = property.getName();
        if (key.compareToIgnoreCase("class") == 0)
        {
          continue;
        }
        Method getter = property.getReadMethod();
        Object value = getter != null ? getter.invoke(obj) : null;
        map.put(key, value);
      }
      return map;
    } catch (Exception e)
    {
      throw new BizException(BizCode.CLASS_OBJECT_MAP_FAIL);
    }
  }

  /**
   * @remark: 转换成Map并提供字段命名为下划线格式
   * @param: object
   * @return: java.util.Map<java.lang.String, java.lang.Object>

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:13 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static Map<String, Object> toMapForUnderline(Object object)
  {
    try
    {
      Map<String, Object> map = toMap(object);
      return toUnderlineStringMap(map);
    } catch (Exception e)
    {
      throw new BizException(BizCode.CLASS_OBJECT_MAP_FAIL);
    }
  }

  /**
   * @remark: 对象集合转换成map集合
   * @param: collection
   * @return: java.util.Collection<java.util.Map < java.lang.String, java.lang.Object>>

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:15 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static <T> Collection<Map<String, Object>> toMapList(Collection<T> collection)
  {
    List<Map<String, Object>> retList = new ArrayList<>();
    if (collection != null && !collection.isEmpty())
    {
      for (Object object : collection)
      {
        Map<String, Object> map = toMap(object);
        retList.add(map);
      }
    }
    return retList;
  }

  /**
   * @remark: 转换成驼峰格式
   * @param: map
   * @return: java.util.Map<java.lang.String, V>

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:15 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static <V> Map<String, V> toMapForCamelCase(Map<String, V> map)
  {
    Map<String, V> newMap = new HashMap<>();
    for (Map.Entry<String, V> entry : map.entrySet())
    {
      safeAddToMap(newMap, Str2Util.toCamelCase(entry.getKey()), entry.getValue());
    }
    return newMap;
  }

  /**
   * @remark: 将Map的Keys转译成下划线格式的
   * @param: map
   * @return: java.util.Map<java.lang.String, V>

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:09 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static <V> Map<String, V> toUnderlineStringMap(Map<String, V> map)
  {
    Map<String, V> newMap = new HashMap<>();
    for (Map.Entry<String, V> entry : map.entrySet())
    {
      newMap.put(Str2Util.toUnderline(entry.getKey()), entry.getValue());
    }
    return newMap;
  }


  /**
   * @remark: 转换为Collection, 同时字段做驼峰转换
   * @param: collection
   * @return: java.util.Collection<java.util.Map < java.lang.String, java.lang.Object>>

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:18 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static <T> Collection<Map<String, Object>> toMapListForUnderline(Collection<T> collection)
  {
    List<Map<String, Object>> retList = new ArrayList<>();
    if (collection != null && !collection.isEmpty())
    {
      for (Object object : collection)
      {
        Map<String, Object> map = toMapForUnderline(object);
        retList.add(map);
      }
    }
    return retList;
  }

  /**
   * @remark: 根据方法名字对对象进行赋值
   * @param: object
   * @param: methodName
   * @param: value
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 11:19 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public static void populateValueByMethod(Object object, String methodName, Object value)
  {
    Method method = org.springframework.beans.BeanUtils.findMethodWithMinimalParameters(object.getClass(), methodName);
    try
    {
      AssertUtil.notNull(method, BizCode.CLASS_NOT_NULL, "method");
      method.invoke(object, value);
    } catch (Exception e)
    {
      throw new BizException(BizCode.POPULATE_VALUE_BYMETHOD);
    }
  }


}
