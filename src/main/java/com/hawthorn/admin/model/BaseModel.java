package com.hawthorn.admin.model;

import lombok.Data;

import java.util.Date;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 基础模型
 * @author:andy.ten@tom.com
 * @date:2020/8/13 8:11 下午
 * @version v1.0.1
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
