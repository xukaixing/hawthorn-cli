# 说明

  `hawthorn-cli` hawthorn搭建模版。   
  作者:andy.ten@tom.com
      xukaixing@hotmail.com
  
## 版本
> v1.0.3 : 2020.08.10 
>> 增加application.yml多环境配置    
>> 增加bootstrap.yml配置文件  
>> 增加增加bootstrap.yml中增加mybatis配置  
>> 增加logback.xml多环境配置

---

> v1.0.2 : 2020.08.08 
>> 日志增加exectime配置  
>> 调整目录结构，增加framework包  
>> 增加aop切面功能  
>> 增加aop的执行时间插件

---

> v1.0.1 : 2020.07.14 
>> 配置日志格式配置：logback-spring.xml    
>> 增加了全局异常捕获处理  
>> 增加swagger2注解  
>> 增加swagger2美化ui  
>> 增加java工具包：hutool依赖

---

## 环境

- SpringBoot版本：2.3.1.RELEASE
- JDK版本：Jdk1.8+
- Maven版本：3.5.0+
- 数据库：mysql5.7，数据库用户名：sprbdemo
- 数据库开发工具：Navicat
- Java开发工具：IntelliJ IDEA
- 组件
  - `Slf4j+logback-spring`：日志插件
  - `Lombok`：生成Setter、Getter插件
  - `HuTool`: java工具包
  - `configuration-processor`: 自定义属性配置插件
  - `exectime`: 增加aop的执行时间插件
  - `mybatis`: 增加mybatis依赖
  - `mybatis-plus`: 增加plus依赖
  
## 运行

```java


```

## 目录

``` 目录
.
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── hawthorn
    │   │           ├── BootApplication.java
    │   │           ├── admin
    │   │           │   ├── controller
    │   │           │   │   ├── HelloController.java
    │   │           │   │   └── sysuser
    │   │           │   ├── model
    │   │           │   │   ├── BaseModel.java
    │   │           │   │   └── sysuser
    │   │           │   ├── repository
    │   │           │   │   └── sysuser
    │   │           │   └── service
    │   │           │       ├── Hello.java
    │   │           │       ├── HelloImpl.java
    │   │           │       └── sysuser
    │   │           └── framework
    │   │               ├── annotation
    │   │               │   ├── ExecTime.java
    │   │               │   └── MarkLog.java
    │   │               ├── aspect
    │   │               │   ├── ExecTimeAspect.java
    │   │               │   ├── MarkLogAspect.java
    │   │               │   └── TransactionalAspect.java
    │   │               ├── config
    │   │               │   ├── ApiError.java
    │   │               │   └── SwaggerConfig.java
    │   │               ├── exception
    │   │               │   ├── BizCode.java
    │   │               │   ├── BizException.java
    │   │               │   └── GlobalExceptionHandler.java
    │   │               ├── ret
    │   │               │   ├── BaseResult.java
    │   │               │   ├── ResultUtil.java
    │   │               │   └── RetCode.java
    │   │               └── util
    │   │                   ├── MyPropsConfig.java
    │   │                   └── http
    │   └── resources
    │       ├── META-INF
    │       ├── application-dev.yml
    │       ├── application-prod.yml
    │       ├── application.yml
    │       ├── banner.txt
    │       ├── bootstrap.yml
    │       ├── logback-spring-dev.xml
    │       ├── logback-spring-prod.xml
    │       ├── mapper
    │       │   └── SysUserMapper.xml
    │       └── rebel.xml
    └── test
        └── java
            └── com
                └── hawthorn
                    └── admin
                        ├── controller
                        │   └── HelloControllerTest.java
                        └── repository
                            └── sysuser

33 directories, 30 files

```

## 主页

- 欢迎访问个人 [github-xukaixing](https://github.com/xukaixing) 主页.
- 欢迎访问个人 [gitee-xukaixing](https://gitee.com/xukaixing) 主页.
