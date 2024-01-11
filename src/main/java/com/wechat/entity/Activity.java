package com.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("activity")
public class Activity {
    @TableId
    private String id; //活动编号
    private String title; //活动标题
    private String photo; //活动照片
    private Date activityDate; //活动时间
    private String originator; //创始人
    private Date initTime; //活动创建时间

}
