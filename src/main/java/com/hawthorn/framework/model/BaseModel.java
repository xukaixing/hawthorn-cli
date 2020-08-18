package com.hawthorn.framework.model;

import com.hawthorn.framework.utils.bean.Map2ObjectUtil;

import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 基础的model类
 * @author:andy.ten@tom.com
 * @date:2020/8/17 6:05 下午
 * @version v1.0.1
 */
public class BaseModel
{

  /**
   * 仅当使用activeRecord模式时使用
   */
  // @Override
  // protected Serializable pkVal()
  // {
  //   return null;
  // }

  /**
   * @remark: 将po<BaseModel>转换为dto
   * @param: dtoClass
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/17 7:31 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/17    andy.ten        v1.0.1             init
   */
  public <T extends BaseDTO> T transPo2Dto(Class<T> dtoClass)
  {
    return Map2ObjectUtil.copyProperties(this, dtoClass);
  }

  /**
   * @remark: 将po转换为dto
   * @param: po 对象实例
   * @param: dto 对象实例
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 12:03 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  protected <T extends BaseDTO> void transPo2Dto(BaseModel po, T dto)
  {
    Map2ObjectUtil.copyProperties(po, dto);
  }

  /**
   * @remark: 根据方法名字对对象进行赋值
   * @param: po
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 12:05 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  protected <T extends BaseDTO> void populateValueByMethod(T po)
  {
  }

  /**
   * @remark: 将对象转换成MAP
   * @param:
   * @return: java.util.Map<java.lang.String, java.lang.Object>

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 12:06 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public Map<String, Object> toMaps()
  {
    return Map2ObjectUtil.toMap(this);
  }

}
