package com.hawthorn.framework.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.exception.BizException;
import com.hawthorn.framework.utils.common.Str2Util;
import com.hawthorn.framework.utils.iassert.AssertUtil;
import com.hawthorn.framework.utils.resource.YmlUtil;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: mybatis-plus 代码生成器
 * @author:andy.ten@tom.com
 * @date:2020/8/16 5:29 下午
 * @version v1.0.1
 */
@Slf4j
public class MPCodeGenerator
{
  private static final String RESOURCE_FILE = "generator.yml";
  private static final String JAVA_VM_SUFFIX = ".java.vm";
  private static final String OUTPUT_MODULE_NAME = "output.moduleName";
  private static final String OUTPUT_PACKAGE_NAME = "output.packageName";
  private static final String OUTPUT_PATH = "output.path";
  private static final String OUTPUT_DEFINE_CHILDPACKAGE_CONTROLLER = "output.defineChildPackage.controller";
  private static final String OUTPUT_DEFINE_CHILDPACKAGE_MAPPER = "output.defineChildPackage.mapper";
  private static final String OUTPUT_DEFINE_CHILDPACKAGE_ENTITY = "output.defineChildPackage.entity";
  private static final String OUTPUT_DEFINE_CHILDPACKAGE_SERVICE = "output.defineChildPackage.service";
  private static final String OUTPUT_DEFINE_CHILDPACKAGE_SERVICEIMPL = "output.defineChildPackage.serviceImpl";


