package com.hawthorn.admin.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hawthorn.framework.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 机构管理(sys_dept) po实体类
 * @author: andy.ten@tom.com
 * @date: 2020-08-24
 * @version v1.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dept" )
public class SysDeptPO extends BasePO
{
  /**
   * 编号
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /**
   * 机构名称
   */
  @TableField("name" )
  private String name;
  /**
   * 上级机构ID，一级机构为0
   */
  @TableField("parent_id" )
  private Long parentId;
  /**
   * 排序
   */
  @TableField("order_num" )
  private Integer orderNum;

  public SysDeptPO()
  {
  }
}
