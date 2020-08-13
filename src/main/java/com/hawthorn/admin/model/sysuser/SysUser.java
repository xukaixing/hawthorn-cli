package com.hawthorn.admin.model.sysuser;

import com.hawthorn.admin.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @version v1.0.1
 * @className:SysUser
 * @descripion: 系统用户类
 * @author:andy.ten@tom.com
 * @date:2020/7/14 4:14 下午
 */

@ApiModel(value = "sys_user", description = "用户对象实体")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"password"})
public class SysUser extends BaseModel
{
  @ApiModelProperty(value = "用户名", name = "username")
  @NonNull
  private String name;

  private String nickName;
  @ApiModelProperty(value = "性别", name = "avatar")
  private String avatar;

  private String password;

  private String salt;

  private String email;

  private String mobile;

  private Byte status;

  private Long deptId;

  public SysUser()
  {
  }
}
