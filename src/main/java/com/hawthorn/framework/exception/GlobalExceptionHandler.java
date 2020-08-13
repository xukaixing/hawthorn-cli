package com.hawthorn.framework.exception;


import com.hawthorn.framework.ret.BaseResult;
import com.hawthorn.framework.ret.ResultUtil;
import com.hawthorn.framework.util.http.HttpStatusUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 全局异常捕获类
 * @author:andy.ten@tom.com
 * @date:2020/8/11 5:26 下午
 * @version v1.0.1
 */
// 拦截全局的Controller的异常，注意：ControllerAdvice注解只拦截Controller不会拦截Interceptor的异常
// 只能处理 Controller 层未捕获（往外抛）的异常，对于 Interceptor（拦截器）层的异常，Spring 框架层的异常，就无能为力了。
// 注意完善ExceptionHandle类
// @ControllerAdvice也是AOP自定义注解
//@ControllerAdvice(annotations = {Controller.class, RestController.class})
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler<T>
{
  /**
   * 全局异常BusinessException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = BizException.class)
  public BaseResult<T> errorHandler(BizException ex)
  {
    log.error("业务异常代码: " + ex.getMsg() + " " + "业务异常: " + ex.getMsg() + " ");
    return ResultUtil.fail(ex.getCode(), "业务异常: " + ex.getMessage());
  }

  /**
   * 全局异常MethodArgumentNotValidException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public BaseResult<T> errorHandler(MethodArgumentNotValidException ex)
  {
    log.error("方法参数无效异常[" + HttpStatusUtils.SC_METHOD_FAILURE + "]: " + ex.getMessage(), ex);
    return ResultUtil.fail(HttpStatusUtils.SC_METHOD_FAILURE, "方法参数无效异常: " + ex.getMessage());
  }

  /**
   * 全局异常NoSuchMethodException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = NoSuchMethodException.class)
  public BaseResult<T> errorHandler(NoSuchMethodException ex)
  {
    log.error("方法不存在异常[" + HttpStatusUtils.SC_METHOD_FAILURE + "]: " + ex.getMessage(), ex);
    return ResultUtil.fail(HttpStatusUtils.SC_METHOD_FAILURE, "方法不存在异常: " + ex.getMessage());
  }

  /**
   * 全局异常ClassNotFoundException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = ClassNotFoundException.class)
  public BaseResult<T> errorHandler(ClassNotFoundException ex)
  {
    log.error("未找到指定类异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("未找到指定类异常: " + ex.getMessage());
  }

  /**
   * 全局异常IllegalArgumentException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = IllegalArgumentException.class)
  public BaseResult<T> errorHandler(IllegalArgumentException ex)
  {
    log.error("方法传递参数异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("方法传递参数异常: " + ex.getMessage());
  }

  /**
   * 全局异常NullPointerException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = NullPointerException.class)
  public BaseResult<T> errorHandler(NullPointerException ex)
  {
    log.error("空指针异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("空指针异常: " + ex.getMessage());
  }

  /**
   * 全局异常IndexOutOfBoundsException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = IndexOutOfBoundsException.class)
  public BaseResult<T> errorHandler(IndexOutOfBoundsException ex)
  {
    log.error("角标越界异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("角标越界异常: " + ex.getMessage());
  }

  /**
   * 全局异常NumberFormatException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = NumberFormatException.class)
  public BaseResult<T> errorHandler(NumberFormatException ex)
  {
    log.error("字符串转换为数字异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("字符串转换为数字异常: " + ex.getMessage());
  }

  /**
   * 全局异常IOException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = IOException.class)
  public BaseResult<T> errorHandler(IOException ex)
  {
    log.error("IO异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("IO异常: " + ex.getMessage());
  }

  /**
   * 全局异常SQLException捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = SQLException.class)
  public BaseResult<T> errorHandler(SQLException ex)
  {
    log.error("SQL异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("SQL异常: " + ex.getMessage());
  }

  /**
   * 全局异常Exception捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public BaseResult<T> errorHandler(Exception ex)
  {
    //获取request
    //ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    //HttpServletRequest request = requestAttributes.getRequest();
    log.error("未知错误异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("未知错误异常: " + ex.getMessage());
    //return ResultUtil.fail(BizCode.ERROR_CREATE_DICT);
  }

}
