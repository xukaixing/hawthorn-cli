package com.hawthorn.admin.model.dto.sysuser;

import com.hawthorn.framework.model.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


/**
 * @Copyright: Copyright (c) 2020 andyten

 * @remark: 系统用户类
 * @author:andy.ten@tom.com
 * @date:2020/8/13 8:11 下午
 * @version v1.0.1
 */
@ApiModel(value = "sys_user", description = "用户对象实体")
@Data
//@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"password"})
public class SysUserDTO extends BaseDTO
{
  private Long id;

  @ApiModelProperty(value = "用户名", name = "username")
  private String name;

  private String nickName;
  @ApiModelProperty(value = "性别", name = "avatar")
  private String avatar;

  private String password;

  private String salt;

  private String email;

  private String mobile;
  //Integer类型的属性加@ApiModelProperty时，必须要给example参数赋值，且值必须为数字类型
  //否则刷新swagger页面，会报java.lang.NumberFormatException: For input string: "" 错误
  @ApiModelProperty(value = "状态", name = "status", example = "1")
  private Byte status;
  @ApiModelProperty(value = "部门id", name = "deptId", example = "00")
  private Long deptId;

  public SysUserDTO()
  {
  }
}
