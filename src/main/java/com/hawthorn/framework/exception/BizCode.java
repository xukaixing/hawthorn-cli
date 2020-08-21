package com.hawthorn.framework.exception;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 异常错误代码枚举类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:26 下午
 * @version v1.0.1
 */
public enum BizCode
{
  //通用
  REQUEST_NULL(-10001, "请求有错误"),
  REQUEST_INVALIDATE(-10002, "请求数据格式不正确"),
  SESSION_TIMEOUT(-10003, "会话超时"),
  SERVER_ERROR(-10004, "服务器异常"),
  CONSOLE_INPUT_TIP(-10005, "在控制台，请输入正确的参数 : {}"),
  NULL_POINTER(-10006, "空指针异常"),
  VARIABLE_NOT_NULL(-10007, "变量值不能为null"),
  VARIABLE_NOT_EMPTY(-10008, "变量值不能为空"),
  VARIABLE_IS_EMPTY(-10009, "变量值必须为空"),
  VARIABLE_IS_NULL(-10010, "变量值必须为null"),
  POPULATE_VALUE_BYMETHOD(-10011, "根据方法名字对对象进行赋值失败"),

  DB_RESOURCE_NULL(-12001, "数据库中没有该资源"),

  STR_NOT_EMPTY(-13001, "字符串不能为空 : {}"),
  STR_FORMAT_NUM(-13002, "字符串转数字异常"),
  INDEX_OUTOF_BOUND(-13003, "角标越界异常"),

  CLASS_NOT_FOUND(-14001, "未找到指定类异常"),
  CLASS_MAP_OBJECT_FAIL(-14002, "map转换对象失败"),
  CLASS_OBJECT_MAP_FAIL(-14003, "对象转换map失败"),
  CLASS_NOT_NULL(-14004, "类实例[{}]不能为null"),
  CLASS_IS_NULL(-14005, "类实例[{}]必须为null"),
  METHOD_ARGS_NOTNULL(-15001, "参数[{}]值不能为空"),
  METHOD_ILLEGAL_ARGS(-15002, "非法参数异常"),
  METHOD_NOT_FOUND(-15003, "方法不存在异"),
  METHOD_ARGS_INVALID(-15004, "方法参数无效异"),

  YML_ANALYSIS_FAIL(-16001, "yml文件解析失败"),
  PROPERTY_LOAD_FAIL(-16002, "property文件加载失败"),
  PROPERTY_FILE_NOTFOUND(-16003, "property文件未找到"),

  UNKNOW_ERROR(-19999, "未知错误异常"),

  //菜单 + 权限
  MENU_PCODE_COINCIDENCE(-20001, "菜单编号和副编号不能一致"),
  MENU_EXISTED(-20002, "菜单编号重复，不能添加"),

  AUTH_NO_PERMITION(-21001, "权限异常"),
  AUTH_INVALID_KAPTCHA(-21002, "验证码不正确"),

  //用户
  USER_CANT_DELETE_ADMIN(-30001, "不能删除超级管理员"),
  USER_CANT_FREEZE_ADMIN(-30002, "不能冻结超级管理员"),
  USER_CANT_CHANGE_ADMIN(-30003, "不能修改超级管理员角色"),
  USER_ALREADY_REG(-30004, "该用户已经注册"),
  USER_NO_THIS(-30005, "没有此用户"),
  USER_NOT_EXISTED(-30006, "没有此用户"),
  USER_ACCOUNT_FREEZED(-30007, "账号被冻结"),
  USER_OLD_PWD_NOT_RIGHT(-30008, "原密码不正确"),
  USER_TWO_PWD_NOT_MATCH(-30009, "两次输入密码不一致"),

  //字典
  DICT_EXISTED(-40001, "字典已经存在"),
  DICT_CREATE(-40002, "创建字典失败"),
  DICT_WRAPPER_FIELD(-40003, "包装字典属性失败"),
  DICT_MUST_BE_NUMBER(-40004, "字典的值必须为数字"),

  //文件
  FILE_READING_ERROR(-50001, "文件读取失败!"),
  FILE_NOT_FOUND(-50002, "文件未找到!"),
  FILE_UPLOAD_ERROR(-50003, "上传图片出错"),
  FILE_OP_ERROR(-59999, "文件流操作失败."),

  //SQL
  SQL_DUPLICATE_KEY(-60001, "唯一键值列数据重复"),
  SQL_DATA_INTEGRITYVIOLATION(-60002, "更新或插入数据时违反完整性"),
  SQL_WALL_UNCATEGORIZED(-60003, "执行语句未通过防火墙验证"),
  SQL_MAPPING_TYPE(-60004, "设置参数时类型映射错误"),

  SQL_TRANSACTION_TIMEOUT(-61001, "事务执行超时"),

  SQL_EXEC_BAD(-69998, "SQL执行错误"),
  SQL_GRAMMAR_BAD(-69999, "SQL语法错误");

  //
  public int code;
  public String msg;

  public int getCode()
  {
    return code;
  }

  public void setCode(int code)
  {
    this.code = code;
  }

  public String getMsg()
  {
    return msg;
  }

  public void setMsg(String msg)
  {
    this.msg = msg;
  }

  BizCode(int code, String msg)
  {
    this.code = code;
    this.msg = msg;
  }

  public static void main(String[] args)
  {
    //System.out.println(BizCode.DICT_EXISTED.code);
  }
}
