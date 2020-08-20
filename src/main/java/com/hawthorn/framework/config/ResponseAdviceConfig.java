package com.hawthorn.framework.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 全局封装响应类之前响应接口
 * @author:andy.ten@tom.com
 * @date:2020/8/20 4:23 下午
 * @version v1.0.1
 */
public interface ResponseAdviceConfig
{
  Object sucessResponse(ServerHttpRequest request, ServerHttpResponse response, Object body, MethodParameter returnType);

  @SuppressWarnings("rawtypes")
  ResponseEntity exceptionResponse(HttpServletRequest req, Throwable error, HttpServletResponse response);
}
