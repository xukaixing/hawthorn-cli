# 说明

  `hawthorn-cli` hawthorn搭建模版。   
  作者:andy.ten@tom.com 
  
## 版本
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
  
## 运行

```java


```

## 目录

``` 目录
.
├── logs
│   ├── log_druid.log
│   ├── logs.2020-07-17-0.log
│   ├── logs.log
│   ├── logs_error.log
│   └── logs_warn.log
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── hawthorn
    │   │           ├── HawthornApplication.java
    │   │           └── admin
    │   └── resources
    │       ├── application.yml
    │       ├── banner.txt
    │       ├── logback-spring.xml
    │       └── rebel.xml
    └── test

9 directories, 11 files

```

## 主页

- 欢迎访问个人 [github-xukaixing](https://github.com/xukaixing) 主页.
- 欢迎访问个人 [gitee-xukaixing](https://gitee.com/xukaixing) 主页.
