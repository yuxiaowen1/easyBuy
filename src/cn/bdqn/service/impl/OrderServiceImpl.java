package cn.bdqn.service.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.OrderDao;
import cn.bdqn.dao.impl.OrderDaoImpl;
import cn.bdqn.entity.Order;
import cn.bdqn.service.OrderService;

import java.sql.Connection;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao dao;

    @Override
    public int add(Order order) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new OrderDaoImpl();
            connection.setAutoCommit(false);
            int count = dao.save(order, connection);
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
    public int del(int id) {
        return 0;
    }

    @Override
    public int update(Order order) {
        return 0;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findByUserId(int userId) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new OrderDaoImpl();
            return dao.findByUserId(userId,connection);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有订单时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
    }

    @Override
    public Order findByUserIdAndAddress(int userId, String address) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new OrderDaoImpl();
            return dao.findByUserIdAndAddress(userId,address,connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
        return null;
    }
}
