package com.hawthorn.framework.model;

import com.hawthorn.framework.utils.bean.Map2ObjectUtil;

import java.io.Serializable;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 基础的dto类
 * @author:andy.ten@tom.com
 * @date:2020/8/17 5:36 下午
 * @version v1.0.1
 */
public class BaseDTO implements Serializable
{
  private static final long serialVersionUID = 1L;

  /**
   * @remark: 将当前dto实例的属性值复制到目标po的clazz类中
   * @param: poClass po类的.class
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 8:12 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public <T extends BaseModel> T transDto2Po(Class<T> poClass)
  {
    return Map2ObjectUtil.copyProperties(this, poClass);
  }

  /**
   * @remark: 将DTO对象实例转换为PO对象实例
   * @param: dto 对象实例dto
   * @param: po 对象实例po
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 8:14 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public <T extends BaseModel> void transDto2Po(BaseDTO dto, T po)
  {
    Map2ObjectUtil.copyProperties(dto, po);
  }

  /**
   * 定义赋值的抽象方法，以便子类继承并实现此方法
   */
  public <T extends BaseModel> void populateValueByMethod(T po)
  {
  }

  /**
   * 定义赋值的抽象方法，以便子类继承并实现此方法
   */
  public Map<String, Object> toMaps()
  {
    return Map2ObjectUtil.toMap(this);
  }
}
