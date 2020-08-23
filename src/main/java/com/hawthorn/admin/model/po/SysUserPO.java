package com.hawthorn.admin.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hawthorn.framework.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 用户管理(sys_user) po实体类
 * @author: andy.ten@tom.com
 * @date: 2020-08-23
 * @version v1.0.1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user" )
public class SysUserPO extends BasePO
{
  /**
   * 编号
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;
  /**
   * 用户名
   */
  @TableField("name" )
  private String name;
  /**
   * 昵称
   */
  @TableField("nick_name" )
  private String nickName;
  /**
   * 头像
   */
  @TableField("avatar" )
  private String avatar;
  /**
   * 密码
   */
  @TableField("password" )
  private String password;
  /**
   * 加密盐
   */
  @TableField("salt" )
  private String salt;
  /**
   * 出生日期
   */
  @TableField("birth_date" )
  private LocalDateTime birthDate;
  /**
   * 邮箱
   */
  @TableField("email" )
  private String email;
  /**
   * 手机号
   */
  @TableField("mobile" )
  private String mobile;
  /**
   * 用户类型
   */
  @TableField("user_type" )
  private Integer userType;
  /**
   * 机构ID
   */
  @TableField("dept_id" )
  private Long deptId;

  public SysUserPO()
  {
  }
}
