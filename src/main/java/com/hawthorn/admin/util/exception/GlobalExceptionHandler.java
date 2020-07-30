package com.hawthorn.admin.util.exception;

import com.hawthorn.admin.util.ret.BaseResult;
import com.hawthorn.admin.util.ret.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version v1.0.1
 * @className:GlobalExceptionHandler
 * @descripion: 全局异常捕获类
 * @author:andy.ten@tom.com
 * @date:2020/7/15 7:33 下午
 */
// 拦截全局的Controller的异常，注意：ControllerAdvice注解只拦截Controller不会拦截Interceptor的异常
// 只能处理 Controller 层未捕获（往外抛）的异常，对于 Interceptor（拦截器）层的异常，Spring 框架层的异常，就无能为力了。
// 注意完善ExceptionHandle类
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
    log.error("方法参数无效异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("方法参数无效异常: " + ex.getMessage());
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
   * 全局异常Exception捕捉处理
   *
   * @param ex
   * @return
   */
  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public BaseResult<T> errorHandler(Exception ex)
  {
    log.error("未知错误异常: " + ex.getMessage(), ex);
    return ResultUtil.fail("未知错误异常: " + ex.getMessage());

    //return ResultUtil.fail(BizCode.ERROR_CREATE_DICT);
  }
}
