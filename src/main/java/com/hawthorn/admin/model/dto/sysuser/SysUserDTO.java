package com.hawthorn.admin.model.dto.sysuser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hawthorn.framework.model.BaseDTO;
import com.hawthorn.framework.utils.json.serializer.JsonLocalDateTimeDeserializer;
import com.hawthorn.framework.utils.json.serializer.JsonLocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 用户管理(sys_user) dto实体类
 * @author: andy.ten@tom.com
 * @date: 2020-08-23
 * @version v1.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "sys_user", description = "用户管理" )
public class SysUserDTO extends BaseDTO
{
  /**
   * 编号
   */
  @ApiModelProperty(value = "编号", name = "id" )
  private Long id;
  /**
   * 用户名
   */
  @ApiModelProperty(value = "用户名", name = "name" )
  private String name;
  /**
   * 昵称
   */
  @ApiModelProperty(value = "昵称", name = "nickName" )
  private String nickName;
  /**
   * 头像
   */
  @ApiModelProperty(value = "头像", name = "avatar" )
  private String avatar;
  /**
   * 密码
   */
  @ApiModelProperty(value = "密码", name = "password" )
  private String password;
  /**
   * 加密盐
   */
  @ApiModelProperty(value = "加密盐", name = "salt" )
  private String salt;
  /**
   * 出生日期
   */
  @ApiModelProperty(value = "出生日期", name = "birthDate" )
  @JsonDeserialize(using = JsonLocalDateTimeDeserializer.class)
  @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
  private LocalDateTime birthDate;
  /**
   * 邮箱
   */
  @ApiModelProperty(value = "邮箱", name = "email" )
  private String email;
  /**
   * 手机号
   */
  @ApiModelProperty(value = "手机号", name = "mobile" )
  private String mobile;
  /**
   * 用户类型
   */
  @ApiModelProperty(value = "用户类型", name = "userType" )
  private Integer userType;
  /**
   * 机构ID
   */
  @ApiModelProperty(value = "机构ID", name = "deptId" )
  private Long deptId;

  public SysUserDTO()
  {
  }
}
