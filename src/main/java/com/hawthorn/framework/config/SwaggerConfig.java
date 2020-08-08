package com.hawthorn.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0.1
 * @className:SwaggerConfig
 * @descripion: swagger配置类
 * @author:andy.ten@tom.com
 * @date:2020/7/14 1:37 下午
 */
@Configuration
// 启动swagger
@EnableSwagger2
// 自动扫描，该注解会扫描指定路径下的所有的配置，默认扫描该类所在包下面的所有配置文件
@ComponentScan("com.**.**.**.config")
public class SwaggerConfig
{
  /*
   * 创建API应用
   * apiInfo() 增加API相关信息
   * select() 选择哪些路径和api会生成document
   * apis() 对所有api进行监控
   * paths() 对所有路径进行监控
   */
  @Bean
  public Docket createRestApi()
  {
    // 设置全局响应状态码
    List<ResponseMessage> responseMessageList = new ArrayList<>();
    responseMessageList.add(new ResponseMessageBuilder().code(200).message("成功").build());
    responseMessageList.add(new ResponseMessageBuilder().code(400).message("请求返回错误").build());
    responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").build());
    responseMessageList.add(new ResponseMessageBuilder().code(409).message("业务逻辑异常").build());
    responseMessageList.add(new ResponseMessageBuilder().code(422).message("参数校验异常").build());
    responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());
    responseMessageList.add(new ResponseMessageBuilder().code(503).message("Hystrix异常").build());

    return new Docket(DocumentationType.SWAGGER_2)

        .useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET, responseMessageList)
        .globalResponseMessage(RequestMethod.POST, responseMessageList)
        .globalResponseMessage(RequestMethod.PUT, responseMessageList)
        .globalResponseMessage(RequestMethod.DELETE, responseMessageList)

        .apiInfo(apiInfo())
        .select()
        //.apis(RequestHandlerSelectors.basePackage("com.andyten.hawthorn.admin.controller"))
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  /*
   * 创建该API的基本信息
   * title:访问界面的标题
   * description：描述
   * version：版本号
   */
  private ApiInfo apiInfo()
  {
    return new ApiInfoBuilder()
        .title("Swagger2 接口服务API文档")
        .description("hawthorn-microplatform")
        .version("1.0")
        .license("version1.0.1")
        .contact(new Contact("xukaixing", "https://github.com/xukaixing/", "andy.ten@tom.com"))
        .build();
  }
}
