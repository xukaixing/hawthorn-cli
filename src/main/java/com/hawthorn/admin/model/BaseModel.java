package com.hawthorn.admin.model;

import lombok.Data;

import java.util.Date;

/**
 * 基础模型
 *
 * @author andy.ten@tom.com
 * @date Sep 13, 2020
 */
@Data
public class BaseModel
{
  private Long id;

  private String createBy;

  private Date createTime;

  private String lastUpdateBy;

  private Date lastUpdateTime;

  private Byte delFlag;

  private Byte status;

}
