package cn.bdqn.dao;

import cn.bdqn.entity.Order;

import java.sql.Connection;
import java.util.List;

public interface OrderDao {
    int save(Order order, Connection connection);

    int del(int id,Connection connection);

    int update(Order order,Connection connection);

    List<Order> findAll();

    List<Order> findByUserId(int userId,Connection connection);

    Order findByUserIdAndAddress(int userId,String address,Connection connection);




}
