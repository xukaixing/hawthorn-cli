package com.hawthorn.admin.database;

import com.hawthorn.BootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Copyright: Copyright (c) 2020 andyten
 * @remark: TODO
 * @author:andy.ten@tom.com
 * @date:2020/8/14 1:42 上午
 * @version v1.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BootApplication.class})
@Slf4j
public class DruidInfoTest
{
  @Autowired
  private DataSource dataSource;

  @Test
  public void showDataSourceInfo() throws SQLException
  {
    log.info("====== connection:" + String.valueOf(dataSource.getConnection()));
    System.out.println(dataSource);
  }
}
