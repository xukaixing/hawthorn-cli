package com.hawthorn.framework.utils.resource;

import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.exception.BizException;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: property文件工具类
 * @author:andy.ten@tom.com
 * @date:2020/8/16 4:57 下午
 * @version v1.0.1
 */
@Slf4j
public class PropertiesUtil
{
  private PropertiesUtil()
  {
  }

  /**
   * @remark: 从文件加载配置文件
   * @param: clazz
   * @param: filePath
   * @return: java.util.Properties

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 5:00 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static Properties loadPropertiesFromFile(Class<?> clazz, String filePath)
  {
    InputStream inputStream = clazz.getClassLoader().getResourceAsStream(filePath);
    return loadPropertiesFromInputStream(inputStream);
  }

  /**
   * @remark: 从输入流加载配置文件
   * @param: inputStream
   * @return: java.util.Properties

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 5:00 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static Properties loadPropertiesFromInputStream(InputStream inputStream)
  {
    Properties pros = new Properties();
    try
    {
      pros.load(inputStream);
    } catch (IOException ex)
    {
      throw new BizException(BizCode.PROPERTY_LOAD_FAIL);
    }
    return pros;
  }

  public static Properties loadPropertiesFromSystem()
  {
    return System.getProperties();
  }


  /**
   * @remark: 读取property文件内容
   * @param: propertiesSource
   * @return: java.util.Properties

   * @author: andy.ten@tom.com
   * @date: 2020/8/16 5:08 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/16    andy.ten        v1.0.1             init
   */
  public static Properties getProperties(String propertiesSource)
  {
    log.info("====== 开始加载properties文件内容 ======");
    Properties props = new Properties();
    try (InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesSource))
    {
      props.load(in);
      log.info("====== properties文件内容：{} ======", props);
      return props;
    } catch (FileNotFoundException e)
    {
      throw new BizException(BizCode.PROPERTY_FILE_NOTFOUND, e);
    } catch (Exception e)
    {
      throw new BizException(BizCode.PROPERTY_LOAD_FAIL, e);
    }
  }
}
