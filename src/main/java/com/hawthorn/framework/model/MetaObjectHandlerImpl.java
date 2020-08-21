package com.hawthorn.framework.model;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 自定填充字段实现类
 * @author:andy.ten@tom.com
 * @date:2020/8/20 6:33 下午
 * @version v1.0.1
 */
@Component
@Slf4j
public class MetaObjectHandlerImpl implements MetaObjectHandler
{
  @Override
  public void insertFill(MetaObject metaObject)
  {
    //createtime
    boolean bol_createTime = metaObject.hasSetter("createTime");
    //拿到createdTime的值
    Object createdTime = getFieldValByName("createTime", metaObject);
    if (bol_createTime) //有set方法
    {
      if (createdTime == null) //值为null填充
      {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        //this.strictUpdateFill(metaObject, "lastUpdateTime", LocalDateTime.class, LocalDateTime.now());
      }
    }
    //createby
    boolean bol_createBy = metaObject.hasSetter("createBy");
    //拿到createdBy的值
    Object createdBy = getFieldValByName("createBy", metaObject);
    if (bol_createBy) //有set方法
    {
      if (createdBy == null) //值为null填充
      {
        this.strictInsertFill(metaObject, "createBy", String.class, "andyten");
      }
    }

    //status
    boolean bol_status = metaObject.hasSetter("status");
    //拿到createdTime的值
    Object status = getFieldValByName("status", metaObject);
    if (bol_status) //有set方法
    {
      if (status == null) //值为null填充
      {
        this.strictInsertFill(metaObject, "status", Integer.class, 1);
      }
    }

    //delFlag
    boolean bol_delFlag = metaObject.hasSetter("delFlag");
    //拿到createdTime的值
    Object delFlag = getFieldValByName("delFlag", metaObject);
    if (bol_delFlag) //有set方法
    {
      if (delFlag == null) //值为null填充
      {
        this.strictInsertFill(metaObject, "delFlag", Integer.class, 0);
      }
    }

    //version
    boolean bol_version = metaObject.hasSetter("version");
    //拿到createdTime的值
    Object version = getFieldValByName("version", metaObject);
    if (bol_version) //有set方法
    {
      if (version == null) //值为null填充
      {
        this.strictInsertFill(metaObject, "version", Integer.class, 1);
      }
    }

    //lastUpdateBy
    boolean bol_updateBy = metaObject.hasSetter("lastUpdateBy");
    //拿到updateTime的值
    Object updateBy = getFieldValByName("lastUpdateBy", metaObject);
    if (bol_updateBy) //有set方法
    {
      if (updateBy == null) //值为null填充
      {
        //log.info("时间：{}", LocalDateTime.now().toString());
        this.strictUpdateFill(metaObject, "lastUpdateBy", String.class, "andyten");
      }
    }

    //lastUpdateTime
    boolean bol_updateTime = metaObject.hasSetter("lastUpdateTime");
    //拿到updateTime的值
    Object updateTime = getFieldValByName("lastUpdateTime", metaObject);
    if (bol_updateTime) //有set方法
    {
      if (updateTime == null) //值为null填充
      {
        //log.info("时间：{}", LocalDateTime.now().toString());
        this.strictUpdateFill(metaObject, "lastUpdateTime", LocalDateTime.class, LocalDateTime.now());
      }
    }
  }

  @Override
  public void updateFill(MetaObject metaObject)
  {
    //是否存在set方法
    boolean bol_updateBy = metaObject.hasSetter("lastUpdateBy");
    //拿到updateTime的值
    Object updateBy = getFieldValByName("lastUpdateBy", metaObject);
    if (bol_updateBy) //有set方法
    {
      if (updateBy == null) //值为null填充
      {
        //log.info("时间：{}", LocalDateTime.now().toString());
        this.strictUpdateFill(metaObject, "lastUpdateBy", String.class, "andyten");
      }
    }

    //是否存在set方法
    boolean bol_updateTime = metaObject.hasSetter("lastUpdateTime");
    //拿到updateTime的值
    Object updateTime = getFieldValByName("lastUpdateTime", metaObject);
    if (bol_updateTime) //有set方法
    {
      if (updateTime == null) //值为null填充
      {
        //log.info("时间：{}", LocalDateTime.now().toString());
        this.strictUpdateFill(metaObject, "lastUpdateTime", LocalDateTime.class, LocalDateTime.now());
      }
    }
  }
}
