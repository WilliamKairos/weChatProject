package com.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.entity.Order;
import com.wechat.mapper.OrderMapper;
import com.wechat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findOrderByTitle(String title) {
        return orderMapper.selectList(new QueryWrapper<Order>().eq("title", title));
    }

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.selectList(null);
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.insert(order);
    }


    @Override
    public void deleteOrder(String id) {
        orderMapper.deleteById(id);
    }
}
