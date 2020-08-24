package com.hawthorn.admin.model.dto.sysdept;

import com.hawthorn.framework.model.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hawthorn.framework.utils.json.serializer.JsonLocalDateTimeDeserializer;
import com.hawthorn.framework.utils.json.serializer.JsonLocalDateTimeSerializer;
import lombok.experimental.Accessors;


/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 机构管理(sys_dept) dto实体类
 * @author: andy.ten@tom.com
 * @date: 2020-08-24
 * @version v1.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "sys_dept", description = "机构管理" )
public class SysDeptDTO extends BaseDTO
{
  /**
   * 编号
   */
  @ApiModelProperty(value = "编号", name = "id" )
  private Long id;
  /**
   * 机构名称
   */
  @ApiModelProperty(value = "机构名称", name = "name" )
  private String name;
  /**
   * 上级机构ID，一级机构为0
   */
  @ApiModelProperty(value = "上级机构ID，一级机构为0", name = "parentId" )
  private Long parentId;
  /**
   * 排序
   */
  @ApiModelProperty(value = "排序", name = "orderNum" )
  private Integer orderNum;

  public SysDeptDTO()
  {
  }
}
