package com.hawthorn.framework.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.hawthorn.framework.utils.bean.Map2ObjectUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

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
  @TableField(value = "create_by", fill = FieldFill.INSERT)
  private String createBy;
  /**
   * 创建时间
   */
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  /**
   * 最后一次更新人
   */
  @TableField(value = "last_update_by", fill = FieldFill.INSERT_UPDATE)
  private String lastUpdateBy;

  /**
   * 最后一次更新时间 ，注意类型必须是：Timestamp，否则自动填充为null
   */
  @TableField(value = "last_update_time", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime lastUpdateTime;

  /**
   * 是否逻辑删除标识
   */
  @TableLogic(value = "0", delval = "-1")
  @TableField(value = "del_flag", fill = FieldFill.INSERT)
  private Integer delFlag;

  /**
   * 状态
   */
  @TableField(value = "status", fill = FieldFill.INSERT)
  private Integer status;

  /**
   * 乐观锁
   */
  @Version
  @TableField(value = "version", fill = FieldFill.INSERT)
  private Integer version;

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
