package com.hawthorn.admin.service.sysdept;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysdept.SysDeptDTO;
import com.hawthorn.framework.utils.bean.QcBean;

import java.util.List;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 机构管理 service 接口
 * @author: andy.ten@tom.com
 * @date: 2020-08-24
 * @version v1.0.1
 */
public interface SysDeptService
{
  /**
   * generator->带分页查询
   */
  IPage<SysDeptDTO> select(Page<SysDeptDTO> page, Map<String, QcBean> qc);

  /**
   * generator->不带分页查询
   */
  List<SysDeptDTO> select(Map<String, QcBean> qc);

  /**
   * generator->新增方法
   */
  SysDeptDTO insert(SysDeptDTO sysDeptDTO);

  /**
   * generator->更新方法
   */
  SysDeptDTO update(SysDeptDTO sysDeptDTO);

  /**
   * generator->带乐观锁更新方法
   */
  SysDeptDTO updateByVersion(SysDeptDTO sysDeptDTO);

  /**
   * generator->根据id删除行记录
   */
  int deleteById(Long id);
}
