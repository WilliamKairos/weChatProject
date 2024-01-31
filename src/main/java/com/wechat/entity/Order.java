package com.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order")
public class Order {
    @TableId
    private String id; //订单号
    @TableField(value = "init_time")
    private Date initTime; //订单时间
    private String address; //订单住址
    @TableField(value = "order_type")
    private String orderType; //订单类型
    @TableField(value = "elder_id")
    private String elderId; //老人id
    @TableField(value = "emp_id")
    private String empId; //陪护id
    @TableField(value = "elder_phone")
    private String elderPhone; //老人电话
    @TableField(value = "emp_phone")
    private String empPhone; //陪护电话
    private String remark; //备注
}
