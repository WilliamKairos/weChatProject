package com.wechat.controller;

import com.wechat.entity.Order;
import com.wechat.service.OrderService;
import com.wechat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    //    实现增删改查的功能
    @RequestMapping("/add")
    public Result addOrder(@RequestBody Order order){
        try {
            orderService.addOrder(order);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加错误！");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteOrder(@PathVariable("id") String id)
    {
        try {
            orderService.deleteOrder(id);
            return Result.success("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除错误！");
        }
    }

    @GetMapping("/find_by_title/{title}")
    public Result findByTitle(@PathVariable(value = "title") String title){
        try {
//            Registrant result = registrantService.findRegistrantByName(name);
            List<Order> orderList = orderService.findOrderByTitle(title);
            if ( orderList != null) {
                return Result.success(orderList);
            } else {
                return Result.error("未找到对应的结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询错误！");
        }
    }

    @GetMapping("/find_all")
    public Result findAll(){
        try {
//            registrantService.findAllRegistrant();
            return Result.success(orderService.findAllOrder());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询错误！");
        }
    }
}
