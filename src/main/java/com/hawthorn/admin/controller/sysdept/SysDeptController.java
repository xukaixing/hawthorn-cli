package com.hawthorn.admin.controller.sysdept;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hawthorn.admin.model.dto.sysdept.SysDeptDTO;
import com.hawthorn.admin.service.sysdept.SysDeptService;
import com.hawthorn.framework.utils.bean.QcBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 机构管理 controller
 * @author: andy.ten@tom.com
 * @date: 2020-08-24
 * @version v1.0.1
 */
@Api(tags = {"admin-sysdept"})
@RestController
@RequestMapping("/admin/sysdept/sysDept")
public class SysDeptController
{
  @Resource
  public SysDeptService sysDeptService;

  /**
   * @author: andy.ten@tom.com
   * @date: 2020-08-24
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->机构管理信息", notes = "查询机构管理信息服务 带分页" )
  @ApiImplicitParams({
  })
  @GetMapping(value = "/select" )
  public IPage<SysDeptDTO> select()
  {
    int pageNum = 1;
    int pageSize = 2;
    Page<SysDeptDTO> page = new Page<>(pageNum, pageSize);
    QcBean qc = new QcBean();
    HashMap<String, QcBean> hm = new HashMap<>();
    return sysDeptService.select(page,hm);
  }

  /**
   * @author: andy.ten@tom.com
   * @date: 2020-08-24
   * @version: 1.0.1
   */
  @ApiOperation(value = "查询->机构管理信息 不带分页", notes = "查询机构管理信息服务 不带分页" )
  @ApiImplicitParams({
  })
  @GetMapping(value = "/selectNoPage" )
  public List<SysDeptDTO> selectNoPage()
  {
    QcBean qc = new QcBean();
    HashMap<String, QcBean> hm = new HashMap<>();
    return sysDeptService.select(hm);
  }
}
