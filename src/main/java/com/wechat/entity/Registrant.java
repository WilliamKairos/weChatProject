package com.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("Registrant")
public class Registrant {
    @TableId
    private String uid; //每个人的独一无二的编号
    private String name; //姓名
    private String nickname; //昵称
    private String avatar; //头像
    @TableField(value = "emp_info")
    private String empInfo; //简介
    @TableField(value = "phone_number")
    private String phoneNumber; //手机号
    private String identity; //身份信息
    private String material; //身份材料
    @TableField(value = "ic")
    private String IC; //身份证
    private int age; //年龄
    @TableField(value = "date_of_birth")
    private Date dateOfBirth; //生日

    public Registrant(String uid){
        this.uid = uid;
        this.name = "张三";
        this.nickname = "张三的昵称";
        this.avatar = "default_avatar.jpg";
        this.empInfo = "张三很懒，什么都没留下";
        this.phoneNumber = "123-4567-8900";
        this.identity = "";
        this.material = "";
        this.IC = "";
        this.age = 0;
        this.dateOfBirth = new Date(0);
    }
}
