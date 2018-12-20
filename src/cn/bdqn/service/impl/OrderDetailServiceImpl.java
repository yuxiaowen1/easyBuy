package cn.bdqn.service.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.OrderDetailDao;
import cn.bdqn.dao.impl.OrderDetailImpl;
import cn.bdqn.entity.OrderDetail;
import cn.bdqn.service.OrderDetailService;

import java.sql.Connection;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailDao dao;

    @Override
    public int add(OrderDetail orderDetail) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new OrderDetailImpl();
            connection.setAutoCommit(false);
            int count = dao.save(orderDetail, connection);
            if (count>0){
                connection.commit();
            }
            connection.setAutoCommit(true);
            return count;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增订单时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
    }

    @Override
    public List<OrderDetail> findByOrderId(int orderId) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new OrderDetailImpl();
            return dao.findByOrderId(orderId,connection);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有订单时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
    }
}
