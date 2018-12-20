package cn.bdqn.service;

import cn.bdqn.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    int add(OrderDetail orderDetail);
    List<OrderDetail> findByOrderId(int orderId);
}
