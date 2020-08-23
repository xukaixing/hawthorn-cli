package com.hawthorn.admin.service.sysuser.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;
import com.hawthorn.admin.model.po.SysUserPO;
import com.hawthorn.admin.repository.SysUserMapper;
import com.hawthorn.admin.service.sysuser.SysUserService2;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.service.DBService;
import com.hawthorn.framework.utils.bean.QcBean;
import com.hawthorn.framework.utils.iassert.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 测试@transactional事务一致性类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:56 下午
 * @version v1.0.1
 */
@Service
@Slf4j
public class SysUserServiceImpl2 implements SysUserService2
{
  @Resource
  private SysUserMapper sysUserMapper;
  @Resource
  private DBService<SysUserPO> dbService;

  public IPage<SysUserDTO> select(Page<SysUserDTO> page, Map<String, QcBean> qc)
  {
    // 逻辑分页：调用selectPage，适合小数据量
    //return sysUserMapper.selectPage(new Page<>(1, 2), null);
    return sysUserMapper.select(page, qc);
  }

  public IPage<SysUserDTO> selectByPage(Page<SysUserDTO> page)
  {
    // 逻辑分页：调用selectPage，适合小数据量
    //return sysUserMapper.selectPage(new Page<>(1, 2), null);
    return sysUserMapper.selectByPage(page);
  }

  public List<SysUserDTO> selectNoPage()
  {
    return sysUserMapper.selectNoPage();
  }

  public List<SysUserDTO> selectAllPrivider()
  {
    return sysUserMapper.selectAllPrivider();
  }

  public List<SysUserDTO> selectAllByStatus(Byte status)
  {
    AssertUtil.notNull(status, BizCode.METHOD_ARGS_NOTNULL, "status" );
    return sysUserMapper.selectAllByStatus(status);
  }

  public List<SysUserDTO> selectAllByField(String fieldName, String fieldValue)
  {
    AssertUtil.notNull(fieldName, BizCode.METHOD_ARGS_NOTNULL, "fieldName" );
    return sysUserMapper.selectAllByField(fieldName, fieldValue);
  }

  //@Transactional(rollbackFor = {Exception.class})
  public boolean insertUser()
  {
    SysUserPO u = new SysUserPO();
    u.setName("test" );
    u.setNickName("test" );
    //baseMapper.insert(u);
    dbService.saveOrUpdate(u);
    log.info("1" );
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // u2.setStatus((byte) 0);
    // saveOrUpdate(u2);
    insertUser2();
    return true;
  }

  @Transactional(rollbackFor = {Exception.class})
  public boolean insertUser2()
  {
    SysUserPO u = new SysUserPO();
    u.setName("test" );
    u.setNickName("test" );
    //baseMapper.insert(u);
    dbService.saveOrUpdate(u);
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // u2.setStatus((byte) 0);
    // saveOrUpdate(u2);
    log.info("2" );
    return true;
  }

}

