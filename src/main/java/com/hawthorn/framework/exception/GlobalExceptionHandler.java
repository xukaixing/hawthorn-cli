package com.hawthorn.framework.exception;


import cn.hutool.core.exceptions.ExceptionUtil;
import com.hawthorn.framework.ret.BaseResult;
import com.hawthorn.framework.ret.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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
@SuppressWarnings("unchecked")
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
    log.error("业务异常[" + ex.getCode() + "] : " + ex.getMsg() + " ");
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
    log.error("方法参数无效异[" + BizCode.METHOD_ARGS_INVALID.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.METHOD_ARGS_INVALID.getCode(), "方法参数无效异:" + BizCode.METHOD_ARGS_INVALID.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("方法不存在异[" + BizCode.METHOD_NOT_FOUND.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.METHOD_NOT_FOUND.getCode(), "方法不存在异:" + BizCode.METHOD_NOT_FOUND.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("未找到指定类异常[" + BizCode.CLASS_NOT_FOUND.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.CLASS_NOT_FOUND.getCode(), "未找到指定类异常:" + BizCode.CLASS_NOT_FOUND.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("空指针异常[" + BizCode.NULL_POINTER.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.NULL_POINTER.getCode(), "空指针异常:" + BizCode.NULL_POINTER.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("角标越界异常常[" + BizCode.INDEX_OUTOF_BOUND.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.INDEX_OUTOF_BOUND.getCode(), "角标越界异常:" + BizCode.INDEX_OUTOF_BOUND.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("字符串转数字异常[" + BizCode.STR_FORMAT_NUM.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.STR_FORMAT_NUM.getCode(), "字符串转数字异常:" + BizCode.STR_FORMAT_NUM.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("IO异常[" + BizCode.FILE_OP_ERROR.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.FILE_OP_ERROR.getCode(), "IO异常:" + BizCode.FILE_OP_ERROR.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 全局异常DuplicateKeyException捕捉处理
   *
   * @param ex
   * @return
   */
  @SuppressWarnings("unchecked")
  @ResponseBody
  @ExceptionHandler(value = DuplicateKeyException.class)
  public BaseResult<T> errorHandler(DuplicateKeyException ex)
  {
    log.error("SQL异常[" + BizCode.SQL_DUPLICATE_KEY.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_DUPLICATE_KEY.getCode(), "数据操作异常:" + BizCode.SQL_DUPLICATE_KEY.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 全局异常DataIntegrityViolationException捕捉处理
   *
   * @param ex
   * @return
   */
  @SuppressWarnings("unchecked")
  @ResponseBody
  @ExceptionHandler(value = DataIntegrityViolationException.class)
  public BaseResult<T> errorHandler(DataIntegrityViolationException ex)
  {
    log.error("SQL异常[" + BizCode.SQL_DATA_INTEGRITYVIOLATION.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_DATA_INTEGRITYVIOLATION.getCode(), "数据操作异常:" + BizCode.SQL_DATA_INTEGRITYVIOLATION.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("非法参数异常[" + BizCode.METHOD_ILLEGAL_ARGS.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.METHOD_ILLEGAL_ARGS.getCode(), "非法参数异常:" + BizCode.METHOD_ILLEGAL_ARGS.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
  }

  // /**
  //  * 全局异常UncategorizedSQLException捕捉处理
  //  *
  //  * @param ex
  //  * @return
  //  */
  // @SuppressWarnings("unchecked")
  // @ResponseBody
  // @ExceptionHandler(value = UncategorizedSQLException.class)
  // public BaseResult<T> errorHandler(UncategorizedSQLException ex)
  // {
  //   log.error("SQL异常[" + BizCode.SQL_WALL_UNCATEGORIZED.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
  //   return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_WALL_UNCATEGORIZED.getCode(), "数据操作异常:" + BizCode.SQL_WALL_UNCATEGORIZED.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
  // }

  /**
   * 全局异常MyBatisSystemException捕捉处理
   *
   * @param ex
   * @return
   */
  @SuppressWarnings("unchecked")
  @ResponseBody
  @ExceptionHandler(value = MyBatisSystemException.class)
  public BaseResult<T> errorHandler(MyBatisSystemException ex)
  {
    String eMsg = ex.getCause().toString();
    // TypeException
    if (eMsg.contains("TypeException"))
    {
      log.error("SQL异常[" + BizCode.SQL_MAPPING_TYPE.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
      return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_MAPPING_TYPE.getCode(), "数据操作异常:" + BizCode.SQL_MAPPING_TYPE.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
    } else if (eMsg.contains("ReflectionException"))
    {
      log.error("SQL异常[" + BizCode.SQL_MAPPING_TYPE.getCode() + "] : " + eMsg);
      return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_MAPPING_TYPE.getCode(), "数据操作异常:" + BizCode.SQL_MAPPING_TYPE.getMsg(), ExceptionUtil.getMessage(ex));
    } else
    {
      log.error("SQL异常[" + BizCode.SQL_EXEC_BAD.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
      return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_EXEC_BAD.getCode(), "数据操作异常:" + BizCode.SQL_EXEC_BAD.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
    }

  }

  /**
   * 全局异常BadSqlGrammarException捕捉处理
   *
   * @param ex
   * @return
   */
  @SuppressWarnings("unchecked")
  @ResponseBody
  @ExceptionHandler(value = BadSqlGrammarException.class)
  public BaseResult<T> errorHandler(BadSqlGrammarException ex)
  {
    log.error("SQL异常[" + BizCode.SQL_GRAMMAR_BAD.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_GRAMMAR_BAD.getCode(), "数据操作异常:" + BizCode.SQL_GRAMMAR_BAD.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
  }

  /**
   * 全局异常TransactionTimedOutException捕捉处理
   *
   * @param ex
   * @return
   */
  @SuppressWarnings("unchecked")
  @ResponseBody
  @ExceptionHandler(value = TransactionTimedOutException.class)
  public BaseResult<T> errorHandler(TransactionTimedOutException ex)
  {
    log.error("SQL异常[" + BizCode.SQL_TRANSACTION_TIMEOUT.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex));
    return (BaseResult<T>) ResultUtil.fail(BizCode.SQL_TRANSACTION_TIMEOUT.getCode(), "数据操作异常:" + BizCode.SQL_TRANSACTION_TIMEOUT.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
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
    log.error("未知错误异常[" + BizCode.UNKNOW_ERROR.getCode() + "] : " + ExceptionUtil.getRootCauseMessage(ex), ex);
    return (BaseResult<T>) ResultUtil.fail(BizCode.UNKNOW_ERROR.getCode(), BizCode.UNKNOW_ERROR.getMsg(), ExceptionUtil.getRootCauseMessage(ex));
    //return ResultUtil.fail(BizCode.ERROR_CREATE_DICT);
  }

}
