package com.hawthorn.framework.utils.resource;

import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;
import java.util.Properties;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: yml读取工具类
 * @author:andy.ten@tom.com
 * @date:2020/8/16 4:44 下午
 * @version v1.0.1
 */
@Slf4j
public class YmlUtil
{
  private YmlUtil()
  {
  }

  /**
   * @remark: 解析yml文件为map类型对象
   * @param: ymlSource
   * @return: java.util.Map<java.lang.String, java.lang.Object>

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 4:53 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static Map<String, Object> yaml2Map(String ymlSource)
  {
    try
    {
      YamlMapFactoryBean yaml = new YamlMapFactoryBean();
      // 绝对路径
      //yaml.setResources(new FileSystemResource(ymlSource));
      // 相对路径
      yaml.setResources(new ClassPathResource(ymlSource));
      return yaml.getObject();
    } catch (Exception e)
    {
      log.error(e.getMessage(), e);
      throw new BizException(BizCode.YML_ANALYSIS_FAIL, e);
    }
  }

  /**
   * @remark: 解析yml文件为Properties类型对象
   * @param: yamlSource
   * @return: java.util.Properties

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 4:53 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static Properties yaml2Properties(String yamlSource)
  {
    try
    {
      YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
      yaml.setResources(new ClassPathResource(yamlSource));
      return yaml.getObject();
    } catch (Exception e)
    {
      throw new BizException(BizCode.YML_ANALYSIS_FAIL, e);
    }
  }
}
