package com.hawthorn.admin.service.sysdept.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysdept.SysDeptDTO;
import com.hawthorn.admin.model.po.SysDeptPO;
import com.hawthorn.admin.repository.SysDeptMapper;
import com.hawthorn.admin.service.sysdept.SysDeptService;
import com.hawthorn.framework.utils.bean.QcBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 机构管理 serviceImp 实现类
 * @author: andy.ten@tom.com
 * @date: 2020-08-24
 * @version v1.0.1
 */
@Service
public class SysDeptServiceImpl implements SysDeptService
{
  @Resource
  private SysDeptMapper sysDeptMapper;

  /**
   * generator->带分页查询
   */
  @Transactional(readOnly = true)
  public List<SysDeptDTO> select(Map<String, QcBean> qc)
  {
    return sysDeptMapper.select(qc);
  }

  /**
   * generator->不带分页查询
   */
  @Transactional(readOnly = true)
  public IPage<SysDeptDTO> select(Page<SysDeptDTO> page, Map<String, QcBean> qc)
  {
    return sysDeptMapper.select(page, qc);
  }

  /**
   * generator->新增方法
   */
  @Transactional(rollbackFor = Exception.class)
  public SysDeptDTO insert(SysDeptDTO sysDeptDTO)
  {
    SysDeptPO sysDeptPO = sysDeptDTO.transDto2Po(SysDeptPO.class);
    int b = sysDeptMapper.insert(sysDeptPO);

    return sysDeptDTO;
  }

  /**
   * generator->新增方法
   */
  @Transactional(rollbackFor = Exception.class)
  public SysDeptDTO update(SysDeptDTO sysDeptDTO)
  {
    // 更新null值情况
    //UpdateWrapper<SysDeptPO> uw = new UpdateWrapper<>();
    //uw.eq("id", sysDeptDTO.getId());
    //uw.set("xx", null);
    //boolean b = dbService.update(uw);
    SysDeptPO sysDeptPO = sysDeptDTO.transDto2Po(SysDeptPO.class);
    int b = sysDeptMapper.updateById(sysDeptPO);

    return sysDeptDTO;
  }

  /**
   * generator->带乐观锁更新方法
   */
  @Transactional(rollbackFor = Exception.class)
  public SysDeptDTO updateByVersion(SysDeptDTO sysDeptDTO)
  {
    SysDeptPO sysDeptPO = sysDeptMapper.selectById(sysDeptDTO.getId());
    int b = sysDeptMapper.updateById(sysDeptPO);

    return sysDeptDTO;
  }

  /**
   * generator->根据id删除行记录
   */
  @Transactional(rollbackFor = Exception.class)
  public int deleteById(Long id)
  {
    return sysDeptMapper.deleteById(id);
  }

}
