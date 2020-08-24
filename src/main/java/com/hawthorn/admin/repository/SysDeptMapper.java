package com.hawthorn.admin.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hawthorn.admin.model.dto.sysdept.SysDeptDTO;
import com.hawthorn.admin.model.po.SysDeptPO;
import com.hawthorn.framework.repository.DBMapper;
import com.hawthorn.framework.utils.bean.QcBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 机构管理(sys_dept) Mapper 接口
 * @author: andy.ten@tom.com
 * @date: 2020-08-24
 * @version v1.0.1
 */
@Repository
public interface SysDeptMapper extends DBMapper<SysDeptPO>
{
  IPage<SysDeptDTO> select(Page<SysDeptDTO> page, Map<String, QcBean> qc);

  List<SysDeptDTO> select(Map<String, QcBean> qc);
}
