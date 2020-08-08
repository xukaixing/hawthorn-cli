package com.hawthorn.framework.exception;

public enum BizCode
{
  //通用
  MENU_PCODE_COINCIDENCE(10001, "菜单编号和副编号不能一致"),
  EXISTED_THE_MENU(10002, "菜单编号重复，不能添加"),
  DICT_MUST_BE_NUMBER(10003, "字典的值必须为数字"),
  REQUEST_NULL(10004, "请求有错误"),
  SESSION_TIMEOUT(10005, "会话超时"),
  SERVER_ERROR(10006, "服务器异常"),
  //权限
  DB_RESOURCE_NULL(20001, "数据库中没有该资源"),
  NO_PERMITION(20002, "权限异常"),
  REQUEST_INVALIDATE(20003, "请求数据格式不正确"),
  INVALID_KAPTCHA(20004, "验证码不正确"),
  CANT_DELETE_ADMIN(20005, "不能删除超级管理员"),
  CANT_FREEZE_ADMIN(20006, "不能冻结超级管理员"),
  CANT_CHANGE_ADMIN(20007, "不能修改超级管理员角色"),
  //用户
  USER_ALREADY_REG(30001, "该用户已经注册"),
  NO_THIS_USER(30002, "没有此用户"),
  USER_NOT_EXISTED(30003, "没有此用户"),
  ACCOUNT_FREEZED(30004, "账号被冻结"),
  OLD_PWD_NOT_RIGHT(30005, "原密码不正确"),
  TWO_PWD_NOT_MATCH(30006, "两次输入密码不一致"),
  //字典
  DICT_EXISTED(40001, "字典已经存在"),
  ERROR_CREATE_DICT(40002, "创建字典失败"),
  ERROR_WRAPPER_FIELD(40003, "包装字典属性失败"),
  //文件
  FILE_READING_ERROR(50001, "文件读取失败!"),
  FILE_NOT_FOUND(50002, "文件未找到!"),
  UPLOAD_ERROR(50003, "上传图片出错");
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
