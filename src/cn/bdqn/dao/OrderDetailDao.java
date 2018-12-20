package cn.bdqn.dao;

import cn.bdqn.entity.OrderDetail;

import java.sql.Connection;
import java.util.List;

public interface OrderDetailDao {
    int save(OrderDetail orderDetail, Connection connection);
    List<OrderDetail> findByOrderId(int orderId,Connection connection);
}
