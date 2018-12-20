package cn.bdqn.service;

import cn.bdqn.entity.Order;

import java.util.List;

public interface OrderService {
    int add(Order order);
    int del(int id);
    int update(Order order);
    List<Order> findAll();
    List<Order> findByUserId(int userId);

    Order findByUserIdAndAddress(int userId,String address);

}
