package com.hawthorn.framework.utils.bean;

import lombok.Data;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 查询条件bean
 * @author:andy.ten@tom.com
 * @date:2020/8/22 2:52 下午
 * @version v1.0.1
 */
@Data
public class QcBean
{
  public QcBean()
  {
  }

  public QcBean(String id, String code, String value, String kind, String format, String action, String ds, String op)
  {
    this.id = id;
    this.code = code;
    this.op = op;
    this.value = value;
    this.kind = kind;
    this.dateFormat = format;
    this.action = action;
    this.ds = ds;
  }

  public static final String KIND_TEXT = "text";
  public static final String KIND_DATE = "date";
  public static final String KIND_DATETIME = "datetime";

  private String id;
  private String op;
  private String value;
  private String code;
  private String kind;
  private String dateFormat;
  private String action;
  private String ds;

}
