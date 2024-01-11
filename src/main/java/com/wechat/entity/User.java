package com.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String avatar;
    private String profile;
    private Integer id; // 用户编号

    private String openid; // 用户唯一标识

    private String nickName; // 用户昵称

    private String avatarUrl; // 用户头像图片的 URL

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private java.util.Date registerDate; // 注册日期

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private java.util.Date lastLoginDate; // 最后登录日期

    @TableField(select = false, exist = false)
    private String code; // 微信用户code 前端传来的


}
