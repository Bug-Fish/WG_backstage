package com.epi.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class UserMember {
    private String id;
    private String openid;
    private String mobile;
    private String password;
    private String nickname;
    private String  sex;
    private String age;
    private String avatar ;
    private String  sign ;
    private Boolean isDisabled;
    private Boolean isDeleted ;
    @TableField(fill = FieldFill.INSERT)
    private Date user_create;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date user_modified;

}
