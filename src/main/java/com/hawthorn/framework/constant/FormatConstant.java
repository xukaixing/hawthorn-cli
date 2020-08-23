package com.hawthorn.framework.constant;

/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 定义时间、浮点数等格式常量
 * @author:andy.ten@tom.com
 * @date:2020/8/23 5:29 下午
 * @version v1.0.1
 */
public class FormatConstant
{
  public static final String IOS_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
  public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
  public static final String SIMPLE_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
  public static final String FULL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String ACCURATE_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
  public static final String SIMPLE_DATE_MONTH_FORMAT = "yyyy-MM";
  public static final String SIMPLE_MONTH_FORMAT = "MM/dd";
  public static final String SIMPLE_MONTH_DAY_FORMAT = "MM-dd";
  public static final String SIMPLE_MONTH = "MM";
  public static final String SIMPLE_DAY_FORMAT = "dd";
  public static final String FULL_DATE_TIME_FORMAT_NUMBER = "yyyyMMddHHmmss";
  // 订单号位数
  public static final int SYSTEM_ORDER_NO_NUMBER = 5;
  /**
   * 不进行任何格式操作，没有千位符，小数点不自动补全
   */
  public static final String EXCEL_NUMBER_FORMAT_SAMPLE = "#";
  public static final String EXCEL_NUMBER_FORMAT_SAMPLE_ROUND2 = "0.00";
  // 设置百分比样式
  public static final String EXCEL_NUMBER_FORMAT_SAMPLE_PERCENT = "0.00%";

  private FormatConstant()
  {
  }
}
