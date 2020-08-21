package com.hawthorn.admin.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hawthorn.framework.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 系统用户类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 8:11 下午
 * @version v1.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"password"})
@TableName("sys_user")
public class SysUserPO extends BasePO
{
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String name;

  private String nickName;
  private String avatar;

  private String password;

  private String salt;

  // @TableField(updateStrategy = FieldStrategy.IGNORED) 该注解可将字段更新为null
  private String email;

  private String mobile;
  //Integer类型的属性加@ApiModelProperty时，必须要给example参数赋值，且值必须为数字类型
  //否则刷新swagger页面，会报java.lang.NumberFormatException: For input string: "" 错误

  private Long deptId;

  public SysUserPO()
  {
  }
}
