package com.hawthorn.framework.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.*;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 自定义扩展：基础mapper类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 7:52 下午
 * @version v1.0.1
 */
public interface DBMapper<T> extends BaseMapper<T>
{
  /**
   * <p>
   * 判断数据库操作是否成功
   * </p>
   *
   * @param result 数据库操作返回影响条数
   * @return boolean
   */
  default boolean retBool(Integer result)
  {
    return SqlHelper.retBool(result);
  }

  /**
   * <p>
   * 删除不存在的逻辑上属于成功
   * </p>
   *
   * @param result 数据库操作返回影响条数
   * @return boolean
   */
  default boolean delBool(Integer result)
  {
    return null != result && result >= 0;
  }

  default Class<T> currentModelClass()
  {
    return (Class<T>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
  }

  /**
   * 获取SqlStatement
   *
   * @param sqlMethod
   * @return
   */
  default String sqlStatement(SqlMethod sqlMethod)
  {
    return SqlHelper.table(currentModelClass()).getSqlStatement(sqlMethod.getMethod());
  }

  /**
   * <p>
   * 批量操作 SqlSession
   * </p>
   */
  default SqlSession sqlSessionBatch()
  {
    return SqlHelper.sqlSessionBatch(currentModelClass());
  }

  /**
   * 释放sqlSession
   *
   * @param sqlSession session
   */
  default void closeSqlSession(SqlSession sqlSession)
  {
    SqlSessionUtils.closeSqlSession(sqlSession, GlobalConfigUtils.currentSessionFactory(currentModelClass()));
  }

  /**
   * 批量插入
   *
   * @param entityList
   * @param batchSize
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  default boolean saveBatch(Collection<T> entityList, int batchSize)
  {
    int i = 0;
    String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
    try (SqlSession batchSqlSession = sqlSessionBatch())
    {
      for (T anEntityList : entityList)
      {
        batchSqlSession.insert(sqlStatement, anEntityList);
        if (i >= 1 && i % batchSize == 0)
        {
          batchSqlSession.flushStatements();
        }
        i++;
      }
      batchSqlSession.flushStatements();
    }
    return true;
  }

  /**
   * 单个插入
   *
   * @param entity
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  default boolean save(T entity)
  {
    return retBool(insert(entity));
  }

  /**
   * 根据集合批量更新
   *
   * @param entityList
   * @param batchSize
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  default boolean updateBatch(Collection<T> entityList, int batchSize)
  {
    if (CollectionUtils.isEmpty(entityList))
    {
      throw new IllegalArgumentException("Error: entityList must not be empty" );
    }
    int i = 0;
    String sqlStatement = sqlStatement(SqlMethod.UPDATE_BY_ID);
    try (SqlSession batchSqlSession = sqlSessionBatch())
    {
      for (T anEntityList : entityList)
      {
        MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
        param.put(Constants.ENTITY, anEntityList);
        batchSqlSession.update(sqlStatement, param);
        if (i >= 1 && i % batchSize == 0)
        {
          batchSqlSession.flushStatements();
        }
        i++;
      }
      batchSqlSession.flushStatements();
    }
    return true;
  }

  /**
   * <p>
   * TableId 判断是否存在更新记录，否插入一条记录
   * 需要选进行一次查询
   * </p>
   *
   * @param entity 实体对象
   * @return boolean
   */
  @Transactional(rollbackFor = Exception.class)
  default boolean saveOrUpdate(T entity)
  {
    if (null != entity)
    {
      Class<?> cls = entity.getClass();
      TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
      if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty()))
      {
        Object idVal = ReflectionKit.getMethodValue(cls, entity, tableInfo.getKeyProperty());
        if (StringUtils.checkValNull(idVal))
        {
          return save(entity);
        } else
        {
          /*
           * 更新成功直接返回，失败执行插入逻辑
           */
          return updateById(entity) > 0 || save(entity);
        }
      } else
      {
        throw ExceptionUtils.mpe("Error:  Can not execute. Could not find @TableId." );
      }
    }
    return false;
  }

  @Transactional(rollbackFor = Exception.class)
  default boolean saveOrUpdateBatch(Collection<T> entityList)
  {
    return saveOrUpdateBatch(entityList, 30);
  }

  @Transactional(rollbackFor = Exception.class)
  default boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize)
  {
    if (CollectionUtils.isEmpty(entityList))
    {
      throw new IllegalArgumentException("Error: entityList must not be empty" );
    }
    Class<?> cls = null;
    TableInfo tableInfo = null;
    int i = 0;
    try (SqlSession batchSqlSession = sqlSessionBatch())
    {
      for (T anEntityList : entityList)
      {
        if (i == 0)
        {
          cls = anEntityList.getClass();
          tableInfo = TableInfoHelper.getTableInfo(cls);
        }
        if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty()))
        {
          Object idVal = ReflectionKit.getMethodValue(cls, anEntityList, tableInfo.getKeyProperty());
          if (StringUtils.checkValNull(idVal))
          {
            String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
            batchSqlSession.insert(sqlStatement, anEntityList);
          } else
          {
            String sqlStatement = sqlStatement(SqlMethod.UPDATE_BY_ID);
            MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap<>();
            param.put(Constants.ENTITY, anEntityList);
            batchSqlSession.update(sqlStatement, param);
          }
          if (i >= 1 && i % batchSize == 0)
          {
            batchSqlSession.flushStatements();
          }
          i++;
        } else
        {
          throw ExceptionUtils.mpe("Error:  Can not execute. Could not find @TableId." );
        }
        batchSqlSession.flushStatements();
      }
    }
    return true;
  }

  /**
   * 根据id删除记录
   *
   * @param id
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  default boolean removeById(Serializable id)
  {
    return delBool(deleteById(id));
  }

  @Transactional(rollbackFor = Exception.class)
  default boolean removeByMap(Map<String, Object> columnMap)
  {
    if (ObjectUtils.isEmpty(columnMap))
    {
      throw ExceptionUtils.mpe("removeByMap columnMap is empty." );
    }
    return delBool(deleteByMap(columnMap));
  }

  @Transactional(rollbackFor = Exception.class)
  default boolean remove(Wrapper<T> wrapper)
  {
    return delBool(delete(wrapper));
  }

  @Transactional(rollbackFor = Exception.class)
  default boolean removeByIds(Collection<? extends Serializable> idList)
  {
    return delBool(deleteBatchIds(idList));
  }
}
