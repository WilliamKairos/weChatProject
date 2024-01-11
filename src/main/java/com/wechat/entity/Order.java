package com.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order")
public class Order {
    @TableId
    private String id; //订单号
    private String title; //订单标题
    private String remark; //备注
    private String orderType; //订单类型
    private Date initTime; //订单创建时间
    private long orderInfo; //订单关联的信息
}
