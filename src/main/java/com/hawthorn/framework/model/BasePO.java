package com.hawthorn.framework.model;

import com.hawthorn.framework.utils.bean.Map2ObjectUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Copyright: Copyright (c) 2020 andyten
 *
 * @remark: 基础模型类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 8:11 下午
 * @version v1.0.1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BasePO extends BaseModel
{
  /**
   * 创建人
   */
  private String createBy;
  /**
   * 创建时间
   */
  private Date createTime;
  /**
   * 最后一次更新人
   */
  private String lastUpdateBy;

  /**
   * 最后一次更新时间
   */
  private Date lastUpdateTime;

  /**
   * 是否逻辑删除标识
   */
  private Byte delFlag;

  /**
   * 状态
   */
  private Byte status;

  /**
   * @remark: 将po<BasePO>转换为dto
   * @param: dtoClass
   * @return: T

   * @author: andy.ten@tom.com
   * @date: 2020/8/18 12:08 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/18    andy.ten        v1.0.1             init
   */
  public <T extends BaseDTO> T transPo2Dto(Class<T> dtoClass)
  {
    return Map2ObjectUtil.copyProperties(this, dtoClass);
  }
}
