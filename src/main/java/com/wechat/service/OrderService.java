package com.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.entity.Order;

import java.util.List;

public interface OrderService extends IService<Order> {
    public List<Order> findOrderByTitle(String title);
    public List<Order> findAllOrder();
    public void addOrder(Order order);
    public void deleteOrder(String id);
}
