package com.hawthorn.admin.service.sysuser.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysuser.SysUserDTO;
import com.hawthorn.admin.model.po.SysUserPO;
import com.hawthorn.admin.repository.sysuser.SysUserMapper;
import com.hawthorn.admin.service.sysuser.SysUserService;
import com.hawthorn.admin.service.sysuser.SysUserService2;
import com.hawthorn.framework.annotation.ExecTime;
import com.hawthorn.framework.exception.BizCode;
import com.hawthorn.framework.service.DBService;
import com.hawthorn.framework.utils.iassert.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 系统用户service
 * @author:andy.ten@tom.com
 * @date:2020/8/13 3:56 下午
 * @version v1.0.1
 */
@Service
@ExecTime
@Slf4j
public class SysUserServiceImpl implements SysUserService
{

  @Resource
  private SysUserMapper sysUserMapper;
  @Resource
  private DBService<SysUserPO> dbService;

  public List<SysUserDTO> selectAll()
  {
    return sysUserMapper.selectAll();
  }

  /**
   * @remark: 带分页查询方法
   * @param: page
   * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.hawthorn.admin.model.dto.sysuser.SysUserDTO>

   * @author: andy.ten@tom.com
   * @date: 2020/8/20 2:31 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/20    any.ten        v1.0.1             init
   */
  public IPage<SysUserDTO> selectUsersByPage(Page<SysUserDTO> page)
  {
    // 逻辑分页：调用selectPage，适合小数据量
    //return sysUserMapper.selectPage(new Page<>(1, 2), null);
    return sysUserMapper.selectUsersByPage(page);
  }

  public List<SysUserDTO> selectAllPrivider()
  {
    return sysUserMapper.selectAllPrivider();
  }

  public List<SysUserDTO> selectAllByStatus(Byte status)
  {
    AssertUtil.notNull(status, BizCode.METHOD_ARGS_NOTNULL, "status");
    return sysUserMapper.selectAllByStatus(status);
  }

  public List<SysUserDTO> selectAllByField(String fieldName, String fieldValue)
  {
    AssertUtil.notNull(fieldName, BizCode.METHOD_ARGS_NOTNULL, "fieldName");
    return sysUserMapper.selectAllByField(fieldName, fieldValue);
  }

  @Autowired
  private SysUserService2 sysUserService2;

  //@Transactional(rollbackFor = {Exception.class})
  public boolean insertUser()
  {
    SysUserDTO u = new SysUserDTO();
    u.setName("test");
    u.setNickName("test");
    //baseMapper.insert(u);
    sysUserMapper.insert(u.transDto2Po(SysUserPO.class));
    log.info("1");
    //sysUserService2.insertUser();
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // u2.setStatus((byte) 0);
    // saveOrUpdate(u2);
    //insertUser2();
    return true;
  }

  /**
   * @remark: 测试transactional方法
   * @param:
   * @return: boolean

   * @author: andy.ten@tom.com
   * @date: 2020/8/14 10:24 上午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/14    andy.ten        v1.0.1             init
   */
  //@Transactional(rollbackFor = {Exception.class})
  public boolean insertUser2()
  {
    SysUserPO u = new SysUserPO();
    u.setName("test");
    u.setNickName("test");
    //baseMapper.insert(u);
    dbService.save(u);
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // u2.setStatus((byte) 0);
    // saveOrUpdate(u2);
    log.info("2");
    return true;
  }

  public SysUserDTO updateUser()
  {
    SysUserDTO u = new SysUserDTO();
    UpdateWrapper<SysUserPO> uw = new UpdateWrapper<>();
    uw.eq("id", 32L);
    uw.set("email", null);
    uw.set("mobile", "1314443331");
    dbService.update(uw);
    //sysUserMapper.updateById(u.transDto2Po(SysUserPO.class));
    //baseMapper.insert(u);
    //dbService.updateById(u.transDto2Po(SysUserPO.class));
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // //baseMapper.insert(u);
    // dbService.saveOrUpdate(u2);
    //dbService.updateById(u);
    //sysUserMapper.update(u);
    return u;
  }

  /**
   * @remark: 乐观锁实现方式
   * @param:
   * @return: com.hawthorn.admin.model.dto.sysuser.SysUserDTO

   * @author: andy.ten@tom.com
   * @date: 2020/8/21 3:14 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/21    andy.ten        v1.0.1             init
   */
  public SysUserDTO updateUserByVersion()
  {
    SysUserDTO u = new SysUserDTO();
    u.setId(32L);
    u.setMobile("13100000002");
    UpdateWrapper<SysUserPO> uw = new UpdateWrapper<>();
    uw.eq("id", 32L);
    uw.set("email", null);
    uw.set("mobile", u.getMobile());
    SysUserPO p = sysUserMapper.selectById(32L);
    // 乐观锁使用前提：1)必须要先把数据查询出来;selectById;
    //              2)乐观锁仅支持updateById和update(entity,wrapper)方法；
    // 利用wrapper解决更新为null问题，实际上，推荐使用warpper方式
    p.setMobile("1111111111");
    dbService.update(p, uw);
    //sysUserMapper.updateById(u.transDto2Po(SysUserPO.class));
    //baseMapper.insert(u);
    //dbService.updateById(u.transDto2Po(SysUserPO.class));
    // SysUser u2 = new SysUser();
    // u2.setName("test");
    // u2.setNickName("test");
    // //baseMapper.insert(u);
    // dbService.saveOrUpdate(u2);
    //dbService.updateById(u);
    //sysUserMapper.update(u);
    return u;
  }

  public boolean deleteAll()
  {
    return sysUserMapper.deleteAllPrivider();
  }

}