  /**
   * @remark: 读取控制台的内容
   * @param: tip
   * @return: java.lang.String

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 5:32 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static String scanner(String tip)
  {
    Scanner scanner = new Scanner(System.in);

    log.info("请输入" + tip + ": ");
    if (scanner.hasNext())
    {
      String ipt = scanner.next();
      return AssertUtil.notEmpty(ipt, BizCode.CONSOLE_INPUT_TIP, "tip");

      // if (StrUtil.isNotEmpty(ipt))
      // {
      //   return ipt;
      // }
    }
    throw new BizException(BizCode.CONSOLE_INPUT_TIP.getCode(), Str2Util.placeHolder(BizCode.CONSOLE_INPUT_TIP.getMsg(), tip));
  }

  /**
   * @remark: 代码生成方法
   * @param:
   * @return: void

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 6:13 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static void generate()
  {
    // 文件目录结构设置
    // 加载yml生成配置文件
    Properties properties = YmlUtil.yaml2Properties(RESOURCE_FILE);
    // 输出的模块名
    String moduleName = properties.getProperty(OUTPUT_MODULE_NAME);
    // 将模块.改为路径：/
    String moduleNameDir = moduleName.replaceAll("\\.", "/");
    // 输出目录的一级包名，例如：com.**.admin
    String packageName = properties.getProperty(OUTPUT_PACKAGE_NAME);
    // 输出一级包下的controller层子包，例如：com.**.admin.controller
    String controllerPackage = Str2Util.emptyToDefault(properties.getProperty(OUTPUT_DEFINE_CHILDPACKAGE_CONTROLLER), "controller");
    // 输出一级包下的mapper层子包，例如：com.**.admin.repository
    String mapperPackage = Str2Util.emptyToDefault(properties.getProperty(OUTPUT_DEFINE_CHILDPACKAGE_MAPPER), "repository");
    // 输出一级包下的model层子包，例如：com.**.admin.model
    String entityPackage = Str2Util.emptyToDefault(properties.getProperty(OUTPUT_DEFINE_CHILDPACKAGE_ENTITY), "entity");
    // 输出一级包下的service层子包，例如：com.**.admin.service
    String servicePackage = Str2Util.emptyToDefault(properties.getProperty(OUTPUT_DEFINE_CHILDPACKAGE_SERVICE), "service");
    // 输出一级包下的serviceImpl层子包，例如：com.**.admin.service.impl
    String serviceImplPackage = Str2Util.emptyToDefault(properties.getProperty(OUTPUT_DEFINE_CHILDPACKAGE_SERVICEIMPL), "impl");

    //策略配置
    CustomStrategyConfig customConfig = new CustomStrategyConfig();
    // 自定义继承的Entity类全称，带包名
    customConfig.setSuperEntityClass("com.hawthorn.framework.model.BaseModel");
    // 自定义基础的Entity类，公共字段
    customConfig.setSuperEntityColumns(new String[]{"CREATED_BY", "CREATED_AT", "UPDATED_BY", "UPDATED_AT", "RECORD_VERSION", "APP_ID"});
    // 自定义继承的Mapper类全称，带包名
    customConfig.setSuperMapperClass("com.hawthorn.framework.repository.DBMapper");
    // 自定义继承的Controller类全称，带包名
    //customConfig.setSuperControllerClass("com.hawthorn.framwork.controller");
    // 是否移除is前缀(默认 false）
    customConfig.setEntityBooleanColumnRemoveIsPrefix(false);
    // 逻辑删除属性名称
    customConfig.setLogicDeleteFieldName("DEL_FLAG");

    // 第一步：代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 第二步：全局配置 + 数据源配置 + 策略配置
    setAutoGeneratorConfig(mpg, properties, customConfig);

    // 第三步：进行模板配置
    setTemplateConfig(mpg, properties);

    // 第四步：包名配置
    PackageConfig packageConfig = new PackageConfig().setParent(packageName);
    packageConfig.setController(controllerPackage + "." + moduleName);
    packageConfig.setEntity(entityPackage + "." + moduleName);
    packageConfig.setService(servicePackage + "." + moduleName);
    packageConfig.setServiceImpl(servicePackage + "." + moduleName + "." + serviceImplPackage);
    packageConfig.setMapper(mapperPackage + "." + moduleName);
    mpg.setPackageInfo(packageConfig);

    String dtoPackage = properties.getProperty("output.defineChildPackage.dto");
    final String dtoPackageStatic = dtoPackage == null ? "bean.dto" : dtoPackage;
    InjectionConfig injectionConfig = new InjectionConfig()
    {
      /**
       * 注入自定义 Map 对象
       */
      @Override
      public void initMap()
      {
        this.getConfig().getGlobalConfig().getEntityName();
        Map<String, Object> map = new HashMap<>();
        map.put("packageDto", packageName + (mpg.getPackageInfo().getModuleName()
            == null ? "" : "." + mpg.getPackageInfo().getModuleName()) + "."
            + dtoPackageStatic + "." +
            moduleName);
        map.put("moduleName", moduleNameDir);

        map.put("packageServiceImplTest", packageName + (mpg.getPackageInfo().getModuleName()
            == null ? "" : "." + mpg.getPackageInfo().getModuleName()) + "."
            + servicePackage + "." +
            moduleName);

        this.setMap(map);
      }
    };

    List<FileOutConfig> fileOutConfigs = new ArrayList<>();
    //进行xml 生成配置
    setXmlOutPutConfig(properties, fileOutConfigs);
    //进行DTO 输出配置
    setDtoOutPutConfig(properties, fileOutConfigs, mpg);
    //进行ControllerTest 输出配置
    setControllerTestConfig(properties, fileOutConfigs, mpg);
    //进行ServiceTest 输出配置
    setServiceTestConfig(properties, fileOutConfigs, mpg);

    injectionConfig.setFileOutConfigList(fileOutConfigs);

    mpg.setCfg(injectionConfig);


    // 执行生成
    mpg.execute();
  }

  // 全局配置 + 数据源配置 + 策略配置
  @SuppressWarnings("deprecation")
  private static void setAutoGeneratorConfig(AutoGenerator mpg, Properties properties, CustomStrategyConfig
      customConfig)
  {
    // 文件路径
    String outputPath = properties.getProperty(OUTPUT_PATH);
    File file = new File(outputPath);
    String path = file.getAbsolutePath();
    // 作者
    String authorName = properties.getProperty("output.author");
    //table名字
    String[] tables = properties.getProperty("table.tableNames").split(",");
    //table前缀
    String prefix = properties.getProperty("table.tablePrefix");
    //全局配置
    mpg.setGlobalConfig(
        // 全局配置
        new GlobalConfig()
            .setOutputDir(path + "/src/main/java")//输出目录
            .setFileOverride(true)// 是否覆盖文件
            .setActiveRecord(false)// 关闭 activeRecord 模式
            .setEnableCache(false)// XML 二级缓存
            .setBaseResultMap(true)// XML ResultMap
            .setBaseColumnList(true)// XML columList
            .setOpen(false)//生成后打开文件夹
            .setSwagger2(true)//生成swagger api
            .setAuthor(authorName)
            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            .setMapperName("%sMapper")
            .setXmlName("%sMapper")
            .setEntityName("%sPO")
            .setServiceName("%sService")
            .setServiceImplName("%sServiceImpl")
            .setControllerName("%sController")
    );
    //配置数据源
    mpg.setDataSource(
        // 数据源配置
        new DataSourceConfig()
            .setDbType(DbType.MYSQL)// 数据库类型
            .setDriverName(properties.getProperty("datasource.driverName"))
            .setUsername(properties.getProperty("datasource.username"))
            .setPassword(properties.getProperty("datasource.password"))
            .setUrl(properties.getProperty("datasource.url"))
    );
    //配置策略
    mpg.setStrategy(
        // 策略配置
        new StrategyConfig()
            .setTablePrefix(prefix)// 此处可以修改为您的表前缀
            .setNaming(NamingStrategy.underline_to_camel)// 配置数据表与实体类名之间映射的策略
            .setColumnNaming(NamingStrategy.underline_to_camel)// 配置数据表的字段与实体类的属性名之间映射的策略
            //.setInclude(tables) // 指定需要生成文件的表名
            .setInclude(scanner("表名，多个英文逗号分割").split(","))
            .setRestControllerStyle(true) // 配置 rest 风格的控制器（@RestController）
            .setEntityLombokModel(true) // 配置 lombok 模式
            //.setExclude(new String[]{"test"}) // 排除生成的表
            // 自定义实体父类
            // .setSuperEntityClass("com.baomidou.demo.TestEntity")
            // 自定义实体，公共字段
            .setSuperEntityColumns(customConfig.getSuperEntityColumns())
            //                        .setSuperEntityColumns(new String[]{"createdBy", "createdTime", "updatedBy",
            //                                "updatedTime", "recordVersion"})
            .setTableFillList(null)
            .setSuperEntityClass(customConfig.getSuperEntityClass())
            // 自定义 mapper 父类
            .setSuperMapperClass(customConfig.getSuperMapperClass())
            // 自定义 service 父类
            // .setSuperServiceClass("com.baomidou.demo.TestService")
            // 自定义 service 实现类父类
            // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
            // 自定义 controller 父类
            .setSuperControllerClass(customConfig.getSuperControllerClass())
            .setEntityBooleanColumnRemoveIsPrefix(customConfig.isEntityBooleanColumnRemoveIsPrefix())
            .setLogicDeleteFieldName(customConfig.getLogicDeleteFieldName())
            .setVersionFieldName(customConfig.getLogicDeleteFieldName())
        // .setRestControllerStyle(true)
        // .setControllerMappingHyphenStyle(true)
    );
  }

  private static void setTemplateConfig(AutoGenerator mpg, Properties properties)
  {
    String isServiceImplGenerate = properties.getProperty("output.isGeneratePackage.serviceImpl");
    String isControllerGenerate = properties.getProperty("output.isGeneratePackage.controller");
    String isMapperGenerate = properties.getProperty("output.isGeneratePackage.mapper");
    String isServiceGenerate = properties.getProperty("output.isGeneratePackage.service");
    String isEntityGenerate = properties.getProperty("output.isGeneratePackage.entity");

    // 关闭默认 xml 生成，调整生成 至 根目录
    TemplateConfig templateConfig = new TemplateConfig().setXml(null);

    // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
    // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
    if (Str2Util.isEmpty(isControllerGenerate) || isControllerGenerate.equals("true"))
    {
      templateConfig.setController("/template/myController.java.vm");
    } else
    {
      templateConfig.setController(null);
    }
    if (Str2Util.isEmpty(isEntityGenerate) || isEntityGenerate.equals("true"))
    {
      templateConfig.setEntity("/template/myEntity.java.vm");
    } else
    {
      templateConfig.setEntity(null);
    }
    if (Str2Util.isEmpty(isServiceGenerate) || isServiceGenerate.equals("true"))
    {
      templateConfig.setService("/template/myService.java.vm");
    } else
    {
      templateConfig.setService(null);
    }
    if (Str2Util.isEmpty(isServiceImplGenerate) || isServiceImplGenerate.equals("true"))
    {
      templateConfig.setServiceImpl("/template/myServiceImpl.java.vm");
    } else
    {
      templateConfig.setServiceImpl(null);
    }
    if (Str2Util.isEmpty(isMapperGenerate) || isMapperGenerate.equals("true"))
    {
      templateConfig.setMapper("/template/myMapper.java.vm");
    } else
    {
      templateConfig.setMapper(null);
    }

    mpg.setTemplate(templateConfig);
  }

  private static void setXmlOutPutConfig(Properties properties, List<FileOutConfig> fileOutConfigs)
  {
    String mapperXmlPackage = properties.getProperty("output.defineChildPackage.mapperXml");
    final String mapperXmlPackageStatic = mapperXmlPackage == null ? "mapper" :
        mapperXmlPackage;

    String moduleName = properties.getProperty(OUTPUT_MODULE_NAME);
    String moduleNameDir = moduleName.replaceAll("\\.", "/");
    //文件路径
    String outputPath = properties.getProperty(OUTPUT_PATH);
    File file = new File(outputPath);
    String path = file.getAbsolutePath();

    FileOutConfig xmlFileConfig = new FileOutConfig("/template/myMapper" + ".xml.vm")
    {
      /**
       * 输出文件
       *
       * @param tableInfo
       */
      @Override
      public String outputFile(TableInfo tableInfo)
      {
        return path + "/src/main/resources/" + mapperXmlPackageStatic.replaceAll("\\.", "/") + "/" +
            moduleNameDir
            + "/" + Str2Util.firstCharToLowerCase(tableInfo.getEntityName())
            + "Mapper" +
            ".xml";
      }
    };

    String isMapperXmlGenerate = properties.getProperty("output.isGeneratePackage.mapperXml");
    if (StringUtils.isNullOrEmpty(isMapperXmlGenerate) || isMapperXmlGenerate.equals("true"))
    {
      fileOutConfigs.add(xmlFileConfig);
    }
  }

  private static void setDtoOutPutConfig(Properties properties, List<FileOutConfig> fileOutConfigs, AutoGenerator
      mpg)
  {
    String dtoPackage = properties.getProperty("output.defineChildPackage.dto");
    final String dtoPackageStatic = dtoPackage == null ? "bean.dto" : dtoPackage;

    String moduleName = properties.getProperty(OUTPUT_MODULE_NAME);
    String moduleNameDir = moduleName.replaceAll("\\.", "/");
    //文件路径
    String outputPath = properties.getProperty(OUTPUT_PATH);
    File file = new File(outputPath);
    String path = file.getAbsolutePath();

    FileOutConfig dtoFileConfig = new FileOutConfig("/template/myDto" + JAVA_VM_SUFFIX)
    {
      /**
       * 输出文件
       *
       * @param tableInfo
       */
      @Override
      public String outputFile(TableInfo tableInfo)
      {
        return path + "/src/main/java/" + mpg.getPackageInfo().getParent().replaceAll("\\.", "/") + "/" + dtoPackageStatic.replaceAll("\\.", "/") + ("/" + moduleNameDir) + "/" + tableInfo
            .getEntityName().substring(0, tableInfo
                .getEntityName().length() - 2) + "DTO.java";
      }
    };

    String isDtoGenerate = properties.getProperty("output.isGeneratePackage.dto");
    if (StringUtils.isNullOrEmpty(isDtoGenerate) || isDtoGenerate.equals("true"))
    {
      fileOutConfigs.add(dtoFileConfig);
    }
  }

  private static void setControllerTestConfig(Properties properties, List<FileOutConfig> fileOutConfigs, AutoGenerator
      mpg)
  {
    String controllerTestPackage = properties.getProperty("output.defineChildPackage.controllerTest");
    final String controllerTestPackageStatic = controllerTestPackage == null ? "controller" :
        controllerTestPackage;

    String moduleName = properties.getProperty(OUTPUT_MODULE_NAME);
    String moduleNameDir = moduleName.replaceAll("\\.", "/");
    //文件路径
    String outputPath = properties.getProperty(OUTPUT_PATH);
    File file = new File(outputPath);
    String path = file.getAbsolutePath();

    FileOutConfig controllerTestFileConfig = new FileOutConfig("/template/myControllerTest" + JAVA_VM_SUFFIX)
    {
      /**
       * 输出文件
       *
       * @param tableInfo
       */
      @Override
      public String outputFile(TableInfo tableInfo)
      {
        return path + "/src/test/java/" + mpg.getPackageInfo().getParent().replaceAll("\\.", "/") + "/" + controllerTestPackageStatic.replaceAll("\\.", "/") + ("/" + moduleNameDir) + "/" + tableInfo
            .getControllerName
                () + "Test.java";
      }
    };

    String isControllerTestGenerate = properties.getProperty("output.isGeneratePackage.controllerTest");
    if (StringUtils.isNullOrEmpty(isControllerTestGenerate) || isControllerTestGenerate.equals("true"))
    {
      fileOutConfigs.add(controllerTestFileConfig);
    }
  }

  private static void setServiceTestConfig(Properties properties, List<FileOutConfig> fileOutConfigs, AutoGenerator
      mpg)
  {
    String serviceTestPackage = properties.getProperty("output.defineChildPackage.serviceTest");
    final String serviceTestPackageStatic = serviceTestPackage == null ? "service" :
        serviceTestPackage;

    String moduleName = properties.getProperty(OUTPUT_MODULE_NAME);
    String moduleNameDir = moduleName.replaceAll("\\.", "/");
    //文件路径
    String outputPath = properties.getProperty(OUTPUT_PATH);
    File file = new File(outputPath);
    String path = file.getAbsolutePath();

    FileOutConfig serviceImplTestFileConfig = new FileOutConfig("/template/myServiceImplTest" + JAVA_VM_SUFFIX)
    {
      /**
       * 输出文件
       *
       * @param tableInfo
       */
      @Override
      public String outputFile(TableInfo tableInfo)
      {
        return path + "/src/test/java/" + mpg.getPackageInfo().getParent().replaceAll("\\.", "/") + "/" + serviceTestPackageStatic.replaceAll("\\.", "/") + ("/" + moduleNameDir) + "/" + tableInfo.getServiceImplName() + "Test.java";
      }
    };

    String isServiceTestGenerate = properties.getProperty("output.isGeneratePackage.serviceTest");
    if (StringUtils.isNullOrEmpty(isServiceTestGenerate) || isServiceTestGenerate.equals("true"))
    {
      fileOutConfigs.add(serviceImplTestFileConfig);
    }
  }


  public static void main(String[] args)
  {
    generate();
  }
}
