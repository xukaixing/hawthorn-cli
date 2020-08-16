package com.hawthorn.framework.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: 自定义扩展：基础mapper类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 7:52 下午
 * @version v1.0.1
 */
@Repository
public interface DBMapper<T> extends BaseMapper<T>
{
}
