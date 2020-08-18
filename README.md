# 说明

  `hawthorn-cli` hawthorn搭建模版。   
  作者:andy.ten@tom.com
      xukaixing@hotmail.com
  
## 版本
> v1.0.4 : 2020.08.18  
>> 增加BasePO、BaseModel、BaseDTO封装类     
>> 增加Str2Util、Map2ObjectUtil工具类，处理字符串工具类、map和object对象互相转换工具类      
>> 增加Yml、Property文件读取工具类    
>> 增加mp generator功能  

---

> v1.0.3 : 2020.08.10 
>> 增加application.yml多环境配置    
>> 增加bootstrap.yml配置文件    
>> 增加mybatis配置  
>> 增加logback.xml多环境配置  

---

> v1.0.2 : 2020.08.08 
>> 日志增加exectime配置  
>> 调整目录结构，增加framework包  
>> 增加aop切面功能  
>> 增加aop的执行时间插件

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
  - `mybatis-plus`: 增加mybatis-plus依赖
  - `mybatis-plus generator`: 增加mybatis-plus generator插件
  - `fastjson`: 增加阿里json处理插件
  
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
    │   │   ├── com
    │   │   │   └── hawthorn
    │   │   │       ├── BootApplication.java
    │   │   │       ├── admin
    │   │   │       │   ├── controller
    │   │   │       │   ├── model
    │   │   │       │   ├── repository
    │   │   │       │   └── service
    │   │   │       └── framework
    │   │   │           ├── annotation
    │   │   │           ├── aspect
    │   │   │           ├── config
    │   │   │           ├── controller
    │   │   │           ├── exception
    │   │   │           ├── generator
    │   │   │           ├── model
    │   │   │           ├── repository
    │   │   │           ├── ret
    │   │   │           ├── service
    │   │   │           └── utils
    │   │   └── template
    │   │       ├── myController.java.vm
    │   │       ├── myControllerTest.java.vm
    │   │       ├── myDto.java.vm
    │   │       ├── myEntity.java.vm
    │   │       ├── myMapper.java.vm
    │   │       ├── myMapper.xml.vm
    │   │       ├── myService.java.vm
    │   │       ├── myServiceImpl.java.vm
    │   │       └── myServiceImplTest.java.vm
    │   └── resources
    │       ├── META-INF
    │       ├── application-dev.yml
    │       ├── application-prod.yml
    │       ├── application.yml
    │       ├── banner.txt
    │       ├── bootstrap.yml
    │       ├── generator.yml
    │       ├── logback-spring-dev.xml
    │       ├── logback-spring-prod.xml
    │       ├── mapper
    │       │   └── SysUserMapper.xml
    │       └── rebel.xml
    └── test
        └── java
            └── com
                └── hawthorn
                    ├── admin
                    │   ├── controller
                    │   ├── database
                    │   └── repository
                    └── framework
                        └── generator

36 directories, 21 files

```

## 主页

- 欢迎访问个人 [github-xukaixing](https://github.com/xukaixing) 主页.
- 欢迎访问个人 [gitee-xukaixing](https://gitee.com/xukaixing) 主页.
