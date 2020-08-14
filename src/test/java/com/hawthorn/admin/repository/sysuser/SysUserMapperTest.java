package com.hawthorn.admin.repository.sysuser;

import com.hawthorn.BootApplication;
import com.hawthorn.admin.model.sysuser.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: SysUserMapper测试类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 11:55 上午
 * @version v1.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApplication.class})
public class SysUserMapperTest
{
  @Resource
  private SysUserMapper sysUserMapper;

  @Test
  public void testSelect()
  {
    System.out.println(("----- selectAll method test ------"));
    List<SysUser> userList = sysUserMapper.selectList(null);
    //Assert.assertEquals(5, userList.size());
    userList.forEach(System.out::println);
  }
}
